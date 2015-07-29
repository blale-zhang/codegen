package org.blade.personal.framework.entity;

import java.lang.reflect.Field;
import java.util.Date;

import org.blade.personal.framework.components.annotation.Column;
import org.blade.personal.framework.components.annotation.Table;
import org.blade.personal.framework.orm.EntityAlies;
import org.blade.personal.framework.orm.base.DateAlies;
import org.blade.personal.framework.orm.base.FloatAlies;
import org.blade.personal.framework.orm.base.IntegerAlies;
import org.blade.personal.framework.orm.base.StringAlies;

/**
 * 抽象实体别名
 * @author ZGF
 *
 * @param <T>
 */
public abstract class AbstractEntityAlies<T> implements EntityAlies<T> {

	/**
	 * The alies of  table.
	 */
	protected String alies;
	
	private String tableName;

	/**
	 * 构造函数,用来初始化子类的各属性的对象
	 * @param alies
	 */
	public AbstractEntityAlies(String alies) {
		this.alies = alies;
		Field[] fields = getClass().getFields();
		Table table = getClass().getAnnotation(Table.class);
		this.tableName = table.name();
		for( Field field : fields ){
			Column column = field.getAnnotation(Column.class);
			try {
				switch(column.javaType()){
					case INTEGER:field.setAccessible(true);
						field.set(this,new IntegerAlies().newInstance(column.name(), 0, this.tableName, this.alies, column.javaType()));
						field.setAccessible(false);
					break;
					case STRING: field.setAccessible(true);
						field.set(this, new StringAlies().newInstance(column.name(), "", this.tableName, this.alies, column.javaType()));
						field.setAccessible(false);
					break;
					case FLOAT: field.setAccessible(true);
					field.set(this, new FloatAlies().newInstance(column.name(), 0.0f, this.tableName, this.alies, column.javaType()));
					field.setAccessible(false);
					break;
					case DATE: 
						field.setAccessible(true);//TODO ?
						field.set(this, new DateAlies().newInstance(column.name(),new Date(),this.tableName,this.alies,column.javaType()));
						field.setAccessible(false);
					    break;
				default:
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
	
	@Override
	public String getEntityName() {
		return this.getClass().getName();
	}
	
	@Override
	public String getTable() {
		return this.tableName;
	}

	
	@Override
	public String getAlise() {
		return this.alies;
	}
}
