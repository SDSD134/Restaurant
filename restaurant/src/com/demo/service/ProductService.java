package com.demo.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.demo.dao.ProductDao;
import com.demo.dao.Product_typeDao;
import com.demo.domain.Product;
import com.demo.domain.Product_type;
import com.demo.util.C3P0Util;
import com.demo.util.UUIDUtil;

public class ProductService {
	ProductDao productDao = new ProductDao();
	Product_typeDao product_typeDao = new Product_typeDao();
	
	//��Ӳ�
	public void addProduct(Product product,String ptname) {
		try {
			int count = product_typeDao.countProduct_Type(ptname);
			System.out.println(count);
			Product_type type;
			try {
				//ͨ��������Ʒ��������
				if (count < 1) {
					type = new Product_type();
					type.setPtid(new UUIDUtil().getUUID());
					type.setPtname(ptname);
					System.out.println(ptname);
					product_typeDao.addProduct_Type(type);
				} 
			} catch (Exception e) {
				return;
			}
			type = product_typeDao.findProduct_Type(ptname);
			productDao.addProduct(product,type.getPtid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//ͨ����Ʒidɾ����Ʒ
	public void deletProduct(String id) {
		// TODO Auto-generated method stub
		try {
			productDao.deleteProduct(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//ͨ����Ʒ���ֲ�ѯ������Ϣ
	public List<Product> findProduct (String pname) {
		List<Product> product = null;
		try {
			product = productDao.findProduct(pname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}
	
	//��������ȡ������Ʒ
	public List<Product> findProductByPtid (String ptid) {
		List<Product> product = null;
		try {
			product = productDao.findProductByPtid(ptid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}
	
	//��ȡ������Ʒ��Ϣ
	public List<Product> allProduct() {
		List<Product> products = new ArrayList<Product>();
		try {
			products = productDao.findAllProduct();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return products ;
		
	}
	
	//ͨ��id���Ĳ�Ʒ��Ʒ��Ϣ
	public void updateProduct(Product product) throws SQLException{
		productDao.updateProduct(product);
		
	}

	
}
