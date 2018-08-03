
package com.neu.service;

import java.util.List;

import com.neu.po.OrderVO;

public interface FrontOrderService {

	public List<OrderVO> findAllorder(String userid);

	public List<OrderVO> findorderpaying(String userid);

	public List<OrderVO> findorderpaied(String userid);

	public List<OrderVO> findorderused(String userid);

	public List<OrderVO> findordercancel(String userid);

	public int deleteorder(int oid);

	public int pay(int oid);

	public int cancel( int oid);
}



