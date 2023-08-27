package com.tyss.foodapp.service.implementation;

import javax.persistence.Query;

import com.tyss.foodapp.dao.ItemDao;
import com.tyss.foodapp.dao.implementation.ItemDaoImplentation;
import com.tyss.foodapp.dto.Item;
import com.tyss.foodapp.service.ItemService;

public class ItemServiceImplementation implements ItemService{

	ItemDao itemDao=new ItemDaoImplentation();
	
	@Override
	public Item createItemService(Item item) {
		
		return itemDao.createItem(item);
	}

	@Override
	public Item updateItemService(Item item) {
		return itemDao.upadteItem(item);
	}

	@Override
	public boolean deleteItemService(Item item) {
		return itemDao.deleteItem(item.getId());
	}

	@Override
	public Item findItemService(int id) {
		
		return itemDao.findItem(id);
	}

	@Override
	public Item findItemByName(String name) {
		Query query=((ItemDaoImplentation)itemDao).entityManager.createQuery("select i from Item i where name=1?");
		query.setParameter(1, name);
		try {
			return (Item)query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

}
