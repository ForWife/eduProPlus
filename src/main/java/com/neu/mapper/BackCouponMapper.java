package com.neu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.neu.beans.Coupon;

public interface BackCouponMapper {
	public List<Coupon> getSubCoupon(@Param("qid") int qid) throws Exception;
	public List<Coupon> getDiscountCoupon(@Param("qid") int qid) throws Exception;
	public List<String> getLessonType(@Param("qid") int qid) throws Exception;
	public void addCoupon(@Param("cid") int cid, 
						  @Param("qid") int qid, 
						  @Param("category") String category, 
						  @Param("total") String total, 
						  @Param("deadline") String deadline, 
						  @Param("full") String full, 
						  @Param("score") String score, 
						  @Param("money") float money) throws Exception;
	public int getId() throws Exception;
}
