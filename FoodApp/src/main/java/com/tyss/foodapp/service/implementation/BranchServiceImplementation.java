package com.tyss.foodapp.service.implementation;

import java.util.List;

import javax.persistence.Query;

import com.tyss.foodapp.dao.implementation.BranchDaoImplemtation;
import com.tyss.foodapp.dto.Branch;
import com.tyss.foodapp.dto.User;
import com.tyss.foodapp.service.BranchService;

public class BranchServiceImplementation implements BranchService {
  
	BranchDaoImplemtation branchDao =new BranchDaoImplemtation();
	
	@Override
	public Branch createBranchService(Branch branch) {
		
		return branchDao.createBranch(branch);
	}

	@Override
	public Branch updateBranchService(Branch branch) {
		return branchDao.upadteBranch(branch);
	}

	@Override
	public boolean deleteBranchService(Branch branch) {
		return branchDao.deleteBranch(branch.getId());
	}

	@Override
	public Branch getBranchServiceById(int id) {
		return branchDao.findBranch(id);
	}

	@Override
	public User getBranchMangerServiceByBranchId(int id) {
		
		return branchDao.findBranch(id).getUser();
	}

	@Override
	public Branch getBranchByBranchName(String branchName) {
		Query query=branchDao.entityManager.createQuery("select b from Branch b where name=?1");
		query.setParameter(1, branchName);
		try {
			return (Branch)query.getSingleResult();
		}
		catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Branch> getAllBranches() {
		Query query=branchDao.entityManager.createQuery("select b from Branch b  ");
		return query.getResultList();
	}

}
