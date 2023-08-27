package com.tyss.foodapp.service;

import java.util.List;

import com.tyss.foodapp.dto.Menu;

public interface MenuService {

	Menu createMenuService(Menu menu);
	Menu updateMenuService(Menu menu);
	boolean deleteMenuService(Menu menu);
	Menu getMenuServiceById(int menuId);
	Menu getMenuServiceByBranchId(int branchId);
	Menu getMenuServiceByUserId(int userId);
	List<Menu> getAllMenu();
}
