package com.ms.www.system.frame.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ms.www.model.TFunctionMenu;
import com.ms.www.model.TSysUser;
import com.ms.www.system.menu.service.FunctionMenuService;
import com.ms.www.util.Util;
import com.ms.www.util.controller.UtilBaseController;
import com.ms.www.util.easyui.Tree;

@Controller
@RequestMapping("/manage/frame")
public class FrameController extends UtilBaseController{
	
	@Autowired
	private FunctionMenuService functionMenuService;
	
	
    @RequestMapping("/index.do")  
    public String  index(Model model,HttpSession session)throws Exception{  
    	TSysUser user =  (TSysUser)session.getAttribute(Util.SESSION_SYS_USER); 
    	List<TFunctionMenu> menuList = functionMenuService.getMenuByUserId(user.getId(),0);
    	model.addAttribute("menuList", menuList);
    	return "/system/frame/index";
    }
    
    @ResponseBody
    @RequestMapping("/getChildrenMenus.do")  
    public void  getChildrenMenus(HttpServletResponse response,Model model,HttpSession session,String pid)throws Exception{  
    	TSysUser user =  (TSysUser)session.getAttribute(Util.SESSION_SYS_USER); 
    	List<TFunctionMenu> menuList = functionMenuService.getMenuByUserId(user.getId(),Integer.parseInt(pid));
    	
    	JSONArray array=new JSONArray();
    	
    	JSONObject jsonObject=null;
    	  for (TFunctionMenu menu : menuList) {
    		  jsonObject=new JSONObject();
    		  jsonObject.put("id", menu.getId());
    		  jsonObject.put("text", menu.getMenuName());
    		  if(menu.getIsLeaf()==0){	//有子节点
    			  jsonObject.put("state", "closed");
    		  }else{
  				JSONObject jsonObjectAttr=new JSONObject();
  				jsonObjectAttr.put("url", menu.getMenuLink());
  				
  				jsonObject.put("attributes", jsonObjectAttr.toString());
  			}
  			
  			getAllChildrenMenus(jsonObject,user.getId(),menu.getId());
  			
  			array.add(jsonObject);
          }
    	  response.setContentType("text/xml;charset=utf-8");   
		  PrintWriter out = response.getWriter();
		  System.out.println(array.toString());
		  out.write(array.toString());
		  out.flush();
		  out.close();
    }
    
	
	
	
	
	private void getAllChildrenMenus(JSONObject jsonObject2, Integer userId, Integer id)throws Exception {
		List<TFunctionMenu> menuList2 = functionMenuService.getMenuByUserId(userId,id);
		if(menuList2!=null&&menuList2.size()>0){
			JSONArray children=new JSONArray();
			for (TFunctionMenu menu : menuList2) {
				JSONObject jsonObject=new JSONObject();
	    		  jsonObject.put("id", menu.getId());
	    		  jsonObject.put("text", menu.getMenuName());
	    		  if(menu.getIsLeaf()==0){	//有子节点
	    			  jsonObject.put("state", "closed");
	    		  }else{
	  				JSONObject jsonObjectAttr=new JSONObject();
	  				jsonObjectAttr.put("url", menu.getMenuLink());
	  				
	  				jsonObject.put("attributes", jsonObjectAttr.toString());
	  			}
				
				getAllChildrenMenus(jsonObject,userId,menu.getId());
				
				children.add(jsonObject);
	        }
			
			jsonObject2.put("children", children.toString());
		}
		
	}

	@ResponseBody
    @RequestMapping("/getMenuByUserId.do")  
    public List<Tree> getMenuByUserId(HttpSession session)throws Exception{  
    	TSysUser user =  (TSysUser)session.getAttribute(Util.SESSION_SYS_USER); 
    	List<TFunctionMenu> menuList = functionMenuService.getMenuByUserId(user.getId(),null);
    	List<Tree> treeList = new ArrayList<Tree>();

        for (TFunctionMenu menu : menuList) {
			Tree node = new Tree();
			node.setId(menu.getId());
			node.setPid(menu.getFkMenuId());
			node.setText(menu.getMenuName());
			if(menu.getIsLeaf()==0){	//有子节点
				node.setState("closed");
			}
			Map<String, Object> attr = new HashMap<String, Object>();
			attr.put("url", menu.getMenuLink());
			node.setAttributes(attr);
			treeList.add(node);
        }
    	return treeList;
    }
    
	

}
