package kr.co.bluezine.service;

import java.util.List;

import kr.co.bluezine.dao.User;

public interface TestService {
	List<User> getUsers();
	User getUser(String id);
	void insertUser(User user);
	void deleteUser(String id);
}
