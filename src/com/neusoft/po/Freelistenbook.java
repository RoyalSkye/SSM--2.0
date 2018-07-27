package com.neusoft.po;

import java.util.Date;

public class Freelistenbook {

	private int id;
	private int fid;
	private String cname;
	private String tel;
	private String booktime;
	private String status;
	private String comment;
	private String openid;
	Freelisten freelisten;
	
	public Freelisten getFreelisten() {
		return freelisten;
	}
	public void setFreelisten(Freelisten freelisten) {
		this.freelisten = freelisten;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getBooktime() {
		return booktime;
	}
	public void setBooktime(String booktime) {
		this.booktime = booktime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	@Override
	public String toString() {
		return "Freelistenbook [id=" + id + ", fid=" + fid + ", cname=" + cname + ", tel=" + tel + ", booktime="
				+ booktime + ", status=" + status + ", comment=" + comment + ", openid=" + openid + "]";
	}
	
}
