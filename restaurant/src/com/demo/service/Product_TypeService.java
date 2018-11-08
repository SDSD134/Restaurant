package com.demo.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.dao.Product_typeDao;
import com.demo.domain.Product;
import com.demo.domain.Product_type;

public class Product_TypeService {
	Product_typeDao dao = new Product_typeDao();
	
	//查找所有菜品种类
	public List<Product_type> findAlllProduct_types(){
		List<Product_type> list = new ArrayList<Product_type>();
		try {
			list  = dao.findAllProduct_type();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//通过商品种类id或者名字删除
	public void deleteProduct_Type(String id) {
		// TODO Auto-generated method stub
		try {
			dao.deletProduct_Type(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//是否有该商品种类
	public int  CountProduct_Type(String ptid) {
		int count = 0;
		try {
			count = dao.countProduct_Type(ptid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
		
		
	}
	
	//通过名字获取菜品种类
	public Product_type findProduct_type(String ptname) {
		try {
			return dao.findProduct_Type(ptname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
   //增加菜品种类
	public void addProduct_Type(String ptname) {
		// TODO Auto-generated method stub
		try {
			dao.addProduct_Type(ptname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
