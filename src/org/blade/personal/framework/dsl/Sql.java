package org.blade.personal.framework.dsl;

import org.blade.personal.framework.orm.EntityAlies;
import org.blade.personal.framework.orm.TypeAlies;

/**
 * SQL子句，由于不同的数据库有不同的方言， 这里需要实现几个版本的子句
 * 
 * @author ZGF
 *
 */
public interface Sql {

	/**
	 * Select
	 * 
	 * @param alies
	 * @return
	 */
	public Sql select(TypeAlies... alies);

	/**
	 * from
	 * 
	 * @param entity
	 * @return
	 */
	public Sql from(EntityAlies entity);

	/**
	 * where
	 * 
	 * @param alies
	 * @return
	 */
	public Sql where(TypeAlies... alies);

	/**
	 * and
	 * 
	 * @param alies
	 * @return
	 */
	public Sql and(TypeAlies alies);

	/**
	 * from
	 * 
	 * @param clause
	 * @return
	 */
	public Sql from(Sql clause);

	/**
	 * list
	 * 
	 * @param alies
	 * @return
	 */

	public Sql list(TypeAlies... alies);

	/**
	 * limit
	 * 
	 * @param max
	 * @return
	 */
	public Sql limit(Integer max);

	/**
	 * union
	 * 
	 * @param clause
	 * @return
	 */
	public Sql union(Sql clause);

	/**
	 * union all
	 * 
	 * @param clause
	 * @return
	 */
	public Sql unionAll(Sql clause);

	/**
	 * Get the SQL
	 * 
	 * @param alies
	 * @return
	 */
	public String get();
	
	/**
	 * 获取别名
	 * @return
	 */
	public String getAlise();
	
}
