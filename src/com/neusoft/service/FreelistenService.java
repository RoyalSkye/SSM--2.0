package com.neusoft.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.neusoft.po.Freelisten;
import com.neusoft.tools.Page;

public interface FreelistenService {
	
	public List<Freelisten> findAllFreelisten(Page page) throws Exception;
	public Freelisten findFreelistenById(int fid) throws Exception;
	public List<Freelisten> findOnlineFreelisten(int qid)throws Exception;
	public List<Freelisten> findFreelistenByBid(Page page)throws Exception;
	public boolean deleteFreelistenById(int fid) throws Exception;
	public boolean saveFreelisten(Freelisten freelisten) throws Exception;
	public boolean updateFreelisten(Freelisten freelisten) throws Exception;
	public int findCount(int qid) throws Exception;
	public int findCountByBid(int bid) throws Exception;

}
