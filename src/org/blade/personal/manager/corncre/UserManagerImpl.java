package org.blade.personal.manager.corncre;

import java.util.Map;

import org.blade.personal.dao.UserDao;
import org.blade.personal.manager.UserManager;
import org.blade.personal.mode.User;
import org.blade.personal.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userManager")
@Transactional("transactionManager")
public class UserManagerImpl implements UserManager {

	@Autowired
	private UserDao userDao;

	@Override
	public int saveUser(User u) {
		
		if(null != u.getId()){
			return this.updateUser(u);
		}
		
		return userDao.add(u);
	}

	@Override
	public int updateUser(User u) {
		
		return userDao.update(u);
	}

	@Override
	public int deleteUser(User u) {
		return userDao.delete(u.getId());
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public void pagingQuery(Pager<User> page, Map<String,Object> param) {
		this.userDao.pagingQuery(page,param);
	}
	
	
	@Override
	public User getUserByNameAndPassword(String name, String password) {
		
		String querySql = " select * from sys_usr where name = '" + name + "' and password ='" + password+"'";
		User user = userDao.queryOne(querySql);
		return user;
	}
	
	@Override
	public int getUserCountByName(String name) {
		String querySql = " select 1 from sys_usr where name = '" + name +"'";
		return userDao.getCount(querySql);
	}
	

}
