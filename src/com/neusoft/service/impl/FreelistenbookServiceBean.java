package com.neusoft.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.mapper.FreelistenbookMapper;
import com.neusoft.po.Freelistenbook;
import com.neusoft.service.FreelistenbookService;
import com.neusoft.tools.Page;

@Service
public class FreelistenbookServiceBean implements FreelistenbookService {

	@Autowired
	private FreelistenbookMapper mapper;
	
	@Override
	public List<Freelistenbook> findFreelistenbook(Map map) throws Exception {
		return mapper.findFreelistenbook(map);
	}

	@Override
	public List<Freelistenbook> findAllFreelistenbook(Page page) throws Exception {
		return mapper.findAllFreelistenbook(page);
	}
	@Override
	public int findCount() throws Exception{
		return mapper.findCount();
	}

	@Override
	public boolean updateFreelistenbook(Freelistenbook freelistenbook) throws Exception {
		boolean isok=false;
		int result=mapper.updateFreelistenbook(freelistenbook);
		if(result>0){
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public boolean saveFreelistenbook(Freelistenbook freelistenbook) throws Exception {
		boolean isok=false;
		int result=mapper.saveFreelistenbook(freelistenbook);
		if(result>0){
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public int findCountByCondition(Map map) throws Exception {
		return mapper.findCountByCondition(map);
	}

	@Override
	public List<Freelistenbook> findFreelistenbookByPhone(String phone) throws Exception {
		return mapper.findFreelistenbookByPhone(phone);
	}

}
