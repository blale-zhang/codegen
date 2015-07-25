package org.blade.personal.manager;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.blade.personal.mode.Role;
import org.blade.personal.utils.Pager;

/**
 * <B>Role manager</B> class, who is managing  system roles;
 * @author zgf
 *
 */
public interface RoleManager {
	public  static final Logger LOG = Logger.getLogger(RoleManager.class.getName());

	/**
	 * Add a role with a  <B>system role</B> class instace.
	 * @param role  an instace of <B>System role</B>
	 * @return the number of effected.
	 */
	int save(Role role);
	
	/**
	 * 
	 * Remove role by ids
	 * @param ids
	 * @return
	 */
	int removeByIds(String ids);
	
	/**
	 * modify a role
	 * @param role
	 * @return
	 */
	int modify(Role role);
	
	
	/**
	 * Fetch roles
	 * @return
	 */
	List<Role> fetchRoles();
	
	/**
	 * Query entity by pager
	 * @param page
	 * @param param
	 */
	public void pagingQuery(Pager<Role> page, Map param);
}
