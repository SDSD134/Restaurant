package com.demo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.demo.domain.Product;
import com.demo.domain.Product_type;
import com.demo.util.C3P0Util;
import com.demo.util.UUIDUtil;

public class ProductDao {
	//增加菜品
	public void addProduct (Product product,String ptid) throws SQLException{
		    QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		    qRunner.update("insert into product values(?,?,?,?,?,?)" ,new UUIDUtil().getUUID(),ptid,product.getPname(),product.getPimg(),0,product.getPprice());
		    
	}
	
	//通过id或者名字删除菜品
	public void deleteProduct(String name) throws SQLException{
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		qRunner.update("delete from product where pid = ? or pname = ?", name,name);
	}
	
	//批量删除菜品
	public void deletAllProduct(String [] ids) throws SQLException{
		QueryRunner qRunner = new QueryRunner();
		Object[][] params = new Object[ids.length][];
		for (int i = 0; i < params.length; i++) {
			params[i] = new Object[]{ids[i]};
		}
		qRunner.batch("delete from product where pid = ? ", params);
	}
	
	//修改菜品信息
	public void updateProduct(Product product) throws SQLException{
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		qRunner.update("update product set ptid = ?,pname = ?, pprice = ?, pstate = ? where pid = ? ",product.getProduct_type().getPtid(),product.getPname(),product.getPprice(),product.getPstate(),product.getPid());
		
	}
	
	//查看所有菜品信息
	public List<Product> findAllProduct() throws SQLException{
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		List<Product> list =new ArrayList<Product>();
		list= qRunner.query("select * from product", new BeanListHandler<Product>(Product.class));
		for (Product product : list) {
			product.setProduct_type(qRunner.query("SELECT* FROM product_type where ptid=?",new BeanHandler<Product_type>(Product_type.class),product.getPtid()));
		}
		return list;
	}
	
	//通过名字或id查询菜品信息
	public List<Product> findProduct (String name) throws SQLException{
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		List<Product> productlist = qRunner.query("select * from product where pname = ?",new BeanListHandler<Product>(Product.class),name);
		for (Product product : productlist) {
			product.setProduct_type(qRunner.query("SELECT* FROM product_type where ptid=?",new BeanHandler<Product_type>(Product_type.class),product.getPtid()));
		}
		return productlist;
	}
	
	//通过种类名字或id查询菜品信息
		public List<Product> findProductByPtid (String ptid) throws SQLException{
			QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
			List<Product> productlist = qRunner.query("select * from product where ptid = ?",new BeanListHandler<Product>(Product.class),ptid);
			for (Product product : productlist) {
				product.setProduct_type(qRunner.query("SELECT* FROM product_type where ptid=?",new BeanHandler<Product_type>(Product_type.class),product.getPtid()));
			}
			return productlist;
		}
	
	//多条件查询菜品
	public List<Product> searchProduct (String pid,String ptid,String pname,String pstate,String minpprice,String maxpprice)
			throws SQLException{
		String sql = "select * from product where 1=1";
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		List list = new ArrayList();
		if (!"".equals(pid.trim())) {
			sql += "and id like ?";
			list.add("%" + pid.trim() +"%");
		}
		
		if (!"".equals(ptid.trim())) {
			sql += "and id = ?";
			list.add("%" + pid.trim() +"%");
		}
		
		if (!"".equals(pname.trim())) {
			sql += "and id like ?";
			list.add("%" + pid.trim() +"%");
		}
		
		if (!"".equals(pstate.trim())) {
			int state = Integer.parseInt(pstate);
			sql += "and id = ?";
			list.add("%" + state +"%");
		}
		
		if (!"".equals(minpprice.trim())) {
			sql += "and id > ?";
			double minprice = Double.parseDouble(minpprice);
			list.add("%" +minprice +"%");
		}
		
		if (!"".equals(maxpprice.trim())) {
			sql += "and id < ?";
			double maxprice = Double.parseDouble(maxpprice);
			list.add("%" +maxprice +"%");
		}
		
		
		return qRunner.query(sql, new BeanListHandler<Product>(Product.class),list.toArray());
	}
	
	//得到菜品总数
	public int productCount() throws SQLException{
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		int count = (Integer) qRunner.query("select count(*) from product", new ScalarHandler(1));
		return count;
	}
	
	
}
