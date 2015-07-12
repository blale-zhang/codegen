package org.blade.personal.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.blade.personal.dao.SqlSelectedTableDefinedDao;
import org.blade.personal.dao.base.BaseDao;
import org.blade.personal.dao.base.EntityMapper;
import org.blade.personal.mode.SqlSelectedTableDefined;
import org.blade.personal.utils.Pager;
import org.springframework.stereotype.Repository;

@Repository("SqlSelectedTableDefinedDao")
public class SqlSelectedTableDefinedDaoImpl extends
		BaseDao<SqlSelectedTableDefined> implements
		SqlSelectedTableDefinedDao<SqlSelectedTableDefined> {

	@Override
	public int add(SqlSelectedTableDefined sqlDefined) {
		// TODO Auto-generated method stub
		return super.save(sqlDefined);
	}

	@Override
	public void update(SqlSelectedTableDefined sqlDefined) {
		// TODO Auto-generated method stub
		super.getSession().update(sqlDefined);
	}

	@Override
	public int delete(String ids) {
		// TODO Auto-generated method stub
		return super.delete(ids, SqlSelectedTableDefined.class);
	}

	@Override
	public void pagingQuery(Pager<SqlSelectedTableDefined> page,
			Map<String, Object> params) {

		String sql = "select * from t_sql_select_table_defined a where 1=1 ";
		Set<String> keySet = params.keySet();
		List<Object> valus = new ArrayList();
		for (String key : keySet) {
			sql += " and a." + key + " = " + params.get(key);
			valus.add(params.get(key));
		}
		super.pagingQuery(page, sql, valus.toArray(),
				new EntityMapper(SqlSelectedTableDefined.class));
	}

	@Override
	public SqlSelectedTableDefined getSqlDefined(Map<String, Object> map) {

		String sql = "select * from t_sql_select_table_defined a where 1=1 ";
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			sql += " and a." + key + " = " + map.get(key);
		}
		return this.jdbcTemplate.queryForObject(sql,
				SqlSelectedTableDefined.class);
	}

}
