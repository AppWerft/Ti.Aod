package ti.aod;

import java.util.Calendar;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.common.Log;

public class Broadcast {
	private String start;
	private String end;
	private String title;
	private String link;
	private String day;
	private static String LCAT = AodModule.LCAT;

	public Broadcast(String day,String start, String title, String link) {
		super();
		this.day = day;
		this.start = start;
		this.title = title;
		this.link = link;
		this.end = start;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getStart() {
		return this.start;
	}
	public String getDay() {
		return this.day;
	}

	public String getEnd() {
		return this.end;
	}

	public int getDuration() {
		return Integer.parseInt(this.end.split(":")[0]) * 60 + Integer.parseInt(this.end.split(":")[1])
				- Integer.parseInt(this.start.split(":")[0]) * 60 + Integer.parseInt(this.start.split(":")[1]);
	}

	public boolean isOnair() {
		long now = getMilliSecondsOfDay();
		
		return (now >= toTime(this.start) && now < toTime(this.end)) ? true : false;
	}
	
	

	private long toTime(String foo) {
		return 60 * 1000 * (Long.parseLong(foo.split(":")[0]) * 60 + Long.parseLong(foo.split(":")[1]));
	}

	public KrollDict toKrollDict() {
		KrollDict res = new KrollDict();
		long starttime = toTime(this.start);
		long endtime = toTime(this.end);
		long now = getMilliSecondsOfDay();
		long duration = endtime - starttime;
		Log.d(LCAT,"duration: " + duration/1000/60);
		if (duration == 0)
			return null;
		float progress = (float)(now - starttime) / duration;
		
		Log.d(LCAT,"times: " + this.start + " "+ this.end);
		Log.d(LCAT,"now: " + (now - starttime)/1000 +  "  duration: " +duration/1000/60);
		
		Log.d(LCAT,"progress: " + progress);
		
		if (progress < 0)
			progress = 0;
		if (progress > 1)
			progress = 1;
		res.put("nowTime", now);
		res.put("start", this.start);
		res.put("end", this.end);
		res.put("startTime", starttime);
		res.put("endTime", endtime);
		res.put("duration", duration);
		res.put("progress", progress);
		res.put("percent", Math.round(100.0 * progress));
		res.put("title", this.title);
		res.put("link", this.link);

		return res;
	}

	private long getMilliSecondsOfDay() {
		Calendar c = Calendar.getInstance();
		long now = c.getTimeInMillis();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return now - c.getTimeInMillis();
	}
}
