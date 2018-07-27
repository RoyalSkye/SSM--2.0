package com.neusoft.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Message {

	private int mid;
	private String mtitle;
	private String mtime;
	private int qid;
	
	List<Messageimg> messageimgList=new ArrayList<Messageimg>();
	List<Messagereply> messagereplyList=new ArrayList<Messagereply>();
	List<Messagelike> messagelikeList=new ArrayList<Messagelike>();
	
	public List<Messagereply> getMessagereplyList() {
		return messagereplyList;
	}
	public void setMessagereplyList(List<Messagereply> messagereplyList) {
		this.messagereplyList = messagereplyList;
	}
	public List<Messagelike> getMessagelikeList() {
		return messagelikeList;
	}
	public void setMessagelikeList(List<Messagelike> messagelikeList) {
		this.messagelikeList = messagelikeList;
	}
	public List<Messageimg> getMessageimgList() {
		return messageimgList;
	}
	public void setMessageimgList(List<Messageimg> messageimgList) {
		this.messageimgList = messageimgList;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMtitle() {
		return mtitle;
	}
	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}
	public String getMtime() {
		return mtime;
	}
	public void setMtime(String mtime) {
		this.mtime = mtime;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	@Override
	public String toString() {
		return "Message [mid=" + mid + ", mtitle=" + mtitle + ", mtime=" + mtime + ", qid=" + qid + "]";
	}
}
