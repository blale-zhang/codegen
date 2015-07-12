package org.blade.personal.mode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_class_member_defined")
public class ClassMemberDefined {

	@Column(name="name")
	public String name;// VARCHAR(255),
	
	@Column(name="memberType")
	public int memberType;// INTEGER,
	
	@Column(name="visitControl")
	public int visitControl;// INTEGER,
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	@Column(name = "owner_id")
	public Long ownerId;

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
