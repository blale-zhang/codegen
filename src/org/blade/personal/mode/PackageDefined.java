package org.blade.personal.mode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 包定义
 * 
 * @author Thinkpad
 *
 */
@Table(name = "t_package_defined")
@Entity
public class PackageDefined {

	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long id;

	/**
	 * 整个包名
	 */
	@Column(name="name")
	public String name;

	/**
	 * 父包Id
	 */
	@Column(name="parent_id")
	public long parentId;
	
	@Column(name="owner_id")
	public long ownerId;
	
}
