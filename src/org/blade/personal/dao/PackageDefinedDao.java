package org.blade.personal.dao;

import java.util.List;

import org.blade.personal.mode.PackageDefined;

/**
 * 
 * 包定义存取对象
 * @author ZGF
 *
 */
public interface PackageDefinedDao {
	
	public int addPackageDefined(PackageDefined packageDefined);
	
	public int deletePackageDefined(Long id);
	
	public int updatePackageDefined(PackageDefined packageDefined);
	
	public PackageDefined queryPackageDefined(Long id);
	
	public List<PackageDefined> queryList();
	
	public int batchUpdate(List<PackageDefined> packageDefineds);
	
	public int batchSave(List<PackageDefined> packageDefineds);
	
	

}
