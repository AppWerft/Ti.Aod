package ti.aod;

import java.io.IOException;
import java.util.ArrayList;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollFunction;
import org.appcelerator.kroll.common.Log;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import android.os.AsyncTask;

public final class ListAudioRequestHandler extends AsyncTask<String, Void, Document> {
	public AsyncResponse delegate;
	
	public interface AsyncResponse {
		void process(int page,ArrayList<Article> articleList);
	}
	
	@Override
	protected Document doInBackground(String[] urls) {
		
		Document doc = null;
		try {
			return Jsoup.connect(urls[0]).ignoreContentType(false).get();
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		return doc;
	}

	protected void onPostExecute(Document doc) {
		super.onPostExecute(doc);
		
		ArrayList<Article> listOfItems = new ArrayList<Article>();
		if (doc != null) {
			int page =0;
			for (Element elem : doc.select("broadcastings > item")) {
				
				Article article = new Article();
				listOfItems.add(article);
			}
			KrollDict res = new KrollDict();
			res.put("broadcastings", listOfItems.toArray());
			delegate.process(page, listOfItems);
			
		} 
	}
}

