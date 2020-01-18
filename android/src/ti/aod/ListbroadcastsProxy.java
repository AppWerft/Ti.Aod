package ti.aod;

import java.io.IOException;
import java.util.ArrayList;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollFunction;
import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.kroll.common.Log;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import android.os.AsyncTask;

// This proxy can be created by calling Drau.createExample({message: "hello world"})
@Kroll.proxy(creatableInModule = AodModule.class, propertyAccessors = { "onLoad" })
public class ListbroadcastsProxy extends KrollProxy {
	// Standard Debugging variables
	private static final String LCAT = AodModule.LCAT + "Broadcasts";
	private int station = 0;
	private String URL = "https://srv.deutschlandradio.de/aodlistbroadcasts.1707.de.rpc?drbm:station_id=";
	private KrollFunction onLoad;
	private KrollFunction onError;

	public ListbroadcastsProxy() {
		super();
	}

	private final class BroadcastsRequestHandler extends AsyncTask<Void, Void, Document> {
		@Override
		protected Document doInBackground(Void[] arg0) {
			Log.d(LCAT, "doInBackground  started " + URL + station);
			Document doc = null;
			try {
				return Jsoup.connect(URL + station).ignoreContentType(false).get();
			} catch (IOException e) {
				e.printStackTrace();
				if (onError != null) {
					KrollDict dict = new KrollDict();
					dict.put("error", e.getLocalizedMessage());
					onError.call(getKrollObject(), dict);
				}
			}
			return doc;
		}

		protected void onPostExecute(Document doc) {
			super.onPostExecute(doc);
			Log.d(LCAT, "onPostExecute ");
			ArrayList<KrollDict> listOfItems = new ArrayList<KrollDict>();
			if (doc != null) {
				Log.d(LCAT,"doc catched");
				for (Element elem : doc.select("broadcastings > item")) {
					Log.d(LCAT,elem.toString());
					KrollDict item = new KrollDict();
					item.put("title", elem.text());
					item.put("id", elem.attr("id"));
					listOfItems.add(item);
				}
				KrollDict res = new KrollDict();
				res.put("broadcastings", listOfItems.toArray());
				if (onLoad != null) {
					onLoad.callAsync(getKrollObject(), res);
				}
				if (hasProperty("onLoad")) {
					((KrollFunction) getProperty("onLoad")).callAsync(getKrollObject(), res);
				}
			} else
				Log.e(LCAT, "doc was null in onPostExecute");
		}
	}

	@Override
	public void handleCreationDict(KrollDict opts) {
		super.handleCreationDict(opts);
		if (opts.containsKey("station")) {
			station = opts.getInt("station");
		}
		if (opts.containsKey("onload")) {
			onLoad = (KrollFunction) opts.get("onload");
		}
		if (opts.containsKey("onerror")) {
			onError = (KrollFunction) opts.get("onerror");
		}
		new BroadcastsRequestHandler().execute();
		Log.d(LCAT, "BroadcastsRequestHandler().execute() ");
	}

}
