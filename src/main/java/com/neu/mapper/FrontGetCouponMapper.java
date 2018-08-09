package com.neu.mapper;

import java.util.List;

import com.neu.beans.Coupon;

public interface FrontGetCouponMapper {

	List<Coupon> getallcoupon();

	int checkhave(int cid, String openid);

	int getscore1(int cid);

	int getscore2(String openid);

	void update1(int score1,String openid);

	void insert(int cid, String openid);

	void update2(int cid);



}
