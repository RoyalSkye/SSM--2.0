package com.neusoft.po;

public class Swiper {

	private int id;
	private int qid;
	private String imgurl;
	private String category;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Swiper [id=" + id + ", qid=" + qid + ", imgurl=" + imgurl + ", category=" + category + "]";
	}
}
