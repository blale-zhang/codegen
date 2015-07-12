package org.blade.personal.mode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * system role entity
 * 
 * @author zgf
 * 
 */
@Entity
@Table(name = "sys_role")
public class Role {

	@Id
	@Column( name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	@Column(name = "type")
	public int type;
	@Column( name = "name")
	public String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
