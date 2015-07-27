package org.blade.personal.framework.orm.base;

import org.blade.personal.framework.components.JavaTypeEnum;
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


	public StringAlies(Attribute<String> attr, String clause, String alise,
			String sqlAlise, JavaTypeEnum type) {
		this.alise = alise;
		this.attr = attr;
		this.clause = clause;
		this.sqlAlise = sqlAlise;
		this.type = type;
	}
	
	public StringAlies(){
		
	}

	@Override
	public TypeAlies<String> newInstance(String name, String value, String table) {
		this.attr = new Attribute<String>(name, value);
		this.alise = table;
		return this;
	}
	
	@Override
	public TypeAlies<String> newInstance(String name, String value, String table,
			String tableAlise,JavaTypeEnum javaType) {
		this.attr = new Attribute<String>(name, value, table);
		this.alise = tableAlise;
		this.type = javaType;
		return this;
	}

	
}
