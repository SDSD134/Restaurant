package com.demo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.demo.domain.Tables;
import com.demo.util.C3P0Util;
import com.demo.util.UUIDUtil;

public class TablesDao {
	//��������
	public void addTables (Tables  table) throws SQLException {
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		qRunner.update("insert into tables values(?,?,?,?)",table.getTid(),table.getState(),table.getTvariety(),table.getTimg());
	}
	
	//����idɾ������
	public void deleteTables (int tid) throws SQLException {
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		qRunner.update("delete from tables where tid = ?",tid);
		
	}
	
	/*//����id����ɾ������
	public void deleteAllTables(int[] tids) throws SQLException{
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		Object[][] params = new Object[tids.length][];  //����Ϊִ�д���
		for (int i = 0; i < params.length; i++) {
			params[i] = new Object[]{tids[i]};
		}
		qRunner.batch("delete from tables where tid = ?", params);
	}*/
	
	//����id�޸�������Ϣ
	public void updateTables(Tables tables) throws SQLException{
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		qRunner.update("update tables set taste = ?,tvariety = ?,timg = ? where tid = ? ",tables.getState(),tables.getTvariety(),tables.getTimg(),tables.getTid());
		
	}

	public void updateTableState(int tid) throws SQLException {
		// TODO Auto-generated method stub
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		qRunner.update("update tables set state = 1 where tid = ? ", tid);
		qRunner.update("update orders set ostate = 1 where tid = ?",tid);
	}

	public List<Tables> getAllTables() throws SQLException {
		QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
		List< Tables> tablelist = new ArrayList<Tables>();
		tablelist = qRunner.query("select * from tables", new BeanListHandler<Tables>(Tables.class));
		return tablelist;
	}
	
	
	
	
}
