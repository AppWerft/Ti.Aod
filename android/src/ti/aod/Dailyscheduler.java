
package ti.aod;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.appcelerator.kroll.common.Log;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.os.AsyncTask;

public class Dailyscheduler {

	private static final String LCAT = AodModule.LCAT;

	Document document;

	public AsyncResponse delegate = null;

	ArrayList<Broadcast> broadcastList = new ArrayList<Broadcast>();
	String day = "";
	private String endpoint;
	Integer stationId;

	public Dailyscheduler(Integer id, String endpoint) {
		super();
		this.stationId = id;
		this.endpoint = endpoint;
		Log.d(LCAT, "endpoint added " + endpoint);
		refreshList();
	}

	public ArrayList<Broadcast> getBroadcastList() {
		return this.broadcastList;
	}
	
	public boolean refreshList() {
		if (this.broadcastList != null && !this.broadcastList.isEmpty()) {
			if (false == isToday(this.broadcastList.get(0).getDay())) {
				Log.d(LCAT, "old broadcastList need to refresh");
				new SoupRequester().execute(this.endpoint);
				return false;
			} else
				return true;
		}
		new SoupRequester().execute(this.endpoint);
		return false;
	}

	private boolean isToday(String start) {
		Log.d(LCAT,"isToday: "+ start);
		String dateOfStart = start.substring(10);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String dateOfToday = format.format(cal.getTime());
		return dateOfStart.equals(dateOfToday) ? true : false;
		
	}

	private final class SoupRequester extends AsyncTask<String, Void, ArrayList<Broadcast>> {

		@Override
		protected ArrayList<Broadcast> doInBackground(String... urls) {
			ArrayList<Broadcast> broadcastList = new ArrayList<Broadcast>();
			try {
				Log.d(LCAT, "doInBackground started width " + urls[0]);
				document = Jsoup.connect(urls[0]).ignoreContentType(false).get();
				return broadcastList;
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}

		protected void onPostExecute(ArrayList<Broadcast> broadcastList) {
			if (document == null) {
				Log.e(LCAT, "document in onPostExecute is null, invalid URL?");
				return;
			}
			Log.d(LCAT, document.charset().displayName());
			/* Convert from XML to list of broadcasts */
			Elements elems = document.select("channel > item");
			Log.d(LCAT, "items in channel found=" + elems.size());
			String day = "";
			for (Element elem : elems) {
				// pattern: 'schema_2020-01-15-15:05'
				String schema = elem.select("guid").get(0).text();
				String datestr = schema.replace("schema-", "");
				day = datestr.substring(0, 10);
				String timestamp = datestr.substring(11, 16);
				Broadcast item = new Broadcast(day,timestamp, elem.select("title").get(0).text(),
						elem.select("link").get(0).text());
				broadcastList.add(item);
			}
			Log.d(LCAT, "items added to broadcastlist");
			/* calculating the ends: */
			for (int i = 0; i < broadcastList.size(); i++) {
				Broadcast item = broadcastList.get(i);
				if (i < broadcastList.size() - 1) {
					item.setEnd(broadcastList.get(i + 1).getStart());
				} else {
					item.setEnd("24:00");
				}
				broadcastList.set(i, item);

			}
			/*
			 * for (int i = 0; i < broadcastList.size(); i++) {
			 * Log.d(LCAT,broadcastList.get(i).toKrollDict().toString()); }
			 */
			Log.d(LCAT, "ends calculated");
			
			delegate.processScheduler(stationId, Dailyscheduler.this);
			Dailyscheduler.this.broadcastList = broadcastList;
		}
	}
}
