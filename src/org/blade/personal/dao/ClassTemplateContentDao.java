package org.blade.personal.dao;

import java.util.List;

import org.blade.personal.mode.ClassTemplateContent;

/**
 * 
 * @author ZGF
 *
 */
public interface ClassTemplateContentDao {

	/**
	 * 批量添加
	 * @param ClassTemplateContents
	 * @return
	 */
	public int add(List<ClassTemplateContent> ClassTemplateContents);
	
	/**
	 * 添加一个
	 * @param ClassTemplateContent
	 * @return
	 */
	public int add(ClassTemplateContent ClassTemplateContent);
	
	/**
	 * 通过Id删除
	 * @param ClassTemplateContentId
	 * @return
	 */
	public int delete(Long ClassTemplateContentId);
	
	/**
	 * 通过多个Id删除
	 * @param ClassTemplateContentIds
	 * @return
	 */
	public int delete(String ClassTemplateContentIds);
	
	/**
	 * 批量修改
	 * @param ClassTemplateContents
	 * @return
	 */
	public void modify(List<ClassTemplateContent> ClassTemplateContents);

	/**
	 * 修改一个
	 * @param ClassTemplateContent
	 * @return
	 */
	public void modify(ClassTemplateContent ClassTemplateContent);
	
	/**
	 * 查询
	 * @param ClassTemplateContent
	 * @return
	 */
	public ClassTemplateContent query(ClassTemplateContent ClassTemplateContent);

}
