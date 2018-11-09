package com.demo.service;

import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.demo.dao.OrdersDao;
import com.demo.domain.Orderitem;
import com.demo.domain.Orders;

public class OrderService {
	OrdersDao ordersDao = new OrdersDao();
	Orderitem orderitem = new Orderitem();
	
	//ͨ������id��ѯ������Ϣ
	public List<Orders> findOrderByTId(String id) {
		
		List<Orders> orders = new ArrayList<Orders>();
		try {
			orders = ordersDao.findOrdersByTid(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
		
	}

	//��ȡ�����ڵĶ�����Ϣ
	public List<Orders> findThreedayOrder() {
		// TODO Auto-generated method stub
		List<Orders> list = new ArrayList<Orders>();
		
		Calendar c=Calendar.getInstance();
		c.add(Calendar.DATE, -3);//��ȡ����ǰʱ��
		//ת�����������ʽ
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		String date = dateFormat.format(c.getTime());
		
		try {
			list= ordersDao.findThreeOrders(date);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public Orders findCurrentOrder(String tid) {
		// TODO Auto-generated method stub
		Orders orders = null;
		try {
			orders = ordersDao.findCurrentOrder(tid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}

	//ͨ��id�͹˿����ֻ�ȡ��������
	public List<Orders> searchOrders(String orderid, String username) {
		List<Orders> list = new ArrayList<Orders>();
		//System.out.println(orderid);
		//System.out.println("service");
		//System.out.println(username);
		try {
			list = ordersDao.searchOrder(orderid,username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	


	
	
	

	
	
	
	
	
}
