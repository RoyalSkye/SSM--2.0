package com.neusoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.mapper.FreelistenMapper;
import com.neusoft.po.Freelisten;
import com.neusoft.service.FreelistenService;
import com.neusoft.tools.Page;

@Service
public class FreelistenServiceBean implements FreelistenService {

	@Autowired
	private FreelistenMapper mapper;
	
	@Override
	public List<Freelisten> findAllFreelisten(Page page) throws Exception {
		return mapper.findAllFreelisten(page);
	}

	@Override
	public Freelisten findFreelistenById(int fid) throws Exception {
		return mapper.findFreelistenById(fid);
	}

	@Override
	public boolean deleteFreelistenById(int fid) throws Exception {
		boolean isok=false;
		int result=mapper.deleteFreelistenById(fid);
		if(result>0){
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public boolean saveFreelisten(Freelisten freelisten) throws Exception {
		boolean isok=false;
		int result=mapper.saveFreelisten(freelisten);
		if(result>0){
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public boolean updateFreelisten(Freelisten freelisten) throws Exception {
		boolean isok=false;
		int result=mapper.updateFreelisten(freelisten);
		if(result>0){
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public List<Freelisten> findFreelistenByBid(Page page) throws Exception {
		return mapper.findFreelistenByBid(page);
	}

	@Override
	public int findCount(int qid) throws Exception {
		
		return mapper.findCount(qid);
	}
	
	@Override
	public int findCountByBid(int bid) throws Exception {
		
		return mapper.findCountByBid(bid);
	}

	@Override
	public List<Freelisten> findOnlineFreelisten(int qid) throws Exception {
		return mapper.findOnlineFreelisten(qid);
	}

}
