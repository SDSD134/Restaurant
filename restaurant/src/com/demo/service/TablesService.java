package com.demo.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.demo.dao.TablesDao;
import com.demo.domain.Orders;
import com.demo.domain.Tables;

public class TablesService {
	TablesDao tablesDao = new TablesDao();
	
	
	//增加桌子
	public void addTables(Tables tables) {
		// TODO Auto-generated method stub
		try {
			tablesDao.addTables(tables);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//删除桌子
	public void deletTables(int tid) {
		// TODO Auto-generated method stub
		try { 
			tablesDao.deleteTables(tid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//改变桌子状态和订单状态
	public void updataState(int tid){
		try {
			tablesDao.updateTableState(tid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Tables> getAllTables() {
		// TODO Auto-generated method stub
		List<Tables> tableslist = new ArrayList<Tables>();
		try {
			tableslist = tablesDao.getAllTables();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tableslist;
	}
	
	
	

	
	}

	
	
	
	


