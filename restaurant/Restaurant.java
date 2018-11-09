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
	//ѡ��������Ʒ����Ʒ����
	public void queryAll(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Product_TypeService  typeService = new Product_TypeService();
		ProductService productService = new ProductService();
		List<Product> products = new ArrayList<Product>();
		List<Product_type> types = new ArrayList<Product_type>();
		products = productService.allProduct();   //������Ʒ
		types = typeService.findAlllProduct_types();
		request.getSession().setAttribute("alltype", types);
		request.getSession().setAttribute("allproduct", products);
		
		response.getWriter().print(true);
		
		
		//�ַ�ת��
		//request.getRequestDispatcher("/last.jsp").forward(request, response);  //ת���Ʒ��ҳ
		
	}
	
	//�����Ʒ
	public void addProduct (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
					request.setCharacterEncoding("UTF-8");
					//����һ��diskfileitemfactory����
					DiskFileItemFactory factory = new DiskFileItemFactory();
					//����һ��servletfileupload����
					ServletFileUpload fileUpload = new ServletFileUpload(factory);
					fileUpload.setHeaderEncoding("UTF-8");  //����ϴ��ļ����� ����
					//����request���󣬷������б���
					List<FileItem> fileItems = new ArrayList<FileItem>();
					//���ڰ�װ��ͨ������
					Map<String , String[]> map = new HashMap<String, String[]>();
					
					try {
						fileItems = fileUpload.parseRequest(request);
						
						//��������
						for (FileItem fileItem : fileItems) {
							if (fileItem.isFormField()) {
								//��ͨ����
								String name = fileItem.getFieldName(); //��ȡ�ֶ���
								System.out.println(name);
								String value = fileItem.getString("UTF-8");  //��ȡ�ֶ�ֵ
								System.out.println(value);
								map.put(name, new String[]{value});          //��map�и�ֵ
								
							} else {
								//�ļ�����
								//InputStream stream = fileItem.getInputStream();
								String filename = fileItem.getName();   //��ȡ�ļ���
								System.out.println(filename + "filename");
								String extension = FilenameUtils.getExtension(filename); //��ȡ�ļ���׺��
								if (!"jsp".equals(extension)) {      //��֤��׺������jsp
									//�����ļ�Ŀ¼
									File storeDirectory = new File(this.getServletContext().getRealPath("/upload/product"));
									System.out.println(this.getServletContext().getRealPath("/upload/product"));
									if(!storeDirectory.exists()){
										storeDirectory.mkdirs();    //û�д�Ŀ¼������Ŀ¼
									}
									
									//�����ļ���
									if (filename != null) {
										filename = FilenameUtils.getName(filename);    //��֤��ȡ�ļ���׺��
									}
									//����ļ�ͬ������
									filename =  UUID.randomUUID().toString().charAt(5) + "_" + filename;
									String filename2 = "upload/product/" + filename;
									//�ϴ��ļ�
									fileItem.write(new File(storeDirectory,filename));
									fileItem.delete();    //ɾ����ʱ�ļ�
									map.put(fileItem.getFieldName(), new String[]{filename2});
								}
							}
						}
						
						Product product = new Product();
						BeanUtils.populate(product, map);
						
						//����ҵ���߼�
						
						//��ȡ��Ʒ����id
						String[] name = map.get("ptname");
						String ptname ="";
						for (int i = 0; i < name.length; i++) {
							ptname += name[i];
						}
						ProductService ps = new ProductService();
						ps.addProduct(product,ptname);
									
						//�ַ�ת��
						queryAll(request, response);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
		
	}
	
	//ͨ���˵�����ɾ����Ʒ����
	public void deletProduct(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException {
		String id = request.getParameter("pide");
		ProductService service = new ProductService();
		service.deletProduct(id);
		
		queryAll(request, response);
		
	}
	
	
	//�ı�˵���Ϣ
	public void updateProduct(HttpServletRequest request,HttpServletResponse response) 
			throws Exception{
		System.out.println("����");
		//��ȡ������
		request.setCharacterEncoding("UTF-8");
		String ptname = request.getParameter("ptname");
		
		System.out.println(ptname);
		Product product = new Product();
		BeanUtils.populate(product, request.getParameterMap());
		System.out.println(product);
		Product_type product_type =null;
		//����ҵ���߼�
		Product_TypeService product_TypeService = new Product_TypeService();
		int count = product_TypeService.CountProduct_Type(ptname);
		if (count > 0) {
			//��ȡ�������
			product_type = product_TypeService.findProduct_type(ptname);
		} else {
			//��Ӳ�Ʒ
			product_TypeService.addProduct_Type(ptname);
			product_type = product_TypeService.findProduct_type(ptname);
			
		}
		product.setProduct_type(product_type);
		//�ı�����˵���Ϣ
		ProductService service = new ProductService();
		service.updateProduct(product);
		queryAll(request, response);
		
		
	}
	
	//ͨ�����ֲ�ѯ��Ʒ
	public void searchProduct (HttpServletRequest request ,HttpServletResponse response) 
			throws Exception {
		//��ȡ��Ʒ����
		String pname = request.getParameter("pname");
		pname = new String(pname.getBytes("iso-8859-1"),"UTF-8");
		
		List<Product> product = new ArrayList<Product>();
		ProductService productService = new ProductService();
		product = productService.findProduct(pname);
		request.getSession().setAttribute("allproduct", product);
		response.getWriter().print(true);
	}
	
	//ͨ�������ѯ��Ʒ
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
