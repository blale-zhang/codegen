package org.blade.personal.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.blade.personal.dao.AuthorityDao;
import org.blade.personal.dao.base.AuthorityRowMapper;
import org.blade.personal.dao.base.BaseDao;
import org.blade.personal.mode.Authority;
import org.blade.personal.utils.Pager;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

@Repository("AuthorityDao")
public class AuthorityDaoImpl extends BaseDao<Authority> implements
		AuthorityDao {

	@Override
	public int addAuthority(Authority authority) {
		this.save(authority);

		return authority.getId() == null ? 0 : 1;
	}

	@Override
	public int deleteAuthority(final String ids) {
		Session session = this.getSession();
		String sql = " delete from Authority a where a.id in (?) ";
		Query query = session.createQuery(sql);
		query.setString(1, ids);
		return query.executeUpdate();
	}

	@Override
	public int updateAuthority(final Authority authority) {

		Session session = this.getSession();
		return (Integer) session.save(authority);
	}

	@Override
	public Authority queryAuthority(String querySql, Object[] params) {
		// TODO Auto-generated method stub

		return jdbcTemplate.queryForObject(querySql, new AuthorityRowMapper(),
				params);
	}

	@Override
	public int batchUpdate(final List<Authority> authorities) {

		Session session = this.getSession();
		return (Integer) session.save(authorities);
	}

	@Override
	public int batchSave(List<Authority> authorities) {
		return this.batchUpdate(authorities);
	}

	@Override
	public List<Authority> queryForList(String querySql, Object[] params,
			RowMapper<Authority> rowMapper) {

		return jdbcTemplate.query(querySql, rowMapper, params);
	}

	@Override
	public List<Map<String, Object>> queryForList(String querySql,
			Object[] params) {

		return jdbcTemplate.queryForList(querySql, params);
	}

	@Override
	public void pagingQuery(Pager<Authority> page, String querySql,
			Object[] params) {

		String sql = "select * from (" + querySql + ") a limit "
				+ page.getIndex() + "," + page.getPageSize();
		List<Authority> list = jdbcTemplate.queryForList(sql, params,
				Authority.class);
		page.setEntities(list);
	}

	@Override
	public int deleteAuthority(String deleteSql, Object[] params) {

		return jdbcTemplate.update(deleteSql, params);
	}

}
