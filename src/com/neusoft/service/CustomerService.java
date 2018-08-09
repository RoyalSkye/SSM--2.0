package com.neusoft.service;

import com.neusoft.po.Customer;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.neusoft.po.Checkin;

public interface CustomerService {
	//public Customer login(Customer customer) throws Exception;
	public Customer findCustomerByPhone(String phone) throws Exception;
	public boolean updateCustomer(Customer customer) throws Exception;
	public boolean saveCustomer(Customer customer) throws Exception;
	public List<String> findAllCheckin(Checkin c) throws Exception;
	public boolean saveCheckin(Checkin c,HttpServletRequest request) throws Exception;
}
