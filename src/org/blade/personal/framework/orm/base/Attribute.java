package org.blade.personal.framework.orm.base;

/**
 * attribute
 * @author ZGF
 *
 */
public class Attribute<T> {

	private String name;
	private T value;
	private String tableName;
	
	/**
	 * 属性类，封装属性名称及值
	 * @param name
	 * @param value
	 */
	public Attribute(String name,T value){
		this.name = name;
		this.value = value;
	}
	
	/**
	 * 属性类，封装属性名称及值
	 * @param name
	 * @param value
	 * @param tableName
	 */
	public Attribute(String name,T value, String tableName){
		this.name = name;
		this.value = value;
		this.tableName = tableName;
	}
	
	public  String getName(){
		return  this.name;
	}
	
	public T getValue(){
		return value;
	}
	
	public void setValue(T value){
		this.value = value;
	}
	
	public String getTalbe(){
		return this.tableName;
	}
	
	public Attribute<T> clone(){
		return new Attribute<T>(name, value, tableName);
	}
}
