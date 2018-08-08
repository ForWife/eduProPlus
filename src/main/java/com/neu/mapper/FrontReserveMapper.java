
package com.neu.mapper;

import java.util.List;

import com.neu.beans.FreeListenBook;
import com.neu.po.FreeListenVO;

public interface FrontReserveMapper 
{

	public List<FreeListenVO> findAllreserve(String userid) throws Exception;

	public List<FreeListenVO> findreserved(String userid) throws Exception;

	public List<FreeListenVO> findreserveing(String userid)throws Exception;
	
	public int addReserve(FreeListenBook freelistenbook) throws Exception;
		
}


