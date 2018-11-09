package com.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.demo.domain.Orders;
import com.demo.domain.User;
import com.demo.util.C3P0Util;
import com.demo.util.UUIDUtil;


public class UserDao {
	
		//�����û���Ϣ
			public void addUser(String username,String upassword) throws SQLException {
				QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
				qRunner.update("insert into user values(?,?,?,?)",new UUIDUtil().getUUID(),username,1,upassword);
			}
			
		//ɾ���û���Ϣ
			public void deleteUSer(String username) throws SQLException {
				QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
				qRunner.update("delete from user where uname = ? or uid = ?",username,username);
			}
			
		//����id����ɾ���û���Ϣ
			public void daleteAllUser (String[] ids) throws SQLException {
				QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
				Object[][] params = new Object[ids.length][];
				for (int i = 0; i < params.length; i++) {
					params[i] = new Object[]{ids[i]};
				}
				qRunner.batch("delete from user where id = ?", params);
			}
			
		//�޸��û���Ϣ
			public void updataUser(User user) throws SQLException {
				QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
				qRunner.update("updata user set uname =?, uidentity =?, upassword=? where uid =? ", user.getUname(),user.getUidentity(),user.getUpassword(),user.getUid());
				
			}
			
		//ͨ��id�����û�
		public User findUserById(String uid) throws SQLException {
			QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
			User user = qRunner.query("select * from user where uid = ?",new BeanHandler<User>(User.class),uid);
			return user;
		}
		
		//ͨ�����ֲ����û�
		public User findUserByName(String uname) throws SQLException {
			QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
			User user = qRunner.query("select * from user where uname = ?", new BeanHandler<User>(User.class),uname);
			/*//��ȡ��������
			List<Orders> orders = qRunner.query("SELECT * FROM USER  u,orders o WHERE u.uid = o.uid AND u.uname = ?",new ResultSetHandler<List<Orders>>(){

				@Override
				public List<Orders> handle(ResultSet rs) throws SQLException {
					List<Orders> orders = new ArrayList<Orders>();
					while (rs.next()) {
						//��װorder����
						Orders order = new Orders();
						order.setOid(rs.getString("oid"));
						order.setAllprice(rs.getDouble("allprice"));
						order.setOstate(rs.getInt("ostate"));
						order.setTid(rs.getInt("tid"));
						orders.add(order);
						
					}
					return orders;
				}},uname);
			
			user.setOrders(orders);*/
			
			return user;
		}
		
		//��ѯ���й˿���Ϣ
		public List<User> findallCustomer() throws SQLException {
			QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
			List<User> costumerlist = qRunner.query("select * from user where uidentity = 1",  new BeanListHandler<User>(User.class));
			return costumerlist;
		}
		
		//��ѯ����Ա����Ϣ
				public List<User> findallUser() throws SQLException {
					QueryRunner qRunner = new QueryRunner(C3P0Util.getDataSource());
					List<User> userlist = qRunner.query("select * from user where uidentity = 0",  new BeanListHandler<User>(User.class));
					return userlist;
				}
		
	
		
		
		
	
}
