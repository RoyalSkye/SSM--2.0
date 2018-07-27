package com.neusoft.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.neusoft.po.Order;
import com.neusoft.tools.Page;

public interface OrderMapper {

	public List<Order> findAllOrder(Page page) throws Exception;
	public List<Order> findOrder(Map map) throws Exception;  //订单查询 退款处理 订单核销
	public List<Order> findOrderByPhone(String phone) throws Exception;
	public Order findOrderByOid(int oid) throws Exception;
	public int updateOrder(Order order) throws Exception;
	public List<Order> findAllOrderByPhone(String phone) throws Exception;  //返回一个用户的所有订单
	public int saveOrder(Order order) throws Exception;
	public int findCount(int qid) throws Exception;
	public int findCountByCondition(Map map) throws Exception;
	
}
