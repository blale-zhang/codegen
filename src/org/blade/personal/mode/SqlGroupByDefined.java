/**
 * 
 */
package org.blade.personal.mode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Thinkpad
 *
 */
@Entity
@Table(name="t_sql_group_by_clause")
public class SqlGroupByDefined {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "owner_id")
	private Long ownerId;
	
	@Column(name = "sql_id")
	private Long sqlId;
	
	@Column(name = "clause")
	private String clause;

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

	public Long getSqlId() {
		return sqlId;
	}

	public void setSqlId(Long sqlId) {
		this.sqlId = sqlId;
	}

	public String getClause() {
		return clause;
	}

	public void setClause(String clause) {
		this.clause = clause;
	}
	
}
