package com.demo.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.demo.wrapper.MyRequest;


public class GlobalFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub'
		//ȫ�ֱ��������
		HttpServletRequest httpServletRequestrequest = (HttpServletRequest) request;
		httpServletRequestrequest = new MyRequest(httpServletRequestrequest);
		chain.doFilter(httpServletRequestrequest, response);
		
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
	
}
