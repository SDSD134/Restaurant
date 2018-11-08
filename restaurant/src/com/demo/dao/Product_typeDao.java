package com.demo.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.demo.domain.Product_type;
import com.demo.domain.User;
import com.demo.util.C3P0Util;
import com.demo.util.UUIDUtil;

public class Product_typeDao implements Serializable{
	//增加商品种类
	public void addProduct_Type (Product_type product_type) throws SQLException{
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		qRunner.update("insert into product_type values(?,?)",product_type.getPtid(),product_type.getPtname());

	}
	
	//通过id或者名字删除商品种类
	public void deletProduct_Type (String  id) throws SQLException{
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		qRunner.update("delete from product_type where ptid = ? or ptname = ?", id,id);
	}
	
	//改变商品种类名字
	public void updateProduct_Type(Product_type product_type) throws SQLException {
		QueryRunner qRunner  = new QueryRunner(C3P0Util.getDataSource());
		qRunner.update("update product_type set ptname = ? where ptid =?",product_type.getPtname(),product_type.getPtid());
	}
	
	//查询商品种类
	public List<Product_type> findAllProduct_type() throws SQLException{
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		return qRunner.query("select * from product_type", new BeanListHandler<Product_type>(Product_type.class));
		
		
	}
	
	//通过名字或者id查询是否有该类商品
	 /*runner.query(sql, new ScalarHandler())得到的值并不能直接强转为integer类型，
	 但是接受端参数是整数类型，因此先将值转为long，
	 然后整体调用intValue()方法得到整型*/
	public int countProduct_Type(String name) throws SQLException{
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		Long a = (Long) qRunner.query("SELECT COUNT(*) FROM product_type WHERE ptid = ? or ptname = ?",new ScalarHandler(),name,name);
		int count = a.intValue();
		return count;
	}

	public Product_type findProduct_Type(String ptname) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(C3P0Util.getDataSource());
		return queryRunner.query("select * from product_type where ptname=?", new BeanHandler<Product_type>(Product_type.class),ptname);
		
	}

	public void addProduct_Type(String ptname) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		qRunner.update("insert into product_tupe values(?,?)",new UUIDUtil().getUUID(),ptname);
	}
	
	
}
