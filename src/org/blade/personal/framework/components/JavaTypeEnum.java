package org.blade.personal.framework.components;

public enum JavaTypeEnum {
	
	STRING("java.lang.String"),
	INTEGER("java.lang.Integer"),
	FLOAT("java.lang.Float"),
	DATE("java.utils.Date");
	
	String type;
	
	JavaTypeEnum(String type){
		this.type = type;
	}
	
	JavaTypeEnum(){
		
	}
}
