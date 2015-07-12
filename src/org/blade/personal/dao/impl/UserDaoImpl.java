package org.blade.personal.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.blade.personal.dao.UserDao;
import org.blade.personal.dao.base.BaseDao;
import org.blade.personal.dao.base.EntityMapper;
import org.blade.personal.mode.User;
import org.blade.personal.utils.Pager;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

@Repository("UserDao")
public class UserDaoImpl extends BaseDao<User> implements UserDao {

	@Override
	public int add(User u) {
		this.save(u);
		return u.getId() == null ? 0 : 1;
	}

	@Override
	public int update(final User u) {
		Session session = super.getSession();
		return (Integer) session.save(u);
	}

	@Override
	public int delete(final String ids) {
		final String deleteHql = " delete from sys_usr where id in(?) ";
		Session session = super.getSession();
		return session.createSQLQuery(deleteHql).setString(1, ids)
				.executeUpdate();
	}

	@Override
	public int delete(Long id) {

		return this.delete(id.toString());
	}

	@Override
	public List<User> queryForList(String querySql) {
		// TODO Auto-generated method stub
		return null;
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
	public void pagingQuery(Pager<User> page, Map param) {

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
