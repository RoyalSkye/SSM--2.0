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

import com.google.gson.Gson;
import com.neusoft.po.Checkin;
import com.neusoft.po.Customer;
import com.neusoft.service.CustomerService;
import com.neusoft.tools.*;

@Controller
public class CustomerHandler {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value="/test/CustomerHandler_islogin",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String islogin(HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		boolean isLoginOK=Boolean.parseBoolean((session.getAttribute("app")+""));
		
		isLoginOK=true;
		//session.setAttribute("phone", "18604010547");
		Gson g=new Gson();
		session.setAttribute("phone", g.toJson("18604010547"));
		
		if(isLoginOK){
			System.out.println("app已登录");
			 return "{\"result\":true}";
		}else{
			System.out.println("app未登录");
			return "{\"result\":false}";
		}
	}
	
	@RequestMapping(value="/test/CustomerHandler_findCustomerByPhone",produces = "application/json; charset=utf-8")
	@ResponseBody
	public Customer findCustomerByPhone(HttpServletRequest request) throws Exception{
		HttpSession session=request.getSession();
		//String phone=(String)session.getAttribute("phone");
		Gson g=new Gson();
		String phone=g.fromJson(session.getAttribute("phone").toString(),String.class);
		return customerService.findCustomerByPhone(phone);
	}
	
	@RequestMapping(value="/test/CustomerHandler_saveCheckin")
	@ResponseBody
	public String saveCheckin(HttpServletRequest request) throws Exception{
		Checkin c=new Checkin();
		HttpSession session=request.getSession();
		Gson g=new Gson();
		String phone=g.fromJson(session.getAttribute("phone").toString(),String.class);
		c.setPhone(phone);
		String timestamp=(System.currentTimeMillis()+"").substring(0, 10);
		c.setTimestamp(timestamp);
		Date date=new Date();
		SimpleDateFormat ft =new SimpleDateFormat ("yyyy-MM-dd");
		c.setTime(ft.format(date));
		if(customerService.saveCheckin(c)){
			return "{\"result\":true}";
		}else{
			return "{\"result\":false}";
		}
	}
	
	@RequestMapping(value="/test/CustomerHandler_findAllCheckin")
	@ResponseBody
	public List<String> findAllCheckin(HttpServletRequest request) throws Exception{
		Checkin c=new Checkin();
		HttpSession session=request.getSession();
		Gson g=new Gson();
		String phone=g.fromJson(session.getAttribute("phone").toString(),String.class);
		c.setPhone(phone);
		return customerService.findAllCheckin(c);
	}
	
	@RequestMapping(value="/test/CustomerHandler_getcode",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getcode(Customer customer,HttpServletRequest request) throws Exception{  //phone
		 String mobileNumber = customer.getPhone();//接收验证码的手机号码
	        try {
	            String str = MobileMessageSend.sendMsg(mobileNumber);
	            if("success".equals(str)){
	                System.out.println("发送成功！");
	                return "{\"result\":true}";
	            }else{
	                System.out.println("发送失败！");
	                return "{\"result\":false}";
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "{\"result\":false}";
	        }
	}
	
	@RequestMapping(value="/test/CustomerHandler_login",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String login(Customer customer,HttpServletRequest request) throws Exception{  //phone password(code)
		Gson g=new Gson();
		String mobileNumber = customer.getPhone();//接收验证码的手机号码
        String code = customer.getPassword();//验证码
        HttpSession session=request.getSession();
        try {
            String str = MobileMessageCheck.checkMsg(mobileNumber,code);
            if("success".equals(str)){
                System.out.println("验证成功！");
                Customer c=customerService.findCustomerByPhone(mobileNumber);
                if(c==null){
                	System.out.println("customer is null");
                	if(customerService.saveCustomer(customer)){
                		session.setAttribute("app", g.toJson(true));
                		session.setAttribute("qid", g.toJson((int)1));
                		session.setAttribute("phone", g.toJson(customer.getPhone()));
                		/*session.setAttribute("app", true);
                    	session.setAttribute("qid", 1);
                        session.setAttribute("phone", customer.getPhone());*/
                        session.setMaxInactiveInterval(60*100);
                        return "{\"result\":true}";
                	}else{
                		 return "{\"result\":false}";
                	}
                }else{
                	session.setAttribute("app", g.toJson(true));
            		session.setAttribute("qid", g.toJson((int)1));
            		session.setAttribute("phone", g.toJson(customer.getPhone()));
                    session.setMaxInactiveInterval(60*30);
                    return "{\"result\":true}";
                }
            }else{
                System.out.println("验证失败！");
                return "{\"result\":false}";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"result\":false}";
        }  
	}
	
}
