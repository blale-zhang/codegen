package org.blade.personal.manager.corncre;

import java.util.List;
import java.util.Map;

import org.blade.personal.dao.ModelDefinedDao;
import org.blade.personal.dao.ModelPropertyDefinedDao;
import org.blade.personal.engine.CodeEngine;
import org.blade.personal.engine.code.EntityCodeEngine;
import org.blade.personal.manager.ModelDefinedManager;
import org.blade.personal.mode.ModelDefined;
import org.blade.personal.mode.ModelPropertyDefined;
import org.blade.personal.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 模型定义业务逻辑
 * @author ZGF
 *
 */
@Transactional("transactionManager")
@Service("ModelDefinedManager")
public class ModelDefinedManagerImpl implements ModelDefinedManager{

	@Autowired
	private ModelPropertyDefinedDao modelPropertyDefinedDao;
	
	@Autowired
	private ModelDefinedDao modelDefinedDao;
	
	@Override
	public int saveModelDefined(List<ModelDefined> ModelDefined) {
		
		return modelDefinedDao.add(ModelDefined);
	}

	@Override
	public int removeModelDefined(String id) {
		// TODO Auto-generated method stub
		return modelDefinedDao.delete(id);
	}

	@Override
	public int saveModelPropertyDefined(
			List<ModelPropertyDefined> modelPropertyDefined) {
		// TODO Auto-generated method stub
		return modelPropertyDefinedDao.batchSave(modelPropertyDefined);
	}

	@Override
	public int removeModelPropertyDefined(String id) {
		// TODO Auto-generated method stub
		return modelPropertyDefinedDao.delete(id);
	}
	
	@Override
	public void findModelDefinedForPage(Pager<ModelDefined> pager, Map params) {
		// TODO Auto-generated method stub
		modelDefinedDao.pagingQuery(pager, params);
	}
	
	@Override
	public void findModelPropertyDefinedForPage(Pager<ModelPropertyDefined> pager,
			Map params) {
		// TODO Auto-generated method stub
		modelPropertyDefinedDao.pagingQuery(pager, params);
	}
	
	@Override
	public ModelDefined findByIdAndGeneratCode(Long id) {

		ModelDefined modelDefined = modelDefinedDao.queryModelDefinedById(id);
		List<ModelPropertyDefined> modelPropertyDefineds  =  modelPropertyDefinedDao.getByModelDefinedId(id);
		modelDefined.setPropreties(modelPropertyDefineds);
		CodeEngine engine = new EntityCodeEngine();
		engine.generate(modelDefined);
		
		return modelDefined;
	}

}
