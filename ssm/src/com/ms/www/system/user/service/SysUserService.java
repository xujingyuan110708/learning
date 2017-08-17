package com.ms.www.system.user.service;

import java.util.List;

import com.ms.www.model.TSysUser;
import com.ms.www.util.easyui.PageHelper;

public interface SysUserService {

	public Long getDatagridTotal(TSysUser user);

	public List<TSysUser> datagridUser(PageHelper page, TSysUser user);


}
