package com.tyss.foodapp.service;

import java.util.List;

import com.tyss.foodapp.dto.Branch;
import com.tyss.foodapp.dto.User;

public interface BranchService {

	Branch createBranchService(Branch branch);
	Branch updateBranchService(Branch branch);
	boolean deleteBranchService(Branch branch);
	Branch getBranchServiceById(int id);
	User getBranchMangerServiceByBranchId(int id);
	Branch getBranchByBranchName(String branchName);
	List<Branch> getAllBranches();
}
