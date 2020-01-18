package ti.aod;

import org.appcelerator.kroll.KrollDict;

public class Article {
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFile_id() {
		return file_id;
	}

	public void setFile_id(String file_id) {
		this.file_id = file_id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public String getSendung_id() {
		return sendung_id;
	}

	public void setSendung_id(String sendung_id) {
		this.sendung_id = sendung_id;
	}

	private long id;
	private String file_id;
	private String url;
	private String datetime;
	private String title;
	private String author;
	private String station;
	private String sendung_id;

	public Article() {

	}

	public Article(long id, String file_id, String url, String datetime, String title, String author, String station,
			String sendung_id) {
		this.id = id;
		this.file_id = file_id;
		this.url = url;
		this.datetime = datetime;
		this.title = title;
		this.author = author;
		this.station = station;
		this.sendung_id = sendung_id;

	}

	public KrollDict toKrollDict() {
		KrollDict d = new KrollDict();
		d.put("id", id);
		d.put("url", url);
		d.put("datetime", datetime);
		d.put("title", title);
		d.put("author", author);
		d.put("sendung_id", sendung_id);
		
		
		
		
		
		return d;
		
	}
}
