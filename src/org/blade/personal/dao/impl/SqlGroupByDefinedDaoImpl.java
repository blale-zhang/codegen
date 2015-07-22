package org.blade.personal.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.blade.personal.dao.SqlGroupByDefinedDao;
import org.blade.personal.dao.base.BaseDao;
import org.blade.personal.dao.base.EntityMapper;
import org.blade.personal.mode.SqlGroupByDefined;
import org.blade.personal.utils.Pager;
import org.springframework.stereotype.Repository;

@Repository("SqlDefinedDao")
public class SqlGroupByDefinedDaoImpl extends BaseDao<SqlGroupByDefined>
		implements SqlGroupByDefinedDao<SqlGroupByDefined> {

	@Override
	public int add(SqlGroupByDefined sqlDefined) {
		// TODO Auto-generated method stub

		return super.saveEntity(sqlDefined);
	}

	@Override
	public void update(SqlGroupByDefined sqlDefined) {
		super.getSession().update(sqlDefined);

	}

	@Override
	public int delete(String ids) {
		// TODO Auto-generated method stub
		return super.delete(ids, SqlGroupByDefined.class);
	}

	@Override
	public void pagingQuery(Pager<SqlGroupByDefined> page,
			Map<String, Object> params) {
		String sql = "select * from t_sql_group_by_clause a where 1=1 ";
		Set<String> keySet = params.keySet();
		List<Object> valus = new ArrayList<Object>();
		for(String key : keySet){
			sql += " and a." + key + " = " + params.get(key);
			valus.add(params.get(key));
		}
		super.pagingQuery(page, sql, valus.toArray(),
				new EntityMapper<SqlGroupByDefined>(SqlGroupByDefined.class));
	}

	@Override
	public SqlGroupByDefined getSqlDefined(Map<String, Object> map) {
		// TODO Auto-generated method stub
		String sql = "select * from t_sql_group_by_clause a where 1=1 ";
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			sql += " and a." + key + " = " + map.get(key);
		}
		return this.jdbcTemplate.queryForObject(sql, SqlGroupByDefined.class);
	}

}
