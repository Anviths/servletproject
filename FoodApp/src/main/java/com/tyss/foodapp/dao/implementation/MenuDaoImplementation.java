package com.tyss.foodapp.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.foodapp.dao.MenuDao;
import com.tyss.foodapp.databse.EntityController;
import com.tyss.foodapp.dto.Menu;

public class MenuDaoImplementation implements MenuDao {

	public EntityManagerFactory entityManagerFactory=EntityController.entityManagerFactory;
	public EntityManager entityManager = entityManagerFactory.createEntityManager();
	public EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public Menu createMenu(Menu menu) {
		entityTransaction.begin();
		entityManager.persist(menu);
		entityTransaction.commit();
		return menu;
	}

	@Override
	public Menu findMenu(int id) {
		return entityManager.find(Menu.class, id);

	}

	@Override
	public Menu upadteMenu(Menu menu) {
		entityTransaction.begin();
		entityManager.merge(menu);
		entityTransaction.commit();
		return menu;
	}

	@Override
	public boolean deleteMenu(int id) {
		Menu menu = findMenu(id);
		if (menu != null) {
			entityTransaction.begin();
			entityManager.merge(menu);
			entityManager.remove(menu);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

}
