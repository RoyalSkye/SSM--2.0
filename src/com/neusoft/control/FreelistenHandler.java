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
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.po.Freelisten;
import com.neusoft.service.FreelistenService;
import com.neusoft.tools.FileTools;
import com.neusoft.tools.Page;

@Controller
public class FreelistenHandler {
	
	@Autowired
	private FreelistenService freelistenService;
	
	
	@RequestMapping(value="/test/FreelistenHandler_findAllFreelisten",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findAllFreelisten(HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		int limit = Integer.parseInt(request.getParameter("limit"));
		int pages = Integer.parseInt(request.getParameter("page"));
		int qid;
		if(session.getAttribute("qid")==null){
			qid=1;
		}else{
			qid=(int)session.getAttribute("qid");
		}
		Page page = new Page(limit,pages,qid);
		page.setTotalPage(freelistenService.findCount(page.getId()));
		return FileTools.addHeader(freelistenService.findAllFreelisten(page),page.getTotalPage());
	}
	
	@RequestMapping(value="/test/FreelistenHandler_findOnlineFreelisten")
	@ResponseBody
	public List<Freelisten> findOnlineFreelisten(HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		int qid;
		if(session.getAttribute("qid")==null){
			qid=1;
		}else{
			qid=(int)session.getAttribute("qid");
		}
		return freelistenService.findOnlineFreelisten(qid);
	}
	
	@RequestMapping(value="/test/FreelistenHandler_findFreelistenById")
	@ResponseBody
	public Freelisten findFreelistenById(int fid) throws Exception{
		return freelistenService.findFreelistenById(fid);
	}
	
	@RequestMapping(value="/test/FreelistenHandler_findFreelistenByBid",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findFreelistenByBid(int bid,HttpServletRequest request) throws Exception{
		int limit = Integer.parseInt(request.getParameter("limit"));
		int pages = Integer.parseInt(request.getParameter("page"));
		Page page = new Page(limit,pages,bid);
		page.setTotalPage(freelistenService.findCountByBid(page.getId()));
		return FileTools.addHeader(freelistenService.findFreelistenByBid(page),page.getTotalPage());
	}
	
	@RequestMapping(value="/test/FreelistenHandler_deleteFreelistenById")
	@ResponseBody
	public String deleteFreelistenById(int fid) throws Exception{
		if(freelistenService.deleteFreelistenById(fid)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	
	@RequestMapping(value="/test/FreelistenHandler_saveFreelisten")
	@ResponseBody
	public String saveFreelisten(Freelisten freelisten,HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		int qid;
		if(session.getAttribute("qid")==null){
			qid=1;
		}else{
			qid=(int)session.getAttribute("qid");
		}
		freelisten.setQid(qid);
		Date date=new Date();
		SimpleDateFormat ft =new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		freelisten.setPubtime(ft.format(date));
		if(freelistenService.saveFreelisten(freelisten)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	
	@RequestMapping(value="/test/FreelistenHandler_updateFreelisten")
	@ResponseBody
	public String updateFreelisten(Freelisten freelisten) throws Exception{
		if(freelistenService.updateFreelisten(freelisten)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	
	@RequestMapping(value="/test/FreelistenHandler_saveimg")
	@ResponseBody
	public String saveimg(MultipartFile file,HttpServletRequest request) throws Exception{
		if(file==null){
			System.out.println("ÎÄ¼þÎª¿Õ!");
			return "{\"result\":false}";
		}
		String url=FileTools.saveimg(file,request).substring(10);
		if(url==null||url==""){
			return "{\"result\":false}";
		}else{
			return "{\"result\":true,\"imgurl\":\""+url+"\"}";
		}
	}
	@RequestMapping(value="/test/FreelistenHandler_findCount")
	@ResponseBody
	public int findCount(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		int qid;
		if(session.getAttribute("qid")==null){
			qid=1;
		}else{
			qid=(int)session.getAttribute("qid");
		}
		return	freelistenService.findCount(qid);
	}
}


