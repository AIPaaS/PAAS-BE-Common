package com.aic.paas.comm.util;

import com.binary.framework.Local;
import com.binary.framework.bean.User;
import com.binary.framework.exception.ServiceException;

public abstract class SystemUtil {

	
	

	
	
	
	/**
	 * 获取登录用户, 如果没有登录则会抛出#ServiceException
	 * @return
	 */
	public static User getLoginUser() {
		User user = Local.getUser();
		if(user == null) {
			throw new ServiceException(" not found login user! ");
		}
		return user;
	}
	
	
	
	
	
	
	
	
}
