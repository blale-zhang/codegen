package org.blade.personal.manager;

import java.util.List;
import java.util.Map;

import org.blade.personal.mode.ModelDefined;
import org.blade.personal.mode.ModelPropertyDefined;
import org.blade.personal.utils.Pager;

/**
 * 模型定义业务逻辑
 * @author Thinkpad
 *
 */
public interface ModelDefinedManager {

	public int saveModelDefined(List<ModelDefined> ModelDefined);
	
	public int removeModelDefined(String id);

	public int saveModelPropertyDefined(List<ModelPropertyDefined> modelPropertyDefined);
	
	public int removeModelPropertyDefined(String id);
	
	public void findModelDefinedForPage(Pager<ModelDefined> pager, Map params);
	
	
	/**
	 * 分页查询查模型属性
	 * @param pager 分页器
	 * @param params 
	 */
	public void findModelPropertyDefinedForPage(Pager<ModelPropertyDefined> pager, Map params);
	
	/**
	 * 通过Id获取模型
	 * @param id 主键
	 * @return <code>ModelDefined</code>
	 */
	public ModelDefined findByIdAndGeneratCode(Long id);

}
