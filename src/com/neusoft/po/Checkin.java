package com.neusoft.po;

public class Checkin {
	private int checkinid;
	private String timestamp;
	private String phone;
	private String time;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCheckinid() {
		return checkinid;
	}
	public void setCheckinid(int checkinid) {
		this.checkinid = checkinid;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
