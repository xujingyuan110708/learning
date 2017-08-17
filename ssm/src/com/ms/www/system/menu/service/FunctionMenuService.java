package com.ms.www.system.menu.service;

import java.util.List;

import com.ms.www.model.TFunctionMenu;



public interface FunctionMenuService {

	public List<TFunctionMenu> getMenuByUserId(Integer userid,Integer pid)throws Exception;
	
	public List<TFunctionMenu> getMenuByPId(Integer pid)throws Exception;

}
