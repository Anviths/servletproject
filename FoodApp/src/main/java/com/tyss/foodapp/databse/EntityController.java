package com.tyss.foodapp.databse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EntityController {
	public static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	
}
