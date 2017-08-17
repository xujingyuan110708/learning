package com.ms.www.util.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ms.www.util.method.FtpServerMethod;


/**
 * 下载Controller
 * @author zxj
 */
@Controller
@RequestMapping("/down/downLoad")
public class DownLoadController {
	@RequestMapping("/ftpDownLoad.do")
	public void ftpDownLoad(HttpServletRequest request, HttpServletResponse response,String filePath){
		FtpServerMethod.download(request, response, filePath);
	}
	
	@RequestMapping("/ftpShow.do")
	public void ftpShow(HttpServletRequest request, HttpServletResponse response,String filePath){
		FtpServerMethod.show(request, response, filePath);
	}

}
