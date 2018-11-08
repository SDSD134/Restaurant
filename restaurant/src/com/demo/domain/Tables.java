package com.demo.domain;

import java.io.Serializable;
import java.util.List;

public class Tables implements Serializable{
	private int tid;   //桌子id
	private int state; //桌子使用状态
	private int tvariety; //桌子容纳数量
	private String timg;  //桌子图片
	
	private List<Orders> orders;    //多个订单内容
	
	
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getTvariety() {
		return tvariety;
	}
	public void setTvariety(int tvariety) {
		this.tvariety = tvariety;
	}
	public String getTimg() {
		return timg;
	}
	public void setTimg(String timg) {
		this.timg = timg;
	}
	
	
	

	
	
	public Tables() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tables(int tid, int state, int tvariety, String timg,
			List<Orders> orders) {
		super();
		this.tid = tid;
		this.state = state;
		this.tvariety = tvariety;
		this.timg = timg;
		this.orders = orders;
	}
	@Override
	public String toString() {
		return "Tables [tid=" + tid + ", state=" + state + ", tvariety="
				+ tvariety + ", timg=" + timg + ", orders=" + orders + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
