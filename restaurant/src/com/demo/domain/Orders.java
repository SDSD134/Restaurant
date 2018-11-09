package com.demo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Orders implements Serializable{
	private String oid;     //�������
	private String uid;       //�˿��˺�
	private int tid;        //���ӱ��
	private double allprice;  //�ܼ�
	private Date start_time;  //����ʹ�ÿ�ʼʱ��
	private Date end_time;    //����ʹ�ý���ʱ��
	private int ostate;        //����״̬
	private List<Orderitem> orderitems;  //һ�Զ�
	
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public Date getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}
	
	
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public double getAllprice() {
		return allprice;
	}
	public void setAllprice(double allprice) {
		this.allprice = allprice;
	}
	
	public int getOstate() {
		return ostate;
	}
	public void setOstate(int ostate) {
		this.ostate = ostate;
	}
	public List<Orderitem> getOrderitems() {
		return orderitems;
	}
	public void setOrderitems(List<Orderitem> orderitems) {
		this.orderitems = orderitems;
	}
	
	
	

	public Orders(String oid, String uid, int tid, double allprice,
			Date start_time, Date end_time, int ostate,
			List<Orderitem> orderitems) {
		super();
		this.oid = oid;
		this.uid = uid;
		this.tid = tid;
		this.allprice = allprice;
		this.start_time = start_time;
		this.end_time = end_time;
		this.ostate = ostate;
		this.orderitems = orderitems;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", uid=" + uid + ", tid=" + tid
				+ ", allprice=" + allprice + ", start_time=" + start_time
				+ ", end_time=" + end_time + ", ostate=" + ostate
				+ ", orderitems=" + orderitems + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
