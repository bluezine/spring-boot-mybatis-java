package kr.co.bluezine.mapper;

import java.util.List;

import kr.co.bluezine.dao.User;

public interface TestMapper {
	List<User> getUsers();
	User getUser(String id);
	void insertUser(User user);
	void deleteUser(String id);
}
