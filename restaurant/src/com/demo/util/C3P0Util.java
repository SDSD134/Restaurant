package com.demo.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	//获取数据源
	private static DataSource dataSource = new ComboPooledDataSource();
	
	//获取连接
	public  static Connection getConnection(){
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("服务器繁忙");
		}
	}
	
	public void  releas(Connection connection,Statement statement,ResultSet rSet) {
		if(rSet!=null){
			try {
				rSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rSet = null;
		}
		if(statement!=null){
			try {
				statement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			statement = null;
		}
		if(connection!=null){
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			connection = null;
		}
	}
	
	public static DataSource getDataSource() {
		return dataSource;
	}
}
