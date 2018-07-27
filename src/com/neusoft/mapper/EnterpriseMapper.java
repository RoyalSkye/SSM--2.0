package com.neusoft.mapper;

import java.util.List;

import com.neusoft.po.Enterprise;

public interface EnterpriseMapper {
	public Enterprise findEnterpriseById(int qid) throws Exception;
	public int updateEnterprise(Enterprise e)throws Exception;
}

