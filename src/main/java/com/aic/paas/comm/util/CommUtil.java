package com.aic.paas.comm.util;

import com.binary.framework.exception.ServiceException;



public abstract class CommUtil {

	
	
	private static final String[] zeros = new String[]{
			"0",
			"00",
			"000",
			"0000",
			"00000",
			"000000",
			"0000000",
			"00000000",
			"000000000",
			"0000000000",
			"00000000000",
			"000000000000",
			"0000000000000",
			"00000000000000",
			"000000000000000",
			"0000000000000000"
	};
	
	
	
	/**
	 * 初前缀0, 最大16位
	 * @param id
	 * @return
	 */
	public static String fillPrefixZero(long id, int maxSize) {
		String cid = String.valueOf(id);
		return fillPrefixZero(cid, maxSize);
	}
	
	
	/**
	 * 初前缀0, 最大16位
	 * @param id
	 * @return
	 */
	public static String fillPrefixZero(String id, int maxSize) {
		if(maxSize<0 || maxSize>16) {
			throw new ServiceException(" is wrong max-size '"+maxSize+"'! ");
		}
		
		int fillzero = maxSize - id.length();
		if(fillzero > 0) {
			id = zeros[fillzero-1] + id;
		}
		return id;
	}
	
	
	
	
	
	
	
	
	

}
