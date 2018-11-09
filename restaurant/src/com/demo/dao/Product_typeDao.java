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
	//������Ʒ����
	public void addProduct_Type (Product_type product_type) throws SQLException{
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		qRunner.update("insert into product_type values(?,?)",product_type.getPtid(),product_type.getPtname());

	}
	
	//ͨ��id��������ɾ����Ʒ����
	public void deletProduct_Type (String  id) throws SQLException{
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		qRunner.update("delete from product_type where ptid = ? or ptname = ?", id,id);
	}
	
	//�ı���Ʒ��������
	public void updateProduct_Type(Product_type product_type) throws SQLException {
		QueryRunner qRunner  = new QueryRunner(C3P0Util.getDataSource());
		qRunner.update("update product_type set ptname = ? where ptid =?",product_type.getPtname(),product_type.getPtid());
	}
	
	//��ѯ��Ʒ����
	public List<Product_type> findAllProduct_type() throws SQLException{
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		return qRunner.query("select * from product_type", new BeanListHandler<Product_type>(Product_type.class));
		
		
	}
	
	//ͨ�����ֻ���id��ѯ�Ƿ��и�����Ʒ
	 /*runner.query(sql, new ScalarHandler())�õ���ֵ������ֱ��ǿתΪinteger���ͣ�
	 ���ǽ��ܶ˲������������ͣ�����Ƚ�ֵתΪlong��
	 Ȼ���������intValue()�����õ�����*/
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
