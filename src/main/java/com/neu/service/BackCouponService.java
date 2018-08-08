package com.neu.service;

import java.util.List;


import com.neu.beans.Coupon;

public interface BackCouponService {
	public List<Coupon> getSubCoupon(int qid) throws Exception;
	public List<Coupon> getDiscountCoupon(int qid) throws Exception;
	public List<String> getLessonType(int qid) throws Exception;
	public void addCoupon(int qid, 
						  String category, 
						  String total, 
						  String deadline, 
						  String full, 
						  String score, 
						  float money) throws Exception;
}
