/**
 * 
 */
package org.blade.personal.dao;

import java.util.Map;

import org.blade.personal.mode.SqlSelectedItemDefined;
import org.blade.personal.utils.Pager;

/**
 * @author Thinkpad
 *
 */
public interface SqlSelectedItemDefinedDao {

	int add(SqlSelectedItemDefined sqlSelectedItemDefined);

	int delete(String ids);

	void update(SqlSelectedItemDefined sqlSelectedItemDefined);

	SqlSelectedItemDefined getSqlSelectedItemDefined(Map<String, Object> map);

	void pagingQuery(Pager<SqlSelectedItemDefined> page, Map<String,Object> params);
}
