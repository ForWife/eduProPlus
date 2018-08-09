package com.neu.service;

import java.util.List;

import com.neu.beans.Coupon;

public interface FrontGetCouponService {

	List<Coupon> getallcoupon();

	int getcoupon(int cid, String openid);

	int getscore(int cid);

}
