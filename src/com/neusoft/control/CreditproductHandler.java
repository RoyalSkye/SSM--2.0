package com.neusoft.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neusoft.po.Branch;
import com.neusoft.po.Creditproduct;
import com.neusoft.service.CreditproductService;
import com.neusoft.tools.FileTools;
import com.neusoft.tools.Page;

@Controller
public class CreditproductHandler {
	
	@Autowired
	private CreditproductService creditproductService;
	
	@RequestMapping(value="/test/CreditproductHandler_findCreditproductByPage",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findCreditproductByPage(HttpServletRequest request) throws Exception{
		int limit = Integer.parseInt(request.getParameter("limit"));
		int pages = Integer.parseInt(request.getParameter("page"));
		Page page = new Page(limit,pages);
		page.setTotalPage(creditproductService.findCount());
		return FileTools.addHeader(creditproductService.findCreditproductByPage(page),page.getTotalPage());
	}
	
	@RequestMapping(value="/test/CreditproductHandler_deleteCreditproduct")
	@ResponseBody
	public String deleteCreditproduct(int cpid) throws Exception{
		if(creditproductService.deleteCreditproduct(cpid)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	
	@RequestMapping(value="/test/CreditproductHandler_saveCreditproduct")
	@ResponseBody
	public String saveCreditproduct(Creditproduct c) throws Exception{
		if(creditproductService.saveCreditproduct(c)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	
}
