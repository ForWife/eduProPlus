package com.neu.mapper;

import java.util.List;
import java.util.Map;

import com.neu.beans.Coupon;
import com.neu.beans.CouponRecord;

public interface FrontCouponMapper {
	public Coupon getCoupon(int cid) throws Exception;
	public int useCoupon(Map<String, Object> map)throws Exception;

	List<Coupon> findCoupons(Map<String, Object>map) throws Exception;
	
	List<CouponRecord> getRecordByOpenid(String openid) throws Exception;

	Coupon getCouponById(int cid) throws Exception;

}
