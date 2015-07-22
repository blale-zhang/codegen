package org.blade.personal.framework.orm;

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
	 * Equal to  
	 * @param type
	 * @return
	 */
	public TypeAlies<T> eq(TypeAlies<Object> type);
	
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
	 * Like start with 
	 * @param type
	 * @return
	 */
	public TypeAlies<T> likeSw(TypeAlies<String>  type);
	
	
	
	/**
	 * Like end with ,eg: like '%%'
	 * @param type
	 * @return
	 */
	public TypeAlies<T> likeEw(TypeAlies<String> type);
	
	
	
	/**
	 * Not like  
	 * @param type
	 * @return
	 */
	public TypeAlies<T> notLike(TypeAlies<String>  type);
	
	
	
	/**
	 * less than 
	 * @param type
	 * @return
	 */
	public TypeAlies<T> lt(TypeAlies<Number> type);
	
	
	
	/**
	 * greate than 
	 * @param type
	 * @return
	 */
	public TypeAlies<T> gt(TypeAlies type);
	
	
	/**
	 * greate than 
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
	
}
