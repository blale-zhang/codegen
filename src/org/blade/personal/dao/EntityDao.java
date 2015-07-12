package org.blade.personal.dao;

import java.util.Map;

import org.blade.personal.utils.Pager;

/**
 * 增删改查操作封装
 * @author Thinkpad
 *
 * @param <T>
 */
public interface EntityDao<T> {

	/**
	 * 添加
	 * @param sqlDefined
	 * @return
	 */
	int add(T sqlDefined);
	
	/**
	 * 更新
	 * @param sqlDefined
	 */
	void update(T sqlDefined);
	
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	int delete(String ids);
	
	/**
	 * 分页查询
	 * @param page
	 * @param params
	 */
	void pagingQuery(Pager<T> page,
			Map<String,Object> params);
	
	/**
	 * 查询一个
	 * @param map
	 * @return
	 */
	T getSqlDefined(Map<String,Object> map);
}
