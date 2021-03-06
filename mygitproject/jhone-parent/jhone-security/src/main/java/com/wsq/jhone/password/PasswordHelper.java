package com.wsq.jhone.password;

import java.security.MessageDigest;

import org.apache.log4j.Logger;

public class PasswordHelper {
	private static final Logger logger = Logger.getLogger(PasswordHelper.class);
    /** 
     * 根据用户名与密码做md5单向hash加密 
     * 
     * @param username 用户名 
     * @param password 用户密码明文 
     * @return md5(username+password) 
     */ 
	public String encryptPassword(String username, String password) {  
		logger.info("开始进行密码转换"); 
        String inStr = username + password;  
  
        MessageDigest md5 = null;  
        try {  
            md5 = MessageDigest.getInstance("MD5");  
        } catch (Exception e) {  
             
        		
        	//  System.out.println(e.toString());  
            e.printStackTrace();  
            return "";  
        }  
        char[] charArray = inStr.toCharArray();  
        byte[] byteArray = new byte[charArray.length];  
  
        for (int i = 0; i < charArray.length; i++)  
            byteArray[i] = (byte) charArray[i];  
        byte[] md5Bytes = md5.digest(byteArray);  
        StringBuffer hexValue = new StringBuffer();  
        for (int i = 0; i < md5Bytes.length; i++) {  
            int val = ((int) md5Bytes[i]) & 0xff;  
            if (val < 16)  
                hexValue.append("0");  
            hexValue.append(Integer.toHexString(val));  
        }  
        logger.info("密码转换结束密文:"+hexValue.toString()); 
        return hexValue.toString();  
  
    } 

}
