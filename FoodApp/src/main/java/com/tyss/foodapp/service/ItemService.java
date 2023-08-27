package com.tyss.foodapp.service;

import com.tyss.foodapp.dto.Item;

public interface ItemService {

	Item createItemService(Item item);
	Item updateItemService(Item item);
	boolean deleteItemService(Item item);
	Item findItemService(int id);
	Item findItemByName(String name);
}
