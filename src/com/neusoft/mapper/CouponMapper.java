package com.neusoft.mapper;

import java.util.List;

import com.neusoft.po.Coupon;;

public interface CouponMapper {
	public List<Coupon> findCouponByCid(Coupon c) throws Exception;  //得到的是starttime>=currentdata的
	public int saveCoupon(Coupon c) throws Exception;  //用户使用积分获得优惠券时调用
	public int deleteCoupon(Coupon c) throws Exception;  //用户购买课程时调用
	public List<Coupon> findCouponByCondition(Coupon c) throws Exception; //根据日期和类别筛选优惠券
	
}
