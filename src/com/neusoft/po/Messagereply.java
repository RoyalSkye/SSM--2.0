package com.neusoft.po;

import java.util.Date;

public class Messagereply {

	private int mrid;
	private int mid;
	private String content;
	private String mrnickname;
	private String mrtime;
	

	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getMrid() {
		return mrid;
	}
	public void setMrid(int mrid) {
		this.mrid = mrid;
	}
	public String getMrnickname() {
		return mrnickname;
	}
	public void setMrnickname(String mrnickname) {
		this.mrnickname = mrnickname;
	}
	public String getMrtime() {
		return mrtime;
	}
	public void setMrtime(String mrtime) {
		this.mrtime = mrtime;
	}

}
