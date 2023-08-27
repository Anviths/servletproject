package com.tyss.foodapp.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.foodapp.dao.UserDao;
import com.tyss.foodapp.databse.EntityController;
import com.tyss.foodapp.dto.User;

public class UserImplementation implements UserDao{

	
	EntityManagerFactory entityManagerFactory=EntityController.entityManagerFactory;
	public EntityManager entityManager=entityManagerFactory.createEntityManager();
	public EntityTransaction entityTransaction=entityManager.getTransaction();
	
	@Override
	public User createUser(User user) {
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return user;
	}

	@Override
	public User findUser(int id) {
		return entityManager.find(User.class, id);
		
	}

	@Override
	public User upadteUser(User user) {
		
		entityTransaction.begin();
		entityManager.merge(user);
		entityTransaction.commit();
		return user;
	}

	@Override
	public boolean deleteUser(int id) {
		User user =findUser(id);
		if(user!=null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	@Override
	public User login(String email, String password) {
		Query query=entityManager.createQuery("select u from User u where email=?1 and password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		try {
			
			return (User) query.getSingleResult();
		}
		catch (Exception e) {
			return null;
		}
		
	}
}
