package com.neusoft.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AppLoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("...AppLoginInterceptor...afterCompletion()...最终通知...");

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("...AppLoginInterceptor...postHandle()...后置通知...");

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		System.out.println("...AppLoginInterceptor...preHandle()...前置通知...");
		HttpSession session=request.getSession();
		boolean app=Boolean.parseBoolean((session.getAttribute("app")+""));
		if(app){
			System.out.println("登录成功");
			System.out.println("session:"+session);
			return true;
		}else{
			System.out.println("您还未登录，请先登录");
			System.out.println("session:"+session);
			//request.getRequestDispatcher("/SSM/build/index.html#/login").forward(request, response);
			//response.sendRedirect(request.getContextPath() +"/login.html");
			response.sendRedirect(response.encodeURL("/SSM/build/index.html#/login"));
			return false;
		}
	}

}
