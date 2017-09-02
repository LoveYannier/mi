package dao;

import domain.User;

public interface UserDao {
	
	
	//ÓÃ»§×¢²á
	void addUser(User user);

	User findUserByUnamePwd(String username, String password);

	User findUserByUname(String username);

}
