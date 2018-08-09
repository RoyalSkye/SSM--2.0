package com.neusoft.control;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.service.CouponService;
import com.neusoft.service.CreditproductService;
import com.google.gson.Gson;
import com.neusoft.po.Coupon;
import com.neusoft.po.Creditproduct;;

@Controller
public class CouponHandler {
	
	@Autowired
	private CouponService couponService;
	@Autowired
	private CreditproductService creditproductService;
	
	@RequestMapping(value="/test/CouponHandler_findCouponByCid")
	@ResponseBody
	public List<Coupon> findCouponByid(HttpServletRequest request) throws Exception{
		Date date=new Date();
		SimpleDateFormat ft =new SimpleDateFormat ("yyyy-MM-dd");
		HttpSession session=request.getSession();
		Gson g=new Gson();
		String phone=g.fromJson(session.getAttribute("phone").toString(),String.class);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("currenttime", ft.format(date));
		map.put("phone", phone);
		return couponService.findCouponByCid(map);
	}
	
	@RequestMapping(value="/test/CouponHandler_findCreditproduct")
	@ResponseBody
	public List<Creditproduct> findCreditproduct() throws Exception{
		return creditproductService.findCreditproduct();
	}
	
	@RequestMapping(value="/test/CouponHandler_exchangeCreditproduct")
	@ResponseBody
	public String saveCoupon1(int cpid,HttpServletRequest request) throws Exception{  //”√ªß∂“ªª”≈ª›»Ø
		if(couponService.saveCoupon1(cpid,request)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}

}
