package com.neusoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.mapper.BranchMapper;
import com.neusoft.po.Branch;
import com.neusoft.service.BranchService;
import com.neusoft.tools.Page;

@Service
public class BranchServiceBean implements BranchService{

	@Autowired
	private BranchMapper mapper;
	
	@Override
	public List<Branch> findAllBranch(int qid) throws Exception{
		return mapper.findAllBranch(qid);
	}
	@Override
	public Branch findBranchById(int bid) throws Exception{
		return mapper.findBranchById(bid);
		
	}
	
	@Override
	public boolean deleteBranchById(int bid) throws Exception{
		boolean isok=false;
		int result=mapper.deleteBranchById(bid);
		if(result>0){
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}
	
	@Override
	public boolean updateBranch(Branch b) throws Exception{
		boolean isok=false;
		int result=mapper.updateBranch(b);
		if(result>0){
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}
	
	@Override
	public boolean saveBranch(Branch b) throws Exception{
		boolean isok=false;
		int result=mapper.saveBranch(b);
		if(result>0){
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}
	
	@Override
	public int findCount(int qid) throws Exception{
		return mapper.findCount(qid);
	}
	@Override
	public List<Branch> findAllBranchByPage(Page page) throws Exception {
		return mapper.findAllBranchByPage(page);
	}
}
