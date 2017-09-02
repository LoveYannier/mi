package service;

import domain.User;
import exception.MsgException;

public interface UserService {

	//зЂВс
	void regist(User user) throws MsgException;

	User login(String username, String password);

}
