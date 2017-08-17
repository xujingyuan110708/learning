/**
 * 
 */
package com.ms.www.system.login.controller;

import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ms.www.model.TSysUser;
import com.ms.www.system.login.service.SysUserLoginService;
import com.ms.www.util.Util;
import com.ms.www.util.controller.UtilBaseController;
import com.ms.www.util.method.AesEncryption;
import com.ms.www.util.method.RandomCodeUtil;




/**登陆的controller
 * @author ZL
 *
 */
@Controller
@RequestMapping("/manage/sysLogin")
public class SysUserLoginController extends UtilBaseController{
	
	@Autowired
	private  SysUserLoginService sysUserLoginService;
	
	/**
	 * 跳转到登陆页�?
	  * toLogin 方法 
	  * <p>方法说明:</p> 
	  * @return 
	  * @return String 
	  * @author ZL 
	  * @date 2014-6-13
	 */
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		return "/system/login/login";
	}
    /**
	 * 刷新（点击）图片获得新的验证码
	 * @return 
	 */
	@RequestMapping("/image.do")
	public void image(HttpServletRequest req, HttpServletResponse resp)throws Exception{
		RandomCodeUtil rdnu = RandomCodeUtil.Instance();
		HttpSession session = req.getSession(); 
		// 取得随机字符串放入Session中
		session.setAttribute("rand", rdnu.getString());
		
		// 禁止图像缓存。  
        resp.setHeader("Pragma", "no-cache"); 
        resp.setHeader("Cache-Control", "no-cache"); 
        resp.setDateHeader("Expires", 0); 
 
        resp.setContentType("image/jpeg"); 
 
        // 将图像输出到Servlet输出流中。  
        ServletOutputStream sos = resp.getOutputStream(); 
        ImageIO.write(rdnu.getBuffImg(), "jpeg", sos); 
        sos.close(); 
	}
	/**
	 * 编码
	 * <b>Description:</b><br> TODO(这里用一句话描述这个类的作用)
	 * @param request
	 * @param response
	 * @param model
	 * @param searchCheck
	 * @Note
	 * <b>Author:</b> xujingyuan
	 * <br><b>Date:</b> 2017-7-17 下午4:22:22
	 * <br><b>Version:</b> 1.0
	 */
	 @RequestMapping("/encode.do")
	 public void encode(HttpServletRequest request,HttpServletResponse response,Model model,String searchCheck){
			try {
				//AES加密
				AesEncryption aes = AesEncryption.getInstance();
				searchCheck = aes.encrypt(searchCheck);
				PrintWriter out = response.getWriter();
				out.write(searchCheck);
				out.flush();
				out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	/**
	 * 登录方法
	 * @return
	 */
	@RequestMapping("/doLogin.do")
	public String doLogin(HttpServletRequest request,String loginname,String password,String code,Model model){
		
		TSysUser user = null;

		String sessionRand = "";
		
		
		if(request.getSession().getAttribute("rand") != null){
			sessionRand = request.getSession().getAttribute("rand").toString();
		}
		
		if(null == code || !code.trim().equalsIgnoreCase(sessionRand)){
			model.addAttribute("msg","验证码错误，请重新输入");
			return "/system/login/login";	
		}else{
			//request.getSession().removeAttribute("rand");
		}
		
		try {
			//通过用户名和密码来获得用户对�?
			if(null != loginname && !"".equals(loginname) && null != password && !"".equals(password)){
				AesEncryption aes = AesEncryption.getInstance();
				password = aes.decrypt(password);
				
				user=sysUserLoginService.getUserByUserNameAndPsd(loginname,password);
				if(user!=null){
					request.getSession().setAttribute(Util.SESSION_SYS_USER, user);
					return "redirect:/manage/frame/index.do";
				}
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("msg","用户名不存在或密码错误！");
		return "/system/login/login";
	}
	/**
	 * 退出的方法
	 * @return
	 */
	@RequestMapping("/doLogout.do")
	public String doLogout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute(Util.SESSION_SYS_USER);
		session.invalidate();
		return "redirect:/manage/sysLogin/toLogin.do";
	}
}
