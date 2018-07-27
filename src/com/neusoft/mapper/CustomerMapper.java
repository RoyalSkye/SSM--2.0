package com.neusoft.mapper;

import com.neusoft.po.Customer;

public interface CustomerMapper {
	public Customer findCustomerByPhone(String phone) throws Exception;
	public int updateCustomer(Customer customer) throws Exception;
	public int saveCustomer(Customer customer) throws Exception;
}
