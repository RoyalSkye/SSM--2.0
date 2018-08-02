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
import com.neusoft.service.FreelistenbookService;
import com.neusoft.service.impl.FreelistenbookServiceBean;
import com.neusoft.tools.FileTools;
import com.neusoft.tools.Page;

@Controller
public class FreelistenbookHandler {
	
	@Autowired
	private FreelistenbookService freelistenbookService;
	
	@RequestMapping(value="/test/FreelistenbookHandler_findAllFreelistenbookByPage",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findAllFreelistenbookByPage(HttpServletRequest request) throws Exception{
		int limit = Integer.parseInt(request.getParameter("limit"));
		int pages = Integer.parseInt(request.getParameter("page"));
		HttpSession session=request.getSession();
		Gson g=new Gson();
		int qid;
		if(request.getSession().getAttribute("qid")==null) qid=1;
		else{
			qid=g.fromJson(session.getAttribute("qid").toString(),int.class);
		}
		Page page = new Page(limit,pages,qid);
		page.setTotalPage(freelistenbookService.findCount());
		return FileTools.addHeader(freelistenbookService.findAllFreelistenbook(page), page.getTotalPage());
	}
	
	@RequestMapping(value="/test/FreelistenbookHandler_findFreelistenbook",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findFreelistenbook(HttpServletRequest request) throws Exception{
		Map<String,Object> map=new HashMap<String,Object>();
		String fid=request.getParameter("fid");
		String cname=request.getParameter("cname");
		cname=java.net.URLDecoder.decode(cname,"UTF-8");  //后台根据url传参 中文 否则乱码
		String starttime=request.getParameter("starttime");
		String endtime=request.getParameter("endtime");
		int limit = Integer.parseInt(request.getParameter("limit"));
		int pages = Integer.parseInt(request.getParameter("page"));
		Page page = new Page(limit,pages);
		map.put("fid", fid);
		map.put("cname", cname);
		map.put("starttime", starttime);
		map.put("endtime", endtime);
		map.put("minNum", page.getMinNum());
		map.put("quantity", page.getQuantity());
		page.setTotalPage(freelistenbookService.findCountByCondition(map));
		return FileTools.addHeader(freelistenbookService.findFreelistenbook(map),page.getTotalPage());
	}
	
	@RequestMapping(value="/test/FreelistenbookHandler_updateFreelistenbook")
	@ResponseBody
	public String updateFreelistenbook(Freelistenbook freelistenbook) throws Exception{
		freelistenbook.setStatus("已处理");
		if(freelistenbookService.updateFreelistenbook(freelistenbook)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	
	@RequestMapping(value="/test/FreelistenbookHandler_findFreelistenbookByPhone")
	@ResponseBody
	public List<Freelistenbook> findFreelistenbookByPhone(HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		Gson g=new Gson();
		String phone=g.fromJson(session.getAttribute("phone").toString(),String.class);
		return freelistenbookService.findFreelistenbookByPhone(phone);
	}
	
	@RequestMapping(value="/test/FreelistenbookHandler_saveFreelistenbook")
	@ResponseBody
	public String saveFreelistenbook(Freelistenbook freelistenbook,HttpServletRequest request) throws Exception{
		//wait for testing 
		System.out.println("tel="+freelistenbook.getTel());
		HttpSession session=request.getSession();
		Gson g=new Gson();
		String phone=g.fromJson(session.getAttribute("phone").toString(),String.class);
		freelistenbook.setStatus("待处理");
		freelistenbook.setOpenid(phone);
		Date date=new Date();
		SimpleDateFormat ft =new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		freelistenbook.setBooktime(ft.format(date));
		if(freelistenbookService.saveFreelistenbook(freelistenbook)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	@RequestMapping(value="/test/FreelistenbookHandler_findCount")
	@ResponseBody
	public int findCount(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		Gson g=new Gson();
		int qid;
		if(request.getSession().getAttribute("qid")==null) qid=1;
		else{
			qid=g.fromJson(session.getAttribute("qid").toString(),int.class);
		}
		return	freelistenbookService.findCount();
	}
}
