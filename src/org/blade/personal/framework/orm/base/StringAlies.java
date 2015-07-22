package org.blade.personal.framework.orm.base;

import org.blade.personal.engine.DdlKeyWord;
import org.blade.personal.framework.orm.AbstractTypeAlise;
import org.blade.personal.framework.orm.TypeAlies;

/**
 * String alise
 * 
 * @author ZGF
 *
 */
public class StringAlies extends AbstractTypeAlise<String> implements
		TypeAlies<java.lang.String> {


	@Override
	public TypeAlies<String> newInstance(String name, String value, String table) {
		this.attr = new Attribute<String>(name, value);
		this.tableAlise = table;
		return this;
	}
	
	@Override
	public TypeAlies<java.lang.String> eq(TypeAlies type) {
		return this.op(type, DdlKeyWord.EQ);
	}

	@Override
	public TypeAlies<java.lang.String> notEq(TypeAlies type) {
		return this.op(type, DdlKeyWord.NOT_EQ);
	}

	@Override
	public TypeAlies<java.lang.String> likeAll(TypeAlies type) {
		// TODO Auto-generated method stub
		StringBuilder buff = new StringBuilder();
		clause = buff.append(this.tableAlise).append(DdlKeyWord.DOT)
				.append(attr.getName()).append(DdlKeyWord.SPACE)
				.append(DdlKeyWord.LIKE).append("'%").append(type.getVal())
				.append("%'").toString();
		return this;
	}

	@Override
	public TypeAlies<java.lang.String> likeSw(TypeAlies type) {
		// TODO Auto-generated method stub
		StringBuilder buff = new StringBuilder();
		clause = buff.append(this.tableAlise).append(DdlKeyWord.DOT)
				.append(attr.getName()).append(DdlKeyWord.SPACE)
				.append(DdlKeyWord.LIKE).append("'%").append(type.getVal())
				.append("'").toString();
		return this;
	}

	@Override
	public TypeAlies<java.lang.String> likeEw(TypeAlies type) {
		// TODO Auto-generated method stub
		StringBuilder buff = new StringBuilder();
		clause = buff.append(this.tableAlise).append(DdlKeyWord.DOT)
				.append(attr.getName()).append(DdlKeyWord.SPACE)
				.append(DdlKeyWord.LIKE).append("'").append(type.getVal())
				.append("%'").toString();
		return this;
	}

	@Override
	public TypeAlies<java.lang.String> notLike(TypeAlies type) {
		return this.op(type, DdlKeyWord.NOT_LIKE);
	}

	@Override
	public TypeAlies<java.lang.String> lt(TypeAlies type) {
		return this.op(type, DdlKeyWord.LT);
	}

	@Override
	public TypeAlies<java.lang.String> gt(TypeAlies type) {
		return this.op(type, DdlKeyWord.GT);
	}

	@Override
	public TypeAlies<java.lang.String> as(java.lang.String type) {
		
		StringBuilder buff = new StringBuilder();
		clause = buff.append(this.tableAlise).append(DdlKeyWord.DOT)
				.append(attr.getName()).append(DdlKeyWord.SPACE)
				.append(DdlKeyWord.AS).append(type).toString();
		return this;
	}

	@Override
	public java.lang.String getClause() {
		return this.clause;
	}

	@Override
	public String getVal() {
		return this.attr.getValue();
	}

}
