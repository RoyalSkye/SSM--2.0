package com.neusoft.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neusoft.mapper.CouponMapper;
import com.neusoft.po.Coupon;
import com.neusoft.service.CouponService;

@Service
public class CouponServiceBean implements CouponService {

	@Autowired
	private CouponMapper mapper;
	
	@Override
	public List<Coupon> findCouponByCid(Coupon c) throws Exception {
		return mapper.findCouponByCid(c);
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

}
