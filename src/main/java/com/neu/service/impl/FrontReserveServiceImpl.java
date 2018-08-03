package com.neu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.neu.mapper.FrontReserveMapper;
import com.neu.po.FreeListenVO;
import com.neu.service.FrontReserveService;

@Service
public class FrontReserveServiceImpl implements FrontReserveService {

	@Autowired
	FrontReserveMapper mapper;
	
	@Override
	public List<FreeListenVO> findAllReserve(String userid) {
		System.out.println("...Service...findAllreserve().....");
		List<FreeListenVO> list=null;
		try {
			list=mapper.findAllreserve(userid);
		} catch (Exception e) {
			list=null;
			e.printStackTrace();
		}
		return list;
	    }

	@Override
	public List<FreeListenVO> findReserved(String userid) {
		System.out.println("...Service...findreserved().....");
		List<FreeListenVO> list=null;
		try {
			list=mapper.findreserved(userid);
		} catch (Exception e) {
			list=null;
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<FreeListenVO> findReserveing(String userid) {
		System.out.println("...Service...findreserveing().....");
		List<FreeListenVO> list=null;
		try {
			list=mapper.findreserveing(userid);
		} catch (Exception e) {
			list=null;
			e.printStackTrace();
		}
		return list;
	}

}
