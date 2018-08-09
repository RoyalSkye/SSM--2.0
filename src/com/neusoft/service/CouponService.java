package com.neusoft.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.neusoft.po.Coupon;

public interface CouponService {
	public List<Coupon> findCouponByCid(Map map) throws Exception;  //�õ���������Ч���ڵ��Ż�ȯ
	public boolean saveCoupon(Coupon c) throws Exception;
	public boolean saveCoupon1(int cpid,HttpServletRequest request) throws Exception;  //�û��һ��Ż�ȯ
	public boolean deleteCoupon(Coupon c) throws Exception;
	public List<Coupon> findCouponByCondition(Coupon c) throws Exception; //�������ں����ɸѡ�Ż�ȯ
}
