package org.blade.personal.mode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity	
@Table(name = "t_model_properties_defined")
public class ModelPropertyDefined {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;
	
	@Column(name = "owner_id")
	public Long ownerId;
	
	@Column(name = "default_value")
	public String defaultValue;

	@Column(name = "property_name")
	public String propertyName;
	
	@Column(name = "data_type")
	public String dataType;
	
	@Column(name = "model_defined_id")
	public Long modelDefinedId;
	
	@Column(name = "property_comment")
	public String propertyComment;
	
	@Column(name = "visit_control")
	public Integer visitControll;

	@Column(name = "property_cn_name")
	public String propertyCnName;

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

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Long getModelDefinedId() {
		return modelDefinedId;
	}

	public void setModelDefinedId(Long modelDefinedId) {
		this.modelDefinedId = modelDefinedId;
	}

	public String getPropertyComent() {
		return propertyComment;
	}

	public void setPropertyComent(String propertyComent) {
		this.propertyComment = propertyComent;
	}

	public Integer getVisitControll() {
		return visitControll;
	}

	public void setVisitControll(Integer visitControll) {
		this.visitControll = visitControll;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public String getPropertyCnName() {
		return propertyCnName;
	}

	public void setPropertyCnName(String propertyCnName) {
		this.propertyCnName = propertyCnName;
	}
	
	
	
}
