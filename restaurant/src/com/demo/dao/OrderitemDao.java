package com.demo.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.demo.domain.Orderitem;
import com.demo.domain.Orders;
import com.demo.util.C3P0Util;

public class OrderitemDao {
	//批量增加订单内容
	public void addOrderitem(Orders orders) throws SQLException {
		List<Orderitem> orderitems = orders.getOrderitems();
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		Object[][] params = new Object[orderitems.size()][];
		
		for (int i = 0; i < params.length; i++) {
			params[i] = new Object[]{orderitems.get(i).getOiid(),orders.getOid(),orderitems.get(i).getProduct().getPid(),
					    orderitems.get(i).getOrderitem_pstate(),orderitems.get(i).getBuynum()};
		}
		qRunner.batch("insert into ordeitem values (?,?,?,?,?)", params);
		
		
	}
	
	//删除订单内容
	
	
	//改变订单内容
	public void updateOrderitem (Orderitem orderitem) throws SQLException {
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		qRunner.update("update orderitem set orderitem_pstate = ? buynum = ? where oiid = ?",orderitem.getProduct().getPid(),orderitem.getOrderitem_pstate(),orderitem.getBuynum());
	}
	
	//通过oid查询订单内容
	public List<Orderitem> findOrderitem(String oid) throws SQLException{
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		List<Orderitem> list = qRunner.query("select * from orderitem where oid = ?", new BeanListHandler<Orderitem>(Orderitem.class),oid);
		return list;
	}
	
	
	
	
}
