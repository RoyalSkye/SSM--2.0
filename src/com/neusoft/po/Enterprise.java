package com.neusoft.po;

import java.util.ArrayList;
import java.util.List;

public class Enterprise {
 
	private int qid;
	private String name;
	private String videopath;
	private String introduction;
	private String uetext;
	List<Swiper> swiperList=new ArrayList<Swiper>();
	public int getQid() {
		return qid;
	}
	public List<Swiper> getSwiperList() {
		return swiperList;
	}
	public void setSwiperList(List<Swiper> swiperList) {
		this.swiperList = swiperList;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVideopath() {
		return videopath;
	}
	public void setVideopath(String videopath) {
		this.videopath = videopath;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getUetext() {
		return uetext;
	}
	public void setUetext(String uetext) {
		this.uetext = uetext;
	}
	
	@Override
	public String toString() {
		return "Enterprise [qid=" + qid + ", name=" + name + ", videopath=" + videopath + ", inrtoduction="
				+ introduction + ", text=" + uetext + "]";
	}
}
