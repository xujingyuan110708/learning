package com.ms.www.system.login.service;

import com.ms.www.model.TSysUser;



public interface SysUserLoginService {

	public TSysUser getUserByUserNameAndPsd(String loginname, String password) throws Exception;

}
