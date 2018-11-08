package com.demo.domain;

import java.io.Serializable;

public class Product implements Serializable{
	private String pid;     //商品id
	private String ptid;    //商品种类
	private String pname;    //商品名字
	private String pimg;     //商品图片
	private int pstate;      //商品状态
	private double pprice;   //商品价格
	private Product_type product_type; //获取商品种类
	
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPtid() {
		return ptid;
	}
	public void setPtid(String ptid) {
		this.ptid = ptid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPimg() {
		return pimg;
	}
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}
	public int getPstate() {
		return pstate;
	}
	public void setPstate(int pstate) {
		this.pstate = pstate;
	}
	public double getPprice() {
		return pprice;
	}
	public void setPprice(double pprice) {
		this.pprice = pprice;
	}
	
	
	public Product_type getProduct_type() {
		return product_type;
	}
	public void setProduct_type(Product_type product_type) {
		this.product_type = product_type;
	}
	
	
	public Product(String pid, String ptid, String pname, String pimg,
			int pstate, double pprice, Product_type product_type) {
		super();
		this.pid = pid;
		this.ptid = ptid;
		this.pname = pname;
		this.pimg = pimg;
		this.pstate = pstate;
		this.pprice = pprice;
		this.product_type = product_type;
	}
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", ptid=" + ptid + ", pname=" + pname
				+ ", pimg=" + pimg + ", pstate=" + pstate + ", pprice="
				+ pprice + ", product_type=" + product_type + "]";
	}
	
	
	
	
	
	
	
}
