package com.ms.www.system.login.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ms.www.dao.TSysUserMapper;
import com.ms.www.model.TSysUser;
import com.ms.www.system.login.service.SysUserLoginService;
import com.ms.www.util.method.PwdEncryption;

@Service
public class SysUserLoginServiceImpl implements SysUserLoginService{
	
	@Resource
	private TSysUserMapper tSysUserMapper;
	

	public TSysUser getUserByUserNameAndPsd(String loginname, String password)
			throws Exception {
		List<TSysUser> userList = tSysUserMapper.selectByName(loginname);
		if(userList!=null&&userList.size()>0){
			for(TSysUser user:userList){
				if(PwdEncryption.encodeAsMD5(password).equals(user.getUserPassword())){
					return user;
				}
				
			}
			
		}
		
		return null;
	}

	
}
