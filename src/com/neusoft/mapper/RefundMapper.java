package com.neusoft.mapper;

import java.util.List;

import com.neusoft.po.Refund;
import com.neusoft.tools.Page;

public interface RefundMapper {
	public int updateRefundByOid(Refund refund) throws Exception;
	public int saveRefund(Refund refund) throws Exception;
	public Refund findRefundByOid(int oid) throws Exception;
}