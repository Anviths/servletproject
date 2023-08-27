package com.tyss.foodapp.dao;

import com.tyss.foodapp.dto.Menu;

public interface MenuDao {

	Menu createMenu(Menu menu);

	Menu findMenu(int id);

	Menu upadteMenu(Menu menu);

	boolean deleteMenu(int id);
}
