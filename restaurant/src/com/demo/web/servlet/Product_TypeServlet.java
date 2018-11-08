package com.demo.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.demo.domain.Product;
import com.demo.domain.Product_type;
import com.demo.service.ProductService;
import com.demo.service.Product_TypeService;
import com.demo.util.UUIDUtil;

public class Product_TypeServlet extends BaseServlet {
	
	//输出所有菜的种类名单
	private void queryAll(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取所有菜品种类
		ProductService productService = new ProductService();
		Product_TypeService service = new Product_TypeService();
		List<Product_type> list = service.findAlllProduct_types();
		List<Product> products = new ArrayList<Product>();
		products = productService.allProduct();   //所有商品
		request.setAttribute("alltype", list);
		request.getSession().setAttribute("allproduct", products);
		response.getWriter().print(true);
		
		
	}
	
	//添加菜品种类
	public void addProduct_Type(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException {
		String productTypeName = request.getParameter("ptname");
		Product_type type = new Product_type();
		type.setPtid(new UUIDUtil().getUUID());
		try {
			BeanUtils.populate(type, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//分发转向
		queryAll(request,response);
		
	}
	
	//删除菜品种类
	public void deletProduct_Type(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException{
		
		String ptid = request.getParameter("ptid");
		Product_TypeService service = new Product_TypeService();
		service.deleteProduct_Type(ptid);
		queryAll(request, response);
		
		
	}

	

}
