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
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.po.Branch;
import com.neusoft.po.Lesson;
import com.neusoft.po.Swiper;
import com.neusoft.service.LessonService;
import com.neusoft.service.SwiperService;
import com.neusoft.tools.FileTools;
import com.neusoft.tools.Page;

@Controller
public class LessonHandler {
	
	@Autowired
	private LessonService lessonService;
	@Autowired
	private SwiperService swiperService;

	@RequestMapping(value="/test/LessonHandler_findLessonByCondition")
	@ResponseBody
	public List<Lesson> findLessonByCondition(HttpServletRequest request) throws Exception{
		Map<String,Object> m=new HashMap<>();
		HttpSession session=request.getSession();
		int qid;
		if(session.getAttribute("qid")==null){
			qid=1;
		}else{
			qid=(int)session.getAttribute("qid");
		}
		if(request.getParameter("bid")==null || request.getParameter("bid")==""){
			m.put("bid", null);
		}else{
			m.put("bid", request.getParameter("bid"));
		}
		if(request.getParameter("category")==null || request.getParameter("category")==""){
			m.put("category", null);
		}else{
			m.put("category", request.getParameter("category"));
		}
		if(request.getParameter("type")==null || request.getParameter("type")==""){
			m.put("type", null);
		}else{
			m.put("type", request.getParameter("type"));
		}
		m.put("page", request.getParameter("page"));
		m.put("qid", qid);
		return null;
	}
	
	@RequestMapping(value="/test/LessonHandler_findAllLesson")
	@ResponseBody
	public List<Lesson> findAllLesson(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		int qid;
		if(session.getAttribute("qid")==null){
			qid=1;
		}else{
			qid=(int)session.getAttribute("qid");
		}
		return	lessonService.findAllLesson(qid);
	}
	
	@RequestMapping(value="/test/LessonHandler_findAllLessonByPage",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findAllLessonByPage(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		int limit = Integer.parseInt(request.getParameter("limit"));
		int pages = Integer.parseInt(request.getParameter("page"));
		int qid;
		if(session.getAttribute("qid")==null){
			qid=1;
		}else{
			qid=(int)session.getAttribute("qid");
		}
		Page page = new Page(limit,pages,qid);
		page.setTotalPage(lessonService.findCount(page.getId()));
		return	FileTools.addHeader(lessonService.findAllLessonByPage(page), page.getTotalPage());
	}
	
	@RequestMapping(value="/test/LessonHandler_findLessonById")
	@ResponseBody
	public Lesson findLessonById(int lid) throws Exception{
		return lessonService.findLessonById(lid);
	}
	
	@RequestMapping(value="/test/LessonHandler_findBranchByLesson")
	@ResponseBody
	public List<Branch> findBranchByLesson(int lid) throws Exception{
		return lessonService.findBranchByLesson(lid);
	}
	
	@RequestMapping(value="/test/LessonHandler_findCount")
	@ResponseBody
	public int findCount(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		int qid;
		if(session.getAttribute("qid")==null){
			qid=1;
		}else{
			qid=(int)session.getAttribute("qid");
		}
		return	lessonService.findCount(qid);
	}
	
	@RequestMapping(value="/test/LessonHandler_findLessonByBid",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findLessonByBid(int bid,HttpServletRequest request) throws Exception{
		int limit = Integer.parseInt(request.getParameter("limit"));
		int pages = Integer.parseInt(request.getParameter("page"));
		Page page = new Page(limit,pages,bid);
		page.setTotalPage(lessonService.findCountByBid(page.getId()));
		return FileTools.addHeader(lessonService.findLessonByBid(page),page.getTotalPage());
	}
	
	@RequestMapping(value="/test/LessonHandler_deleteLessonById")
	@ResponseBody
	public String deleteLessonById(int lid) throws Exception{
		if(lessonService.deleteLessonById(lid)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	
	@RequestMapping(value="/test/LessonHandler_selectCategory")
	@ResponseBody
	public List<String> selectCategory() throws Exception{
		return lessonService.selectCategory();
	}
	
	@RequestMapping(value="/test/LessonHandler_saveLesson")
	@ResponseBody
	public String saveLesson(Lesson lesson,HttpServletRequest request) throws Exception{
		String bid = request.getParameter("bid");  //课程所属的branchid  eg:1,2,3,5
		//System.out.println("bid.length="+bid.length());
		HttpSession session=request.getSession();
		int qid;
		if(session.getAttribute("qid")==null){
			qid=1;
		}else{
			qid=(int)session.getAttribute("qid");
		}
		lesson.setQid(qid);
		Date date=new Date();
		SimpleDateFormat ft =new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		lesson.setPubtime(ft.format(date));
		if(lessonService.saveLesson(lesson,bid)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	
	@RequestMapping(value="/test/LessonHandler_updateLesson")
	@ResponseBody
	public String updateLesson(Lesson lesson,HttpServletRequest request) throws Exception{ 
		String bid = request.getParameter("bid"); 
		System.out.println("bid="+bid);
		HttpSession session=request.getSession();
		int qid;
		if(session.getAttribute("qid")==null){
			qid=1;
		}else{
			qid=(int)session.getAttribute("qid");
		}
		lesson.setQid(qid);
		Date date=new Date();
		SimpleDateFormat ft =new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		lesson.setPubtime(ft.format(date));
		if(lessonService.updateLesson(lesson,bid)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	
	@RequestMapping(value="/test/LessonHandler_findimgurl")
	@ResponseBody
	public String findimgurl(HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		int qid;
		if(session.getAttribute("qid")==null){
			qid=1;
		}else{
			qid=(int)session.getAttribute("qid");
		}
		String imgurl=lessonService.findimgurl(qid).getImgurl();
		return imgurl;
	}
	
	@RequestMapping(value="/test/LessonHandler_saveimg")
	@ResponseBody
	public String saveimg(MultipartFile file,HttpServletRequest request) throws Exception{
		if(file==null){
			System.out.println("文件为空");
			return "{\"result\":false}";
		}
		//String url=FileTools.saveimg(file,request).substring(10);
		String url=FileTools.saveimg(file,request);
		System.out.println("url="+url);
		if(url==null||url==""){
			return "{\"result\":false}";
		}else{
			return "{\"result\":true,\"imgurl\":\""+url+"\"}";
		}
	}
	
	@RequestMapping(value="/test/LessonHandler_saveswiperimg")
	@ResponseBody
	public String saveswiperimg(MultipartFile file,HttpServletRequest request) throws Exception{
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
			int qid;
			if(session.getAttribute("qid")==null){
				qid=1;
			}else{
				qid=(int)session.getAttribute("qid");
			}
			Swiper swiper=new Swiper();
			swiper.setCategory("C");
			swiper.setQid(qid);
			//String imgurl=url.substring(10);
			swiper.setImgurl(url);
			if(swiperService.updateSwiper(swiper)){
				return "{\"result\":true,\"imgurl\":\""+url+"\"}";
			}else{
				return "{\"result\":false}";
			}
		}
	}
	
}


