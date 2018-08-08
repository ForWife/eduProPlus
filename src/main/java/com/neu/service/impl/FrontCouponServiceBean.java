package com.neu.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.beans.Coupon;
import com.neu.mapper.FrontCouponMapper;
import com.neu.service.FrontCouponService;

@Service
public class FrontCouponServiceBean implements FrontCouponService {

	@Autowired
	FrontCouponMapper couponMapper;
	
	@Override
	public List<Coupon> findCoupon(String openid, int lid) throws Exception {
		System.out.println("FrontCouponServiceBean.findCoupon()");
		Map<String, Object> map = new HashMap<>();
		map.put("lid", lid);
		map.put("openid", openid);
		List<Coupon> couponlist = couponMapper.findCoupons(map);
		return couponlist;
	}

	@Override
	public Coupon getaCoupon(int cid) throws Exception {
		// TODO Auto-generated method stub
		return couponMapper.getCoupon(cid);
	}

}
