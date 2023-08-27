package com.tyss.foodapp.service.implementation;

import java.util.List;

import javax.persistence.Query;

import com.tyss.foodapp.dao.implementation.FoodProductDaoImplementation;
import com.tyss.foodapp.dto.Branch;
import com.tyss.foodapp.dto.FoodProduct;
import com.tyss.foodapp.dto.Menu;
import com.tyss.foodapp.service.FoodProductService;

public class FoodProductServiceImplementation implements FoodProductService{
   FoodProductDaoImplementation foodProductDao =new FoodProductDaoImplementation();
	@Override
	public FoodProduct createFoodProduct(FoodProduct foodProduct) {
		return foodProductDao.createFoodProduct(foodProduct);
	}

	@Override
	public FoodProduct updateFoodProduct(FoodProduct foodProduct) {
		// TODO Auto-generated method stub
		return foodProductDao.upadteFoodProduct(foodProduct);
	}

	@Override
	public boolean deleteFoodProduct(FoodProduct foodProduct) {
		return foodProductDao.deleteFoodProduct(foodProduct.getId());
	}

	@Override
	public FoodProduct getFoodProductById(int id) {
		return foodProductDao.findFoodProduct(id);
	}

	@Override
	public FoodProduct getFoodProductByName(String name) {
		Query query=foodProductDao.entityManager.createQuery("select f from FoodProduct f where name=?1");
		query.setParameter(1, name);
		try {
			return (FoodProduct) query.getSingleResult();
		}
		catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<FoodProduct> getFoodProductByBranchId(int branchId) {
		try {
		Query query=foodProductDao.entityManager.createQuery("select b from Branch b where name=?1");
		query.setParameter(1, branchId);
		Branch branch=(Branch) query.getSingleResult();
		Query menuquery=foodProductDao.entityManager.createQuery("select b from Branch b where name=?1");
		Menu menu= (Menu)menuquery.setParameter(1, branch.getUser());
		
		return getFoodProductByBranchId(menu.getId());
		}
		catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<FoodProduct> getFoodProductByMenuId(int menuId) {
		Query query=foodProductDao.entityManager.createQuery("select f from FoodProduct f where menu_id=?1");
		query.setParameter(1, menuId);
		
		return query.getResultList();
	}

	@Override
	public List<FoodProduct> getFoodAllProducts() {
		Query query=foodProductDao.entityManager.createQuery("select f from FoodProduct f");
		return query.getResultList();
	}

}
