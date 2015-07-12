package org.blade.personal.engine.corcre;

import java.util.List;

import org.blade.personal.engine.SqlEngine;
import org.blade.personal.engine.sql.Sql;
import org.blade.personal.mode.SqlSelectedItemDefined;
import org.blade.personal.mode.SqlSelectedTableDefined;
import org.blade.personal.mode.SqlWhereConditionDefined;

/**
 * 
 * @author ZGF
 *
 */
public class CorcreSqlEngine implements SqlEngine {

	/**
	 * 
	 */
	private List<SqlSelectedItemDefined> selectedItems;
	
	/**
	 * 
	 */
	private List<SqlSelectedTableDefined> selectedTables;

	/**
	 * 
	 */
	private List<SqlWhereConditionDefined> whereConditions;

	@Override
	public Sql getSql() {
		// TODO Auto-generated method stub
		
		
		
		
		return null;
	}

	@Override
	public void setSelectedItem(List<SqlSelectedItemDefined> selectedItems) {
		// TODO Auto-generated method stub
		
		this.selectedItems = selectedItems;

	}

	@Override
	public void setSelectedTable(List<SqlSelectedTableDefined> selectedTables) {
		// TODO Auto-generated method stub
		this.selectedTables = selectedTables;
	}

	@Override
	public void setWhereCondition(List<SqlWhereConditionDefined> whereConditions) {
		// TODO Auto-generated method stub
		this.whereConditions = whereConditions;
	}

}
