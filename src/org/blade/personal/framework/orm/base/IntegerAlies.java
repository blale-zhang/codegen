package org.blade.personal.framework.orm.base;

import org.blade.personal.framework.components.JavaTypeEnum;
import org.blade.personal.framework.orm.AbstractTypeAlise;
import org.blade.personal.framework.orm.TypeAlies;

/**
 * 整型别名类
 * @author ZGF
 *
 */
public class IntegerAlies extends AbstractTypeAlise<Integer> implements TypeAlies<Integer> {

	
	public IntegerAlies(Attribute<Integer> attr, String clause, String alise,
			String sqlAlise, JavaTypeEnum type) {
		this.alise = alise;
		this.attr = attr;
		this.clause = clause;
		this.sqlAlise = sqlAlise;
		this.type = type;

	}
	
	public IntegerAlies(){
		
	}
	
	@Override
	public TypeAlies<Integer> newInstance(String name, Integer value, String table) {
		this.attr = new Attribute<Integer>(name,value);
		this.alise = table;
		return this;
	}
	
	@Override
	public TypeAlies<Integer> newInstance(String name, Integer value, String table,
			String tableAlise,JavaTypeEnum javaType) {
		this.attr = new Attribute<Integer>(name, value, table);
		this.alise = tableAlise;
		this.type = javaType;
		return this;
	}

}
