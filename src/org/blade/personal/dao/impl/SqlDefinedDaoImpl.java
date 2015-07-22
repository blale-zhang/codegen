package org.blade.personal.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.blade.personal.dao.SqlDefinedDao;
import org.blade.personal.dao.base.BaseDao;
import org.blade.personal.dao.base.EntityMapper;
import org.blade.personal.mode.SqlDefined;
import org.blade.personal.utils.Pager;
import org.springframework.stereotype.Repository;

@Repository("sqlDefinedDao")
public class SqlDefinedDaoImpl extends BaseDao<SqlDefined> implements SqlDefinedDao<SqlDefined> {

	@Override
	public int add(SqlDefined sqlDefined) {
		return super.saveEntity(sqlDefined);
	}

	@Override
	public void update(SqlDefined sqlDefined) {
		
		 super.getSession().update(sqlDefined);
	}

	@Override
	public int delete(String ids) {
		return super.delete(ids, SqlDefined.class);
	}

	@Override
	public void pagingQuery(Pager<SqlDefined> page,
			Map<String,Object> params) {
		String sql = "select * from t_sql_defined a where 1=1 ";
		Set<String> keySet = params.keySet();
		List<Object> valus = new ArrayList();
		for(String key : keySet){
			sql += " and a." + key + " = " + params.get(key);
			valus.add(params.get(key));
		}
		super.pagingQuery(page, sql, valus.toArray(),
				new EntityMapper(SqlDefined.class));
	}

	@Override
	public SqlDefined getSqlDefined(Map<String, Object> map) {
		
		String sql = "select * from t_sql_defined a where 1=1 ";
		Set<String> keySet = map.keySet();
		for(String key : keySet){
			sql += " and a." + key + " = " + map.get(key);
		}
		return this.jdbcTemplate.queryForObject(sql, SqlDefined.class);
	}

}
