package com.demo.domain;

import java.util.Date;

public class Table_record {
	private String trid;   //����ʹ�ü�¼id
	private int tid;    //����id
	private String uid; //�˿�id
	private Date start_time;  //����ʹ�ÿ�ʼʱ��
	private Date end_time;    //����ʹ�ý���ʱ��
	
	public String getTrid() {
		return trid;
	}
	public void setTrid(String trid) {
		this.trid = trid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
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
	
	public Table_record() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Table_record(String trid, int tid, String uid, Date start_time,
			Date end_time) {
		super();
		this.trid = trid;
		this.tid = tid;
		this.uid = uid;
		this.start_time = start_time;
		this.end_time = end_time;
	}
	
	@Override
	public String toString() {
		return "Table_recordDao [trid=" + trid + ", tid=" + tid + ", uid="
				+ uid + ", start_time=" + start_time + ", end_time=" + end_time
				+ "]";
	}
	
	
	
	
}
