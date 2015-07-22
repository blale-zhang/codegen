package org.blade.personal.framework.orm;

/**
 * 实体别名类
 * @author ZGF
 *
 */
public interface EntityAlies<T> {

	/**
	 * 产生实体别名
	 * @param instance
	 * @return
	 */
	public EntityAlies<T> create(T instance);
}
