package com.ms.www.util.method;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * 字符串MD5/SHA-1加密方法类
 * @author admin
 *
 */
public class PwdEncryption {
	/**
	 * 字符串MD5加密
	 * @param password     输入密码
	 * @return
	 */
	public static String encodeAsMD5(String password) throws Exception{
		String newPwd = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] digesta = md.digest();
			newPwd = byte2hex(digesta);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();  
			throw e;
		}
		return newPwd;
	}
	
	/**
	 * 字符串SHA-1加密
	 * @param password     输入密码
	 * @return
	 */
	public static String encodeAsSHA1(String password) throws Exception{
		String newPwd = "";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(password.getBytes());
			byte[] digesta = md.digest();
			newPwd = byte2hex(digesta);
		}catch (NoSuchAlgorithmException e) {
			e.printStackTrace();  
			throw e;
		}
		return newPwd;
	}
	
	/**
	 * 二进制转字符
	 * @param b
	 * @return
	 */
	public static String byte2hex(byte[] b){
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1){
				hs = hs + "0" + stmp;
			}else{
				hs = hs + stmp;
			}
		}
		return hs.toUpperCase();
	}

}
