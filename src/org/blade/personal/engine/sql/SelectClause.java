package org.blade.personal.engine.sql;

import java.util.List;

import org.blade.personal.engine.DdlKeyWord;
import org.blade.personal.mode.SqlSelectedItemDefined;

public class SelectClause implements Clause {

	private List<SqlSelectedItemDefined> selectedItems;

	private Clause clause;
	
	public SelectClause(List<SqlSelectedItemDefined> selectedItems) {
		// TODO Auto-generated constructor stub
		this.selectedItems = selectedItems;
	}

	/**
	 * 构建SELECT的子句
	 */
	@Override
	public Clause build(StringBuilder clause) {
		// TODO Auto-generated method stub
		clause.append(DdlKeyWord.SELECT);

		if (this.selectedItems.size() > 0) {
			int i = 0;

			for (SqlSelectedItemDefined ssid : selectedItems) {

				clause.append(ssid.getName()).append(DdlKeyWord.AS)
						.append(ssid.getAlise());
				if (i + 1 < selectedItems.size()) {
					clause.append(",");
				}
				i++;
			}
			if( this.clause != null ){
				if(i < 1){
					clause.append(DdlKeyWord.ALL);
				}
					
				return this.clause.build(clause);
			}
		}
		return this;
	}

	@Override
	public void setClause(Clause clause) {
		// TODO Auto-generated method stub
		this.clause = clause;
	}
}
