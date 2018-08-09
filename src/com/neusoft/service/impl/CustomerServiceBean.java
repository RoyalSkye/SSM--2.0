package com.neusoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.neusoft.mapper.CheckinMapper;
import com.neusoft.mapper.CustomerMapper;
import com.neusoft.po.Customer;
import com.neusoft.service.CustomerService;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.neusoft.po.Checkin;

@Service
public class CustomerServiceBean implements CustomerService {
	
	@Autowired
	private CustomerMapper mapper;
	@Autowired
	private CheckinMapper checkinmapper;

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

	@Override
	public List<String> findAllCheckin(Checkin c) throws Exception {
		return checkinmapper.findAllCheckin(c);
	}

	@Override
	public boolean saveCheckin(Checkin c,HttpServletRequest request) throws Exception {  //签到成功，积分+10
		if(checkinmapper.findCheckin(c)==0){
			if(checkinmapper.saveCheckin(c)>0){
				Customer customer=new Customer();
				HttpSession session=request.getSession();
				Gson g=new Gson();
				String phone=g.fromJson(session.getAttribute("phone").toString(),String.class);
				customer.setPhone(phone);
				customer.setCredit(10);
				if(mapper.updateCustomer(customer)<=0) return false;
				return true;
			}
		}
		return false;
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
