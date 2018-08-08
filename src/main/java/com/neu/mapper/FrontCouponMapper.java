package com.neu.mapper;

import java.util.List;
import java.util.Map;

import com.neu.beans.Coupon;

public interface FrontCouponMapper {
	public Coupon getCoupon(int cid) throws Exception;
	public int useCoupon(Map<String, Object> map)throws Exception;

	List<Coupon> findCoupons(Map<String, Object>map) throws Exception;
}
