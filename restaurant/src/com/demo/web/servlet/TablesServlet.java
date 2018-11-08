package com.demo.web.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.demo.domain.Tables;
import com.demo.service.TablesService;
import com.demo.util.UUIDUtil;

public class TablesServlet extends BaseServlet {
	
	public void queryAll (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		TablesService tablesService = new TablesService();
		List<Tables> tableslist = tablesService.getAllTables();
		HttpSession session = request.getSession();
		session.setAttribute("tablelist", tableslist);
		//分发转向
		response.sendRedirect( request.getContextPath() + "/last.jsp");
	}
	
	
	//添加桌子订单
	public void addTablesServlet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//判断是否支持文件上传
		boolean flag = ServletFileUpload.isMultipartContent(request);
		if(!flag){
			throw new RuntimeException("上传方式错误");
			
		}
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
						String value = fileItem.getString("UTF-8");  //获取字段值
						map.put(name, new String[]{value});          //向map中赋值
						
					} else {
						//文件表单项
						InputStream stream = fileItem.getInputStream();
						String filename = fileItem.getName();   //获取文件名
						String extension = FilenameUtils.getExtension(filename); //获取文件后缀名
						
						if (!"jsp".equals(extension)) {      //保证后缀名不是jsp
							//创建文件目录
							String directoryRealPath = this.getServletContext().getRealPath("upload/table");
							File storeDirectory = new File(directoryRealPath);
							if(!storeDirectory.exists()){
								storeDirectory.mkdirs();    //没有此目录创建此目录
							}
							
							//处理文件名
							if (filename != null) {
								filename = FilenameUtils.getName(filename);    //保证获取文件后缀名
							}
							//解决文件同名问题
							filename =  UUID.randomUUID().toString().charAt(5) + "_" + filename;
							String filename2 = "upload/table/" + filename;
							//上传文件
							fileItem.write(new File(storeDirectory,filename));
							fileItem.delete();    //删除临时文件
							System.out.println(fileItem.getFieldName());
							map.put("timg", new String[]{filename2});
						}
					}
				}
				
				Tables tables = new Tables();
				BeanUtils.populate(tables, map);
				System.out.println("进入");
				//调用业务逻辑
				TablesService ts = new TablesService();
				ts.addTables(tables);
				
				queryAll(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

	//删除桌子
	public void dleteTables (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//获取表单信息
		String tid = request.getParameter("tid");
		int id = Integer.parseInt(tid);
		//处理业务逻辑
		 TablesService ts = new TablesService();
		 ts.deletTables(id);
		 
		
	}
	
	
	
	
	


}
