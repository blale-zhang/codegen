package org.blade.personal.framework.orm.base;

/**
 * attribute
 * @author ZGF
 *
 */
public class Attribute<T> {

	private String name;
	private T value;
	
	/**
	 * 属性类，封装属性名称及值
	 * @param name
	 * @param value
	 */
	public Attribute(String name,T value){
		this.name = name;
		this.value = value;
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
	
}
