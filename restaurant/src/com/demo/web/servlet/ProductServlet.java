package com.demo.web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.demo.dao.Product_typeDao;
import com.demo.domain.Product;
import com.demo.domain.Product_type;
import com.demo.domain.Tables;
import com.demo.service.ProductService;
import com.demo.service.Product_TypeService;
import com.demo.service.TablesService;

public class ProductServlet extends BaseServlet {
	//选择所有商品和商品种类
	public void queryAll(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Product_TypeService  typeService = new Product_TypeService();
		ProductService productService = new ProductService();
		List<Product> products = new ArrayList<Product>();
		List<Product_type> types = new ArrayList<Product_type>();
		products = productService.allProduct();   //所有商品
		types = typeService.findAlllProduct_types();
		request.getSession().setAttribute("alltype", types);
		request.getSession().setAttribute("allproduct", products);
		
		response.getWriter().print(true);
		
		
		//分发转向
		//request.getRequestDispatcher("/last.jsp").forward(request, response);  //转向菜品主页
		
	}
	
	//添加商品
	public void addProduct (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
					request.setCharacterEncoding("UTF-8");
					//创建一个diskfileitemfactory工厂
					DiskFileItemFactory factory = new DiskFileItemFactory();
					//创建一个servletfileupload对象
					ServletFileUpload fileUpload = new ServletFileUpload(factory);
					fileUpload.setHeaderEncoding("UTF-8");  //解决上传文件乱码 问题
					//解析request对象，返回所有表单项
					List<FileItem> fileItems = new ArrayList<FileItem>();
					//用于包装普通表单数据
					Map<String , String[]> map = new HashMap<String, String[]>();
					
					try {
						fileItems = fileUpload.parseRequest(request);
						
						//迭代表单项
						for (FileItem fileItem : fileItems) {
							if (fileItem.isFormField()) {
								//普通表单项
								String name = fileItem.getFieldName(); //获取字段名
								System.out.println(name);
								String value = fileItem.getString("UTF-8");  //获取字段值
								System.out.println(value);
								map.put(name, new String[]{value});          //向map中赋值
								
							} else {
								//文件表单项
								//InputStream stream = fileItem.getInputStream();
								String filename = fileItem.getName();   //获取文件名
								System.out.println(filename + "filename");
								String extension = FilenameUtils.getExtension(filename); //获取文件后缀名
								if (!"jsp".equals(extension)) {      //保证后缀名不是jsp
									//创建文件目录
									File storeDirectory = new File(this.getServletContext().getRealPath("/upload/product"));
									System.out.println(this.getServletContext().getRealPath("/upload/product"));
									if(!storeDirectory.exists()){
										storeDirectory.mkdirs();    //没有此目录创建此目录
									}
									
									//处理文件名
									if (filename != null) {
										filename = FilenameUtils.getName(filename);    //保证获取文件后缀名
									}
									//解决文件同名问题
									filename =  UUID.randomUUID().toString().charAt(5) + "_" + filename;
									String filename2 = "upload/product/" + filename;
									//上传文件
									fileItem.write(new File(storeDirectory,filename));
									fileItem.delete();    //删除临时文件
									map.put(fileItem.getFieldName(), new String[]{filename2});
								}
							}
						}
						
						Product product = new Product();
						BeanUtils.populate(product, map);
						
						//调用业务逻辑
						
						//获取菜品种类id
						String[] name = map.get("ptname");
						String ptname ="";
						for (int i = 0; i < name.length; i++) {
							ptname += name[i];
						}
						ProductService ps = new ProductService();
						ps.addProduct(product,ptname);
									
						//分发转向
						queryAll(request, response);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
		
	}
	
	//通过菜的名字删除商品内容
	public void deletProduct(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException {
		String id = request.getParameter("pide");
		ProductService service = new ProductService();
		service.deletProduct(id);
		
		queryAll(request, response);
		
	}
	
	
	//改变菜的信息
	public void updateProduct(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{
		System.out.println("进入");
		//获取表单数据
		request.setCharacterEncoding("UTF-8");
		String ptname = request.getParameter("ptname");
		
		System.out.println(ptname);
		Product product = new Product();
		BeanUtils.populate(product, request.getParameterMap());
		System.out.println(product);
		Product_type product_type =null;
		//处理业务逻辑
		Product_TypeService product_TypeService = new Product_TypeService();
		int count = product_TypeService.CountProduct_Type(ptname);
		if (count > 0) {
			//获取菜类对象
			product_type = product_TypeService.findProduct_type(ptname);
		} else {
			//添加菜品
			product_TypeService.addProduct_Type(ptname);
			product_type = product_TypeService.findProduct_type(ptname);
			
		}
		product.setProduct_type(product_type);
		//改变这个菜的信息
		ProductService service = new ProductService();
		service.updateProduct(product);
		queryAll(request, response);
		
		
	}
	
	//通过名字查询商品
	public void searchProduct (HttpServletRequest request ,HttpServletResponse response) 
			throws Exception {
		//获取商品名字
		String pname = request.getParameter("pname");
		pname = new String(pname.getBytes("iso-8859-1"),"UTF-8");
		
		List<Product> product = new ArrayList<Product>();
		ProductService productService = new ProductService();
		product = productService.findProduct(pname);
		request.getSession().setAttribute("allproduct", product);
		response.getWriter().print(true);
	}
	
	//通过种类查询商品
	public void findProductByPtid (HttpServletRequest request,HttpServletResponse response ) 
			throws Exception {
		String ptid = request.getParameter("ptid");
		ptid = new String(ptid.getBytes("iso-8859-1"),"UTF-8");
		ProductService service = new ProductService();
		List<Product> productlist = new ArrayList<Product>();
		productlist = service.findProductByPtid(ptid);
		request.getSession().setAttribute("allproduct", productlist);
		response.getWriter().print(true);
	}
	

	

}
