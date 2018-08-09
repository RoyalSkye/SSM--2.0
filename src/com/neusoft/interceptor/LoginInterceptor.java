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
		System.out.println("...LoginInterceptor...afterCompletion()...����֪ͨ...");

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("...LoginInterceptor...postHandle()...����֪ͨ...");

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		System.out.println("...LoginInterceptor...preHandle()...ǰ��֪ͨ...");
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
			System.out.println("��¼�ɹ�");
			String ip = request.getRemoteAddr();
			System.out.println("session:"+session);
			System.out.println("ip:"+ip);
			return true;
		}else{
			System.out.println("����δ��¼�����ȵ�¼");
			String ip = request.getRemoteAddr();
			System.out.println("session:"+session);
			System.out.println("ip:"+ip);
			//request.getRequestDispatcher("/login.html").forward(request, response);  //���������������ܵ��µ�¼����ʸող�����������ҳ��ֱ����ת����¼ҳ��
			//response.sendRedirect(request.getContextPath() +"/login.html");
			response.sendRedirect(response.encodeURL("/SSM/login.html"));
			return false;
		}
	}

}
