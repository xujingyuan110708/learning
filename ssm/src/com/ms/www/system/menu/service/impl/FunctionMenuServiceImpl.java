package com.ms.www.system.menu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ms.www.dao.TFunctionMenuMapper;
import com.ms.www.model.TFunctionMenu;
import com.ms.www.system.menu.service.FunctionMenuService;

@Service
public class FunctionMenuServiceImpl implements FunctionMenuService{
	
	@Resource
	private TFunctionMenuMapper tFunctionMenuMapper;

	public List<TFunctionMenu> getMenuByUserId(Integer id,Integer pid) throws Exception {
		return tFunctionMenuMapper.getMenuByUserId(id,pid);
	}

	public List<TFunctionMenu> getMenuByPId(Integer pid) throws Exception {
		return tFunctionMenuMapper.getMenuByPId(pid);
	}

}
