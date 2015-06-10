package com.gzucm.volunteer.util;

import java.util.Map;

public class StringHelp {
	public static String concatConditionSql(Map<String,String> condition){
		String hqlWhere=" ";
		for( Map.Entry<String, String> entry:condition.entrySet()){
			if(!entry.getValue().equals("")){
				hqlWhere+=entry.getKey()+"='"+entry.getValue()+"'";
			}
		}
		return hqlWhere;
	}
	
}
