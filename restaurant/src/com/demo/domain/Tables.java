package com.demo.domain;

import java.io.Serializable;
import java.util.List;

public class Tables implements Serializable{
	private int tid;   //����id
	private int state; //����ʹ��״̬
	private int tvariety; //������������
	private String timg;  //����ͼƬ
	
	private List<Orders> orders;    //�����������
	
	
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
