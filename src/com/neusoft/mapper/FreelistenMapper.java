package com.neusoft.mapper;

import java.util.List;
import java.util.Map;

import com.neusoft.po.Freelisten;
import com.neusoft.tools.Page;

public interface FreelistenMapper {

	public List<Freelisten> findAllFreelisten(Page page) throws Exception;
	public Freelisten findFreelistenById(int fid)throws Exception;
	public List<Freelisten> findOnlineFreelisten(int qid)throws Exception;
	//public List<Freelisten> findFreelistenByBid(int bid)throws Exception;
	public List<Freelisten> findFreelistenByBid(Page page)throws Exception;
	public int deleteFreelistenById(int fid)throws Exception;
	public int saveFreelisten(Freelisten freelisten)throws Exception;
	public int updateFreelisten(Freelisten freelisten)throws Exception;
	public int findCount(int qid) throws Exception;
	public int findCountByBid(int bid) throws Exception;
}
	

