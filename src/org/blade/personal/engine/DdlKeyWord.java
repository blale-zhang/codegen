package org.blade.personal.engine;

public interface DdlKeyWord{
	
	//查询语句关键词
	public final String SELECT = " select ";
	public final String FROM = " from ";
	public final String TABLE = " table ";
	public final String WHERE = " where ";
	public final String AND = " and ";
	public final String OR = " or ";
	public final String IN = " in ";
	public final String LIKE = " like ";
	
	public final String NOT_IN = " not in ";
	public final String NOT_LIKE = " not like ";
	public final String BETWEEN = " between ";
	public final String EXISTS = " exists ";
	public final String AS = " as ";
	public final String SPACE = " ";
	public final String ALL = " * ";
	public final String EQ = " = ";
	public final String NOT_EQ = " <> ";
	public final String GT = " > ";
	public final String LT = " < ";
	public final String DOT = ".";
	public final String WHERE_ONE_EQ_ONE = " 1=1 ";


	public final String JOIN = " join ";
	public final String LEFT_JOIN = " left join ";
	public final String RIGHT_JOIN = " right join ";
	public final String OUTER_JOIN = " outer join ";
	public final String ON = " on ";
	public final String GROUP_BY = " group by ";
	public final String ORDER_BY = " order by ";
	public final String DESC = " desc ";
	public final String ASC = " asc ";
	public final String HAVING = " having";
	public final String COUNT = " count";
	public final String SUM = " sum";
	public final String MAX = " max";
	public final String MIN = " min";
	public final String SELECT_CLAUSE = " {SELECT_CLAUSE} ";
	public final String FROM_CALUSE = " {FROM_CLAUSE} ";
	public final String TABLE_CLAUSE = " {TABLE_NAME} ";
	public final String WHERE_CLAUSE = " {WHERE_CLAUSE} ";
	public final String AND_CLAUSE = " {AND_CLAUSE} ";

	public final String OR_CLAUSE = " {OR_CLAUSE} ";
	public final String IN_CLAUSE = " {IN_CLAUSE} ";
	public final String LIKE_CLAUSE = " {LIKE_CLAUSE} ";
	public final String NOT_IN_CLAUSE = " {NOT_IN_CLAUSE} ";
	public final String NOT_LIKE_CLAUSE = " {NOT_LIKE_CLAUSE} ";
	public final String BETWEEN_CLAUSE = " {BETWEEN} ";
	public final String BETWEEN_AND = " {AND} ";
	public final String BETWEEN_AND_CLAUSE = " {BETWEEN_AND_CLAUSE} ";
	public final String EXISTS_CLAUSE = " {EXISTS_CLAUSE} ";
	public final String JOIN_CLAUSE = " {JOIN_CLAUSE} ";
	public final String LEFT_JOIN_CLAUSE = " {LEFT_JOIN_CLAUSE} ";
	public final String JOIN_CONDITION = " {JOIN_CONDITION} ";
	public final String ON_CLAUSE = " {ON} ";
	public final String ON_CONDITION = " {ON_CONDITION} ";
	public final String RIGHT_JOIN_CLAUSE = " {RIGHT_JOIN_CLAUSE} ";
	public final String OUTER_JOIN_CLAUSE = " {OUTER_JOIN_CLAUSE} ";
	public final String GROUP_BY_CLAUSE = " {GROUP_BY_CLAUSE} ";
	public final String ORDER_BY_CLAUSE = " {ORDER_BY_CLAUSE} ";
	public final String DESC_CLAUSE = " {DESC_CLAUSE} ";
	public final String ASC_CLAUSE = " {ASC_CLAUSE} ";
	public final String HAVING_CLAUSE = " {HAVING_CLAUSE} ";
	public final String COUNT_CLAUSE = " {COUNT_CLAUSE} ";
	public final String SUM_CLAUSE = " {SUM_CLAUSE} ";
	public final String MAX_CLAUSE = " {MAX_CLAUSE} ";
	public final String MIN_CLAUSE = " {MIN_CLAUSE} ";
	
	/**
	 * final,those keywrods will be replaced by ""
	 */
	public String[] keyWrods = { WHERE_CLAUSE, AND_CLAUSE, OR_CLAUSE,
			IN_CLAUSE, LIKE_CLAUSE, NOT_IN_CLAUSE, NOT_LIKE_CLAUSE,
			BETWEEN_AND_CLAUSE, EXISTS_CLAUSE, JOIN_CLAUSE,
			LEFT_JOIN_CLAUSE, JOIN_CONDITION, ON_CLAUSE, ON_CONDITION,
			RIGHT_JOIN_CLAUSE, OUTER_JOIN_CLAUSE, GROUP_BY_CLAUSE,
			ORDER_BY_CLAUSE, DESC_CLAUSE, ASC_CLAUSE, HAVING_CLAUSE,
			COUNT_CLAUSE, SUM_CLAUSE, MAX_CLAUSE, MIN_CLAUSE };
	
	//insert key words
	public final String INSERT = " insert into ";
	public final String VALUES = " values ";
	/**
	 * insert 语句 valus子句
	 */
	public final String VALUES_CLAUSE = " {VALUES_CLAUSE} ";
	public final String COLUMNS_CLAUSE = " {COLUMNS_CLAUSE} ";
	
	//delete key words
	public final String DELETE = " delete ";
	
	//update key words
	public final String UPDATE = " update ";
	public final String SET = " set ";
	public final String SET_CLAUSE = " {SET_CLAUSE} ";


}
