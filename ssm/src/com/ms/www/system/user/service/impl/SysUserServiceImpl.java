package com.ms.www.system.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ms.www.dao.TSysUserMapper;
import com.ms.www.model.TSysUser;
import com.ms.www.system.user.service.SysUserService;
import com.ms.www.util.easyui.PageHelper;

@Service
public class SysUserServiceImpl implements SysUserService{
	
	@Resource
	private TSysUserMapper tSysUserMapper;
	

	public Long getDatagridTotal(TSysUser user) {
		return tSysUserMapper.getDatagridTotal(user);
	}

	public List<TSysUser> datagridUser(PageHelper page, TSysUser user) {
		page.setStart((page.getPage()-1)*page.getRows());
		page.setEnd(page.getPage()*page.getRows());
		return tSysUserMapper.datagridUser(page, user);
	}


}
