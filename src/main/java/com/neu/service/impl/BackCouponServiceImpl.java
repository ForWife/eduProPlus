package com.neu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.beans.Coupon;
import com.neu.mapper.BackCouponMapper;
import com.neu.service.BackCouponService;
@Service
public class BackCouponServiceImpl implements BackCouponService {
	@Autowired
	private BackCouponMapper backCouponMapper;

	@Override
	public List<Coupon> getSubCoupon(int qid) throws Exception {
		return backCouponMapper.getSubCoupon(qid);
	}
	
	@Override
	public List<Coupon> getDiscountCoupon(int qid) throws Exception {
		return backCouponMapper.getDiscountCoupon(qid);
	}

	@Override
	public List<String> getLessonType(int qid) throws Exception {
		// TODO Auto-generated method stub
		return backCouponMapper.getLessonType(qid);
	}

	@Override
	public void addCoupon(int qid, String category, String total, String deadline, String full, String score,
			float money) throws Exception {
		backCouponMapper.addCoupon(backCouponMapper.getId(), qid, category, total, deadline, full, score, money);
	}

}
