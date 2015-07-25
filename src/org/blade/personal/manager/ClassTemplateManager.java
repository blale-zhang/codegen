package org.blade.personal.manager;

import java.util.Map;
import java.util.logging.Logger;

import org.blade.personal.mode.ClassTemplateContent;
import org.blade.personal.mode.ClassTemplateDefined;
import org.blade.personal.utils.Pager;

/**
 * 代码模型管理者
 * @author ZGF
 *
 */
public interface ClassTemplateManager {
	public  static final Logger LOG = Logger.getLogger(ClassTemplateManager.class.getName());

	/**
	 * 保存类模板
	 * @param ctd
	 * @return
	 */
	public int saveClassTemplateDefined(ClassTemplateDefined ctd);
	
	/**
	 * 保存类模板内容
	 * @param ctt
	 * @return
	 */
	public int saveClassTemplateContent(ClassTemplateContent ctt);
	
	/**
	 * 删除类模板定义
	 * @param ctd
	 * @return
	 */
	public int removeClassTemplateDefined(ClassTemplateDefined ctd);
	
	/**
	 * 修改类模板定义
	 * @param ctd
	 */
	public void modifyClassTemplateDefined(ClassTemplateDefined ctd);
	
	/**
	 * 修改类模板内容
	 * @param ctt
	 */
	public void modifyClassTemplateContent(ClassTemplateContent ctt);

	/**
	 * 分页查询类模板
	 * @param page
	 * @param params
	 */
	public void queryForPage(Pager<ClassTemplateDefined> page, Map params);
	
	/**
	 * 查询类模板内容
	 * @param classTemplateContent
	 * @return
	 */
	public ClassTemplateContent queryClassTemplateContent(ClassTemplateContent classTemplateContent);
}
