package org.blade.personal.dao;

import java.util.List;
import java.util.Map;

import org.blade.personal.mode.ModelDefined;
import org.blade.personal.utils.Pager;

/**
 * 模型定义存取对象
 * @author Thinkpad
 *
 */
public interface ModelDefinedDao {

	public int add(List<ModelDefined> modelDefineds);
	
	public int delete(String id);
	
	public void update(ModelDefined ModelDefined);
	
	public void pagingQuery(Pager<ModelDefined> page, Map params);
	
	public ModelDefined queryModelDefinedById(Long id);
}
