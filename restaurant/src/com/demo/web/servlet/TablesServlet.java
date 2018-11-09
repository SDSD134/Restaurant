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
		//�ַ�ת��
		response.sendRedirect( request.getContextPath() + "/last.jsp");
	}
	
	
	//������Ӷ���
	public void addTablesServlet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�ж��Ƿ�֧���ļ��ϴ�
		boolean flag = ServletFileUpload.isMultipartContent(request);
		if(!flag){
			throw new RuntimeException("�ϴ���ʽ����");
			
		}
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
						String value = fileItem.getString("UTF-8");  //��ȡ�ֶ�ֵ
						map.put(name, new String[]{value});          //��map�и�ֵ
						
					} else {
						//�ļ�����
						InputStream stream = fileItem.getInputStream();
						String filename = fileItem.getName();   //��ȡ�ļ���
						String extension = FilenameUtils.getExtension(filename); //��ȡ�ļ���׺��
						
						if (!"jsp".equals(extension)) {      //��֤��׺������jsp
							//�����ļ�Ŀ¼
							String directoryRealPath = this.getServletContext().getRealPath("upload/table");
							File storeDirectory = new File(directoryRealPath);
							if(!storeDirectory.exists()){
								storeDirectory.mkdirs();    //û�д�Ŀ¼������Ŀ¼
							}
							
							//�����ļ���
							if (filename != null) {
								filename = FilenameUtils.getName(filename);    //��֤��ȡ�ļ���׺��
							}
							//����ļ�ͬ������
							filename =  UUID.randomUUID().toString().charAt(5) + "_" + filename;
							String filename2 = "upload/table/" + filename;
							//�ϴ��ļ�
							fileItem.write(new File(storeDirectory,filename));
							fileItem.delete();    //ɾ����ʱ�ļ�
							System.out.println(fileItem.getFieldName());
							map.put("timg", new String[]{filename2});
						}
					}
				}
				
				Tables tables = new Tables();
				BeanUtils.populate(tables, map);
				System.out.println("����");
				//����ҵ���߼�
				TablesService ts = new TablesService();
				ts.addTables(tables);
				
				queryAll(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

	//ɾ������
	public void dleteTables (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//��ȡ����Ϣ
		String tid = request.getParameter("tid");
		int id = Integer.parseInt(tid);
		//����ҵ���߼�
		 TablesService ts = new TablesService();
		 ts.deletTables(id);
		 
		
	}
	
	
	
	
	


}
