package com.tyss.foodapp.service;

import java.util.List;

import com.tyss.foodapp.dto.User;
import com.tyss.foodapp.util.Role;

public interface UserService {

	User loginService(String name,String password);
	User saveService(User user);
	User getByIdService(int id);
	List<User> getByUserName(String userName);
	User getByEmail(String email);
	User getByPhoneNumber(String phoneNumber);
	List<User> getUserByRole(String role);
	User updateService(User user);
	boolean deleteService(User user);
}
