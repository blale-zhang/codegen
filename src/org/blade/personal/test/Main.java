package org.blade.personal.test;

import org.blade.personal.framework.dsl.corcre.MySQLSql;

public class Main {

	public static void main(String[] args) {

		MyEntity e = new MyEntity("e");
		System.out.println((new MySQLSql("ee")
				.select(e.age)
				.from(
						new MySQLSql().select(e.age, e.name, e.id).from(e)
						.where( e.id.eq(8) )
				).where(e.age.eq(5)).and(e.name.likeEw("张国富"))).get());
		
		
		System.out.println(new MySQLSql("dd").select(e.age, e.name, e.id).from(e)
				.where( e.id.eq(8) ).get());

	}
}
