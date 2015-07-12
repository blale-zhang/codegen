package org.blade.personal.dao;

import java.util.List;
import java.util.Map;

import org.blade.personal.mode.SystemUrl;
import org.blade.personal.utils.Pager;
import org.springframework.jdbc.core.RowMapper;

public interface SystemUrlDao {

	/**
	 * Add a user
	 * @param u 
	 * @return
	 */
	public int add(SystemUrl u);
	
	/**
	 * Update  information of systemUrl
	 * @param u
	 * @return
	 */
	public void update(SystemUrl u);
	
	/**
	 * 
	 * @param deleteSql
	 * @return
	 */
	public int delete(String deleteSql);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public int delete(Long id);
	
	
	/**
	 * Query for children of current node
	 * @param parentId current node id
	 * @return
	 */
	public List<SystemUrl> queryForChildren(Long id);
	
	
	/**
	 * Query all the URL
	 * @return
	 */
	public List queryForAll();
	/**
	 * 
	 * @param querySql
	 * @return
	 */
	public List<SystemUrl> queryForList(String querySql);
	
	/**
	 * 
	 * @param querySql
	 * @return
	 */
	public SystemUrl queryOne(String querySql);
	
	/**
	 * 
	 * @param page
	 */
	public void pagingQuery(Pager<SystemUrl> page,Map params);
	
	/**
	 * 
	 * @param page
	 * @param querySql
	 * @param params
	 * @param rowMapper
	 */
	public void pagingQuery(Pager<SystemUrl> page,String querySql,Object[] params,RowMapper<SystemUrl> rowMapper);
}
