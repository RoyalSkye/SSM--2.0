package com.neusoft.service;

import java.util.List;

import com.neusoft.po.Refund;
import com.neusoft.tools.Page;

public interface RefundService {
	public boolean updateconfirmRefund(Refund refund) throws Exception;
	public Refund findRefundByOid(int oid) throws Exception;
	public boolean updatedenyRefund(Refund refund) throws Exception;
	public boolean saveRefund(Refund refund) throws Exception;
}