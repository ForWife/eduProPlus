package com.neu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.beans.Coupon;
import com.neu.mapper.FrontGetCouponMapper;
import com.neu.service.FrontGetCouponService;
@Service
public class FrontGetCouponServiceImpl implements FrontGetCouponService {
	@Autowired
	FrontGetCouponMapper  mapper;
	@Override
	public List<Coupon> getallcoupon() {		
		return mapper.getallcoupon();
	}
	
	@Override
	public int getcoupon(int cid,String openid) 
	{
		//判断此用户是否拥有这个优惠券
		//判断用户的积分是否足够
		//如果是 添加一条信息 record  更新数据库中的优惠券信息 
		//最后返回状态码 1拥有这个优惠券 2积分不够 3兑换成功
		
		int a= mapper.checkhave(cid,openid);
		if(a==1)
		{
			return 1;
		}
		else
		{
			int score1=mapper.getscore1(cid);
			int score2=mapper.getscore2(openid);	
			if(score1>score2)
			{
				return 2;
			}
			else
			{
				mapper.update1(score1,openid);
				mapper.update2(cid);
				mapper.insert(cid,openid);
				return 3;
			}
			
		}
	
		
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getscore(int cid) {
		return mapper.getscore1(cid);
	}

	

}
