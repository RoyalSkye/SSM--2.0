package com.neusoft.po;

import java.util.Date;

public class Messagelike {

	
	private int mlid;
	private int mid;
	private String mlnickname;
	private String mltime;
	

	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}

	public int getMlid() {
		return mlid;
	}
	public void setMlid(int mlid) {
		this.mlid = mlid;
	}
	public String getMlnickname() {
		return mlnickname;
	}
	public void setMlnickname(String mlnickname) {
		this.mlnickname = mlnickname;
	}
	public String getMltime() {
		return mltime;
	}
	public void setMltime(String mltime) {
		this.mltime = mltime;
	}
}
