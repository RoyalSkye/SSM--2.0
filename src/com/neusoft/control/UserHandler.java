package com.neusoft.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.neusoft.po.User;
import com.neusoft.service.UserService;

@Controller
public class UserHandler {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/test/UserHandler_login")
	public String login(User user,HttpServletRequest request) throws Exception{
		if(userService.login(user)){
			Gson g=new Gson();
			User u=userService.findUserinfoByUsername(user);
			HttpSession session=request.getSession();
			//session.setAttribute("qid", u.getQid());
			//session.setAttribute("isLoginOK", true);
			session.setAttribute("qid", g.toJson(u.getQid()));
			//session.setAttribute("user", u);
			session.setAttribute("isLoginOK", g.toJson(true));
			session.setMaxInactiveInterval(60*30);
			//return "{\"result\":true}";
			return "redirect:/index2.html";
		}else{
			//return "{\"result\":false}";
			return "redirect:/login.html";
		}
	}
	
	@RequestMapping(value="/test/UserHandler_updateUser")
	@ResponseBody
	public String updateUser(User user) throws Exception{
		if(userService.updateUser(user)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	
	@RequestMapping(value="/test/UserHandler_findUserinfo")
	@ResponseBody
	public User findUserinfo(User user) throws Exception{
		return userService.findUserinfoByUsername(user);
	}
	
}
