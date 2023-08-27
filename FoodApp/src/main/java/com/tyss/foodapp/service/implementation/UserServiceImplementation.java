package com.tyss.foodapp.service.implementation;

import java.util.List;

import javax.persistence.Query;

import com.tyss.foodapp.dao.implementation.UserImplementation;
import com.tyss.foodapp.dto.User;
import com.tyss.foodapp.service.UserService;
import com.tyss.foodapp.util.Role;

public class UserServiceImplementation implements UserService {

	
	UserImplementation userDao=new UserImplementation();
	@Override
	public User loginService(String name, String password) {
		return userDao.login(name, password);
		
	}

	@Override
	public User saveService(User user) {
		return userDao.createUser(user);
	}

	@Override
	public User getByIdService(int id) {
		return userDao.findUser(id);
	}

	@Override
	public List<User> getByUserName(String userName) {
		Query query=userDao.entityManager.createQuery("select u from User u where name=?1");
		query.setParameter(1, userName);
		List<User> users  = query.getResultList();
		return users;
	}

	@Override
	public User getByEmail(String email) {
		Query query=userDao.entityManager.createQuery("select u from User u where email=?1");
		query.setParameter(1, email);
		try {
	 return (User) query.getSingleResult();
		}
		catch(Exception e) {
			
			return null;
		}
	}

	@Override
	public User getByPhoneNumber(String phoneNumber) {
		Query query=userDao.entityManager.createQuery("select u from User u where phoneNumber=?1");
		query.setParameter(1, phoneNumber);
		try {
	 return (User) query.getSingleResult();
		}
		catch(Exception e) {
			
			return null;
		}
	}

	@Override
	public User updateService(User user) {
		
		return userDao.upadteUser(user);
	}

	@Override
	public boolean deleteService(User user) {
		return userDao.deleteUser(user.getId());
		
	}

	@Override
	public List<User> getUserByRole(String role) {
		Query query=userDao.entityManager.createQuery("select u from User u where role=?1");
		query.setParameter(1, Role.valueOf(role.toUpperCase()));
		
		
		return query.getResultList();
	}

	

}
