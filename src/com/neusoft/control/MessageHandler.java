package com.neusoft.control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.neusoft.po.Customer;
import com.neusoft.po.Message;
import com.neusoft.po.Messageimg;
import com.neusoft.po.Messagelike;
import com.neusoft.po.Messagereply;
import com.neusoft.po.Swiper;
import com.neusoft.service.MessageService;
import com.neusoft.service.SwiperService;
import com.neusoft.tools.FileTools;
import com.neusoft.tools.Page;

@Controller
public class MessageHandler {

	@Autowired
	private MessageService messageService;
	@Autowired
	private SwiperService swiperService;
	
	@RequestMapping(value="/test/MessageHandler_findAllMessage")
	@ResponseBody
	public List<Message> findAllMessage(HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		int qid;
		if(session.getAttribute("qid")==null){
			qid=1;
		}else{
			qid=(int)session.getAttribute("qid");
		}
		return messageService.findAllMessage(qid);
	}
	
	/*@RequestMapping(value="/test/MessageHandler_findAllMessageByPage",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String findAllMessageByPage(HttpServletRequest request) throws Exception{
		int limit = Integer.parseInt(request.getParameter("limit"));
		int pages = Integer.parseInt(request.getParameter("page"));
		HttpSession session=request.getSession();
		int qid=(int)session.getAttribute("qid");
		Page page = new Page(limit,pages,qid);
		page.setTotalPage(messageService.findMessageCount(page.getId()));
		return FileTools.addHeader(messageService.findAllMessageByPage(page),page.getTotalPage());
	}*/
	
	@RequestMapping(value="/test/MessageHandler_findMessageById")
	@ResponseBody
	public Message findMessageById(int mid) throws Exception{
		return messageService.findMessageById(mid);
	}
	
	@RequestMapping(value="/test/MessageHandler_updateMessage")
	@ResponseBody
	public String updateMessage(Message message,HttpServletRequest request) throws Exception{
		//System.out.println(message.getMid());
		//System.out.println(message.getMtitle());
		String imgurl = request.getParameter("imgurl"); 
		//System.out.println(imgurl);
		Date date=new Date();
		SimpleDateFormat ft =new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		message.setMtime(ft.format(date));
		if(messageService.updateMessage(message,imgurl)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	
	@RequestMapping(value="/test/MessageHandler_saveMessage")
	@ResponseBody
	public String saveMessage(Message message,HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		int qid;
		if(session.getAttribute("qid")==null){
			qid=1;
		}else{
			qid=(int)session.getAttribute("qid");
		}
		message.setQid(qid);
		String imgurl = request.getParameter("imgurl"); 
		Date date=new Date();
		SimpleDateFormat ft =new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		message.setMtime(ft.format(date));
		if(messageService.saveMessage(message,imgurl)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	
	@RequestMapping(value="/test/MessageHandler_deleteMessage")
	@ResponseBody
	public String deleteMessage(int mid) throws Exception{
		if(messageService.deleteMessage(mid)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	
	@RequestMapping(value="/test/MessageHandler_findMessagereplyById")
	@ResponseBody
	public String findMessagereplyById(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		int qid;
		if(session.getAttribute("qid")==null){
			qid=1;
		}else{
			qid=(int)session.getAttribute("qid");
		}
		Page page = new Page((int)session.getAttribute("limit"),(int)session.getAttribute("page"),qid);
		page.setTotalPage(messageService.findMessageCount(page.getId()));
		return FileTools.addHeader(messageService.findMessagereplyById(page), page.getTotalPage()) ;
	}
	
	@RequestMapping(value="/test/MessageHandler_deleteMessagereply")
	@ResponseBody
	public String deleteMessagereply(int mrid) throws Exception{
		if(messageService.deleteMessagereply(mrid)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	
	@RequestMapping(value="/test/MessageHandler_saveMessagereply")
	@ResponseBody
	public String saveMessagereply(Messagereply m,HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		String phone=session.getAttribute("phone").toString();
		Date date=new Date();
		SimpleDateFormat ft =new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		m.setMrtime(ft.format(date));
		/*Customer c=(Customer)session.getAttribute("customer");
		String mrnickname=c.getNickname();*/
		m.setMrnickname(phone);
		if(messageService.saveMessagereply(m)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	
	@RequestMapping(value="/test/MessageHandler_saveMessagelike")
	@ResponseBody
	public String saveMessagelike(Messagelike m,HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		String phone=session.getAttribute("phone").toString();
		Date date=new Date();
		SimpleDateFormat ft =new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
		m.setMltime(ft.format(date));
		m.setMlnickname(phone);
		//Customer c=(Customer)session.getAttribute("customer");
		//String mrnickname=c.getNickname();
		m.setMlnickname(phone);
		if(messageService.saveMessagelike(m)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	
	@RequestMapping(value="/test/MessageHandler_deleteMessagelike")
	@ResponseBody
	public String deleteMessagelike(Messagelike m,HttpServletRequest request) throws Exception{
		if(messageService.saveMessagelike(m)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	
	@RequestMapping(value="/test/MessageHandler_findAllMessagelike")
	@ResponseBody
	public List<Messagelike> findAllMessagelike(HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		String phone=session.getAttribute("phone").toString();
		//Customer c=(Customer)session.getAttribute("customer");
		//String mlnickname=c.getNickname();
		//System.out.println("phone"+phone);
		//System.out.println("2"+c.getNickname());
		//System.out.println("3"+c.getMoney());
		return messageService.findAllMessagelike(phone);
	}
	
	@RequestMapping(value="/test/MessageHandler_findimgurl")
	@ResponseBody
	public String findimgurl(HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		int qid;
		if(session.getAttribute("qid")==null){
			qid=1;
		}else{
			qid=(int)session.getAttribute("qid");
		}
		String imgurl="/upload/"+messageService.findimgurl(qid).getImgurl();
		return imgurl;
	}
	
	@RequestMapping(value="/test/MessageHandler_saveimg")
	@ResponseBody
	public String saveimg(MultipartFile file,HttpServletRequest request) throws Exception{
		if(file==null){
			System.out.println("文件为空");
			return "{\"result\":false}";
		}
		String url=FileTools.saveimg(file,request).substring(10);
		if(url==null||url==""){
			return "{\"result\":false}";
		}else{
			return "{\"result\":true,\"imgurl\":\""+url+"\"}";
		}
	}
	
	@RequestMapping(value="/test/MessageHandler_saveswiperimg")
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
			int qid;
			if(session.getAttribute("qid")==null){
				qid=1;
			}else{
				qid=(int)session.getAttribute("qid");
			}
			Swiper swiper=new Swiper();
			swiper.setCategory("D");
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
	
}
