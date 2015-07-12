package org.blade.personal.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.blade.personal.dao.SqlWhereConditionDefinedDao;
import org.blade.personal.dao.base.BaseDao;
import org.blade.personal.dao.base.EntityMapper;
import org.blade.personal.mode.SqlSelectedTableDefined;
import org.blade.personal.mode.SqlWhereConditionDefined;
import org.blade.personal.utils.Pager;
import org.springframework.stereotype.Repository;

@Repository("SqlWhereConditionDefinedDao")
public class SqlWhereConditionDefinedDaoImpl extends
		BaseDao<SqlWhereConditionDefined> implements
		SqlWhereConditionDefinedDao<SqlWhereConditionDefined> {

	@Override
	public int add(SqlWhereConditionDefined sqlDefined) {
		// TODO Auto-generated method stub
		return super.save(sqlDefined);
	}

	@Override
	public void update(SqlWhereConditionDefined sqlDefined) {
		// TODO Auto-generated method stub
		super.getSession().update(sqlDefined);
	}

	@Override
	public int delete(String ids) {
		// TODO Auto-generated method stub
		return this.delete(ids, SqlWhereConditionDefined.class);
	}

	@Override
	public void pagingQuery(Pager<SqlWhereConditionDefined> page,
			Map<String, Object> params) {
		// TODO Auto-generated method stub
		String sql = "select * from t_sql_where_condition_defined a where 1=1 ";
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
	public SqlWhereConditionDefined getSqlDefined(Map<String, Object> map) {
		String sql = "select * from t_sql_where_condition_defined a where 1=1 ";
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			sql += " and a." + key + " = " + map.get(key);
		}
		return this.jdbcTemplate.queryForObject(sql,
				SqlWhereConditionDefined.class);
	}

}
