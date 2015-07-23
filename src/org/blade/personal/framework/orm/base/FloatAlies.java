package org.blade.personal.framework.orm.base;

import org.blade.personal.framework.orm.AbstractTypeAlise;
import org.blade.personal.framework.orm.TypeAlies;

/**
 * 浮点类型别名类
 * @author ZGF
 *
 */
public class FloatAlies extends AbstractTypeAlise<Float> {

	
	@Override
	public TypeAlies<Float> newInstance(String name, Float value, String table) {
		this.attr = new Attribute<Float>(name,value);
		this.tableAlise = table;
		return this;
	}
	
}
