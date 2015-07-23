package org.blade.personal.test;

import org.blade.personal.framework.dsl.Sql;
import org.blade.personal.framework.dsl.corcre.MySQLSql;
import org.blade.personal.framework.orm.TypeAlies;


public class Main {

	public static void main(String[] args) {
		
		MyEntity myEntity = new MyEntity("e");
		Sql sql =  new MySQLSql();
		sql.select(new TypeAlies[] {myEntity.age.as(" AGE "),myEntity.id,myEntity.name})
		.from(myEntity)
		.where(new TypeAlies[] {myEntity.age.eq(myEntity.id),myEntity.id.eq(myEntity.age)});
		System.out.println(sql.get());
		
	}
}
