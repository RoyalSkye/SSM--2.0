package com.neusoft.control;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.po.Swiper;
import com.neusoft.po.Teacher;
import com.neusoft.service.SwiperService;
import com.neusoft.service.TeacherService;
import com.neusoft.tools.FileTools;
import com.neusoft.tools.Page;

@Controller
public class TeacherHandler {

	@Autowired
	private TeacherService teacherService;
	@Autowired
	private SwiperService swiperService;
	
	@RequestMapping(value="/test/TeacherHandler_findAllTeacher",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findAllTeacher(HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		int qid;
		if(session.getAttribute("qid")==null){
			qid=1;
		}else{
			qid=(int)session.getAttribute("qid");
		}
		Page page=new Page();
		page.setId(qid);
		page.setTotalPage(teacherService.findCount(page.getId()));
		return FileTools.addHeader(teacherService.findAllTeacher(qid),page.getTotalPage());
		}
	
	@RequestMapping(value="/test/TeacherHandler_findAllTeacherByPage",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findAllTeacherByPage(HttpServletRequest request) throws Exception{
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
		page.setTotalPage(teacherService.findCount(page.getId()));
		return FileTools.addHeader(teacherService.findAllTeacherByPage(page),page.getTotalPage());
		}
	
	@RequestMapping(value="/test/TeacherHandler_findTeacherById")
	@ResponseBody
	public Teacher findTeacherById(int tid) throws Exception{
		return teacherService.findTeacherById(tid);
	}
	
	@RequestMapping(value="/test/TeacherHandler_deleteTeacherById")
	@ResponseBody
	public String deleteTeacherById(int tid) throws Exception{
		if(teacherService.deleteTeacherById(tid)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	
	@RequestMapping(value="/test/TeacherHandler_updateTeacher")
	@ResponseBody
	public String updateTeacher(Teacher t) throws Exception{
		if(teacherService.updateTeacher(t)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
		//return to the findallbranch html
	}
	
	@RequestMapping(value="/test/TeacherHandler_saveTeacher")
	@ResponseBody
	public String saveTeacher(Teacher t,HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		int qid;
		if(session.getAttribute("qid")==null){
			qid=1;
		}else{
			qid=(int)session.getAttribute("qid");
		}
		t.setQid(qid);
		if(teacherService.saveTeacher(t)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	
	@RequestMapping(value="/test/TeacherHandler_findimgurl")
	@ResponseBody
	public String findimgurl(HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		int qid;
		if(session.getAttribute("qid")==null){
			qid=1;
		}else{
			qid=(int)session.getAttribute("qid");
		}
		String imgurl="/upload/"+teacherService.findimgurl(qid).getImgurl();
		return imgurl;
	}
	
	@RequestMapping(value="/test/TeacherHandler_saveimg")
	@ResponseBody
	public String saveimg(MultipartFile file,HttpServletRequest request) throws Exception{
		if(file==null){
			System.out.println("文件为空");
			return "{\"result\":false}";
		}
		String url=FileTools.saveimg(file,request).substring(2);
		if(url==null||url==""){
			return "{\"result\":false}";
		}else{
			return "{\"result\":true,\"imgurl\":\""+url+"\"}";
		}
	}
	
	@RequestMapping(value="/test/TeacherHandler_saveswiperimg")
	@ResponseBody
	public String saveswiperimg(MultipartFile file,HttpServletRequest request) throws Exception{
		if(file==null){
			System.out.println("文件为空");
			return "{\"result\":false}";
		}
		String url=FileTools.saveimg(file,request);
		if(url==null||url==""){
			return "{\"result\":false}";
		}else{
			HttpSession session=request.getSession();
			int qid=(int)session.getAttribute("qid");
			Swiper swiper=new Swiper();
			swiper.setCategory("B");
			swiper.setQid(qid);
			String imgurl=url.substring(10);
			swiper.setImgurl(imgurl);
			if(swiperService.updateSwiper(swiper)){
				return "{\"result\":true,\"imgurl\":\""+url+"\"}";
			}else{
				return "{\"result\":false}";
			}
		}
	}
	@RequestMapping(value="/test/TeacherHandler_findCount")
	@ResponseBody
	public int findCount(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		int qid;
		if(session.getAttribute("qid")==null){
			qid=1;
		}else{
			qid=(int)session.getAttribute("qid");
		}
		return teacherService.findCount(qid);
	}
}
