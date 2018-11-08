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
	
	//通过桌子id查询订单信息
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

	//获取三天内的订单信息
	public List<Orders> findThreedayOrder() {
		// TODO Auto-generated method stub
		List<Orders> list = new ArrayList<Orders>();
		
		Calendar c=Calendar.getInstance();
		c.add(Calendar.DATE, -3);//获取三天前时间
		//转换日期输出格式
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

	//通过id和顾客名字获取订单详情
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
