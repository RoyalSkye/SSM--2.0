package com.neusoft.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.neusoft.po.Freelistenbook;
import com.neusoft.tools.Page;

public interface FreelistenbookService {

	public List<Freelistenbook> findFreelistenbook(Map map) throws Exception;
	public boolean updateFreelistenbook(Freelistenbook freelistenbook) throws Exception;
	public boolean saveFreelistenbook(Freelistenbook freelistenbook) throws Exception;
	public List<Freelistenbook> findAllFreelistenbook(Page page) throws Exception;
	public int findCount() throws Exception;
	public int findCountByCondition(Map map) throws Exception;
	public List<Freelistenbook> findFreelistenbookByPhone(String phone) throws Exception;
}
