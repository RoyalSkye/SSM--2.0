package com.neusoft.service;

import java.util.List;

import com.neusoft.po.Creditproduct;
import com.neusoft.tools.Page;

public interface CreditproductService {
	public List<Creditproduct> findCreditproductByPage(Page page) throws Exception;
	public List<Creditproduct> findCreditproduct() throws Exception;
	public boolean saveCreditproduct(Creditproduct c) throws Exception;
	public boolean updateCreditproduct(Creditproduct c) throws Exception;
	public boolean deleteCreditproduct(int cpid) throws Exception;
	public int findCount() throws Exception;
	public Creditproduct findCreditproductById(int cpid) throws Exception;
}
