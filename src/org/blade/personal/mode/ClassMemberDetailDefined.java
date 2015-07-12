package org.blade.personal.mode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_class_member_detail_defined")
public class ClassMemberDetailDefined {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "class_member_defined_id")
	private Long classMemberDefinedId;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "owner_id")
	private Long ownerId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClassMemberDefinedId() {
		return classMemberDefinedId;
	}

	public void setClassMemberDefinedId(Long classMemberDefinedId) {
		this.classMemberDefinedId = classMemberDefinedId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	
	
}
