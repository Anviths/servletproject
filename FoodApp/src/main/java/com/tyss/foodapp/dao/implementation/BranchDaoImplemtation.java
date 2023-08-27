package com.tyss.foodapp.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.foodapp.dao.BranchDao;
import com.tyss.foodapp.databse.EntityController;
import com.tyss.foodapp.dto.Branch;

public class BranchDaoImplemtation implements BranchDao {

	EntityManagerFactory entityManagerFactory=EntityController.entityManagerFactory;
	public EntityManager entityManager = entityManagerFactory.createEntityManager();
	public EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public Branch createBranch(Branch branch) {
		entityTransaction.begin();
		entityManager.persist(branch);
		entityTransaction.commit();
		return branch;
	}

	@Override
	public Branch findBranch(int id) {
		return entityManager.find(Branch.class, id);

	}

	@Override
	public Branch upadteBranch(Branch branch) {
		entityTransaction.begin();
		entityManager.merge(branch);
		entityTransaction.commit();
		return branch;
	}

	@Override
	public boolean deleteBranch(int id) {
		Branch branch = findBranch(id);
		if (branch != null) {
			entityTransaction.begin();
			entityManager.remove(branch);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

}
