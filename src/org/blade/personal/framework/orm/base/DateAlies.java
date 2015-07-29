package org.blade.personal.framework.orm.base;

import java.util.Date;

import org.blade.personal.framework.components.JavaTypeEnum;
import org.blade.personal.framework.orm.AbstractTypeAlise;
import org.blade.personal.framework.orm.TypeAlies;
/**
 * 日期别名类
 * @author LeisurelyRN
 *
 */
public class DateAlies extends AbstractTypeAlise<java.util.Date> implements TypeAlies<java.util.Date>{

	
	
	public DateAlies(Attribute<Date> attr, String clause, String alise,
			String sqlAlise, JavaTypeEnum type){
		this.alise = alise;
		this.attr = attr;
		this.clause = clause;
		this.sqlAlise = sqlAlise;
		this.type = type;
	}
	public DateAlies(){
		
	}
	
	@Override
	public TypeAlies<Date> newInstance(String name, Date value, String table) {
		this.attr = new Attribute<Date>(name,value);
		this.alise = table;
		return this;
	}

	@Override
	public TypeAlies<Date> newInstance(String name, Date value, String table,
			String tableAlise, JavaTypeEnum javaType) {
		this.attr = new Attribute<Date>(name, value, table);
		this.alise = tableAlise;
		this.type = javaType;
		return this;
	}

}
