package org.blade.personal.test;



import javax.persistence.Id;

import org.blade.personal.framework.components.JavaTypeEnum;
import org.blade.personal.framework.components.annotation.Column;
import org.blade.personal.framework.components.annotation.Entity;
import org.blade.personal.framework.components.annotation.Table;
import org.blade.personal.framework.entity.AbstractEntityAlies;
import org.blade.personal.framework.orm.base.IntegerAlies;
import org.blade.personal.framework.orm.base.StringAlies;

@Entity()
@Table(name="t_entity")
public class MyEntity extends AbstractEntityAlies<Blade>{

	@Id
	@Column(dataType = "int",javaType = JavaTypeEnum.INTEGER, name = "id")
	public IntegerAlies id;
	
	@Column(dataType = "varchar",javaType = JavaTypeEnum.STRING, name = "name")
	public StringAlies name;
	
	@Column(dataType = "int",javaType = JavaTypeEnum.INTEGER, name = "age")
	public IntegerAlies age;

	public MyEntity(String alies) {
		super(alies);
		this.alies = alies;
	}
	
	public MyEntity(){
		super();
	}
	
	public IntegerAlies getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id.setValue(id);;
	}

	public String getName() {
		return name.getVal();
	}

	public void setName(StringAlies name) {
		this.name = name;
	}

	public Integer getAge() {
		return age.getVal();
	}

	public void setAge(Integer age) {
		this.age.setValue(age);
	}
	
	
	
}
