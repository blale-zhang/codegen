package org.blade.personal.mode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 代码模板内容
 * 
 * @author Thinkpad
 *
 */
@Entity
@Table(name = "t_class_temlate_content")
public class ClassTemplateContent {

	@Column(name = "content_name")
	private String name;

	@Column(name = "content_code")
	private String code;

	@Column(name = "content")
	private String content;

	@Column(name = "template_id")
	private Long templateId;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;

	@Column(name = "owner_id")
	public Long ownerId;

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
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
