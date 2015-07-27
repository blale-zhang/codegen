package org.blade.personal.framework.orm;

import org.blade.personal.engine.DdlKeyWord;
import org.blade.personal.framework.components.JavaTypeEnum;
import org.blade.personal.framework.orm.base.Attribute;
import org.blade.personal.framework.orm.base.FloatAlies;

/**
 * 抽象类型别名
 * @author ZGF
 *
 * @param <T>
 */
public abstract class AbstractTypeAlise<T> implements TypeAlies<T>{

	/**
	 * 属性
	 */
	protected Attribute<T> attr;
	
	/**
	 * 子句
	 */
	protected String clause;
	
	/**
	 * 表别名
	 */
	protected String alise;
	
	/**
	 * SQL结果集别名
	 */
	protected String sqlAlise;
	
	protected JavaTypeEnum type;

	@Override
	public JavaTypeEnum getType() {
		return this.type;
	}
	
	@Override
	public T getVal() {
		return this.attr.getValue();
	}
	
	@Override
	public String getName() {
		return this.attr.getName();
	}
	
	@Override
	public void setValue(T value){
		this.attr.setValue(value);
	}
	
	@Override
	public TypeAlies<T> setAlise(String alise){
		this.alise = alise;
		return this;
	}
	
	@Override
	public String getClause() {
		if(null == this.clause){
			return this.alise + DdlKeyWord.DOT +  this.attr.getName();
		}
		return this.clause;
	}
	
	
	protected TypeAlies<T> op(TypeAlies type, String keyWord) {
		TypeAlies<T> typeClone = this.clone();
		StringBuilder buff = new StringBuilder();
		buff.append(this.alise).append(DdlKeyWord.DOT)
				.append(attr.getName())
				.append(DdlKeyWord.SPACE)
				.append(keyWord).append(type.getVal()).toString();
		typeClone.setClause(buff.toString());
		return typeClone;
	}
	
	protected TypeAlies<T> op(String val, String keyWord) {
		TypeAlies<T> typeClone = this.clone();
		StringBuilder buff = new StringBuilder();
		buff.append(this.alise).append(DdlKeyWord.DOT)
				.append(attr.getName())
				.append(DdlKeyWord.SPACE)
				.append(keyWord).append(val).toString();
		typeClone.setClause(buff.toString());
		return typeClone;
	}
	
	
	@Override
	public TypeAlies<T> eq(TypeAlies type) {
		return this.op(type, DdlKeyWord.EQ);
	}

	@Override
	public TypeAlies<T> notEq(TypeAlies type) {
		return this.op(type, DdlKeyWord.NOT_EQ);
	}

	@Override
	public TypeAlies<T> likeAll(TypeAlies type) {
		// TODO Auto-generated method stub
		TypeAlies<T> typeClone = this.clone();
		StringBuilder buff = new StringBuilder();
		 buff.append(this.alise).append(DdlKeyWord.DOT)
				.append(attr.getName()).append(DdlKeyWord.SPACE)
				.append(DdlKeyWord.LIKE).append("'%").append(type.getVal())
				.append("%'").toString();
		typeClone.setClause(buff.toString());
		return typeClone;
	}

	@Override
	public TypeAlies<T> likeSw(TypeAlies type) {

		TypeAlies<T> typeClone = this.clone();
		StringBuilder buff = new StringBuilder();
		buff.append(this.alise).append(DdlKeyWord.DOT)
				.append(attr.getName()).append(DdlKeyWord.SPACE)
				.append(DdlKeyWord.LIKE).append("'%").append(type.getVal())
				.append("'").toString();
		typeClone.setClause(buff.toString());
		return typeClone;
	}

	@Override
	public TypeAlies<T> likeEw(TypeAlies type) {
		TypeAlies<T> typeClone = this.clone();
		StringBuilder buff = new StringBuilder();
		buff.append(this.alise).append(DdlKeyWord.DOT)
				.append(attr.getName()).append(DdlKeyWord.SPACE)
				.append(DdlKeyWord.LIKE).append("'").append(type.getVal())
				.append("%'").toString();
		typeClone.setClause(buff.toString());
		return typeClone;
	}

	@Override
	public TypeAlies<T> notLike(TypeAlies type) {
		return this.op(type, DdlKeyWord.NOT_LIKE);
	}

	@Override
	public TypeAlies<T> lt(TypeAlies type) {
		return this.op(type, DdlKeyWord.LT);
	}

	@Override
	public TypeAlies<T> gt(TypeAlies type) {
		return this.op(type, DdlKeyWord.GT);
	}

	@Override
	public TypeAlies<T> as(String type) {
		return this.op(type,DdlKeyWord.AS); 
	}
	
	@Override
	public TypeAlies<T> gt(T val) {
		return this.op(val.toString(), DdlKeyWord.GT);
	}
	
	
	@Override
	public TypeAlies<T> eq(Object type) {
		
		TypeAlies<T> typeClone = this.clone();
		StringBuilder buff = new StringBuilder();
		buff.append(this.alise).append(DdlKeyWord.DOT)
				.append(attr.getName()).append(DdlKeyWord.SPACE)
				.append(DdlKeyWord.EQ).append(type.toString()).toString();
		typeClone.setClause(buff.toString());
		return typeClone;
	}
	
	@Override
	public TypeAlies<T> likeAll(String val) {
		TypeAlies<T> typeClone = this.clone();
		StringBuilder buff = new StringBuilder();
		buff.append(this.alise).append(DdlKeyWord.DOT)
				.append(attr.getName()).append(DdlKeyWord.SPACE)
				.append(DdlKeyWord.LIKE).append("'").append(DdlKeyWord.PRECENT_CODE)
				.append(val.toString()).append(DdlKeyWord.PRECENT_CODE)
				.append("'").toString();
		typeClone.setClause(buff.toString());
		return typeClone;
	}
	
	@Override
	public TypeAlies<T> likeEw(String val) {
		TypeAlies<T> typeClone = this.clone();
		
		StringBuilder buff = new StringBuilder();
		buff.append(this.alise).append(DdlKeyWord.DOT)
				.append(attr.getName()).append(DdlKeyWord.SPACE)
				.append(DdlKeyWord.LIKE).append("'").append(val.toString())
				.append(DdlKeyWord.PRECENT_CODE).append("'").toString();
		typeClone.setClause(buff.toString());
		return typeClone;
	}
	
	@Override
	public TypeAlies<T> likeSw(String type) {
		TypeAlies<T> typeClone = this.clone();
		StringBuilder buff = new StringBuilder();
		buff.append(this.alise).append(DdlKeyWord.DOT)
				.append(attr.getName()).append(DdlKeyWord.SPACE)
				.append(DdlKeyWord.LIKE).append("'").append(DdlKeyWord.PRECENT_CODE)
				.append(type.toString()).append("'").toString();
		typeClone.setClause(buff.toString());
		return typeClone;
	}
	
	@Override
	public TypeAlies<T> lt(T val) {
		return this.op(val.toString(), DdlKeyWord.LT);
	}
	
	@Override
	public TypeAlies<T> notLike(String type) {
		TypeAlies<T> typeClone = this.clone();
		StringBuilder buff = new StringBuilder();
		buff.append(this.alise).append(DdlKeyWord.DOT)
				.append(attr.getName()).append(DdlKeyWord.SPACE)
				.append(DdlKeyWord.NOT_LIKE).append("'")
				.append(type.toString()).append("'").toString();
		typeClone.setClause(buff.toString());
		return typeClone;
	}
	
	@Override
	public TypeAlies<T> gtoeq(T val) {
		return this.op(val.toString(), DdlKeyWord.GTOEQ);
	}
	
	@Override
	public TypeAlies<T> ltoeq(T val) {
		return this.op(val.toString(), DdlKeyWord.LTOEQ);
	}
	
	@Override
	public String getTable() {
		return this.attr.getTalbe();
	}
	
	@Override
	public TypeAlies<T> clone() {
		// TODO Auto-generated method stub
		Attribute<T> attr = this.attr.clone();
		return TypeAliseFactory.newInstance().create(attr, clause, alise, sqlAlise, type);
	}

	
	public void setClause(String clause){
		this.clause = clause;
	}
}
