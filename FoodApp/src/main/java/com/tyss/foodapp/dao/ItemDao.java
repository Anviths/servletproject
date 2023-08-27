package com.tyss.foodapp.dao;

import com.tyss.foodapp.dto.Item;

public interface ItemDao {

	Item createItem(Item item);

	Item findItem(int id);

	Item upadteItem(Item item);

	boolean deleteItem(int id);
}
