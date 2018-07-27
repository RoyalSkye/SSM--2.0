package com.neusoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.mapper.CustomerMapper;
import com.neusoft.po.Customer;
import com.neusoft.service.CustomerService;

@Service
public class CustomerServiceBean implements CustomerService {
	
	@Autowired
	private CustomerMapper mapper;

	@Override
	public Customer findCustomerByPhone(String phone) throws Exception {
		return mapper.findCustomerByPhone(phone);
	}

	@Override
	public boolean updateCustomer(Customer customer) throws Exception {
		boolean isok=false;
		int result=mapper.updateCustomer(customer);
		if(result>0){
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public boolean saveCustomer(Customer customer) throws Exception {
		boolean isok=false;
		int result=mapper.saveCustomer(customer);
		if(result>0){
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}

	/*@Override
	public boolean login(Customer customer) throws Exception {
		boolean isok=false;
		String phone=customer.getPhone();
		Customer c=mapper.findCustomerByPhone(phone);
		if(c==null){
			System.out.println("customer is null");
			if(mapper.saveCustomer(customer)<=0) isok=false;
		}else{ //原来就存在
			isok=true;
		}
		return isok;
	}*/

}
