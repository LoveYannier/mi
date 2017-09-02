package service;

import dao.UserDao;
import dao.UserDaoImpl;
import domain.User;
import exception.MsgException;

public class UserServiceImpl implements UserService{

	private UserDao userDao =new UserDaoImpl();
	
	
	//用户的注册
	public void regist(User user) throws MsgException {
		if(userDao.findUserByUname(user.getUsername())!=null){
			throw new MsgException("用户名已经存在！");
		}
		//2、如果不存在，则执行添加操作
		userDao.addUser(user);
	}
	


	public User login(String username, String password) {
		return userDao.findUserByUnamePwd(username,password);
	}
	
	public User findByUsername(String username) {
		return userDao.findUserByUname(username);
	}

}
