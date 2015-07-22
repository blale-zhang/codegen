package org.blade.personal.framework.orm.base;

import org.blade.personal.framework.orm.AbstractTypeAlise;
import org.blade.personal.framework.orm.TypeAlies;

public class FloatAlies extends AbstractTypeAlise<Float> {

	
	@Override
	public TypeAlies<Float> newInstance(String name, Float value, String table) {
		this.attr = new Attribute<Float>(name,value);
		this.tableAlise = table;
		return this;
	}
	
	
	@Override
	public String getClause() {
		// TODO Auto-generated method stub
		
		return null;
	}

}
