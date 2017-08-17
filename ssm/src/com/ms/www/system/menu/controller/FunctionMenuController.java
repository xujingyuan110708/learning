package com.ms.www.system.menu.controller;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ms.www.model.TFunctionMenu;
import com.ms.www.model.TSysUser;
import com.ms.www.system.menu.service.FunctionMenuService;
import com.ms.www.util.easyui.DataGrid;
import com.ms.www.util.easyui.PageHelper;

@Controller
@RequestMapping("/manage/functionMenu")
public class FunctionMenuController {
	
	@Autowired
	private FunctionMenuService functionMenuService;
	
	@RequestMapping("list.do")
    public String userList(Model model) {
		
        return "/system/menu/list";
    }
	
	
	@RequestMapping("datagrid.do")
	public void datagrid(HttpServletResponse response)throws Exception {
         List<TFunctionMenu> menuList = functionMenuService.getMenuByPId(0);
    	JSONArray array=new JSONArray();
    	
    	JSONObject jsonObject=null;
    	
    	SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
    	
    	  for (TFunctionMenu menu : menuList) {
    		  jsonObject=new JSONObject();
    		  jsonObject.put("id", menu.getId());
    		  jsonObject.put("name", menu.getMenuName());
    		  jsonObject.put("url", menu.getMenuLink());
    		  jsonObject.put("code", menu.getCode());
    		  jsonObject.put("sortnum", menu.getMenuSort());
    		  jsonObject.put("createTime", dateFormat.format(menu.getCreateTime()));
    		  jsonObject.put("updateTime", dateFormat.format(menu.getUpdateTime()));
  			
  			getAllChildrenMenus(jsonObject,menu.getId(),dateFormat);
  			
  			array.add(jsonObject);
          }
    	  response.setContentType("text/xml;charset=utf-8");   
		  PrintWriter out = response.getWriter();
		  System.out.println(array.toString());
		  out.write(array.toString());
		  out.flush();
		  out.close();
		
	}
	
	
	private void getAllChildrenMenus(JSONObject jsonObject2, Integer id,SimpleDateFormat dateFormat)throws Exception {
		List<TFunctionMenu> menuList2 = functionMenuService.getMenuByPId(id);
		if(menuList2!=null&&menuList2.size()>0){
			JSONArray children=new JSONArray();
			for (TFunctionMenu menu : menuList2) {
				JSONObject jsonObject=new JSONObject();
				  jsonObject.put("id", menu.getId());
	    		  jsonObject.put("name", menu.getMenuName());
	    		  jsonObject.put("url", menu.getMenuLink());
	    		  jsonObject.put("code", menu.getCode());
	    		  jsonObject.put("sortnum", menu.getMenuSort());
	    		  jsonObject.put("createTime", dateFormat.format(menu.getCreateTime()));
	    		  jsonObject.put("updateTime", dateFormat.format(menu.getUpdateTime()));
				
				getAllChildrenMenus(jsonObject,menu.getId(),dateFormat);
				
				children.add(jsonObject);
	        }
			
			jsonObject2.put("children", children.toString());
		}
		
	}
}
