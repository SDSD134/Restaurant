package com.demo.domain;

import java.io.Serializable;

public class Orderitem implements Serializable {
	private String oiid;    //
	private Orders orders;     //订单编号
	private Product product;     //    商品id
	private int orderitem_pstate;    //订单状态
	private int buynum;     //商品数量
	
	
	public String getOiid() {
		return oiid;
	}
	public void setOiid(String oiid) {
		this.oiid = oiid;
	}
	public int getOrderitem_pstate() {
		return orderitem_pstate;
	}
	public void setOrderitem_pstate(int orderitem_pstate) {
		this.orderitem_pstate = orderitem_pstate;
	}
	public int getBuynum() {
		return buynum;
	}
	public void setBuynum(int buynum) {
		this.buynum = buynum;
	}
	
	
	public Orderitem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Orders getOrders() {
		return orders;
	}
	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	public Orderitem(String oiid, Orders orders, Product product,
			int orderitem_pstate, int buynum) {
		super();
		this.oiid = oiid;
		this.orders = orders;
		this.product = product;
		this.orderitem_pstate = orderitem_pstate;
		this.buynum = buynum;
	}
	@Override
	public String toString() {
		return "Orderitem [oiid=" + oiid + ", orders=" + orders + ", product="
				+ product + ", orderitem_pstate=" + orderitem_pstate
				+ ", buynum=" + buynum + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
