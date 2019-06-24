package model.vo;

public class MeetingVO {
	private String name;
	private String Date;
	private String perpose;
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getPerpose() {
		return perpose;
	}
	public void setPerpose(String perpose) {
		this.perpose = perpose;
	}
	
}
