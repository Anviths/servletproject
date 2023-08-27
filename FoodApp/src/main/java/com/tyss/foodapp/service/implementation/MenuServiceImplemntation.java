package com.tyss.foodapp.service.implementation;

import java.util.List;

import javax.persistence.Query;

import com.tyss.foodapp.dao.implementation.MenuDaoImplementation;
import com.tyss.foodapp.dto.Branch;
import com.tyss.foodapp.dto.Menu;
import com.tyss.foodapp.dto.User;
import com.tyss.foodapp.service.MenuService;

public class MenuServiceImplemntation implements MenuService{
 
   MenuDaoImplementation menuDao=new MenuDaoImplementation();
	
	@Override
	public Menu createMenuService(Menu menu) {
		return menuDao.createMenu(menu) ;
	}

	@Override
	public Menu updateMenuService(Menu menu) {
		
		return menuDao.upadteMenu(menu);
	}

	@Override
	public boolean deleteMenuService(Menu menu) {
		return menuDao.deleteMenu(menu.getId());
	}

	@Override
	public Menu getMenuServiceById(int menuId) {
		
		return menuDao.findMenu(menuId);
	}

	@Override
	public Menu getMenuServiceByBranchId(int branchId) {
		Query query=menuDao.entityManager.createQuery("select b from Branch b where id=?1");
		query.setParameter(1, branchId);
		try {
			Branch branch=(Branch) query.getSingleResult();
			Query menuquery=menuDao.entityManager.createQuery("select m from Menu m where =?1");
			menuquery.setParameter(1, branch.getUser());
			return (Menu) menuquery.getSingleResult();
		}
		catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public Menu getMenuServiceByUserId(int userId) {
		Query queryu=menuDao.entityManager.createQuery("select u from User u where id=?1");
		try {
			queryu.setParameter(1, userId);
			User user=(User) queryu.getSingleResult();
			
			if(user!=null) {
		Query query=menuDao.entityManager.createQuery("select m from Menu m where user_id=?1");
		query.setParameter(1, user.getId());
			return (Menu) query.getSingleResult();
		}
		}
		catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public List<Menu> getAllMenu() {
		Query query=menuDao.entityManager.createQuery("select m from Menu m ");
		return query.getResultList();
	}

}
