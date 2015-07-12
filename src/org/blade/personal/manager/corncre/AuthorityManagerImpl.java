package org.blade.personal.manager.corncre;

import java.util.List;
import java.util.Map;

import org.blade.personal.dao.AuthorityDao;
import org.blade.personal.manager.AuthorityManager;
import org.blade.personal.mode.Authority;
import org.blade.personal.mode.User;
import org.blade.personal.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional("transactionManager")
@Service("AuthorityManager")
public class AuthorityManagerImpl implements AuthorityManager {

	@Autowired
	private AuthorityDao authorityDao;
	
	@Override
	public int saveAuthority(Authority authority) {
		
		int affect = 0;
		if( null == authority ){
			return affect;
		}
		
		if( null == authority.getId() ){
			affect = authorityDao.addAuthority(authority);
		}else {
			affect = authorityDao.updateAuthority(authority);
		}
		
		return affect;
	}

	@Override
	public int deleteAuthority(String authIds) {
		
		String deleteSql = "delete from sys_authority where id in (?)";
		return authorityDao.deleteAuthority(deleteSql, new Object[]{authIds});
	}

	@Override
	public int deleteAuthorityByUser(Long usrId, String authIds) {
		
		String deleteSql = "delete from sys_authority where id in (?) and user_id = ?";
		return authorityDao.deleteAuthority(deleteSql, new Object[]{authIds,usrId});
	}

	@Override
	public int deleteAuthorityByRole(Long roleId, String authIds) {
		String deleteSql = "delete from sys_authority where id in (?) and role_id = ?";
		return authorityDao.deleteAuthority(deleteSql, new Object[]{authIds,roleId});
	}

	@Override
	public int updateAuthority(Authority authority) {
		return authorityDao.updateAuthority(authority);
	}

	@Override
	public int batchSave(List<Authority> authorities) {
		if(authorities.size() == 0 ){
			return authorities.size();
		}
		return authorityDao.batchSave(authorities);
	}

	@Override
	public int batchUpdate(List<Authority> authorities) {
		if(authorities.size() == 0 ){
			return authorities.size();
		}
		return authorityDao.batchUpdate(authorities);
	}
	
	@Override
	public List<Map<String,Object>> queryAllTheAuthorities(Long userId) {
		StringBuilder querySqlBuff = new StringBuilder();
		
		querySqlBuff.append(" select * from sys_authority a join sys_url u on a.url_id = u.id where a.usr_id = ? ")
		.append(" union  all ")
		.append("select * from sys_authority a join sys_url u on a.url_id = u.id where a.role_id in ( ")
		.append( "select r.id from sys_usr  u left join sys_role r on u.role_id = r.id where u.id = ? )");
		return authorityDao.queryForList(querySqlBuff.toString(),
				new Object[]{userId,userId});
	}
	
	@Override
	public void pagingQueryAuthoritiesForUsr(Pager<Authority> page,Long usrId) {

		String querySql = " select * from sys_authority where usr_id = ? ";
		authorityDao.pagingQuery(page, querySql, new Object[]{usrId});
	}
	
	@Override
	public void pagingQueryAuthoritiesForRole(Pager<Authority> page, Long roleId) {
		
		String querySql = " select * from  sys_authority where role_id = ? ";
		authorityDao.pagingQuery(page, querySql, new Object[]{roleId});

	}
	
	
	@Override
	public List<Map<String,Object>> queryNavigation(long parentId,long authId,long type, User usr) {

		String countSubNode = " select count(1) as \"sonNodeNum\", su.parent_id as \"pId\"  from sys_url su left join sys_url pu on su.parent_id = pu.id  where su.parent_id is not null and su.type = 2 group by su.parent_id ";
		//		 
		StringBuilder querySqlBuff = new StringBuilder();
		querySqlBuff.append(" select u.name, u.url, a.weight_value, u.id, su.sonNodeNum from sys_authority a join sys_url u on a.url_id = u.id  ");
		querySqlBuff.append(" left join   (").append(countSubNode).append(") su on su.pId = u.id ");
		querySqlBuff.append(" where a.usr_id = ? and u.parent_id = ? and a.weight_value >= 8 and u.type = ? ");
		
		querySqlBuff.append(" union  all ");
		querySqlBuff.append(" select u.name, u.url, a.weight_value, u.id, su.sonNodeNum  from sys_authority a join sys_url u on a.url_id = u.id ");
		querySqlBuff.append(" left join   (").append(countSubNode).append(") su on su.pId = u.id ");
		querySqlBuff.append(" where a.role_id = ?  and u.parent_id = ? and a.weight_value >= 8  and u.type = ? ");
		
		return authorityDao.queryForList(querySqlBuff.toString(), new Object[]{usr.getId(),parentId,type,usr.getRoleId(),parentId,type});
	}
}
