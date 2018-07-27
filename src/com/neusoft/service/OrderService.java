package com.neusoft.service;

import java.util.List;
import java.util.Map;

import com.neusoft.po.Order;
import com.neusoft.tools.Page;

public interface OrderService {

	public List<Order> findAllOrder(Page page) throws Exception;
	public Order findOrderByOid(int oid) throws Exception;
	public List<Order> findOrder(Map map) throws Exception;
	public boolean updateOrder(Order order) throws Exception;
	public List<Order> findAllOrderByPhone(String phone) throws Exception;
	public boolean saveOrder(Order order) throws Exception;
	public int findCount(int qid) throws Exception;
	public int findCountByCondition(Map map) throws Exception;
	public List<Order> findOrderByPhone(String phone) throws Exception;
}
