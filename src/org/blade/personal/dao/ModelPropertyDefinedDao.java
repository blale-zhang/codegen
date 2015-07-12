package org.blade.personal.dao;

import java.util.List;
import java.util.Map;

import org.blade.personal.mode.ModelPropertyDefined;
import org.blade.personal.utils.Pager;

/**
 * 模型属性定义存取对象
 * @author ZGF
 *
 */
public interface ModelPropertyDefinedDao {
	
	/**
	 * 批量删除
	 * @param ModelPropertyDefineds
	 * @return
	 */
	public int batchSave(List<ModelPropertyDefined> ModelPropertyDefineds);

	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	public int delete(String ids);
	
	/**
	 * 更新
	 * @param ModelPropertyDefined
	 * @return
	 */
	public void update(ModelPropertyDefined ModelPropertyDefined);
	
	
	/**
	 * 分面查询,jdbcTemplate实现查询
	 * @param page 分页器
	 * @param params 参数
	 */
	public void pagingQuery(Pager<ModelPropertyDefined> page, Map params);
	
	
	/**
	 * 通过模型Id获取模型属性
	 * @param modelDefinedId 模型Id
	 */
	public List<ModelPropertyDefined> getByModelDefinedId(Long modelDefinedId);
	
}
