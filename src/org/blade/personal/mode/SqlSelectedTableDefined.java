package org.blade.personal.mode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_sql_select_table_defined")
public class SqlSelectedTableDefined {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name = "owner_id")
	private Long ownerId;

	@Column(name = "table_name")
	private String tableName;

	@Column(name = "table_cn_name")
	private Long tableCnName;

	@Column(name = "alise")
	private String alise;

	@Column(name = "sql_id")
	private Long sqlId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	
	public Long getTableCnName() {
		return tableCnName;
	}

	public void setTableCnName(Long tableCnName) {
		this.tableCnName = tableCnName;
	}

	public String getAlise() {
		return alise;
	}

	public void setAlise(String alise) {
		this.alise = alise;
	}

	public Long getSqlId() {
		return sqlId;
	}

	public void setSqlId(Long sqlId) {
		this.sqlId = sqlId;
	}
	
	

}
