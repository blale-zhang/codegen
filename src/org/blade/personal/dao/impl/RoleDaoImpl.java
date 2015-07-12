package org.blade.personal.dao.impl;

import java.util.List;
import java.util.Map;

import org.blade.personal.dao.RoleDao;
import org.blade.personal.dao.base.BaseDao;
import org.blade.personal.mode.Role;
import org.blade.personal.utils.Pager;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDao<Role> implements RoleDao {

	@Override
	public int add(final Role role) {
		Session session = super.getSession();
		return (Integer) session.save(role);
	}

	@Override
	public int update(final Role role) {
		Session session = super.getSession();
		return (Integer) session.save(role);
	}

	@Override
	public int delete(final Long id) {

		Session session = super.getSession();
		return session.createQuery("delete from Role where id = ? ")
				.setLong(1, id).executeUpdate();

	}

	@Override
	public int deleteByIds(String ids) {

		return super.getSession()
				.createQuery(" delete from Role where id in (?) ")
				.setString(1, ids).executeUpdate();
	}

	@Override
	public Role queryOne(final Long id) {

		return jdbcTemplate.queryForObject(
				" select *  from  sys_role  where id = ? ", Role.class,
				new Object[] { id });
	}

	@Override
	public List<Role> fetchAllRoles() {

		return jdbcTemplate
				.queryForList("select *  from  sys_role", Role.class);
	}

	@Override
	public void pagingQuery(Pager<Role> page, Map param) {

		String sql = " select * from sys_role where 1=1 ";
		super.pagingQuery(page, sql, param);

	}

}
