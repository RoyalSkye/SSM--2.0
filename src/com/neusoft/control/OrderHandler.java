package com.neusoft.control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.google.gson.Gson;
import com.neusoft.po.Customer;
import com.neusoft.po.Freelistenbook;
import com.neusoft.po.Order;
import com.neusoft.service.OrderService;
import com.neusoft.tools.FileTools;
import com.neusoft.tools.Page;

@Controller
public class OrderHandler {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/test/OrderHandler_findAllOrder",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findAllOrder(HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		int limit = Integer.parseInt(request.getParameter("limit"));
		int pages = Integer.parseInt(request.getParameter("page"));
		Gson g=new Gson();
		int qid;
		if(request.getSession().getAttribute("qid")==null) qid=1;
		else{
			qid=g.fromJson(session.getAttribute("qid").toString(),int.class);
		}
		Page page = new Page(limit,pages,qid);
		page.setTotalPage(orderService.findCount(page.getId()));
		return FileTools.addHeader(orderService.findAllOrder(page),page.getTotalPage());
	}
	
	@RequestMapping(value="/test/OrderHandler_findOrderByPhone")
	@ResponseBody
	public List<Order> findOrderByPhone(HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		Gson g=new Gson();
		String phone=g.fromJson(session.getAttribute("phone").toString(),String.class);
		return orderService.findOrderByPhone(phone);
	}
	
	@RequestMapping(value="/test/OrderHandler_findOrder",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findOrder(HttpServletRequest request) throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		HttpSession session = request.getSession();
		Gson g=new Gson();
		int qid;
		if(request.getSession().getAttribute("qid")==null) qid=1;
		else{
			qid=g.fromJson(session.getAttribute("qid").toString(),int.class);
		}
		String oid=request.getParameter("oid");
		String status=request.getParameter("status");
		status=java.net.URLDecoder.decode(status,"UTF-8");
		String starttime=request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
		int limit = Integer.parseInt(request.getParameter("limit"));
		int pages = Integer.parseInt(request.getParameter("page"));
		Page page = new Page(limit,pages);
		System.out.println("oid="+oid);
		System.out.println("status="+status);
		System.out.println("starttime="+starttime);
		System.out.println("endtime="+endtime);
		map.put("qid", qid);
		map.put("oid", oid);
		map.put("status", status);
		map.put("starttime", starttime);
		map.put("endtime", endtime);
		map.put("minNum", page.getMinNum());
		map.put("quantity", page.getQuantity());
		page.setTotalPage(orderService.findCountByCondition(map));
		return FileTools.addHeader(orderService.findOrder(map),page.getTotalPage());
	}
	
	@RequestMapping(value="/test/OrderHandler_updateOrder")
	@ResponseBody
	public String updateOrder(Order order,HttpServletRequest request) throws Exception{
		//System.out.println("total="+order.getTotal());
		HttpSession session=request.getSession();
		Gson g=new Gson();
		String phone=g.fromJson(session.getAttribute("phone").toString(),String.class);
		order.setOpenid(phone);
		if(orderService.updateOrder(order)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	
	@RequestMapping(value="/test/OrderHandler_findAllOrderByPhone")
	@ResponseBody
	public List<Order> findAllOrderByPhone(HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		Gson g=new Gson();
		String phone=g.fromJson(session.getAttribute("phone").toString(),String.class);
		return orderService.findAllOrderByPhone(phone);
	}

	@RequestMapping(value="/test/OrderHandler_saveOrder")
	@ResponseBody
	public String saveOrder(Order order,int couponid,HttpServletRequest request) throws Exception{
		System.out.println("couponid="+couponid);
		HttpSession session=request.getSession();
		Gson g=new Gson();
		String phone=g.fromJson(session.getAttribute("phone").toString(),String.class);
		order.setOpenid(phone);
		Date date=new Date();
		SimpleDateFormat ft =new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		order.setOrdertime(ft.format(date));
		int qid;
		if(request.getSession().getAttribute("qid")==null) qid=1;
		else{
			qid=g.fromJson(session.getAttribute("qid").toString(),int.class);
		}
		order.setQid(qid);
		String transactionid=System.currentTimeMillis()+"";
		order.setTransactionid(transactionid);
		System.out.println("transactionid"+transactionid+"test");
		if(couponid==0){
			order.setActual(order.getTotal());
		}else{  //使用了优惠券
			if(orderService.saveOrder2(order, couponid)){
				return "{\"result\":true}";
			}else{
				return "{\"result\":false}";
			}
		}
		if(orderService.saveOrder(order)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	@RequestMapping(value="/test/OrderHandler_findCount")
	@ResponseBody
	public int findCount(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		Gson g=new Gson();
		int qid;
		if(request.getSession().getAttribute("qid")==null) qid=1;
		else{
			qid=g.fromJson(session.getAttribute("qid").toString(),int.class);
		}
		return	orderService.findCount(qid);
	}
}
