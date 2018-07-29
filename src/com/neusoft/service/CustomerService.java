package com.neusoft.service;

import com.neusoft.po.Customer;

import java.util.List;

import com.neusoft.po.Checkin;

public interface CustomerService {
	//public Customer login(Customer customer) throws Exception;
	public Customer findCustomerByPhone(String phone) throws Exception;
	public boolean updateCustomer(Customer customer) throws Exception;
	public boolean saveCustomer(Customer customer) throws Exception;
	public List<Checkin> findAllCheckin(int cid) throws Exception;
	public boolean saveCheckin(Checkin c) throws Exception;
}
