package org.blade.personal.framework.orm.base;

import org.blade.personal.framework.components.JavaTypeEnum;
import org.blade.personal.framework.orm.AbstractTypeAlise;
import org.blade.personal.framework.orm.TypeAlies;

/**
 * 浮点类型别名类
 * @author ZGF
 *
 */
public class FloatAlies extends AbstractTypeAlise<Float> {

	
	public FloatAlies(Attribute<Float> attr, String clause, String alise,
			String sqlAlise, JavaTypeEnum type) {
		
		this.attr = attr;
		this.clause = clause;
		this.alise = alise;
		this.sqlAlise = sqlAlise;
		this.type = type;
	}
	
	public FloatAlies() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TypeAlies<Float> newInstance(String name, Float value, String table, String tableAlise,JavaTypeEnum javaType) {
		this.attr = new Attribute<Float>(name,value,table);
		this.alise = tableAlise;
		this.type = javaType;
		return this;
	}

	@Override
	public TypeAlies<Float> newInstance(String name, Float value, String table) {
		this.attr = new Attribute<Float>(name,value);
		this.alise = table;
		return this;
	}
	
}
