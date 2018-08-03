package com.neu.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neu.beans.Address;
import com.neu.beans.Lesson;
import com.neu.beans.SOrder;
import com.neu.mapper.FrontLessonMapper;
import com.neu.mapper.FrontOrderMapper;
import com.neu.po.OrderVO;
import com.neu.service.FrontOrderService;

@Service
public class FrontOrderServiceImpl implements FrontOrderService {

	@Autowired
    FrontOrderMapper mapper;
	
	@Autowired
	FrontLessonMapper lessonMapper;
	
	@Override
	public List<OrderVO> findAllorder(String userid) {
		System.out.println("...Service...findAllorder().....");
		List<OrderVO> list=new ArrayList<OrderVO>();
		List<SOrder> orderList = null;			
		try {
			orderList=mapper.getOrderByPhone(userid);
			
			for (SOrder sOrder : orderList) {
				OrderVO ordervo = new OrderVO();
				Lesson lesson = mapper.getLesssonById(sOrder.getLid());
				Address address = mapper.getLessonAdderss(sOrder.getBranchid());
				ordervo.setAddress(address);
				ordervo.setLesson(lesson);
				ordervo.setSorder(sOrder);
				list.add(ordervo);
			}
		} catch (Exception e) {
			list=null;
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<OrderVO> findorderpaying(String userid) {
		System.out.println("...Service...findorderpaying().....");
		List<OrderVO> list=new ArrayList<OrderVO>();
		List<SOrder> orderList = null;			
		try {
			orderList=mapper.getOrderByPhone(userid);
			
			for (SOrder Sorder : orderList) {
				OrderVO ordervo = new OrderVO();
				if(Sorder.getStatus().equals("待付款"))
				{
					Lesson lesson = mapper.getLesssonById(Sorder.getLid());
					Address address = mapper.getLessonAdderss(Sorder.getBranchid());
					ordervo.setAddress(address);
					ordervo.setLesson(lesson);
					ordervo.setSorder(Sorder);
					list.add(ordervo);
				}		
			}
		} catch (Exception e) {
			list=null;
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<OrderVO> findorderpaied(String userid) {
		System.out.println("...Service...findorderpaied().....");
		List<OrderVO> list=new ArrayList<OrderVO>();
		List<SOrder> orderList = null;			
		try {
			orderList=mapper.getOrderByPhone(userid);//???? ???? ?? openid  ???? ?????????
			
			for (SOrder Sorder : orderList) {
				OrderVO ordervo = new OrderVO();
				if(Sorder.getStatus().equals("已付款"))
				{
					Lesson lesson = mapper.getLesssonById(Sorder.getLid());
					Address address = mapper.getLessonAdderss(Sorder.getBranchid());
					ordervo.setAddress(address);
					ordervo.setLesson(lesson);
					ordervo.setSorder(Sorder);
					list.add(ordervo);
				}		
			}
		} catch (Exception e) {
			list=null;
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<OrderVO> findorderused(String userid) {
		System.out.println("...Service...findorderused().....");
		List<OrderVO> list=new ArrayList<OrderVO>();
		List<SOrder> orderList = null;			
		try {
			orderList=mapper.getOrderByPhone(userid);//???? ???? ?? openid  ???? ?????????
			
			for (SOrder Sorder : orderList) {
				OrderVO ordervo = new OrderVO();
				if(Sorder.getStatus().equals("已使用"))
				{
					Lesson lesson = mapper.getLesssonById(Sorder.getLid());
					Address address = mapper.getLessonAdderss(Sorder.getBranchid());
					ordervo.setAddress(address);
					ordervo.setLesson(lesson);
					ordervo.setSorder(Sorder);
					list.add(ordervo);
				}		
			}
		} catch (Exception e) {
			list=null;
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<OrderVO> findordercancel(String userid) {
		System.out.println("...Service...findordercalcel().....");
		List<OrderVO> list=new ArrayList<OrderVO>();
		List<SOrder> orderList = null;			
		try {
			orderList=mapper.getOrderByPhone(userid);
			
			for (SOrder Sorder : orderList) {
				OrderVO ordervo = new OrderVO();
				if((Sorder.getStatus().equals("退款中"))||(Sorder.getStatus().equals("已退款")))
				{
					Lesson lesson = mapper.getLesssonById(Sorder.getLid());
					Address address = mapper.getLessonAdderss(Sorder.getBranchid());
					ordervo.setAddress(address);
					ordervo.setLesson(lesson);
					ordervo.setSorder(Sorder);
					list.add(ordervo);
				}		
			}
		} catch (Exception e) {
			list=null;
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int deleteorder( int oid) {
		System.out.println("...Service...deleteorder().....");
		int a;	
		try {
			a=mapper.deleteorderbyoid(oid);			
		} catch (Exception e) {
			a=0;
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int pay(int oid) {
		System.out.println("...Service...pay().....");
		int a;			
		try {
			a=mapper.paybyoid(oid);
						
		} catch (Exception e) {
			a=0;
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int cancel(int oid) {
		System.out.println("...Service...cancel().....");
		int a;			
		try {
			a=mapper.cancelbyoid(oid);
			
		
		} catch (Exception e) {
			a=0;
			e.printStackTrace();
		}
		return a;
	}

	@Override
	public int addOrder(SOrder sorder) throws Exception {
		//get transationid
		String transationid = "" ;
		SimpleDateFormat sfdate = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		System.out.println(sfdate);
		transationid += sfdate;
		//and three random
		Random random = new Random();
		for (int i = 0; i < 3; ++i) {
			int j = random.nextInt(10);
			transationid += j;
		}
		System.out.println(transationid);
		sorder.setTransactionid(transationid);
		
		Lesson lesson = mapper.getLesssonById(sorder.getLid());
		sorder.setTotal(lesson.getLprice());
		
		
		
		return 0;
	}
	


	

}

