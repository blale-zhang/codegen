package org.blade.personal.dao;

import java.util.List;
import java.util.Map;

import org.blade.personal.mode.ClassTemplateDefined;
import org.blade.personal.utils.Pager;

/**
 * 代码定义存取对象
 * 
 * @author ZGF
 *
 */
public interface ClassTemplateDefinedDao {

	public int add(List<ClassTemplateDefined> classTemplateDefineds);
	
	public int add(ClassTemplateDefined classTemplateDefined);
	
	public int delete(Long classTemplateDefinedId);
	
	public int delete(String classTemplateDefinedIds);
	
	public void update(List<ClassTemplateDefined> classTemplateDefineds);

	public void update(ClassTemplateDefined classTemplateDefined);
	
	public void pagingQuery(Pager<ClassTemplateDefined> page, Map params);

	
}
