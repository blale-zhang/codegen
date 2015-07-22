package org.blade.personal.framework.entity;

import org.blade.personal.framework.orm.EntityAlies;

/**
 * 抽象实体别名
 * @author ZGF
 *
 * @param <T>
 */
public class AbstractEntityAlies<T> implements EntityAlies<T> {

	/**
	 * The alies of  table.
	 */
	protected String alies;
	
	@Override
	public EntityAlies<T> create(T instance) {
	
		
		return null;
	}
	
	

}
