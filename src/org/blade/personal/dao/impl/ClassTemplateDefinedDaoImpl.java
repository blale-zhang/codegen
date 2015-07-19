package org.blade.personal.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.blade.personal.dao.ClassTemplateDefinedDao;
import org.blade.personal.dao.base.BaseDao;
import org.blade.personal.dao.base.EntityMapper;
import org.blade.personal.mode.ClassTemplateDefined;
import org.blade.personal.utils.Pager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author ZGF
 *
 */
@Repository("ClassTemplateDefinedDao")
public class ClassTemplateDefinedDaoImpl extends BaseDao<ClassTemplateDefined>
		implements ClassTemplateDefinedDao {

	@Override
	public int add(List<ClassTemplateDefined> classTemplateDefineds) {

		Session session = this.getSession();

		String sql = "";
		Query query = session.createSQLQuery(sql);
		return query.executeUpdate();
	}

	@Override
	public int add(ClassTemplateDefined classTemplateDefined) {

		Session session = this.getSession();
		String sql = "";
		Query query = session.createQuery(sql);
		return query.executeUpdate();

	}

	@Override
	public int delete(Long classTemplateDefinedId) {

		return super.delete(classTemplateDefinedId.toString(),
				ClassTemplateDefined.class);
	}

	@Override
	public int delete(final String classTemplateDefinedIds) {

		return super
				.delete(classTemplateDefinedIds, ClassTemplateDefined.class);
	}

	@Override
	public void update(List<ClassTemplateDefined> classTemplateDefineds) {
		this.getSession().update(classTemplateDefineds);

	}

	@Override
	public void update(ClassTemplateDefined classTemplateDefined) {
		this.getSession().update(classTemplateDefined);
	}

	@Override
	public void pagingQuery(Pager<ClassTemplateDefined> page, Map params) {
		String sql = "select * from t_class_template_defined a where 1=1 ";
		Set<String> keySet = params.keySet();
		List<Object> valus = new ArrayList();
		for (String key : keySet) {
			sql += " and a." + key + " = " + params.get(key);
			valus.add(params.get(key));
		}
		super.pagingQuery(page, sql, valus.toArray(), new EntityMapper(
				ClassTemplateDefined.class));
	}

}
