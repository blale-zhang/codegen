/**
 * 
 */
package org.blade.personal.dao.impl;

import java.util.List;

import org.blade.personal.dao.ClassTemplateContentDao;
import org.blade.personal.dao.base.BaseDao;
import org.blade.personal.mode.ClassTemplateContent;
import org.springframework.stereotype.Repository;

/**
 * @author Thinkpad
 *
 */
@Repository("ClassTemplateContentDao")
public class ClassTemplateContentDaoImpl extends BaseDao<ClassTemplateContent> implements ClassTemplateContentDao {

	/* (non-Javadoc)
	 * @see org.blade.personal.dao.ClassTemplateContentDao#add(java.util.List)
	 */
	@Override
	public int add(List<ClassTemplateContent> ClassTemplateContents) {
		
		this.save(ClassTemplateContents);
		return ClassTemplateContents.size();
	}

	/* (non-Javadoc)
	 * @see org.blade.personal.dao.ClassTemplateContentDao#add(org.blade.personal.mode.ClassTemplateContent)
	 */
	@Override
	public int add(ClassTemplateContent ClassTemplateContent) {
		// TODO Auto-generated method stub
		this.save(ClassTemplateContent);
		return ClassTemplateContent.id == null ? 0 : 1;
	}

	/* (non-Javadoc)
	 * @see org.blade.personal.dao.ClassTemplateContentDao#delete(java.lang.Long)
	 */
	@Override
	public int delete(Long ClassTemplateContentId) {
		// TODO Auto-generated method stub
		
		super.removeById(ClassTemplateContent.class, ClassTemplateContentId);
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.blade.personal.dao.ClassTemplateContentDao#delete(java.lang.String)
	 */
	@Override
	public int delete(String ClassTemplateContentIds) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see org.blade.personal.dao.ClassTemplateContentDao#modify(java.util.List)
	 */
	@Override
	public void modify(List<ClassTemplateContent> ClassTemplateContents) {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see org.blade.personal.dao.ClassTemplateContentDao#modify(org.blade.personal.mode.ClassTemplateContent)
	 */
	@Override
	public void modify(ClassTemplateContent ClassTemplateContent) {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see org.blade.personal.dao.ClassTemplateContentDao#query(org.blade.personal.mode.ClassTemplateContent)
	 */
	@Override
	public ClassTemplateContent query(ClassTemplateContent ClassTemplateContent) {
		// TODO Auto-generated method stub
		return null;
	}

}
