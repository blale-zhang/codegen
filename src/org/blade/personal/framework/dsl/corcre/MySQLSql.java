package org.blade.personal.framework.dsl.corcre;

import org.blade.personal.framework.dsl.AbstractSql;
import org.blade.personal.framework.dsl.Sql;
import org.blade.personal.framework.orm.TypeAlies;

/**
 * MySQL的子句类,方言
 * @author Thinkpad
 *
 * @param 
 */
public class MySQLSql extends AbstractSql implements Sql {

	
	public MySQLSql() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 构造MySQL 的 SQL语句。一般用于子查询的SQL
	 * @param alise
	 */
	public MySQLSql(String alise) {
		this.alise = alise;
	}
	
	@Override
	public Sql list(TypeAlies... alies) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sql limit(Integer max) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Sql unionAll(Sql clause) {
		// TODO Auto-generated method stub
		return null;
	}


}
