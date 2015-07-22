package org.blade.personal.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.blade.personal.dao.ModelDefinedDao;
import org.blade.personal.dao.base.BaseDao;
import org.blade.personal.dao.base.EntityMapper;
import org.blade.personal.mode.ModelDefined;
import org.blade.personal.utils.Pager;
import org.springframework.stereotype.Repository;

@Repository("ModelDefinedDao")
public class ModelDefinedDaoImpl extends BaseDao<ModelDefined> implements ModelDefinedDao {

	@Override
	public int add(List<ModelDefined> modelDefineds) {
		return super.saveEntity(modelDefineds.get(0));
	}

	@Override
	public int delete(String id) {
		return super.delete(id, ModelDefined.class);
	}

	@Override
	public void update(ModelDefined ModelDefined) {
		 this.getSession().update(ModelDefined);
	}

	@Override
	public void pagingQuery(Pager<ModelDefined> page,
			Map params) {

		String sql = "select * from t_model_defined a where 1=1 ";
		Set<String> keySet = params.keySet();
		List<Object> valus = new ArrayList();
		for(String key : keySet){
			sql += " and a." + key + " = " + params.get(key);
			valus.add(params.get(key));
		}
		super.pagingQuery(page, sql, valus.toArray(),
				new EntityMapper(ModelDefined.class));
	}
	
	@Override
	public ModelDefined queryModelDefinedById(Long id) {
		// TODO Auto-generated method stub
		String sql = "select * from t_model_defined a where 1=1 and a.id = ? ";
		return this.jdbcTemplate.queryForObject(sql, new Object[]{id}, new EntityMapper(ModelDefined.class));
	}

}
