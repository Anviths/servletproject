package com.tyss.foodapp.dao;

import com.tyss.foodapp.dto.User;

public interface UserDao {

	User createUser(User user);
	User findUser(int id);
	User upadteUser(User user);
	boolean deleteUser(int id);
	User login(String email,String password);
}
