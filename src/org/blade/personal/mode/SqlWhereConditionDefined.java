package org.blade.personal.mode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_sql_where_condition_defined")
public class SqlWhereConditionDefined {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name = "owner_id")
	private Long ownerId;

	@Column(name = "column_name")
	private String columnName;
	
	@Column(name = "op_type")
	private Integer opType;
	
	@Column(name = "logic_op_type")
	private Integer logicOpType;
	
	@Column(name = "sql_id")
	private Long sqlId;

	@Column(name = "default_value")
	private String defaultValue;
	
	@Column(name = "param")
	private String param;

}
