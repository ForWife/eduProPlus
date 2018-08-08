package com.neu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.beans.Coupon;
import com.neu.beans.User;
import com.neu.service.BackCouponService;

@Controller
public class BackCouponHandler {
	@Autowired
	private BackCouponService backCouponService;
	
	@RequestMapping(value = "/back/getSubCoupon")
    @ResponseBody
	public List<Coupon> getSubCoupon(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
	    User user = (User) session.getAttribute("user");
		return backCouponService.getSubCoupon(user.getQid());
	}
	
	@RequestMapping(value = "/back/getDiscountCoupon")
    @ResponseBody
	public List<Coupon> getDiscountCoupon(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
	    User user = (User) session.getAttribute("user");
		return backCouponService.getDiscountCoupon(user.getQid());
	}
	
	@RequestMapping(value = "/back/getLessonType")
    @ResponseBody
	public List<String> getLessonType(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
	    User user = (User) session.getAttribute("user");
	    return backCouponService.getLessonType(user.getQid());
	}
	
	@RequestMapping(value = "/back/addCoupon")
    @ResponseBody
	public void addCoupon(@RequestParam String lessonType,
						  @RequestParam float money1,
						  @RequestParam String full,
						  @RequestParam float money2,
						  @RequestParam String total,
						  @RequestParam String deadline,
						  @RequestParam String score,
						  HttpServletRequest request) throws Exception{
		System.out.println(lessonType+" "+money1+" "+full+" "+money2+" "+total+" "+deadline+" "+score);
		HttpSession session = request.getSession();
	    User user = (User) session.getAttribute("user");
		if(money1 == 0) {
			backCouponService.addCoupon(user.getQid(), lessonType, total, deadline, full, score, money2 * (float)0.1);
		}else{
			backCouponService.addCoupon(user.getQid(), lessonType, total, deadline, full, score, money1 * -1);
		}
	}
}
