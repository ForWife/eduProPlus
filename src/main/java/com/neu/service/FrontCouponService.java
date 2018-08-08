package com.neu.service;

import java.util.List;

import com.neu.beans.Coupon;

public interface FrontCouponService {
	public List<Coupon> findCoupon(String openid,int lid) throws Exception;
	public Coupon getaCoupon(int cid) throws Exception;
}
