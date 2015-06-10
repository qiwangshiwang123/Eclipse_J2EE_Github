package com.gzucm.volunteer.util;

/**
 * 字符拼接和拆装
 * @author 万允山
 * */
public class AddressUtil {
	private static String SIGN = "&&"; //分隔符

	public static String PackString(String[] params){
		StringBuffer str = new StringBuffer();
		for (int i=0; i<params.length;i++) {
			str.append(params[i]);
			if (i < params.length -1) {
				str.append(SIGN);
			}
		}
		return str.toString();
	}
	
	public static String[] UnpackString(String str){
		return str.split(SIGN);
	}
	
	public static void main(String[] args){
		String[] params = {"1","2","3","4"}; 
		String str = PackString(params);
		System.out.println(str);
		params = null;
		params = UnpackString(str);
		for (String param : params) {
			System.out.println(param);
		}
		
	}
}
