package com.neusoft.control;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.service.CouponService;
import com.neusoft.po.Coupon;

@Controller
public class CouponHandler {
	
	@Autowired
	private CouponService couponService;
	
	@RequestMapping(value="/test/CouponHandler_findCouponByCid")
	@ResponseBody
	public List<Coupon> findCouponByCid(Coupon c) throws Exception{
		Date date=new Date();
		SimpleDateFormat ft =new SimpleDateFormat ("yyyy-MM-dd");
		c.setStarttime(ft.format(date));
		return couponService.findCouponByCid(c);
	}
	
	@RequestMapping(value="/test/CouponHandler_findCouponByCondition")
	@ResponseBody
	public List<Coupon> findCouponByCondition(Coupon c) throws Exception{
		return couponService.findCouponByCid(c);
	}

}
