package com.demo.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.domain.Orders;
import com.demo.domain.User;
import com.demo.service.OrderService;
import com.demo.service.UserService;

public class OrderServlet extends BaseServlet{
	
	public void findThreedayOrder (HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException {
			OrderService orderService = new OrderService();
			//��ȡ��������ж���
			List<Orders> orderlist = new ArrayList<Orders>();
			orderlist = orderService.findThreedayOrder();
//			session.removeAttribute("order");
			request.getSession().setAttribute("orderlist", orderlist);
		    response.getWriter().print(true);
	}
	
	//ͨ������id�ҵ�����
	public void  findOrderByTid(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException {
		//��ȡ����Ϣ
				String tid = request.getParameter("tableid");
				//System.out.println(tid);
				
				
				//����ҵ���߼�
				List<Orders> order = new ArrayList<Orders>();
				OrderService orderService = new OrderService();
				order = orderService.findOrderByTId(tid);
				
				HttpSession session = request.getSession();
				session.setAttribute("orderlist",order);
				
				PrintWriter out = response.getWriter();
				out.print(true);
				
				//request.getRequestDispatcher(request.getContextPath() + "/back.jsp");
				

	}
	
	//ͨ������id�ҵ���ǰ����
	public void findCurrentOrder(HttpServletRequest request,HttpServletResponse response) 
			throws Exception { 
		//��ȡ����Ϣ
		//��ȡ����id
		response.setContentType("text/html;charset=UTF-8");
		String tid = request.getParameter("tid");
		OrderService orderService = new OrderService();
		Orders order = null;
		//ͨ������id��ȡ����
		order = orderService.findCurrentOrder(tid);
		String username = "";
		if(order == null) {
			order = new Orders();
			order.setOid("��");
			order.setAllprice(0.0);
			order.setOstate(0);
			order.setUid("����");
		} else {
			UserService userService = new UserService();
			User user = userService.findUserByID(order.getUid());
			username = user.getUname();
		}
		//HttpSession session = request.getSession();
		//session.setAttribute("order",order);
		PrintWriter out = response.getWriter();
		String str =""; 
		str =  order.getTid() +"," + order.getOstate() + "," + username + "," + order.getOid() + "," + order.getAllprice();
		out.write(str);
	}
	
	//ͨ���˿����ֺͶ���id��ѯ
	public void searchOrder(HttpServletRequest request, HttpServletResponse response) {
		//��ȡǰ̨��Ϣ
		String username = request.getParameter("username");
		String oid = request.getParameter("orderid");
		if(username == null) {
			username = "";
		}
		if (oid == null) {
			oid = "";
		}
		System.out.println(oid);
		//System.out.println("servlet");
		//System.out.println(oid);
		//�����߼�
		OrderService orderService = new OrderService();
		List<Orders> list = new ArrayList<Orders>();
		list = orderService.searchOrders(oid,username);
		//System.out.println(list);
		request.getSession().setAttribute("orderlist", list);
		try {
			response.getWriter().print(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
