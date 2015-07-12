package org.blade.personal.engine.sql;

public interface Clause {

	public Clause build(StringBuilder clause);
	
	public void setClause(Clause clause);
}
