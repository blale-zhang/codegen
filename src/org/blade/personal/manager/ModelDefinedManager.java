package org.blade.personal.manager;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.blade.personal.mode.ModelDefined;
import org.blade.personal.mode.ModelPropertyDefined;
import org.blade.personal.utils.Pager;

/**
 * 模型定义业务逻辑
 * @author ZGF
 *
 */
public interface ModelDefinedManager {
	public  static final Logger log = Logger.getLogger(ModelDefinedManager.class.getName());

	/**
	 * 保存模型
	 * @param ModelDefined
	 * @return
	 */
	public int saveModelDefined(List<ModelDefined> ModelDefined);
	
	/**
	 * 删除模型
	 * @param id
	 * @return
	 */
	public int removeModelDefined(String id);

	/**
	 * 保存模型属性
	 * @param modelPropertyDefined
	 * @return
	 */
	public int saveModelPropertyDefined(List<ModelPropertyDefined> modelPropertyDefined);
	
	/**
	 * 删除模型属性
	 * @param id
	 * @return
	 */
	public int removeModelPropertyDefined(String id);
	
	/**
	 * 查找模型
	 * @param pager
	 * @param params
	 */
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
