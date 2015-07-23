package org.blade.personal.framework.orm.base;

import org.blade.personal.framework.orm.AbstractTypeAlise;
import org.blade.personal.framework.orm.TypeAlies;

/**
 * String alise
 * 
 * @author ZGF
 *
 */
public class StringAlies extends AbstractTypeAlise<String> implements
		TypeAlies<java.lang.String> {


	@Override
	public TypeAlies<String> newInstance(String name, String value, String table) {
		this.attr = new Attribute<String>(name, value);
		this.tableAlise = table;
		return this;
	}

}
