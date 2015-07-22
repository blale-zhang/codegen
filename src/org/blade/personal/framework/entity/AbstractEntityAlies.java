package org.blade.personal.framework.entity;

import java.lang.reflect.Field;

import org.blade.personal.framework.components.annotation.Column;
import org.blade.personal.framework.orm.EntityAlies;
import org.blade.personal.framework.orm.base.FloatAlies;
import org.blade.personal.framework.orm.base.IntegerAlies;
import org.blade.personal.framework.orm.base.StringAlies;

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

	/**
	 * 构造函数
	 * @param alies
	 */
	public AbstractEntityAlies(String alies) {
		this.alies = alies;
		Field[] fields = getClass().getFields();
		
		for( Field field : fields ){
			Column column = field.getAnnotation(Column.class);
			try {
				switch(column.javaType()){
					case INTEGER:field.setAccessible(true);
						field.set(this,new IntegerAlies().newInstance(column.name(), 0, this.alies));
						field.setAccessible(false);
					break;
					case STRING: field.setAccessible(true);
						field.set(this, new StringAlies().newInstance(column.name(), "", this.alies));
						field.setAccessible(false);
					break;
					case FLOAT: field.setAccessible(true);
					field.set(this, new FloatAlies().newInstance(column.name(), 0.0f, this.alies));
					field.setAccessible(false);
					break;
				}
			}catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * 重写默认构造函数
	 */
	public AbstractEntityAlies( ){
		this(null);
	}
	
	

}
