package com.demo.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.demo.domain.User;
import com.demo.service.UserService;

public class UserServlet extends BaseServlet {
    //获取所有员工信息
	public void queryAll(HttpServletRequest request,HttpServletResponse response) 
			throws IOException {
		response.setContentType("text/html;charset=UTF-8");
	    UserService service = new UserService();
	    List<User> users = new ArrayList<User>();
	  //  List<Map> userslist = new ArrayList<Map>();
	    users = service.queryAll();
	    request.getSession().setAttribute("userlist", users);
	   response.getWriter().print(true);
	   /*for (User user : users) {
	    	Map map = new HashMap();
			map.put("name", user.getUname());
			map.put("password", user.getUpassword());
			userslist.add(map);
		}
	    String json = JSONArray.fromObject(userslist).toString();*/
	    response.setDateHeader("expires", -1);
	    //response.getWriter().print(json);
	    
	}
	
	//查询用户信息
	public void findUser (HttpServletRequest request,HttpServletResponse response) 
			throws IOException{
		String username = request.getParameter("username");
		List<User> users = new ArrayList<User>();
		//System.out.println(username);
		UserService service = new UserService();
		if ("".equals(username)) {
			users= service.queryAll();
			
		}else {
			User user = service.findUserByName(username);
			users.add(user);
			//System.out.println(users);
			
		}
		
		System.out.println(users);
		
		
		
			request.getSession().setAttribute("costumerlist", users);
			response.getWriter().write("true");
		
	}
	
	//注册员工信息
	public void register(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		//request.setCharacterEncoding("UTf-8");
		String username = request.getParameter("username");
		username = new String(username.getBytes("iso-8859-1"),"UTF-8") ; 
		String upassword = request.getParameter("password");
		upassword = new String(upassword.getBytes("iso-8859-1"),"UTF-8"); 
		//System.out.println(username);
		//System.out.println(upassword);
		
		UserService service = new UserService();
		User user = service.findUserByName(username);
		//System.out.println(user);
		if (user == null) {
			try {
				service.addUser(username,upassword);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			queryAll(request, response);
		}else {
			System.out.println("凉凉");
			response.getWriter().print(false);
			
		}
	
}
	
	//删除员工信息
	public void deleteUser (HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		String username = request.getParameter("username");
		username = new String(username.getBytes("iso-8859-1"),"UTF-8"); 
		System.out.println(username);
		UserService service = new UserService();
		service.deletUser(username);
		queryAll(request, response);
	}
	
	//获取所有顾客信息
	public void allCostumer(HttpServletRequest request,HttpServletResponse response) 
			throws Exception {
		UserService service = new UserService();
		List<User> list = new ArrayList<User>();
		list = service.allCostumer();
		request.getSession().setAttribute("costumerlist", list);
		response.getWriter().print(true);
	}
}
