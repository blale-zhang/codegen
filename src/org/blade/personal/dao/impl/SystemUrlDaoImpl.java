package org.blade.personal.dao.impl;

import java.util.List;
import java.util.Map;

import org.blade.personal.dao.SystemUrlDao;
import org.blade.personal.dao.base.BaseDao;
import org.blade.personal.dao.base.EntityMapper;
import org.blade.personal.mode.SystemUrl;
import org.blade.personal.utils.Pager;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("SystemUrlDao")
public class SystemUrlDaoImpl extends BaseDao<SystemUrl> implements SystemUrlDao {

	@Override
	public int add(SystemUrl u) {
		// TODO Auto-generated method stub
		return this.save(u);
		
	}

	@Override
	public void update(SystemUrl u) {
		this.getSession().update(u);
	}


	@Override
	public int delete(String ids) {
		return this.delete(ids, SystemUrl.class);
	}

	@Override
	public int delete(Long id) {

		return this.delete(id.toString());
	}

	@Override
	public List<SystemUrl> queryForChildren(Long id) {
		
		return jdbcTemplate.query("select * from sys_url where parent_id =  ? " , new Object[]{id}, new EntityMapper(SystemUrl.class));
//		return super.jdbcTemplate.queryForList("select * from sys_url where parent_id =  ? " , new Object[]{id}, SystemUrl.class);
	}

	@Override
	public List queryForAll() {
		// TODO Auto-generated method stub
		return super.jdbcTemplate.queryForList("select * from sys_url ");
	}

	@Override
	public List<SystemUrl> queryForList(String querySql) {
		// TODO Auto-generated method stub
		return super.jdbcTemplate.queryForList(querySql, SystemUrl.class);
	}

	@Override
	public SystemUrl queryOne(String querySql) {
		// TODO Auto-generated method stub
		return super.jdbcTemplate.queryForObject(querySql, SystemUrl.class);
	}

	@Override
	public void pagingQuery(Pager<SystemUrl> page,Map params) {
		// TODO Auto-generated method stub
	}

	@Override
	public void pagingQuery(Pager<SystemUrl> page, String querySql,
			Object[] params, RowMapper<SystemUrl> rowMapper) {
		// TODO Auto-generated method stub
		this.pagingQuery(page, querySql, params, rowMapper);
	}

}
