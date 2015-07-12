package org.blade.personal.dao.base;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.persistence.Column;

import org.springframework.jdbc.core.RowMapper;

/**
 * jdbcTemplate 组件
 * 
 * @author ZGF
 * @param <T>
 */
public class EntityMapper<T> implements RowMapper<T> {

	private Class<T> clazz;

	public EntityMapper(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public T mapRow(ResultSet rs, int arg1) throws SQLException {

		T t = null;
		try {
			t = (T) this.clazz.newInstance();
			Field[] fields = clazz.getDeclaredFields();
			for (Field f : fields) {
				Column a = (Column) f.getAnnotation(Column.class);
				if(null == a){
					continue;
				}
				f.getType();
				f.setAccessible(true);
				f.set(t, rs.getObject(a.name()));
				f.setAccessible(false);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return t;
	}

}
