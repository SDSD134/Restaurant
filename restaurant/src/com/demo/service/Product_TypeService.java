package com.demo.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.dao.Product_typeDao;
import com.demo.domain.Product;
import com.demo.domain.Product_type;

public class Product_TypeService {
	Product_typeDao dao = new Product_typeDao();
	
	//�������в�Ʒ����
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
	
	//ͨ����Ʒ����id��������ɾ��
	public void deleteProduct_Type(String id) {
		// TODO Auto-generated method stub
		try {
			dao.deletProduct_Type(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//�Ƿ��и���Ʒ����
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
	
	//ͨ�����ֻ�ȡ��Ʒ����
	public Product_type findProduct_type(String ptname) {
		try {
			return dao.findProduct_Type(ptname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
   //���Ӳ�Ʒ����
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
