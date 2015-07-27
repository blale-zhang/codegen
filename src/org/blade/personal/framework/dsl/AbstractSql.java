package org.blade.personal.framework.dsl;

import org.blade.personal.engine.DdlKeyWord;
import org.blade.personal.framework.dsl.corcre.MySQLSqlClauseFactory;
import org.blade.personal.framework.dsl.corcre.SqlClauseFactory;
import org.blade.personal.framework.orm.EntityAlies;
import org.blade.personal.framework.orm.TypeAlies;

/**
 * 抽象子句类
 * @author ZGF
 *
 * @param 
 */
public abstract class AbstractSql implements Sql {

	/**
	 * 子句
	 */
	protected Clause clause;
	
	/**
	 * 别名
	 */
	protected String alise;
	
	private SqlClauseFactory  factory = new MySQLSqlClauseFactory();
	
	/**
	 * 构造带别人的SQL，一般用于要子查询语句的时候
	 * @param alise
	 */
	public AbstractSql(String alise) {
		this.alise = alise;
	}
	
	public AbstractSql() {
		this.alise = "";
	}
	
	/**
	 * 为属性设置别
	 * @param alise
	 * @param attribute
	 * @return
	 */
	private TypeAlies appendAttributeAlise(String alise, TypeAlies attribute ){
		
		if(null == alise || "".equals(alise)){
			return attribute; 
		}
		return attribute.setAlise(alise);
	}
	
	
	@Override
	public Sql select(TypeAlies... alies) {
		StringBuilder clause = new StringBuilder();
		clause.append(DdlKeyWord.SELECT);
		for(int i = 0 ; i < alies.length ; i++){
			//TODO 需要改进
			clause.append(DdlKeyWord.SPACE).append(alies[i].clone().getClause());
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
	public Sql and(TypeAlies alies) {
		StringBuilder clause = new StringBuilder();
		clause.append(DdlKeyWord.AND).append(DdlKeyWord.SPACE)
		.append(alies.getClause());
		this.clause.setClause(factory.build(clause));
		return this;
	}

	@Override
	public Sql from(Sql sql) {
		this.alise = sql.getAlise();
		StringBuilder clause = new StringBuilder();
		clause.append(DdlKeyWord.FROM).append("(")
		.append(sql.get()).append(")").append(DdlKeyWord.SPACE)
		.append(sql.getAlise());
		this.clause.setClause(factory.build(clause));
		return this;
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
	public Sql union(Sql sql) {
		StringBuilder clause = new StringBuilder();
		clause.append(DdlKeyWord.UNION).append("(")
		.append(sql.get()).append(")")
		.append(this.alise);
		this.clause.setClause(factory.build(clause));
		return this;
	}

	@Override
	public Sql unionAll(Sql sql) {
		StringBuilder clause = new StringBuilder();
		clause.append(DdlKeyWord.UNION).append("(")
		.append(sql.get()).append(")")
		.append(this.alise);
		this.clause .setClause(factory.build(clause));
		return this;
	}
	
	@Override
	public String get() {
		return this.clause.build();
	}
	
	@Override
	public String getAlise() {
		// TODO Auto-generated method stub
		return this.alise;
	}

}
