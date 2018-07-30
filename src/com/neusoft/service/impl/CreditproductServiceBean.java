package com.neusoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.mapper.CreditproductMapper;
import com.neusoft.po.Creditproduct;
import com.neusoft.service.CreditproductService;
import com.neusoft.tools.Page;

@Service
public class CreditproductServiceBean implements CreditproductService {

	@Autowired
	private CreditproductMapper mapper;
	
	@Override
	public List<Creditproduct> findCreditproductByPage(Page page) throws Exception {
		return mapper.findCreditproductByPage(page);
	}

	@Override
	public boolean saveCreditproduct(Creditproduct c) throws Exception {
		boolean isok=false;
		int result=mapper.saveCreditproduct(c);
		if(result>0){
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public boolean updateCreditproduct(Creditproduct c) throws Exception {
		boolean isok=false;
		int result=mapper.updateCreditproduct(c);
		if(result>0){
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public boolean deleteCreditproduct(int cpid) throws Exception {
		boolean isok=false;
		int result=mapper.deleteCreditproduct(cpid);
		if(result>0){
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public int findCount() throws Exception {
		return mapper.findCount();
	}

	@Override
	public Creditproduct findCreditproductById(int cpid) throws Exception {
		return mapper.findCreditproductById(cpid);
	}

}
