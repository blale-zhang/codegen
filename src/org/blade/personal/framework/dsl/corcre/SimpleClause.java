package org.blade.personal.framework.dsl.corcre;

import org.blade.personal.framework.dsl.Clause;

/**
 * 简单子句
 * @author ZGF
 *
 */
public class SimpleClause implements Clause {

	private Clause clause;
	
	private StringBuilder val;
	
	public SimpleClause(StringBuilder val) {
		this.val = val;
	}
	
	@Override
	public void setClause(Clause clause) {
		if(null == this.clause){
			this.clause = clause;
			return;
		}
		this.clause.setClause(clause);
	}

	@Override
	public String build() {
		if(this.clause == null){
			return this.val.toString();
		}
		return this.val.append(clause.build()).toString();
	}

}
