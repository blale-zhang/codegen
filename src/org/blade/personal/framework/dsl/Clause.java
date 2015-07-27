package org.blade.personal.framework.dsl;

/**
 * 子句，通过正确的顺序来构建
 * @author ZGF
 *
 */
public interface Clause {


	public void setClause(Clause clause);
	
	public String build();
}
