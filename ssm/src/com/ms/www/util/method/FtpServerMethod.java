package com.ms.www.util.method;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FtpServerMethod {
	 /**
     * FTP上传单个文件测试
     */
    public static void upload(HttpServletRequest request, String dir, FileInputStream fis, String fileName) {
        FTPClient ftpClient = new FTPClient();
        try {
        	String ip = ReadProperties.readValue(request.getSession().getServletContext().getRealPath("/WEB-INF/classes/ftp.properties"), "ftp.ip");//ftp服务器地址
        	Integer port = Integer.parseInt(ReadProperties.readValue(request.getSession().getServletContext().getRealPath("/WEB-INF/classes/ftp.properties"), "ftp.port"));//服务器端口号
        	String username = ReadProperties.readValue(request.getSession().getServletContext().getRealPath("/WEB-INF/classes/ftp.properties"), "ftp.username");//ftp用户名
        	String password = ReadProperties.readValue(request.getSession().getServletContext().getRealPath("/WEB-INF/classes/ftp.properties"), "ftp.password");//ftp登录名密码
        	//链接ftp服务器
        	boolean flag = connect(ftpClient,ip, port, username, password);
        	if(flag){
        		// 如果不能进入dir下，说明此目录不存在！  
        		if (!ftpClient.changeWorkingDirectory(dir)){
        			//设置上传目录
        			if(ftpClient.makeDirectory(dir)){
        				System.out.println("创建文件目录【"+dir+"】 成功！"); 
        			}else{
        				System.out.println("创建文件目录【"+dir+"】 失败！"); 
        			}
        		}
        		ftpClient.changeWorkingDirectory(dir);
                ftpClient.setBufferSize(500 * 1024);
                ftpClient.setControlEncoding("GBK");
                //设置文件类型（二进制）
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                ftpClient.storeFile(fileName, fis);
        	}
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("FTP客户端出错！", e);
        } finally {
            IOUtils.closeQuietly(fis);
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("关闭FTP连接发生异常！", e);
            }
        }
    }

    /**
     * FTP下载单个文件测试
     */
    public static void download(HttpServletRequest request,HttpServletResponse response, String filePath) {
        FTPClient ftpClient = new FTPClient();
        BufferedOutputStream outputStream = null;

        try {
        	String ip = ReadProperties.readValue(request.getSession().getServletContext().getRealPath("/WEB-INF/classes/ftp.properties"), "ftp.ip");//ftp服务器地址
        	Integer port = Integer.parseInt(ReadProperties.readValue(request.getSession().getServletContext().getRealPath("/WEB-INF/classes/ftp.properties"), "ftp.port"));//服务器端口号
        	String username = ReadProperties.readValue(request.getSession().getServletContext().getRealPath("/WEB-INF/classes/ftp.properties"), "ftp.username");//ftp用户名
        	String password = ReadProperties.readValue(request.getSession().getServletContext().getRealPath("/WEB-INF/classes/ftp.properties"), "ftp.password");//ftp登录名密码
        	//链接ftp服务器
        	boolean flag = connect(ftpClient,ip, port, username, password);
        	if(flag){
        		String fileName=filePath.substring(filePath.lastIndexOf("/")+1);
	            response.setContentType("application/x-msdownload;");   
	            response.setHeader("Content-disposition", "attachment; filename="+ new String(fileName.getBytes("utf-8"), "ISO8859-1"));   
        		outputStream = new BufferedOutputStream(response.getOutputStream());   

                ftpClient.setBufferSize(1024);
                //设置文件类型（二进制）
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                ftpClient.retrieveFile(filePath, outputStream);
        	}
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("FTP客户端出错！", e);
        } finally {
            IOUtils.closeQuietly(outputStream);
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("关闭FTP连接发生异常！", e);
            }
        }
    } 
    
    /**
     * FTP展示
     */
    public static void show(HttpServletRequest request,HttpServletResponse response, String filePath) {
        FTPClient ftpClient = new FTPClient();
        BufferedOutputStream outputStream = null;

        try {
        	String ip = ReadProperties.readValue(request.getSession().getServletContext().getRealPath("/WEB-INF/classes/ftp.properties"), "ftp.ip");//ftp服务器地址
        	Integer port = Integer.parseInt(ReadProperties.readValue(request.getSession().getServletContext().getRealPath("/WEB-INF/classes/ftp.properties"), "ftp.port"));//服务器端口号
        	String username = ReadProperties.readValue(request.getSession().getServletContext().getRealPath("/WEB-INF/classes/ftp.properties"), "ftp.username");//ftp用户名
        	String password = ReadProperties.readValue(request.getSession().getServletContext().getRealPath("/WEB-INF/classes/ftp.properties"), "ftp.password");//ftp登录名密码
        	//链接ftp服务器
        	boolean flag = connect(ftpClient,ip, port, username, password);
        	if(flag){
//        		String fileName=filePath.substring(filePath.lastIndexOf("/")+1);
//	            response.setContentType("application/x-msdownload;");   
//	            response.setHeader("Content-disposition", "attachment; filename="+ new String(fileName.getBytes("utf-8"), "ISO8859-1"));   
        		outputStream = new BufferedOutputStream(response.getOutputStream());   

                ftpClient.setBufferSize(1024);
                //设置文件类型（二进制）
                ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
                ftpClient.retrieveFile(filePath, outputStream);
        	}
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("FTP客户端出错！", e);
        } finally {
            IOUtils.closeQuietly(outputStream);
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("关闭FTP连接发生异常！", e);
            }
        }
    } 
    
    /** 
     * 连接到FTP服务器 
     * @param ip 主机名 
     * @param port 端口 
     * @param username 用户名 
     * @param password 密码 
     * @return 是否连接成功 
     * @throws IOException 
     */  
    public static boolean connect(FTPClient ftpClient,String ip,int port,String username,String password) throws IOException{   
        ftpClient.connect(ip, port);   
        ftpClient.setControlEncoding("GBK");   
        if(FTPReply.isPositiveCompletion(ftpClient.getReplyCode())){   
            if(ftpClient.login(username, password)){   
                return true;   
            }   
        }   
        disconnect(ftpClient);   
        return false;   
    } 
    /** 
     * 断开与远程服务器的连接 
     * @throws IOException 
     */  
    public static void disconnect(FTPClient ftpClient) throws IOException{   
        if(ftpClient.isConnected()){   
            ftpClient.disconnect();   
        }   
    } 
}
