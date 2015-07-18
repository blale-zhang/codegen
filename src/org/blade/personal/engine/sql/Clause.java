package org.blade.personal.engine.sql;



/**
 * 
 * 子句类，把SQL分成不同的子句。
 * select * from Table where 1=1 <br/>
 * 把上句分成:<br/>
 * 1.select <br/>
 * 2.from <br/>
 * 3.where<br/>
 * 
 * @author ZGF
 *
 */
public interface Clause {

	/**
	 * 建造语句
	 * @param clause
	 * @return
	 */
	public Clause build(StringBuilder clause);
	
	/**
	 * 设置下一个子句部份
	 * @param clause
	 */
	public void setClause(Clause clause);
}
