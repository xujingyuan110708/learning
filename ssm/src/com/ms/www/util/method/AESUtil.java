package com.ms.www.util.method;


import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.text.SimpleDateFormat;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

/**
 * AES���ܹ���
 * 
 * @author
 * 
 * @version ����ʱ�䣺2008-8-5 ����10:58:16
 * 
 */  

public class AESUtil {  

	private static byte[] keybytes = "You are dead man".getBytes();
    
    /**
	 * ����
	 * 
	 * @param value
	 * @return
	 */  
    public static String encrypt(String value) {  
          
        String s=null;  
  
        int mode = Cipher.ENCRYPT_MODE;  
 
        try {  
            Cipher cipher = initCipher(mode);  
  
            byte[] outBytes = cipher.doFinal(value.getBytes());  
  
            s = String.valueOf(Hex.encodeHex(outBytes));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return s;  
    }  
  
    /**
	 * ����
	 * 
	 * @param value
	 * @return
	 */  
    public static String decrypt(String value) {  
  
        String s = null;  
  
        int mode = Cipher.DECRYPT_MODE;  
  
        try {  
            Cipher cipher = initCipher(mode);  
  
            byte[] outBytes = cipher.doFinal(Hex.decodeHex(value.toCharArray()));  
  
            s = new String(outBytes);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return s;  
    }  
      
    private static Cipher initCipher(int mode) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException{  
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        Key key = new SecretKeySpec(keybytes, "AES");
        cipher.init(mode, key);
        return cipher;
    }  

    public static void main(String[] args) {
    	Calendar c = Calendar.getInstance();
    	java.sql.Date date = new java.sql.Date(1);
    	SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");

// String qwe = "123456789123456789";
// String sar =qwe.substring(0, 16);
// //4ec4feb19e50ec01c95f06fe08844326
    	String str =AESUtil.decrypt("4518683a04a5f79dd9dab42f14e73b92");
	}
}  