package com.neu.service;

import java.util.List;

import com.neu.po.FreeListenVO;



public interface FrontReserveService 
{
   public List<FreeListenVO> findAllReserve(String userid);

   public List<FreeListenVO> findReserved(String userid);

   public List<FreeListenVO> findReserveing(String userid);
}
