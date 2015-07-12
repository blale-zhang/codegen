package org.blade.personal.dao;

import java.util.List;
import java.util.Map;

import org.blade.personal.mode.Role;
import org.blade.personal.utils.Pager;

/**
 * 角色存取对象
 * @author zgf
 *
 */
public interface RoleDao {

	/**
	 * 添加一个角色
	 * @return
	 */
	int add(Role role);
	
	
	/**
	 * 更新
	 * @param role
	 * @return
	 */
	int update(Role role);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int delete(Long id);
	
	
	/**
	 * delete by ids
	 * @param ids
	 * @return
	 */
	int deleteByIds(String ids);
	
	
	/**
	 * 查询单个
	 * @return
	 */
	Role queryOne(Long id);
	
	List<Role> fetchAllRoles();
	
	/**
	 * 分页查询
	 * @param page 分页器
	 * @param param 查询条件参数
	 */
	void pagingQuery(Pager<Role> page, Map param);
	
}
