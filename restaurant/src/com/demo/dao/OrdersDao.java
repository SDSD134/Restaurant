package com.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.demo.domain.Orderitem;
import com.demo.domain.Orders;
import com.demo.domain.Product;
import com.demo.util.C3P0Util;

public class OrdersDao {
	    //��Ӷ���
		public void addOrders(Orders orders) throws SQLException {
			QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
			qRunner.update("insert into orders values(?,?,?,?,?)",orders.getOid(),orders.getUid(),orders.getTid(),orders.getAllprice(),orders.getOstate());
		}
		
		//ͨ������idɾ������(����ɾ��)
		public void deleteOrders (String[] oids) throws SQLException {
			QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
			Object[][] params = new Object[oids.length][];
			for (int i = 0; i < params.length; i++) {
				params[i] = new Object[]{oids[i]};
				
			}
			qRunner.batch("delete from orders where oid = ?", params);
		}
		
		//ͨ������id�ı�����
		public void updateOrders (Orders orders) throws SQLException {
			QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
			qRunner.update("update orders set allprice = ? ostate = ?",orders.getAllprice(),orders.getOstate());
		}
		
		//ͨ���û�id��ѯ��������
		public List<Orders> findOrdersByUid(String uid) throws SQLException {
			QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
			String sql = "select * from orders where uid = ? ";
			List<Orders> list = qRunner.query(sql, new BeanListHandler<Orders>(Orders.class),uid);
		
			return list;
		}
		
		//ͨ������id��ѯ����
		public Orders findOrdersByOid(String oid) throws SQLException{
			QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
			//�õ��ö���
			Orders orders = qRunner.query("select * from orders where oid = ?", new BeanHandler<Orders>(Orders.class),oid);
			//��ȡ������
//			List<Orderitem> orderitems = new ArrayList<Orderitem>();
			List<Orderitem> orderitems = qRunner.query("select * from orderitem o,product p where p.pid = o.pid and o.oid = ?", new ResultSetHandler<List<Orderitem>>(){

				@Override
				public List<Orderitem> handle(ResultSet reSet)
						throws SQLException {
					// TODO Auto-generated method stub
					List<Orderitem> orderitems = new ArrayList<Orderitem>();
					while (reSet.next()) {
						
						//��װOrderItem����
						Orderitem orderitem = new Orderitem();
						orderitem.setBuynum(reSet.getInt("buynum"));
						orderitem.setOrderitem_pstate(reSet.getInt("orderitem_pstate"));
						
						//��װproduct����
						Product product = new Product();
						product.setPname(reSet.getString("pname"));
						product.setPprice(reSet.getDouble("pprice"));
						//��product�����װ��orderitem������
						orderitem.setProduct(product);
						orderitems.add(orderitem);
						
					}
					return orderitems;
				}
				
			},oid);
			orders.setOrderitems(orderitems);
			
			
			return orders;
			
		}
		
		//�����û����ֺ��û�id���������ѯ����
		public List<Orders> searchOrder(String orderid,String uname) throws SQLException {
			QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
			List<Orders> list = new ArrayList<Orders>();
			if ("".equals(orderid)) {
				System.out.println("����1");
				//System.out.println("".equals(orderid));
				list = qRunner.query("SELECT * FROM orders WHERE uid = (SELECT uid FROM USER WHERE uname = ?) ", new BeanListHandler<Orders>(Orders.class),uname);
				System.out.println(uname);
				System.out.println(list);
			} else if("".equals(uname)) {
				System.out.println("����2");
				list = qRunner.query("select * from orders where oid=? ", new BeanListHandler<Orders>(Orders.class),orderid);
				System.out.println(orderid);
				System.out.println(list);
			} else {
					list = qRunner.query("SELECT * FROM orders WHERE  uid = (SELECT uid FROM USER WHERE uname = ?) AND oid = ?", new BeanListHandler<Orders>(Orders.class),uname,orderid);
					System.out.println(list);
				}
				
			
			List<Orders> orderslist = new ArrayList<Orders>();
			for (Orders orders: list) {
				Orders order = new Orders();
				order = findOrdersByOid(orders.getOid());
				orderslist.add(order);
			}
			return orderslist;
			
			
		}
		
		//ͨ������id��ѯ��ʷ����
		public List<Orders> findOrdersByTid(String  tid) throws SQLException {
			QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
			List<Orders> orders = qRunner.query("select * from orders where tid = ?", new BeanListHandler<Orders>(Orders.class),tid);
			List<Orders > list = new ArrayList<Orders>();
			for (Orders order : orders) {
				Orders ord = new Orders();
				ord = findOrdersByOid(order.getOid());
				list.add(ord);
			}
			return list; 
		}
		
		//��ȡ�����ڶ���
		public List<Orders> findThreeOrders(String date) throws SQLException {
			// TODO Auto-generated method stub
			List<Orders> list = new ArrayList<Orders>();  
			QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
			list = qRunner.query("select * from orders where start_time >= ?",new BeanListHandler<Orders>(Orders.class),date);
			List<Orders> orderslist = new ArrayList<Orders>();
			for (Orders orders: list) {
				Orders order = new Orders();
				order = findOrdersByOid(orders.getOid());
				orderslist.add(order);
			}
			return orderslist;
			
			
		}

		public Orders findCurrentOrder(String tid) throws SQLException {
			QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
			Orders orders = qRunner.query("select * from orders where tid = ? and ostate = 1", new BeanHandler<Orders>(Orders.class),tid);
			if(orders!=null){
				try {
					orders = findOrdersByOid(orders.getOid());
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return orders;
		}

		
		
}
