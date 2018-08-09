package com.neusoft.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("...LoginInterceptor...afterCompletion()...最终通知...");

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("...LoginInterceptor...postHandle()...后置通知...");

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		System.out.println("...LoginInterceptor...preHandle()...前置通知...");
		HttpSession session=request.getSession();
		/*boolean isLoginOK=Boolean.parseBoolean((session.getAttribute("isLoginOK")+""));
		System.out.println("isLoginOK="+isLoginOK);
		int q1=(int)session.getAttribute("qid");
		System.out.println("qid="+q1);*/
		Gson g=new Gson();
		boolean isLoginOK;
		if(session.getAttribute("isLoginOK")==null) isLoginOK=false;
		else{
			isLoginOK=g.fromJson(session.getAttribute("isLoginOK").toString(),boolean.class);
		}
		System.out.println("isLoginOK="+isLoginOK);
		//int q=g.fromJson(request.getSession().getAttribute("qid").toString(),int.class);
		if(isLoginOK){
			System.out.println("登录成功");
			String ip = request.getRemoteAddr();
			System.out.println("session:"+session);
			System.out.println("ip:"+ip);
			return true;
		}else{
			System.out.println("您还未登录，请先登录");
			String ip = request.getRemoteAddr();
			System.out.println("session:"+session);
			System.out.println("ip:"+ip);
			//request.getRequestDispatcher("/login.html").forward(request, response);  //由于浏览器缓存可能导致登录后访问刚刚测试拦截器的页面直接跳转到登录页面
			//response.sendRedirect(request.getContextPath() +"/login.html");
			response.sendRedirect(response.encodeURL("/SSM/login.html"));
			return false;
		}
	}

}
