package com.neu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.beans.Coupon;
import com.neu.beans.Userlist;
import com.neu.service.FrontGetCouponService;

@Controller
public class FrontGetCouponHandler {
	@Autowired
	FrontGetCouponService frontgetcouponService;
	
	 @RequestMapping(value = "/front/getallcoupon")
	 @ResponseBody
	  public List<Coupon> getallcoupon()
	  {
		  System.out.println("....servlet....getallcoupon()......");
		  return frontgetcouponService.getallcoupon();
     }
	 
	 @RequestMapping(value = "/front/getacoupon")
	 @ResponseBody
	  public int getcoupon(int cid,String openid,HttpServletRequest request)
	  {
		 int a;
		 int score;
		  System.out.println("....servlet....getcoupon()兑换优惠券......");
		  a= frontgetcouponService.getcoupon(cid,openid);
		  score =frontgetcouponService.getscore(cid);
		  if(a==3)
		  {
			  HttpSession session=request.getSession();
				Userlist user=(Userlist)session.getAttribute("user");				
				user.setScore(user.getScore()-score);
				session.setAttribute("user", user);
		  }
		  return a;
     }
	
	
	
}
