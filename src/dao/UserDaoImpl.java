package dao;

import org.apache.commons.dbutils.handlers.BeanHandler;

import utils.DaoUtils;
import domain.User;

public class UserDaoImpl implements UserDao{
	
	public User findUserByUname(String username) {
		//1����дsql���
		String sql= "select * from user where username=?";
		//��ȡ���ݿ�����
		return DaoUtils.query(sql, new BeanHandler<User>(User.class), username);
	}

	public void addUser(User user) {
		//1����дsql���
		String sql = "insert into user(username,password,nickname,email)" +
				" values(?,?,?,?)";
		DaoUtils.update(sql, user.getUsername(),user.getPassword(),
				user.getNickname(),user.getEmail());
		
	}
	public User findUserByUnamePwd(String username, String password) {
		//1����дsql���
		String sql= "select * from user where username=? and password=?";
		//��ȡ���ݿ�����
		return DaoUtils.query(sql, new BeanHandler<User>(User.class), 
				username,password);
	}

}
