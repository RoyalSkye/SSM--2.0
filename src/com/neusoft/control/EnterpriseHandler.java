package com.neusoft.control;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.neusoft.po.Enterprise;
import com.neusoft.po.Swiper;
import com.neusoft.service.impl.EnterpriseServiceBean;
import com.neusoft.tools.FileTools;

import com.neusoft.service.EnterpriseService;
import com.neusoft.service.SwiperService;



@Controller
public class EnterpriseHandler {
	@Autowired
	private EnterpriseService enterpriseService;
	@Autowired
	private SwiperService swiperService;

	@RequestMapping(value="/test/EnterpriseHandler_findEnterpriseById")
	@ResponseBody
	public Enterprise findEnterpriseById(HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		Gson g=new Gson();
		int qid;
		if(request.getSession().getAttribute("qid")==null) qid=1;
		else{
			qid=g.fromJson(session.getAttribute("qid").toString(),int.class);
		}
		return enterpriseService.findEnterpriseById(qid);
	}
	
	@RequestMapping(value="/test/EnterpriseHandler_updateEnterprise")
	@ResponseBody
	public String updateEnterprise(Enterprise e,HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		Gson g=new Gson();
		int qid;
		if(request.getSession().getAttribute("qid")==null) qid=1;
		else{
			qid=g.fromJson(session.getAttribute("qid").toString(),int.class);
		}
		e.setQid(qid);
		if(enterpriseService.updateEnterprise(e)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	
	@RequestMapping(value="/test/EnterpriseHandler_findSwiperByQid")
	@ResponseBody
	public List<Swiper> findSwiperByQid(HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		Gson g=new Gson();
		int qid;
		if(request.getSession().getAttribute("qid")==null) qid=1;
		else{
			qid=g.fromJson(session.getAttribute("qid").toString(),int.class);
		}
		return swiperService.findSwiperByQid(qid);
	}
	
	@RequestMapping(value="/test/EnterpriseHandler_savevideo")
	@ResponseBody
	public String savevideo(MultipartFile file,HttpServletRequest request) throws Exception{
		if(file==null){
			System.out.println("文件为空");
			return "{\"result\":false}";
		}
		String url=FileTools.saveimg(file,request);
		System.out.println("url="+url);
		if(url==null||url==""){
			return "{\"result\":false}";
		}else{
			HttpSession session=request.getSession();
			Gson g=new Gson();
			int qid;
			if(request.getSession().getAttribute("qid")==null) qid=1;
			else{
				qid=g.fromJson(session.getAttribute("qid").toString(),int.class);
			}
			//String videopath=url.substring(10);
			Enterprise e=new Enterprise();
			e.setQid(qid);
			e.setVideopath(url);
			enterpriseService.updateEnterprise(e);
			return "{\"result\":true,\"imgurl\":\""+url+"\"}";
		}
	}
	
	@RequestMapping(value="/test/EnterpriseHandler_saveimg")
	@ResponseBody
	public String saveimg(MultipartFile file,HttpServletRequest request) throws Exception{
		if(file==null){
			System.out.println("文件为空");
			return "{\"result\":false}";
		}
		String url=FileTools.saveimg(file,request);
		System.out.println("url="+url);
		if(url==null||url==""){
			return "{\"result\":false}";
		}else{
			HttpSession session=request.getSession();
			Gson g=new Gson();
			int qid;
			if(request.getSession().getAttribute("qid")==null) qid=1;
			else{
				qid=g.fromJson(session.getAttribute("qid").toString(),int.class);
			}
			Swiper swiper=new Swiper();
			swiper.setQid(qid);
			//String imgurl=url.substring(10);  //  ../upload/....jpg
			swiper.setImgurl(url);
			swiper.setCategory("A");
			if(swiperService.updateSwiper(swiper)){
				return "{\"result\":true,\"imgurl\":\""+url+"\"}";
			}else{
				return "{\"result\":false}";
			}
		}
	}
	
}
