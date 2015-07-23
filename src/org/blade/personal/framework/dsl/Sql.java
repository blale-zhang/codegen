package org.blade.personal.framework.dsl;

import org.blade.personal.framework.orm.EntityAlies;
import org.blade.personal.framework.orm.TypeAlies;

/**
 * SQL子句，由于不同的数据库有不同的方言，
 * 这里需要实现几个版本的子句
 * @author ZGF
 *
 */
public interface Sql {

	public Sql select(TypeAlies...alies );
	
	public Sql from(EntityAlies entity);
	
	public Sql where(TypeAlies...alies);
	
	public Sql and(Sql clause);
	
	public Sql from(Sql clause);
	
	public Sql list(TypeAlies...alies );
	
	public Sql limit(Integer max);
	
	public Sql union(Sql clause);
	
	public Sql unionAll(Sql clause);
	
	public String get();
}
