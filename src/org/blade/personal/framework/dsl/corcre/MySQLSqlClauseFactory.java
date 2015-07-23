package org.blade.personal.framework.dsl.corcre;

import org.blade.personal.framework.dsl.Clause;

public class MySQLSqlClauseFactory implements SqlClauseFactory {

	
	@Override
	public Clause build(StringBuilder clause) {
			Clause cl =  new SimpleClause(clause);
			return cl ;
	}

}
