package com.neu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import com.neu.beans.Userlist;
import com.neu.service.FrontCheckService;



@Controller
public class FrontLoginHandler {
	@Autowired
	private  FrontCheckService service;
	
	  @RequestMapping(value = "/front/login") 	
 	  public  String frontlogin(HttpServletRequest request,HttpServletResponse response)
 	  {
		  //请求和响应的信息都不应该被存储在对方的磁盘系统中； 
		   response.addHeader( "Cache-Control", "no-store");
		   //于客户机的每次请求，代理服务器必须想服务器验证缓存是否过时；
		   response.addHeader( "Cache-Control", "must-revalidate");
//			response.setContentType("text/html;charset=utf-8");
//			//指定该页面不缓存
//			response.setDateHeader("Expires",-1); //IE游览器支持的			
//			//保证兼容性
//			response.setHeader("Cache-Control", "no-cache");
//			response.setHeader("Pragme", "no-cache");
 		  System.out.println("....servlet....frontlogin()......");


 		 //请求和响应的信息都不应该被存储在对方的磁盘系统中； 
		   response.addHeader( "Cache-Control", "no-store");
		   //于客户机的每次请求，代理服务器必须想服务器验证缓存是否过时；
		   response.addHeader( "Cache-Control", "must-revalidate");

 		 //从数据库查找是否存在这样一个手机号的用户
 		  //如果存在那么就取出来 返回
 		  //如果不存在那么就 写入一个
 		  String phone=request.getParameter("phone"); 		
 		  if(service.check(phone)==null)
 		  {
 			  Userlist user=new Userlist();
 			  user.setTel(phone); 		
 			  user.setUname(phone);
 			 user.setOpenid(phone);
 			  user.setUserimg("default.jpg");
 			  adduser(user);
 			 System.out.println(user.getTel());
 			 System.out.println(user.getUid());//默认是0
 			Userlist user1= service.check(phone);
 		     HttpSession session=request.getSession();
 		     session.setAttribute("user", user1);
 		    System.out.println(user1.getUid());
 		     System.out.println("存入session成功！");
 			 return "forward:index.html";
 			  //如果为空 捏造一个用户 返回 并 写入数据库
 		  }
 		  else
 		  {
 			 Userlist user= service.check(phone);
 			 System.out.println(user.getTel());
 			HttpSession session=request.getSession();		     
		     session.setAttribute("user", user);
		     System.out.println("存入session成功！");
 			return "forward:index.html";
 			  //如果不为空 那就将返回的对象返回
 		  }
 		  
 		  
      }
	  
	  public  void adduser(Userlist user)
	  {
		  String phone= user.getTel();
		  service.insert(phone);		  
	  }
	  
}
