package org.blade.personal.manager;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.blade.personal.mode.Authority;
import org.blade.personal.mode.User;
import org.blade.personal.utils.Pager;

/**
 * Authority manager 
 * @author Thinkpad
 *
 */
public interface AuthorityManager {

	public  static final Logger log = Logger.getLogger(AuthorityManager.class.getName());
	/**
	 * Save authority 
	 * @param authority 
	 * @return the number of affected
	 */
	int saveAuthority(Authority authority);
	
	/**
	 * Delete authority 
	 * @param authIds
	 * @return the number of affected
	 */
	int deleteAuthority(String authIds);
	
	/**
	 * Delete authority by user id
	 * @param roleId The Id of User
	 * @param authIds Authorities'id
	 * @return the number of affected
	 */
	int deleteAuthorityByUser(Long usrId,String authIds);
	
	/**
	 * Delete authority by role id
	 * @param roleId The Id of Role
	 * @param authIds The Id of authorities
	 * @return the number of affected
	 */
	int deleteAuthorityByRole(Long roleId,String authIds);
	
	/**
	 * Update authority
	 * @param authority The information of authority
	 * @return the number of affected
	 */
	int updateAuthority(Authority authority);
	
	/**
	 * Batch update
	 * @param authorities The information of authorities
	 * @return the number of affected
	 */
	int batchUpdate(List<Authority> authorities);
	
	/**
	 * Batch save
	 * @param authorities The information of authorities
	 * @return the number of affected
	 */
	int batchSave(List<Authority> authorities);
	
	/**
	 * Query all the authorities of current user
	 * @param userId The id of current user
	 * @return List of authority
	 */
	List<Map<String,Object>> queryAllTheAuthorities(Long userId);
	
	/**
	 * Query all the authorities for assigning user
	 * @param page Pager object
	 * @param usrId The id of current user
	 * @return List of authority
	 */
	public void pagingQueryAuthoritiesForUsr(Pager<Authority> page, Long usrId) ;
	
	
	/**
	 * Query all the authorities for assigning user
	 * @param page Pager object
	 * @param roleId The id of assigning role
	 * @return List of authority
	 */
	public void pagingQueryAuthoritiesForRole(Pager<Authority> page, Long roleId) ;
	
	/**
	 * Query navigation data
	 * @param parentId The parent's id of navigation datas to be queried;  
	 * @param authId The authority id  of assigning user
	 * @param type The type of URL
	 * @param user The user
	 * @return
	 */
	public List queryNavigation(long parentId, long authId,long type, User user);
	
}
