package com.tyss.foodapp.test;

import java.util.List;

import com.tyss.foodapp.dao.BranchDao;
import com.tyss.foodapp.dao.implementation.BranchDaoImplemtation;
import com.tyss.foodapp.dao.implementation.UserImplementation;
import com.tyss.foodapp.dto.Branch;
import com.tyss.foodapp.dto.User;
import com.tyss.foodapp.service.BranchService;
import com.tyss.foodapp.service.implementation.BranchServiceImplementation;
import com.tyss.foodapp.service.implementation.UserServiceImplementation;

public class BranchTest {

	public static void main(String[] args) {

//		Branch branch=new Branch();
//		branch.setName("abc");
//		branch.setEmail("attuABC.COM");
//		branch.setPhoneNumber(90220123);
//		branch.setAddress("manglore");
//		branch.setUser(new UserImplementation().findUser(2));
		
		BranchService branchService=new BranchServiceImplementation();
		List<Branch> allBranches = branchService.getAllBranches();
		for (Branch branch : allBranches) {
			System.out.println(branch.getName());
			
//			User user=new UserServiceImplementation().getUserByBranchId();
		}
//		System.out.println(branchService.getBranchServiceById(3).getName());
//		
//		for (Branch branch : allBranches) {
//			System.out.println(branch.getName());
//			System.out.println(branch.getAddress());
//			System.out.println("==============");
//		}
		
//		User user = branchService.getBranchMangerServiceByBranchId(1);
//		System.out.println(user.getEmail());
//		Branch branchByBranchName = branchService.getBranchByBranchName("abc");
//		System.out.println(branchByBranchName);
//		branchService.createBranchService(branch);
//		BranchDao branchDao=new BranchDaoImplemtation();
//		branchDao.createBranch(branch);
		
//		Branch branch=branchDao.findBranch(1);
//		System.out.println(branch);
		
//		if(branch!=null) {
//			branch.setUser(new UserImplementation().findUser(7));
//			branchDao.upadteBranch(branch);
//		}
		
//		branchDao.deleteBranch(1);
	}

}
