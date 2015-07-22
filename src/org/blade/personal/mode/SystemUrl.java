package org.blade.personal.mode;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * 系统URL实体类
 * 
 * @author zgf
 *
 */
@Entity
@Table(name="sys_url")
public class SystemUrl {
	
	/**
	 * 连接
	 */
	@Column(name="url")
	private String url;
	/**
	 * 连接对应的名字
	 */
	@Column(name="name")
	private String name;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="uuid")
	private String uuid;

	/**
	 * url对应界面的类型
	 */
	@Column(name="type")
	private int type;
	
	@Column(name="parent_id")
	private Long parentId = 0L;//默认值
	
	@Column(name="icon")
	private String icon;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
}
