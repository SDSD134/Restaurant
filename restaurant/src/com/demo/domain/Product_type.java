package com.demo.domain;

import java.io.Serializable;

public class Product_type implements Serializable{
	private String ptid;  //��Ʒ����id
	private String ptname;   //��Ʒ��������
	
	
	public String getPtid() {
		return ptid;
	}
	public void setPtid(String ptid) {
		this.ptid = ptid;
	}
	public String getPtname() {
		return ptname;
	}
	public void setPtname(String ptname) {
		this.ptname = ptname;
	}
	
	
	public Product_type(String ptid, String ptname) {
		super();
		this.ptid = ptid;
		this.ptname = ptname;
	}
	public Product_type() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Product_typeDao [ptid=" + ptid + ", ptname=" + ptname + "]";
	}
	
	
	
	
}
