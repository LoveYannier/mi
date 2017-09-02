package service;

import dao.UserDao;
import dao.UserDaoImpl;
import domain.User;
import exception.MsgException;

public class UserServiceImpl implements UserService{

	private UserDao userDao =new UserDaoImpl();
	
	
	//�û���ע��
	public void regist(User user) throws MsgException {
		if(userDao.findUserByUname(user.getUsername())!=null){
			throw new MsgException("�û����Ѿ����ڣ�");
		}
		//2����������ڣ���ִ����Ӳ���
		userDao.addUser(user);
	}
	


	public User login(String username, String password) {
		return userDao.findUserByUnamePwd(username,password);
	}
	
	public User findByUsername(String username) {
		return userDao.findUserByUname(username);
	}

}
