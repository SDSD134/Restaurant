package com.demo.test;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.junit.Test;

import com.demo.dao.OrdersDao;
import com.demo.dao.ProductDao;
import com.demo.domain.Orders;
import com.demo.domain.Product;
import com.demo.domain.Product_type;
import com.demo.domain.User;
import com.demo.service.OrderService;
import com.demo.service.ProductService;
import com.demo.service.Product_TypeService;
import com.demo.service.TablesService;
import com.demo.service.UserService;

public class Test1 {
	
	/*public static void main(String[] args) {
		OrdersDao ordersDao = new OrdersDao();
		try {
			Orders orders =ordersDao.findOrdersByOid("1");
			System.out.println(orders.getOid() + orders.getOrderitems().get(1).getProduct().getPname());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	/*public static void main(String[] args) {
		ProductService service = new ProductService();
		Product product = new Product();
		String ptname = "凉菜";
		product.setPid("5");
		product.setPname("海带");
		service.addProduct(product, ptname);
	}*/
	
	/*@Test
	public void test1(){
		TablesService tablesService = new TablesService();
		int tid = 1;
		tablesService.updataState(tid);
	}
	
	@Test
	public void test2() {
		ProductService productService = new ProductService();
		Product_TypeService product_TypeService = new Product_TypeService();
		String ptname = "3";
		Product product = new Product("1", "", "1", "1",1,80,null);
		try {
			Product_type product_type = product_TypeService.findProduct_type(ptname);
			product.setProduct_type(product_type);
			System.out.println(product);
			productService.updateProduct(product);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	
	/*@Test
	public void test5(){
		OrdersDao ordersDao = new OrdersDao();
		Orders orders = new Orders();
		String oid = "1";
		try {
			orders = ordersDao.findOrdersByOid(oid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(orders);
		
		
	}*/
	/*@Test
	public void test6() {
		Calendar c=Calendar.getInstance();
		c.add(Calendar.DATE, -3);
		//转换日期输出格式
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
		Date date = c.getTime();
		String s = dateFormat.format(date);
		System.out.println(s);
	}*/
	
	/*
	public void test7() {
		OrderService orderService = new OrderService();
		List<Orders> list = orderService.findThreedayOrder();
		System.out.println(list);
	}*/
	
	/*@Test
	public void test8() {
		OrderService orderService = new OrderService();
		List<Orders> list = orderService.searchOrders("", "1");
		//System.out.println(list);
	}*/
	/*@Test
	public void tast9() {
		List<Map> userslist = new ArrayList<Map>();
		UserService userService = new UserService();
		List<User> users =  new ArrayList<User>();
		users = userService.queryAll();
	    
	    for (User user : users) {
	    	Map map = new HashMap();
			map.put("name", user.getUname());
			map.put("password", user.getUpassword());
			userslist.add(map);
		}
	    
	    String json = JSONArray.fromObject(userslist).toString();
	    System.out.println(json);
	}*/
	/*@Test
	public void tast10(){
		String name = "1";
		ProductDao pDao = new ProductDao();
		List<Product> products  = null;
		try {
			products = pDao.findProduct(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(products);
	}*/
}
