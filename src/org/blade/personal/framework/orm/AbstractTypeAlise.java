package org.blade.personal.framework.orm;

import org.blade.personal.engine.DdlKeyWord;
import org.blade.personal.framework.orm.base.Attribute;

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
	protected java.lang.String clause;
	
	/**
	 * 表别名
	 */
	protected java.lang.String tableAlise;

	
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
	public String getClause() {
		if(null == this.clause){
			return this.tableAlise + DdlKeyWord.DOT +  this.attr.getName();
		}
		return this.clause;
	}
	
	
	protected TypeAlies<T> op(TypeAlies type, String keyWord) {
		StringBuilder buff = new StringBuilder();
		clause = buff.append(this.tableAlise).append(DdlKeyWord.DOT)
				.append(attr.getName())
				.append(DdlKeyWord.SPACE)
				.append(keyWord).append(type.getVal()).toString();
		return this;
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
		StringBuilder buff = new StringBuilder();
		clause = buff.append(this.tableAlise).append(DdlKeyWord.DOT)
				.append(attr.getName()).append(DdlKeyWord.SPACE)
				.append(DdlKeyWord.LIKE).append("'%").append(type.getVal())
				.append("%'").toString();
		return this;
	}

	@Override
	public TypeAlies<T> likeSw(TypeAlies type) {
		// TODO Auto-generated method stub
		StringBuilder buff = new StringBuilder();
		clause = buff.append(this.tableAlise).append(DdlKeyWord.DOT)
				.append(attr.getName()).append(DdlKeyWord.SPACE)
				.append(DdlKeyWord.LIKE).append("'%").append(type.getVal())
				.append("'").toString();
		return this;
	}

	@Override
	public TypeAlies<T> likeEw(TypeAlies type) {
		// TODO Auto-generated method stub
		StringBuilder buff = new StringBuilder();
		clause = buff.append(this.tableAlise).append(DdlKeyWord.DOT)
				.append(attr.getName()).append(DdlKeyWord.SPACE)
				.append(DdlKeyWord.LIKE).append("'").append(type.getVal())
				.append("%'").toString();
		return this;
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
	public TypeAlies<T> as(java.lang.String type) {
		
		StringBuilder buff = new StringBuilder();
		clause = buff.append(this.tableAlise).append(DdlKeyWord.DOT)
				.append(attr.getName()).append(DdlKeyWord.SPACE)
				.append(DdlKeyWord.AS).append(type).toString();
		return this;
	}
}
