package org.blade.personal.dao;

import java.util.List;
import java.util.Map;

import org.blade.personal.mode.User;
import org.blade.personal.utils.Pager;
import org.springframework.jdbc.core.RowMapper;

/**
 * User domain access object
 * @author zgf
 *
 */
public interface UserDao {
	
	/**
	 * Add a user
	 * @param u 
	 * @return
	 */
	public int add(User u);
	
	/**
	 * Update  information of user
	 * @param u
	 * @return
	 */
	public int update(User u);
	
	
	/**
	 * 
	 * @param ids
	 * @return
	 */
	public int delete(String ids);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public int delete(Long id);
	
	/**
	 * 
	 * @param querySql
	 * @return
	 */
	public List<User> queryForList(String querySql);
	
	
	/**
	 * 
	 * @param querySql
	 * @return
	 */
	public User queryOne(String querySql);
	
	
	public User queryForOne(String querySql, Object[] params);
	
	/**
	 * 
	 * @param page
	 */
	public void pagingQuery(Pager<User> page, Map param);
	
	/**
	 * 
	 * @param page
	 * @param querySql
	 * @param params
	 * @param rowMapper
	 */
	public void pagingQuery(Pager<User> page,String querySql,Object[] params,RowMapper<User> rowMapper);
	
	/**
	 * Get counter of Querying
	 * @param countSql
	 */
	public int getCount(String countSql);
}
