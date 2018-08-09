package com.neu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.beans.Coupon;
import com.neu.beans.CouponRecord;
import com.neu.mapper.FrontCouponMapper;
import com.neu.service.FrontCouponService;


import com.neu.po.CouponVO;


@Service
public class FrontCouponServiceBean implements FrontCouponService {

	@Autowired
	FrontCouponMapper mapper;
	
	@Override
	public List<Coupon> findCoupon(String openid, int lid) throws Exception {
		System.out.println("FrontCouponServiceBean.findCoupon()");
		Map<String, Object> map = new HashMap<>();
		map.put("lid", lid);
		map.put("openid", openid);
		List<Coupon> couponlist = mapper.findCoupons(map);
		return couponlist;
	}

	@Override
	public Coupon getaCoupon(int cid) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getCoupon(cid);
	}
	
	
	
	@Override
	public List<CouponVO> getjavacoupon(String openid) {
		System.out.println("...Service...getjavacoupon().....");
		List<CouponVO> list=new ArrayList<CouponVO>();
		List<CouponRecord> couponList = null;			
		try {
			couponList=mapper.getRecordByOpenid(openid);
			
			for (CouponRecord couponrecord : couponList) {
				 Coupon	coupon=mapper.getCouponById (couponrecord.getCid());
				if(coupon!=null)
				{
					System.out.println(coupon.getCategory());
				 if(coupon.getCategory().equals("JAVA"))
				 {	
					 System.out.println("数组中多了一个记录");
					 CouponVO couponvo = new CouponVO();
					couponvo.setCoupon(coupon);
					couponvo.setCouponRecord(couponrecord);
					list.add(couponvo);		
				}	
				}
			}
		} catch (Exception e) {
			list=null;
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<CouponVO> getccoupon(String openid) {
		System.out.println("...Service...getccoupon().....");
		List<CouponVO> list=new ArrayList<CouponVO>();
		List<CouponRecord> couponList = null;			
		try {
			couponList=mapper.getRecordByOpenid(openid);
			
			for (CouponRecord couponrecord : couponList) {
				 Coupon	coupon=mapper.getCouponById (couponrecord.getCid());
				if(coupon!=null)
				{
					System.out.println(coupon.getCategory());
				 if(coupon.getCategory().equals("C++"))
				 {	
					 System.out.println("数组中多了一个记录");
					 CouponVO couponvo = new CouponVO();
					couponvo.setCoupon(coupon);
					couponvo.setCouponRecord(couponrecord);
					list.add(couponvo);		
				}	
				}
			}
		} catch (Exception e) {
			list=null;
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<CouponVO> getgocoupon(String openid) {
		System.out.println("...Service...getgocoupon().....");
		List<CouponVO> list=new ArrayList<CouponVO>();
		List<CouponRecord> couponList = null;			
		try {
			couponList=mapper.getRecordByOpenid(openid);
			
			for (CouponRecord couponrecord : couponList) {
				 Coupon	coupon=mapper.getCouponById (couponrecord.getCid());
				if(coupon!=null)
				{
					System.out.println(coupon.getCategory());
				 if(coupon.getCategory().equals("Golang"))
				 {	
					 System.out.println("数组中多了一个记录");
					 CouponVO couponvo = new CouponVO();
					couponvo.setCoupon(coupon);
					couponvo.setCouponRecord(couponrecord);
					list.add(couponvo);		
				}	
				}
			}
		} catch (Exception e) {
			list=null;
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<CouponVO> getpythoncoupon(String openid) {
		System.out.println("...Service...getpythoncoupon().....");
		List<CouponVO> list=new ArrayList<CouponVO>();
		List<CouponRecord> couponList = null;			
		try {
			couponList=mapper.getRecordByOpenid(openid);
			
			for (CouponRecord couponrecord : couponList) {
				 Coupon	coupon=mapper.getCouponById (couponrecord.getCid());
				if(coupon!=null)
				{
					System.out.println(coupon.getCategory());
				 if(coupon.getCategory().equals("Python"))
				 {	
					 System.out.println("数组中多了一个记录");
					 CouponVO couponvo = new CouponVO();
					couponvo.setCoupon(coupon);
					couponvo.setCouponRecord(couponrecord);
					list.add(couponvo);		
				}	
				}
			}
		} catch (Exception e) {
			list=null;
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<CouponVO> gethtmlcoupon(String openid) {
		System.out.println("...Service...gethtmlcoupon().....");
		List<CouponVO> list=new ArrayList<CouponVO>();
		List<CouponRecord> couponList = null;			
		try {
			couponList=mapper.getRecordByOpenid(openid);
			
			for (CouponRecord couponrecord : couponList) {
				 Coupon	coupon=mapper.getCouponById (couponrecord.getCid());
				if(coupon!=null)
				{
					System.out.println(coupon.getCategory());
				 if(coupon.getCategory().equals("HTML5"))
				 {	
					 System.out.println("数组中多了一个记录");
					 CouponVO couponvo = new CouponVO();
					couponvo.setCoupon(coupon);
					couponvo.setCouponRecord(couponrecord);
					list.add(couponvo);		
				}	
				}
			}
		} catch (Exception e) {
			list=null;
			e.printStackTrace();
		}
		return list;
	}

}
