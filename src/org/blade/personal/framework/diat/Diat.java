package org.blade.personal.framework.diat;

public enum Diat {

	MYSQL(""), 
	SQL_SERVER(""), 
	ORACLE(""),
	DB2(""), 
	SYBASE("");
	private String driverName;

	private Diat(String driverName) {
		// TODO Auto-generated constructor stub
		this.driverName = driverName;
	}
}
