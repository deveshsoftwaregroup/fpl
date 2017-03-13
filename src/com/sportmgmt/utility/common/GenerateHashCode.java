package com.sportmgmt.utility.common;

import java.security.MessageDigest;

public class GenerateHashCode {
	public static String generate(String data,String shaKey) throws Exception
	{
        MessageDigest md = MessageDigest.getInstance(shaKey);
        md.update(data.getBytes());
        byte byteData[] = md.digest();
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	if(hexString.toString().equals(""))
    	 throw  new Exception("Empty Hash Code");
    	
		return hexString.toString();
	}

}
