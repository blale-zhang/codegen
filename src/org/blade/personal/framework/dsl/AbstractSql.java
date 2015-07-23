package org.blade.personal.framework.dsl;

import org.blade.personal.engine.DdlKeyWord;
import org.blade.personal.framework.dsl.corcre.MySQLSqlClauseFactory;
import org.blade.personal.framework.dsl.corcre.SimpleClause;
import org.blade.personal.framework.dsl.corcre.SqlClauseFactory;
import org.blade.personal.framework.orm.EntityAlies;
import org.blade.personal.framework.orm.TypeAlies;

/**
 * 抽象子句类
 * @author ZGF
 *
 * @param 
 */
public class AbstractSql implements Sql {

	public Clause clause;
	
	private SqlClauseFactory  factory = new MySQLSqlClauseFactory();
	
	@Override
	public Sql select(TypeAlies... alies) {
		StringBuilder clause = new StringBuilder();
		clause.append(DdlKeyWord.SELECT);
		for(int i = 0 ; i < alies.length ; i++){
			clause.append(DdlKeyWord.SPACE).append(alies[i].getClause());
			if( i+1 < alies.length){
				clause.append(",");
			}
		}
		
		this.clause = factory.build(clause);
		return this;
	}

	@Override
	public Sql from(EntityAlies entity) {

		StringBuilder clause = new StringBuilder();
		clause.append(DdlKeyWord.FROM).append(DdlKeyWord.SPACE)
		.append(DdlKeyWord.SPACE).append(entity.getTable())
		.append(DdlKeyWord.SPACE).append(entity.getAlise());
		this.clause.setClause(factory.build(clause));
		
		return this;
	}
	@Override
	public Sql where(TypeAlies... alies) {
		StringBuilder clause = new StringBuilder();
		clause.append(DdlKeyWord.WHERE).append(DdlKeyWord.SPACE)
		.append(DdlKeyWord.WHERE_ONE_EQ_ONE);
		for(int i = 0 ; i < alies.length ; i++){
			clause.append(DdlKeyWord.SPACE)
			.append(DdlKeyWord.AND)
			.append(alies[i].getClause());
		}
		this.clause.setClause(factory.build(clause));
		return this;
	}

	@Override
	public Sql and(Sql clause) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sql from(Sql clause) {
		// TODO Auto-generated method stub
		return null;
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
	public Sql union(Sql clause) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sql unionAll(Sql clause) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String get() {
		return this.clause.build();
	}

}
