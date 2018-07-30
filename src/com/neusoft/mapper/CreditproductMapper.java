package com.neusoft.mapper;

import java.util.List;

import com.neusoft.po.Creditproduct;
import com.neusoft.tools.Page;

public interface CreditproductMapper {
	public List<Creditproduct> findCreditproductByPage(Page page) throws Exception;
	public int saveCreditproduct(Creditproduct c) throws Exception;
	public int updateCreditproduct(Creditproduct c) throws Exception;
	public int deleteCreditproduct(int cpid) throws Exception;
	public int findCount() throws Exception;
	public Creditproduct findCreditproductById(int cpid) throws Exception;
}
