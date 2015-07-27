package org.blade.personal.framework.orm;

import org.blade.personal.framework.components.JavaTypeEnum;
import org.blade.personal.framework.orm.base.Attribute;
import org.blade.personal.framework.orm.base.FloatAlies;
import org.blade.personal.framework.orm.base.IntegerAlies;
import org.blade.personal.framework.orm.base.StringAlies;

/**
 * 类型别名工厂
 * @author ZGF
 *
 * @param <T>
 */
public class TypeAliseFactory<T> {

	private static TypeAliseFactory factory = null;
	
	/**
	 * 获取音例工厂
	 * @return
	 */
	public static TypeAliseFactory newInstance(){
		
		if(factory == null){
			factory = new TypeAliseFactory();
		}
		return factory;
	}
	
	private TypeAliseFactory(){
		
	}
	
	/**
	 * 生产
	 * @param attr 
	 * @param clause
	 * @param alise
	 * @param sqlAlise
	 * @param type 
	 * @return
	 */
	public TypeAlies create(Attribute<T> attr, String clause, String alise,
			String sqlAlise, JavaTypeEnum type){
		TypeAlies typeAlise = null;
		switch(type){
			case FLOAT: typeAlise =  new FloatAlies( (Attribute<Float>)attr,  clause,  alise, sqlAlise,  type);break;
			case INTEGER: typeAlise =  new IntegerAlies( (Attribute<Integer>)attr,  clause,  alise, sqlAlise,  type);break;
			case STRING: typeAlise =  new StringAlies( (Attribute<String>)attr,  clause,  alise, sqlAlise,  type);break;
			default: typeAlise =  new StringAlies( (Attribute<String>)attr,  clause,  alise, sqlAlise,  type);
				break;
			
		}
		
		return typeAlise;
	}
}
