package com.neu.service;

import java.util.List;

import com.neu.beans.Coupon;
import com.neu.po.CouponVO;

public interface FrontCouponService {
	public List<Coupon> findCoupon(String openid,int lid) throws Exception;
	public Coupon getaCoupon(int cid) throws Exception;
	
	
	List<CouponVO> getjavacoupon(String openid);

	List<CouponVO> getccoupon(String openid);

	List<CouponVO> getgocoupon(String openid);

	List<CouponVO> getpythoncoupon(String openid);

	List<CouponVO> gethtmlcoupon(String openid);
}
