package com.neusoft.po;

import java.util.Date;

public class Freelisten {

	private int fid;
	private String title;
	private String imgurl;
	private String fdesc;
	private String status;
	private int qid;
	private int bid;
	private String pubtime;
	
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getFdesc() {
		return fdesc;
	}
	public void setFdesc(String fdesc) {
		this.fdesc = fdesc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getPubtime() {
		return pubtime;
	}
	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}
	
	@Override
	public String toString() {
		return "Freelisten [fid=" + fid + ", title=" + title + ", imgurl=" + imgurl + ", fdesc=" + fdesc + ", status="
				+ status + ", qid=" + qid + ", bid=" + bid + ", pubtime=" + pubtime + "]";
	}
}
