/**
 * 
 */
package org.blade.personal.dao;

import java.util.Map;

import org.blade.personal.utils.Pager;

/**
 * 
 * Sql 定义存取接口
 * @author Thinkpad
 *
 */
public interface SqlDefinedDao<SqlDefined> extends EntityDao<SqlDefined> {
	
	
	/**
	 * 添加
	 * @param sqlDefined
	 * @return
	 */
	int add(SqlDefined sqlDefined);
	
	/**
	 * 更新
	 * @param sqlDefined
	 */
	void update(SqlDefined sqlDefined);
	
	int delete(String ids);
	
	void pagingQuery(Pager<SqlDefined> page,
			Map<String,Object> params);
	
	SqlDefined getSqlDefined(Map<String,Object> map);
}
