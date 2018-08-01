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

import com.neusoft.po.Refund;
import com.neusoft.service.OrderService;
import com.neusoft.service.RefundService;
import com.neusoft.tools.Page;

@Controller
public class RefundHandler {
	@Autowired
	private RefundService refundservice;

	@RequestMapping(value="/test/RefundHandler_confirmRefund")
	@ResponseBody
	public String confirmRefund(Refund refund) throws Exception{
		refund.setStatus("已处理");
		if(refundservice.updateconfirmRefund(refund)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	
	@RequestMapping(value="/test/RefundHandler_denyRefund")
	@ResponseBody
	public String denyRefund(Refund refund) throws Exception{
		refund.setStatus("已处理");
		if(refundservice.updatedenyRefund(refund)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	
	@RequestMapping(value="/test/RefundHandler_saveRefund")
	@ResponseBody
	public String saveRefund(Refund refund) throws Exception{
		refund.setStatus("待处理");
		Date date=new Date();
		SimpleDateFormat ft =new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		refund.setRefundtime(ft.format(date));
		if(refundservice.saveRefund(refund)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	
}
