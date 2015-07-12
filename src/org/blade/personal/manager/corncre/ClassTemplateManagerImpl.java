package org.blade.personal.manager.corncre;

import java.util.Map;

import org.blade.personal.dao.ClassTemplateContentDao;
import org.blade.personal.dao.ClassTemplateDefinedDao;
import org.blade.personal.manager.ClassTemplateManager;
import org.blade.personal.mode.ClassTemplateContent;
import org.blade.personal.mode.ClassTemplateDefined;
import org.blade.personal.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional("transactionManager")
@Service("ClassTemplateManager")
public class ClassTemplateManagerImpl implements ClassTemplateManager {

	@Autowired
	private ClassTemplateDefinedDao classTemplateDao;
	
	@Autowired
	private ClassTemplateContentDao classTemplateContentDao;
	
	@Override
	public int saveClassTemplateDefined(ClassTemplateDefined ctd) {
		return classTemplateDao.add(ctd);
	}

	@Override
	public int saveClassTemplateContent(ClassTemplateContent ctt) {
		return classTemplateContentDao.add(ctt);
	}

	@Override
	public int removeClassTemplateDefined(ClassTemplateDefined ctd) {
		return classTemplateDao.delete(ctd.getId());
	}

	@Override
	public void modifyClassTemplateDefined(ClassTemplateDefined ctd) {
		classTemplateDao.update(ctd);
	}

	@Override
	public void modifyClassTemplateContent(ClassTemplateContent ctt) {
		classTemplateContentDao.modify(ctt);
	}

	@Override
	public void queryForPage(Pager<ClassTemplateDefined> page,
			Map params) {
		 classTemplateDao.pagingQuery(page, params);
	}

	@Override
	public ClassTemplateContent queryClassTemplateContent(ClassTemplateContent classTemplateContent) {
		return classTemplateContentDao.query(classTemplateContent);
	}

}
