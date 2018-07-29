package com.neusoft.service;

import java.util.List;

import com.neusoft.po.Coupon;

public interface CouponService {
	public List<Coupon> findCouponByCid(Coupon c) throws Exception;  //得到的是starttime>=currentdata的
	public boolean saveCoupon(Coupon c) throws Exception;
	public boolean deleteCoupon(Coupon c) throws Exception;
	public List<Coupon> findCouponByCondition(Coupon c) throws Exception; //根据日期和类别筛选优惠券
}
