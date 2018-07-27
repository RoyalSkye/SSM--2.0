package com.neusoft.tools;

public class Page {

	private int quantity;
	private int currentPage;
	private int totalPage;
	private int id;
	private int maxNum;
	private int minNum;
	
	public Page() {}
	
	public Page(int quantity, int currentPage,int id) {
		super();
		this.quantity = quantity;
		this.currentPage = currentPage;
		this.id = id;
		maxNum = (currentPage)*quantity;
		minNum = (currentPage-1)*quantity;
		
	}
	
	public Page(int quantity, int currentPage) {
		super();
		this.quantity = quantity;
		this.currentPage = currentPage;
		maxNum = (currentPage)*quantity;
		minNum = (currentPage-1)*quantity;
		
	}
	

	public Page(int quantity, int currentPage, int totalPage, int id) {
		super();
		this.quantity = quantity;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.id = id;
		maxNum = (currentPage+1)*quantity;
		minNum = currentPage*quantity+1;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}

	public int getMinNum() {
		return minNum;
	}

	public void setMinNum(int minNum) {
		this.minNum = minNum;
	}

}
