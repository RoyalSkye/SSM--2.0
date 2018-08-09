package com.neusoft.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.neusoft.po.Coupon;

public interface CouponService {
	public List<Coupon> findCouponByCid(Map map) throws Exception;  //得到的是在有效期内的优惠券
	public boolean saveCoupon(Coupon c) throws Exception;
	public boolean saveCoupon1(int cpid,HttpServletRequest request) throws Exception;  //用户兑换优惠券
	public boolean deleteCoupon(Coupon c) throws Exception;
	public List<Coupon> findCouponByCondition(Coupon c) throws Exception; //根据日期和类别筛选优惠券
}
