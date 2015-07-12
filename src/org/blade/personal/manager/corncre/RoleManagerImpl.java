package org.blade.personal.manager.corncre;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.blade.personal.dao.RoleDao;
import org.blade.personal.manager.RoleManager;
import org.blade.personal.mode.Role;
import org.blade.personal.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author zgf
 *
 */
@Transactional("transactionManager")
@Service("RoleManager")
public class RoleManagerImpl implements RoleManager{

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public int save(Role role) {
		return roleDao.add(role);
	}


	@Override
	public int modify(Role role) {
		
		return roleDao.update(role);
	}
	
	@Override
	public List<Role> fetchRoles() {

		return roleDao.fetchAllRoles();
	}
	
	@Override
	public void pagingQuery(Pager<Role> page, Map param) {
		
		roleDao.pagingQuery(page,param);
	}


	@Override
	public int removeByIds(String ids) {
		return roleDao.deleteByIds(ids);
	}

}
