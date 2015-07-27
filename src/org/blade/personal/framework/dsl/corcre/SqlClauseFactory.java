package org.blade.personal.framework.dsl.corcre;

import org.blade.personal.framework.dsl.Clause;

/**
 * Sql 子句工厂
 * @author ZGF
 *
 */
public interface SqlClauseFactory {

	/**
	 * 生产子句
	 * @param clause
	 * @return
	 */
	Clause build(StringBuilder clause);
}
