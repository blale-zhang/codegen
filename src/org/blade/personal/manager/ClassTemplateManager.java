package org.blade.personal.manager;

import java.util.Map;

import org.blade.personal.mode.ClassTemplateContent;
import org.blade.personal.mode.ClassTemplateDefined;
import org.blade.personal.utils.Pager;

/**
 * 代码模型管理者
 * @author ZGF
 *
 */
public interface ClassTemplateManager {

	public int saveClassTemplateDefined(ClassTemplateDefined ctd);
	
	public int saveClassTemplateContent(ClassTemplateContent ctt);
	
	public int removeClassTemplateDefined(ClassTemplateDefined ctd);
	
	public void modifyClassTemplateDefined(ClassTemplateDefined ctd);
	
	public void modifyClassTemplateContent(ClassTemplateContent ctt);

	public void queryForPage(Pager<ClassTemplateDefined> page, Map params);
	
	public ClassTemplateContent queryClassTemplateContent(ClassTemplateContent classTemplateContent);
}
