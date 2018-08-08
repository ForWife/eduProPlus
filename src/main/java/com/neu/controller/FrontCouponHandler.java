package com.neu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.beans.Coupon;
import com.neu.service.FrontCouponService;

@Controller
public class FrontCouponHandler {

	@Autowired
	FrontCouponService couponService;
	
	@RequestMapping(value="/front/findCoupon")
	@ResponseBody
	public List<Coupon> findCoupon(String openid,int lid) throws Exception{
		return couponService.findCoupon(openid, lid);
	}
	
	@RequestMapping(value="/front/getaCoupon")
	@ResponseBody
	public Coupon getaCoupon(int cid) throws Exception{
		System.out.println("FrontCouponHandler.getaCoupon()");
		return couponService.getaCoupon(cid);
	}
}
