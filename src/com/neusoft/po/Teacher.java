package com.neusoft.po;

public class Teacher {

	private int tid;
	private String tname;
	private String tphoto_url;
	private String introduction;
	private int qid;

	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTphoto_url() {
		return tphoto_url;
	}
	public void setTphoto_url(String tphoto_url) {
		this.tphoto_url = tphoto_url;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tname=" + tname + ", tphoto_url=" + tphoto_url + ", introduction="
				+ introduction + ", qid=" + qid + "]";
	}
}
