package dao;

import domain.User;

public interface UserDao {
	
	
	//�û�ע��
	void addUser(User user);

	User findUserByUnamePwd(String username, String password);

	User findUserByUname(String username);

}
