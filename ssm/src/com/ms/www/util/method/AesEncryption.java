package com.ms.www.util.method;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/**
 * 单例模式AES加密解密
 * @author zxj
 */
public class AesEncryption {

	private static AesEncryption instance=null;
	
	private static String AES_HEX = "112b1ea14ae0ac4c081c26b4974b03f8c41d40cea3418eba6c0203404cb470bf";  
    private Cipher cipher;  
    private IvParameterSpec dps;  
    private SecretKeySpec skeySpec;  
      
    private  AesEncryption() throws Exception{  
        byte[] passkey = hex2Bin(AES_HEX);  
        byte[] key = getAESKey(passkey);  
        byte[] iv = getAESIV(passkey);  
        dps = new IvParameterSpec(iv);  
        skeySpec = new SecretKeySpec(key, "AES");  
        cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");  
    }  
    
    public static AesEncryption getInstance() {
    	try {
	        if(instance==null)
			instance=new AesEncryption();
	        return instance;
    	} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
      
    private byte[] getAESIV(byte[] keyRaw) throws Exception {   //获得32 byte数组中的一部分作为KEY  
        byte[] iv = new byte[16];  
        System.arraycopy(keyRaw, 8, iv, 0, 16);  
        return iv;  
    }  
  
    private byte[] getAESKey(byte[] keyRaw) throws Exception {  //获得32 byte数组中的一部分作为KEY  
        byte[] key = new byte[16];  
        System.arraycopy(keyRaw, 0, key, 0, 8);  
        System.arraycopy(keyRaw, 24, key, 8, 8);  
        return key;  
    }  
  /**
   * 加密
   * @param command
   * @return
   * @throws Exception
   */
    public String encrypt(String command) throws Exception {  
          
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, dps);  
        byte[] buf = cipher.doFinal(command.getBytes());  
  
        return this.byte2hexString(buf);  
    }  
  /**
   * 解密
   * @param sSrc
   * @return
   * @throws Exception
   */
    public String decrypt(String sSrc) throws Exception {  
  
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, dps);  
        return new String(cipher.doFinal(hex2Bin(sSrc)));  
  
    }  
  
    private byte[] hex2Bin(String src) {  
        if (src.length() < 1)  
            return null;  
        byte[] encrypted = new byte[src.length() / 2];  
        for (int i = 0; i < src.length() / 2; i++) {  
            int high = Integer.parseInt(src.substring(i * 2, i * 2 + 1), 16);  
            int low = Integer.parseInt(src.substring(i * 2 + 1, i * 2 + 2), 16);  
  
            encrypted[i] = (byte) (high * 16 + low);  
        }  
        return encrypted;  
    }  
  
    private String byte2hexString(byte buf[]) {  
        StringBuffer strbuf = new StringBuffer(buf.length * 2);  
        int i;  
  
        for (i = 0; i < buf.length; i++) {  
            if (((int) buf[i] & 0xff) < 0x10)  
                strbuf.append("0");  
  
            strbuf.append(Long.toString((int) buf[i] & 0xff, 16));  
        }  
  
        return strbuf.toString();  
    }  
    /**
     * 测试代码
     * 创建人：zxj
     * 创建时间：2014-8-5 上午9:22:55
     */
    public static void main(String[] args) {  
    	AesEncryption aes = null;  
        try {  
            aes = AesEncryption.getInstance();
            String test = aes.encrypt("关于");  
            System.out.println("加密后："+test);
            System.out.println("解密后："+aes.decrypt(test));
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  

}
