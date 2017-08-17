package com.ms.www.system.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ms.www.model.TSysUser;
import com.ms.www.system.user.service.SysUserService;
import com.ms.www.util.controller.UtilBaseController;
import com.ms.www.util.easyui.DataGrid;
import com.ms.www.util.easyui.PageHelper;


@Controller
@RequestMapping("/manage/sysuser")
public class SysUserController  extends UtilBaseController {

	@Autowired
	private SysUserService sysUserService;
	
	/**
	 * 跳转到用户表格页面
	 * @return
	 */
	@RequestMapping("list.do")
    public String userList(Model model) {
		
        return "/system/sysuser/list";
    }
	
	@ResponseBody
	@RequestMapping("datagrid.do")
	public DataGrid datagrid(PageHelper page,TSysUser user) {
		DataGrid dg = new DataGrid();
		dg.setTotal(sysUserService.getDatagridTotal(user));
		List<TSysUser> userList = sysUserService.datagridUser(page,user);
		dg.setRows(userList);
		return dg;
	}
	
	@RequestMapping("add.do")
    public String add(Model model) {
        return "/system/sysuser/add";
    }
	
}
