package org.blade.personal.framework.orm.base;

import org.blade.personal.framework.orm.AbstractTypeAlise;
import org.blade.personal.framework.orm.TypeAlies;

/**
 * 整型别名类
 * @author Thinkpad
 *
 */
public class IntegerAlies extends AbstractTypeAlise<Integer> implements TypeAlies<Integer> {

	
	@Override
	public TypeAlies<Integer> newInstance(String name, Integer value,
			String table) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getClause() {
		return this.clause;
	}


	@Override
	public Integer getVal() {
		return this.attr.getValue();
	}
	

}
