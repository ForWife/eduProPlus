package com.neu.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.beans.Userlist;
import com.neu.service.FrontMypageService;

@Controller
public class FrontMypageHandler {
	  @Autowired
	  private FrontMypageService frontMypageService;
	
	  @RequestMapping(value = "/front/signin")
	  @ResponseBody
	  public int signin(HttpServletRequest request,HttpServletResponse response,int uid)
	  {
		  System.out.println("....servlet....signin()......");
		  int count= frontMypageService.signin(uid);
		  
		  if(count==1)
		  {
			 
		  }
		  else
		  {
			  //签到成功 更新数据库和session
			  HttpSession session=request.getSession();
			  Userlist user=(Userlist)session.getAttribute("user");
			  user.setScore(user.getScore()+10);
			  session.setAttribute("user", user);
			  frontMypageService.addscore(uid);
			  frontMypageService.addrecord(uid);
		  }
		  return count;
		  
		  
      }
	  
	  @RequestMapping(value = "/front/changenamehandler")
	  @ResponseBody
	  public String changename(HttpServletRequest request,HttpServletResponse response,String name,String phone)
	  {		  
		  System.out.println("....servlet....changenamehandler()......");
		  frontMypageService.changename(name,phone);
			HttpSession session=request.getSession();
			Userlist user=(Userlist)session.getAttribute("user");
			user.setUname(name);
			session.setAttribute("user", user);
		    return "changeinfo.html";
		  
      }
	  
	
	
}
