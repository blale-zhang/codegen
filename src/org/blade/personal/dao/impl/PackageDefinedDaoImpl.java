package org.blade.personal.dao.impl;

import java.util.List;

import org.blade.personal.dao.PackageDefinedDao;
import org.blade.personal.dao.base.BaseDao;
import org.blade.personal.mode.PackageDefined;
import org.springframework.stereotype.Repository;



@Repository("PackageDefinedDao")
public class PackageDefinedDaoImpl extends BaseDao<PackageDefined> implements PackageDefinedDao {

	@Override
	public int addPackageDefined(PackageDefined packageDefined) {
		// TODO Auto-generated method stub
		return super.saveEntity(packageDefined);
	}

	@Override
	public int deletePackageDefined(Long id) {
		// TODO Auto-generated method stub
		return super.delete(id.toString(), PackageDefined.class);
	}

	@Override
	public int updatePackageDefined(PackageDefined packageDefined) {
		// TODO Auto-generated method stub
		super.getSession().update(packageDefined);
		return 1;
	}

	@Override
	public PackageDefined queryPackageDefined(Long id) {
		// TODO Auto-generated method stub
		String sql = "select * from t_package_defined where id = ? ";
		return super.jdbcTemplate.queryForObject(sql, new Object[]{id}, PackageDefined.class);
	}

	@Override
	public List<PackageDefined> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int batchUpdate(List<PackageDefined> packageDefineds) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int batchSave(List<PackageDefined> packageDefineds) {
		// TODO Auto-generated method stub
		return 0;
	}

}
