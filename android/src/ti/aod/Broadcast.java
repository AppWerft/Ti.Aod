package ti.aod;

import java.util.Calendar;

import org.appcelerator.kroll.KrollDict;

public class Broadcast {
	private String start;
	private String end;
	private String title;
	private String link;

	public Broadcast(String start, String title, String link) {
		super();
		this.start = start;
		this.title = title;
		this.link = link;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getStart() {
		return start;
	}

	public String getEnd() {
		return end;
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
		return 60*1000* (Long.parseLong(foo.split(":")[0]) * 60 + Long.parseLong(foo.split(":")[1]));
	}
	public KrollDict toKrollDict() {
		KrollDict res = new KrollDict();
		long duration = toTime(this.end)-toTime(this.start);
		double progress = (getMilliSecondsOfDay()-toTime(this.start))/duration;
		res.put("start", this.start);
		res.put("end", this.end);
		res.put("startTime", toTime(this.start));
		res.put("endTime", toTime(this.end));
		res.put("duration", duration);
		res.put("progress", progress);
		res.put("percent", Math.round(100*progress));
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
