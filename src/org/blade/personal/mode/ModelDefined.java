package org.blade.personal.mode;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="t_model_defined")
public class ModelDefined {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	@Column(name = "id")
	public Long id;
	
	@Column(name = "owner_id")
	public Long ownerId;
	
	@Column(name = "name")
	public String name; 

	@Column(name = "chinese_name")
	public String chineseName; 
	
	@Transient
	private List<ModelPropertyDefined>  propreties;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}

	public List<ModelPropertyDefined> getPropreties() {
		return propreties;
	}

	public void setPropreties(List<ModelPropertyDefined> propreties) {
		this.propreties = propreties;
	}

}
