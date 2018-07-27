package com.neusoft.service;

import com.neusoft.po.Customer;

public interface CustomerService {
	//public Customer login(Customer customer) throws Exception;
	public Customer findCustomerByPhone(String phone) throws Exception;
	public boolean updateCustomer(Customer customer) throws Exception;
	public boolean saveCustomer(Customer customer) throws Exception;
}
