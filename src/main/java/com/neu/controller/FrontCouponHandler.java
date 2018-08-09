package com.neu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.beans.Coupon;
import com.neu.service.FrontCouponService;

import com.neu.po.CouponVO;


@Controller
public class FrontCouponHandler {

	@Autowired
	FrontCouponService couponService;
	
	@Autowired
	FrontCouponService frontcouponService;
	
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
	
	
	
	 @RequestMapping(value = "/front/getjavacoupon")
	 @ResponseBody
	  public List<CouponVO> getjavacoupon(String openid)
	  {
		  System.out.println("....servlet....getjavacoupon()......");
		  return frontcouponService.getjavacoupon(openid);
   }
	 
	 @RequestMapping(value = "/front/getccoupon")
	 @ResponseBody
	  public List<CouponVO> getccoupon(String openid)
	  {
		  System.out.println("....servlet....getccoupon()......");
		  return frontcouponService.getccoupon(openid);
   }
	 
	 @RequestMapping(value = "/front/getgocoupon")
	 @ResponseBody
	  public List<CouponVO> getgocoupon(String openid)
	  {
		  System.out.println("....servlet....getgocoupon()......");
		  return frontcouponService.getgocoupon(openid);
   }
	 
	 @RequestMapping(value = "/front/getpythoncoupon")
	 @ResponseBody
	  public List<CouponVO> getpythoncoupon(String openid)
	  {
		  System.out.println("....servlet....getpythoncoupon()......");
		  return frontcouponService.getpythoncoupon(openid);
   }
	 
	 @RequestMapping(value = "/front/gethtmlcoupon")
	 @ResponseBody
	  public List<CouponVO> gethtmlcoupon(String openid)
	  {
		  System.out.println("....servlet....gethtmlcoupon()......");
		  return frontcouponService.gethtmlcoupon(openid);
   }
}
