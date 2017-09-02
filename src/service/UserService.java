package service;

import domain.User;
import exception.MsgException;

public interface UserService {

	//ע��
	void regist(User user) throws MsgException;

	User login(String username, String password);

}
