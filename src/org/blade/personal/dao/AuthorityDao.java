package org.blade.personal.dao;

import java.util.List;
import java.util.Map;

import org.blade.personal.mode.Authority;
import org.blade.personal.utils.Pager;
import org.springframework.jdbc.core.RowMapper;

/**
 * Authority Dao
 * 
 * @author zgf
 * 
 */
public interface AuthorityDao {


	/**
	 * Add authority 
	 * @param authority 权限实体
	 * @return the Number of affected 
	 */
	int addAuthority(Authority authority);

	/**
	 * Delete authority 
	 * @param ids ids
	 * @return Number of effected
	 */
	int deleteAuthority(String ids);

	/**
	 * Update authority 
	 * @param authority Authority entity
	 * @return the Number of affected 
	 */
	int updateAuthority(Authority authority);

	/**
	 * Query authority 
	 * 
	 * @return 
	 */
	Authority queryAuthority(String querySql, Object[] params);
	
	/**
	 * Batch update
	 * @param authorities
	 * @return
	 */
	int batchUpdate(List<Authority> authorities);
	
	/**
	 * Batch save
	 * @param authorities
	 * @return
	 */
	int batchSave(List<Authority> authorities);
	
	
	/**
	 * delete 
	 * @param deleteSql
	 * @param params
	 * @return
	 */
	int deleteAuthority(String deleteSql, Object[] params);
	
    /**
     * Query for list
     * @param querySql query SQL clause
     * @param params params
     * @param rowMapper
     * @return
     */
    public List<Authority> queryForList(String querySql, Object[] params, RowMapper<Authority> rowMapper);
    
    /**
     * Query for list
     * @param querySql query SQL clause
     * @param params params
     * @return
     */
    public List<Map<String,Object>> queryForList(String querySql, Object[] params);
    
    
	/**
	 * Paging query
	 * @param page pager
	 * @param querySql query SQL clause
	 * @param params 
	 * @param rowMapper 
	 */
	public void pagingQuery(Pager<Authority> page,String querySql,Object[] params);


}
