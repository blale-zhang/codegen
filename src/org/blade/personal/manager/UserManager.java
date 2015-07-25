package org.blade.personal.manager;

import java.util.Map;
import java.util.logging.Logger;

import org.blade.personal.mode.User;
import org.blade.personal.utils.Pager;

/**
 * 用户管理者
 * @author zgf
 *
 */
public interface UserManager {
	public  static final Logger LOG = Logger.getLogger(UserManager.class.getName());

	/**
	 * save user
	 * @param u The instance of User
	 * @return The effected number;
	 */
	public int saveUser(User u);
	
	public int updateUser(User u);
	
	public int deleteUser(User u);
	
	public void pagingQuery(Pager<User> page,Map<String,Object> params);
	
	/**
	 * Get user information by name and password
	 * @param name 
	 * @param password
	 * @return
	 */
	public User getUserByNameAndPassword(String name, String password);
	
	/**
	 * Got the number of user by name 
	 * @param name 
	 * @return
	 */
	public int getUserCountByName(String name);
}
