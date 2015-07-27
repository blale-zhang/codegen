package org.blade.personal.framework.orm;

import org.blade.personal.framework.components.JavaTypeEnum;

/**
 * Type alieses
 * @author ZGF
 *
 * @param <T>
 */
public interface TypeAlies<T> {

	
	/**
	 * 约定实例化方法
	 * @param name 属性名
	 * @param value 值
	 * @param table 表别名
	 * @return
	 */
	public TypeAlies<T> newInstance(String name,T value, String table);
	
	
	
	/**
	 * 约定实例化方法
	 * @param name 属性名
	 * @param value 值
	 * @param table 表名
	 * @param tableAlise 表别名
	 * @return
	 */
	public TypeAlies<T> newInstance(String name, T value, String table, String tableAlise,JavaTypeEnum javaType);
	/**
	 * Equal to  
	 * @param type
	 * @return
	 */
	public TypeAlies<T> eq(TypeAlies<Object> type);
	
	
	/**
	 * Equal to  
	 * @param type
	 * @return
	 */
	public TypeAlies<T> eq(Object type);
	
	/**
	 * Not equal to 
	 * @param type
	 * @return
	 */
	public TypeAlies<T> notEq(TypeAlies type);
	
	
	/**
	 * Like 
	 * @param type
	 * @return
	 */
	public TypeAlies<T> likeAll(TypeAlies<String>  type);
	
	/**
	 * Like 
	 * @param type
	 * @return
	 */
	public TypeAlies<T> likeAll(String  val);
	
	/**
	 * Like start with 
	 * @param type
	 * @return
	 */
	public TypeAlies<T> likeSw(TypeAlies<String>  type);
	
	/**
	 * Like start with 
	 * @param type
	 * @return
	 */
	public TypeAlies<T> likeSw(String  type);
	
	
	
	/**
	 * Like end with ,eg: like '%'
	 * @param type
	 * @return
	 */
	public TypeAlies<T> likeEw(TypeAlies<String> type);
	
	/**
	 * Like end with ,eg: like '%'
	 * @param type
	 * @return
	 */
	public TypeAlies<T> likeEw(String val);	
	
	/**
	 * Not like  
	 * @param type 
	 * @return
	 */
	public TypeAlies<T> notLike(TypeAlies<String>  type);
	
	
	/**
	 * Not like  
	 * @param type 条件
	 * @return
	 */
	public TypeAlies<T> notLike(String  type);
	
	
	/**
	 * less than 
	 * @param type
	 * @return
	 */
	public TypeAlies<T> lt(TypeAlies<Number> type);
	
	
	/**
	 * less than 
	 * @param type
	 * @return
	 */
	public TypeAlies<T> lt(T val);
		
	/**
	 * greate than 
	 * @param type
	 * @return
	 */
	public TypeAlies<T> gt(TypeAlies type);
	
	/**
	 * greate than 
	 * @param val
	 * @return
	 */
	public TypeAlies<T> gt(T val);
	
	/**
	 * greate  or equal  
	 * @param val
	 * @return
	 */
	public TypeAlies<T> gtoeq(T val);
	
	/**
	 * greate or equal 
	 * @param val
	 * @return
	 */
	public TypeAlies<T> ltoeq(T val);
	
	
	
	/**
	 * as 
	 * @param type
	 * @return
	 */
	public TypeAlies<T> as(String type);
	
	/**
	 * Get clause
	 * @return
	 */
	public String getClause();
	
	/**
	 * Get value
	 * @return
	 */
	public T getVal();
	
	public void setValue(T value);
	
	/**
	 * 获取名字
	 * @return
	 */
	public String getName();
	
	/**
	 * 设置别名
	 * @param alise
	 */
	public TypeAlies<T>  setAlise(String alise);
	
	/**
	 * 获取 javaType 枚举
	 * @return
	 */
	public JavaTypeEnum getType();
	
	/**
	 * 获取表
	 * @return
	 */
	public String getTable();
	
	public TypeAlies<T> clone();
	
	public void setClause(String clause);
	
}
