package com.neusoft.service;

import java.util.List;

import com.neusoft.po.Branch;
import com.neusoft.tools.Page;

public interface BranchService {
	public List<Branch> findAllBranch(int qid) throws Exception;
	public List<Branch> findAllBranchByPage(Page page) throws Exception;
	public Branch findBranchById(int bid) throws Exception;
	public boolean deleteBranchById(int bid) throws Exception;
	public boolean updateBranch(Branch b) throws Exception;
	public boolean saveBranch(Branch b) throws Exception;
	public int findCount(int qid) throws Exception;
}
