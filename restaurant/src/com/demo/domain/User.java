package com.demo.domain;

import java.io.Serializable;
import java.util.List;


public class User implements Serializable {
	private String uid;    //用户id
	private String uname;   //用户名字
	private int uidentity;   //用户身份
	private String upassword;  //用户密码
	private List<Orders> orders;   //用户订单
	
	public List<Orders> getOrders() {
		return orders;
	}
	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getUidentity() {
		return uidentity;
	}
	public void setUidentity(int uidentity) {
		this.uidentity = uidentity;
	}
	
	
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public User(String uid, String uname, int uidentity, String upassword,
			List<Orders> orders) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.uidentity = uidentity;
		this.upassword = upassword;
		this.orders = orders;
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", uidentity="
				+ uidentity + ", upassword=" + upassword + ", orders=" + orders
				+ "]";
	}
	
	
	
	
	
	
	
	
}
