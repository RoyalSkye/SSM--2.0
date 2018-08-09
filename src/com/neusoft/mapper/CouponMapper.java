package com.neusoft.mapper;

import java.util.List;
import java.util.Map;

import com.neusoft.po.Coupon;

public interface CouponMapper {
	public List<Coupon> findCouponByCid(Map map) throws Exception;  //�õ���������Ч���ڵ��Ż�ȯ
	public int saveCoupon(Coupon c) throws Exception;  //�û�ʹ�û��ֻ���Ż�ȯʱ����
	public int deleteCoupon(Coupon c) throws Exception;  //�û�����γ�ʱ����
	public List<Coupon> findCouponByCondition(Coupon c) throws Exception; //�������ں����ɸѡ�Ż�ȯ
	public Coupon findCouponById(int couponid) throws Exception;
	public int updateCoupon(Coupon c) throws Exception;  //�û�ʹ���Ż�ȯ�� valid-->0
}
