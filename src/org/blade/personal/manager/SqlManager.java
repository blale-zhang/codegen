/**
 * 
 */
package org.blade.personal.manager;

import org.blade.personal.mode.SqlDefined;

/**
 * @author ZGF
 *
 */
public interface SqlManager {

	int saveSqlDefined(SqlDefined sqlDefined );
	
	void deleteSqlDefineds(String ids);
	
}
