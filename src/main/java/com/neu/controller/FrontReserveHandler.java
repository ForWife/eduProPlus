package com.neu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.beans.FreeListenBook;
import com.neu.po.FreeListenVO;
import com.neu.service.FrontReserveService;

@Controller
public class FrontReserveHandler 
{

	  @Autowired
	  FrontReserveService frontreserverService;
	  
	  @RequestMapping(value = "/front/ajaxallreserve")
	  @ResponseBody
	  public List<FreeListenVO> findAllreserve(String userid)
	  {
		  System.out.println("....servlet....findAllreserve()......");
		  return frontreserverService.findAllReserve(userid);
      }
	  
	  @RequestMapping(value = "/front/ajaxreserved")
	  @ResponseBody
	  public List<FreeListenVO> findreserved(String userid)
	  {
		  System.out.println("....servlet....findreserved()......");
		  return frontreserverService.findReserved(userid);
      }
	  
	  @RequestMapping(value = "/front/ajaxreserveing")
	  @ResponseBody
	  public List<FreeListenVO> findreserveing(String userid)
	  {
		  System.out.println("....servlet....findreserveing()......");
		  return frontreserverService.findReserveing(userid);
      }
	  
	  @RequestMapping(value="/front/addReserve")
	  @ResponseBody
	  public String addReserve(FreeListenBook freelistenbook) throws Exception{
		  System.out.println("FrontReserveHandler.addReserve()");
		  int count = frontreserverService.addReserve(freelistenbook);
		  if (count>0) {
			return "{\"result\":\"ok\"}";
		}else{
			return "{\"result\":\"=failed\"}";
		}
	  }
	  
}
