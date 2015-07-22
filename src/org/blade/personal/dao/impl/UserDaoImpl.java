package org.blade.personal.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.blade.personal.dao.UserDao;
import org.blade.personal.dao.base.BaseDao;
import org.blade.personal.dao.base.EntityMapper;
import org.blade.personal.mode.User;
import org.blade.personal.utils.Pager;
import org.hibernate.Session;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("UserDao")
public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@Override
	public int add(User u) {
		this.saveEntity(u);
		return u.getId() == null ? 0 : 1;
	}

	@Override
	public int update(final User u) {
		Session session = super.getSession();
		session.update(u);
		return u.getId().intValue();
	}

	@Override
	public int delete(final String ids) {
		final String deleteHql = " delete from sys_usr where id in(?) ";
		Session session = super.getSession();
		return session.createSQLQuery(deleteHql).setString(0, ids)
				.executeUpdate();
	}

	@Override
	public int delete(Long id) {

		return this.delete(id.toString());
	}

	@Override
	public List<User> queryForList(String querySql) {
		// TODO Auto-generated method stub
		return this.jdbcTemplate.query(querySql, new EntityMapper(
				User.class));
	}

	@Override
	public User queryOne(String querySql) {
		return jdbcTemplate.queryForObject(querySql, new EntityMapper(
				User.class));
	}

	@Override
	public User queryForOne(String querySql, Object[] params) {
		return jdbcTemplate.queryForObject(querySql, new EntityMapper(
				User.class), params);
	}

	@Override
	public void pagingQuery(Pager<User> page, Map params) {
		
		String querySql = " select * from sys_usr where 1=1 ";
		Set<String> keySet = params.keySet();
		List<Object> valus = new ArrayList();
		for(String key : keySet){
			querySql += " and a." + key + " = " + params.get(key);
			valus.add(params.get(key));
		}
		this.pagingQuery(page, querySql, valus.toArray(),
				new EntityMapper(User.class));
		
	}

	@Override
	public void pagingQuery(Pager<User> page, String querySql, Object[] params,
			RowMapper<User> rowMapper) {
		// TODO Auto-generated method stub
		super.pagingQuery(page, querySql, params, rowMapper);
	}

	@Override
	public int getCount(String countSql) {
		return jdbcTemplate.queryForInt(countSql);
	}

}
