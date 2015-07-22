package org.blade.personal.dao.base;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.blade.personal.utils.Pager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * 建议使用jdbcTemplate来做查询，其他操作交给hibernate 实现读写分离。
 * 
 * @author ZGF
 * @param <T>
 */
public class BaseDao<T> extends BladeHibernateGenericDao<T> {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Autowired
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	/**
	 * 分页查询
	 * 
	 * @param page
	 *            分页器
	 * @param sql
	 *            简单查询语句
	 * @param param
	 *            查询条件
	 */
	public void pagingQuery(Pager<T> page, String sql, Map param) {

		final Set<String> keySet = param.keySet();
		for (String key : keySet) {
			sql += " and " + key + " = " + param.get(key);
		}
		Session session = this.getSession();
		String countsql = " select count(1) from (" + sql + ") ";
		Query q = session.createSQLQuery(countsql);

		Long totalCount = (Long) q.uniqueResult();
		page.setTotalCount(totalCount);
		if (totalCount > 0) {
			q = session.createSQLQuery(sql);
			q.setMaxResults(page.getPageSize().intValue());
			q.setFirstResult(page.getIndex().intValue());
			List<T> list = q.list();
			page.setEntities(list);
		}
	}

	/**
	 * jdbcTemplate 分页查询
	 * 
	 * @param page
	 *            分页器
	 * @param sql
	 *            查询语句
	 * @param params
	 *            查询条件值
	 * @param rowMapper
	 *            映射器
	 */
	public void pagingQuery(final Pager<T> page, String sql, Object[] params,
			RowMapper<T> rowMapper) {

		String countSql = "select count(1) from (" + sql + ") a ";
		Long totalCount = jdbcTemplate.queryForLong(countSql, params);
		page.setTotalCount(totalCount);
		if (totalCount > 0) {
			String selectSql = sql + " limit " + page.getIndex() + ","
					+ page.getPageSize();
			List<T> list = jdbcTemplate.query(selectSql, params, rowMapper);
			page.setEntities(list);
		}
	}
	

	/**
	 * save enity
	 * 
	 * @param t
	 * @return
	 */
	public int saveEntity(T object) {
		Session session = this.getSession();
		Long effected = (Long) session.save(object);
		return effected.intValue();
	}

	public int delete(final String ids, Class<T> clazz) {
		final String sql = "delete from " + clazz.getName() + " where id in (?) ";
		Session session = this.getSession();
		return session.createQuery(sql).setString(0, ids).executeUpdate();
	}

}
