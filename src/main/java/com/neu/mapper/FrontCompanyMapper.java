package com.neu.mapper;

import java.util.List;
import java.util.Map;

import com.neu.beans.Coupon;
import com.neu.beans.Enterprise;

public interface FrontCompanyMapper 
{
	Enterprise getenterprise(int qid) throws Exception;
	
}
