package com.tyss.foodapp.dao;

import com.tyss.foodapp.dto.Branch;

public interface BranchDao {
 
	Branch createBranch(Branch branch);
	Branch findBranch(int id);
	Branch upadteBranch(Branch branch);
	boolean deleteBranch(int id);
}
