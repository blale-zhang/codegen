package org.blade.personal.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.blade.personal.dao.SqlSelectedItemDefinedDao;
import org.blade.personal.dao.base.BaseDao;
import org.blade.personal.dao.base.EntityMapper;
import org.blade.personal.mode.SqlSelectedItemDefined;
import org.blade.personal.utils.Pager;
import org.springframework.stereotype.Repository;

@Repository("SqlSelectedItemDefinedDao")
public class SqlSelectedItemDefinedDaoImpl extends
		BaseDao<SqlSelectedItemDefined> implements SqlSelectedItemDefinedDao {

	@Override
	public int add(SqlSelectedItemDefined sqlSelectedItemDefined) {
		return super.save(sqlSelectedItemDefined);
	}

	@Override
	public int delete(String ids) {
		// TODO Auto-generated method stub
		return super.delete(ids, SqlSelectedItemDefined.class);
	}

	@Override
	public void update(SqlSelectedItemDefined sqlSelectedItemDefined) {
		// TODO Auto-generated method stub
		super.getSession().update(sqlSelectedItemDefined);
	}

	@Override
	public SqlSelectedItemDefined getSqlSelectedItemDefined(
			Map<String, Object> map) {
		// TODO Auto-generated method stub
		String sql = "select * from t_sql_select_item_defined a where 1=1 ";
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			sql += " and a." + key + " = " + map.get(key);
		}
		return this.jdbcTemplate.queryForObject(sql,
				SqlSelectedItemDefined.class);
	}

	@Override
	public void pagingQuery(Pager<SqlSelectedItemDefined> page,
			Map<String, Object> params) {
		String sql = "select * from t_sql_select_item_defined a where 1=1 ";
		Set<String> keySet = params.keySet();
		List<Object> valus = new ArrayList();
		for (String key : keySet) {
			sql += " and a." + key + " = " + params.get(key);
			valus.add(params.get(key));
		}
		super.pagingQuery(page, sql, valus.toArray(),
				new EntityMapper(SqlSelectedItemDefined.class));
	}

}
