package com.neusoft.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.neusoft.mapper.CouponMapper;
import com.neusoft.mapper.CreditproductMapper;
import com.neusoft.mapper.CustomerMapper;
import com.neusoft.po.Coupon;
import com.neusoft.po.Creditproduct;
import com.neusoft.po.Customer;
import com.neusoft.service.CouponService;

@Service
public class CouponServiceBean implements CouponService {

	@Autowired
	private CouponMapper mapper;
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private CreditproductMapper creditproductMapper;
	
	
	@Override
	public List<Coupon> findCouponByCid(Map map) throws Exception {
		return mapper.findCouponByCid(map);
	}

	@Override
	public boolean saveCoupon(Coupon c) throws Exception {
		boolean isok=false;
		int result=mapper.saveCoupon(c);
		if(result>0){
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public boolean deleteCoupon(Coupon c) throws Exception {
		boolean isok=false;
		int result=mapper.deleteCoupon(c);
		if(result>0){
			isok=true;
		}else{
			isok=false;
		}
		return isok;
	}

	@Override
	public List<Coupon> findCouponByCondition(Coupon c) throws Exception {
		return mapper.findCouponByCondition(c);
	}

	@Override
	public boolean saveCoupon1(int cpid,HttpServletRequest request) throws Exception {
		boolean isok=false;
		HttpSession session=request.getSession();
		Gson g=new Gson();
		String phone=g.fromJson(session.getAttribute("phone").toString(),String.class);
		Creditproduct creditproduct=creditproductMapper.findCreditproductById(cpid);
		Customer c=customerMapper.findCustomerByPhone(phone);
		if(c!=null && creditproduct!=null && c.getCredit()>=creditproduct.getCredit()){
			Coupon coupon=new Coupon();
			coupon.setCategory(creditproduct.getCategory());
			coupon.setPhone(phone);
			Date date=new Date();
			SimpleDateFormat ft =new SimpleDateFormat ("yyyy-MM-dd");
		    coupon.setStarttime(ft.format(date));
		    
		    Calendar now = Calendar.getInstance(); 
			now.add(Calendar.DAY_OF_YEAR, creditproduct.getDuration());
			date=now.getTime();
			String time=ft.format(date);
		    coupon.setEndtime(time);
		    
		    coupon.setDiscount(creditproduct.getDiscount());
		    coupon.setName(creditproduct.getCpname());
		    if(mapper.saveCoupon(coupon)<=0) return false;
		    c.setCredit(0-creditproduct.getCredit());
		    if(customerMapper.updateCustomer(c)<=0) return false;
		    isok=true;
		}
		return isok;
	}

}
