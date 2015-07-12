package org.blade.personal.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.blade.personal.dao.ModelPropertyDefinedDao;
import org.blade.personal.dao.base.BaseDao;
import org.blade.personal.dao.base.EntityMapper;
import org.blade.personal.mode.ModelPropertyDefined;
import org.blade.personal.utils.Pager;
import org.springframework.stereotype.Repository;

@Repository("ModelPropertyDefinedDao")
public class ModelPropertyDefinedDaoImpl extends BaseDao<ModelPropertyDefined>
		implements ModelPropertyDefinedDao {

	@Override
	public int batchSave(List<ModelPropertyDefined> ModelPropertyDefineds) {
		// TODO Auto-generated method stub
		int effect = 0 ;
		for( ModelPropertyDefined mpd : ModelPropertyDefineds){
			effect += (Long)this.getSession().save(mpd);
		}
		return effect;
	}

	@Override
	public int delete(String ids) {
		
		return super.delete(ids, ModelPropertyDefined.class);
		
	}

	@Override
	public void update(ModelPropertyDefined ModelPropertyDefined) {
		// TODO Auto-generated method stub
		this.getSession().update(ModelPropertyDefined);
	}

	@Override
	public void pagingQuery(Pager<ModelPropertyDefined> page, Map params) {
		// TODO Auto-generated method stub
		String sql = " select * from t_model_properties_defined a where 1=1 ";
		Set<String> keySet = params.keySet();
		List<Object> valus = new ArrayList();
		for (String key : keySet) {
			sql += " and a." + key + " =  ? ";
			valus.add(params.get(key));
		}
		super.pagingQuery(page, sql, valus.toArray(),
				new EntityMapper<ModelPropertyDefined>(ModelPropertyDefined.class));
	}
	
	
	@Override
	public List<ModelPropertyDefined> getByModelDefinedId(Long modelDefinedId) {
		// TODO Auto-generated method stub
		String sql = " select * from t_model_properties_defined a where 1=1  and a.model_defined_id = ? ";
		return 	super.jdbcTemplate.query(sql, new Object[]{modelDefinedId},
				new EntityMapper<ModelPropertyDefined>(ModelPropertyDefined.class));
	}

}
