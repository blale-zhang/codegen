package org.blade.personal.mode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 代码模板内容
 * @author Thinkpad
 *
 */
@Entity
@Table(name="t_class_template_defined")
public class ClassTemplateDefined {
	
	@Column(name = "type")
	private Integer type;
	
	@Column(name = "class_defined_id")
	private Long classDefinedId;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;

	@Column(name = "owner_id")
	public Long ownerId;
	
	@Column(name = "name")
	public String name;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Long getClassDefinedId() {
		return classDefinedId;
	}

	public void setClassDefinedId(Long classDefinedId) {
		this.classDefinedId = classDefinedId;
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(long ownerId) {
		this.ownerId = ownerId;
	}

	
	
}
