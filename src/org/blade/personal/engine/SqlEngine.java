/**
 * 
 */
package org.blade.personal.engine;

import java.util.List;

import org.blade.personal.engine.sql.Sql;
import org.blade.personal.mode.SqlSelectedItemDefined;
import org.blade.personal.mode.SqlSelectedTableDefined;
import org.blade.personal.mode.SqlWhereConditionDefined;

/**
 * 
 * sql 引擎
 * @author ZGF
 *
 */
public interface SqlEngine {

	/**
	 * 获取Sql
	 * @return
	 */
	public Sql getSql();
	
	public void setSelectedItem(List<SqlSelectedItemDefined> selectedItems);
	
	public void setSelectedTable(List<SqlSelectedTableDefined> selectedTables);
	
	public void setWhereCondition(List<SqlWhereConditionDefined> whereConditions);
	

}
