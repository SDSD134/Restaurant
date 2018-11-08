package com.demo.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.demo.dao.UserDao;
import com.demo.domain.User;
import com.demo.util.UUIDUtil;

public class UserService {
	UserDao dao = new UserDao();
	//通过名字获取用户信息
	public User findUserByName(String username) {
		
		User user = new User();
		try {
			user = dao.findUserByName(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	//通过id查找用户
public User findUserByID(String uid) {
		
		User user = new User();
		try {
			user = dao.findUserById(uid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	//获取所有用户信息
	public List<User> queryAll() {
		List<User> userlist = new ArrayList<User>();
		try {
			userlist = dao.findallCustomer();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userlist;
	}

	//添加用户信息
	public void addUser(String username, String upassword) throws SQLException {
		// TODO Auto-generated method stub
		dao.addUser(username,upassword);
	}

	public void deletUser(String username) {
		// TODO Auto-generated method stub
		try {
			dao.deleteUSer(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<User> allCostumer() throws SQLException {
		List<User> costumerList = null;
		costumerList = dao.findallCustomer();
		return costumerList;
	}
}

