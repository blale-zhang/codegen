/**
 * 
 */
package org.blade.personal.manager;

import java.util.logging.Logger;

import org.blade.personal.mode.SqlDefined;

/**
 * @author ZGF
 *
 */
public interface SqlManager {
	public  static final Logger log = Logger.getLogger(SqlManager.class.getName());

	int saveSqlDefined(SqlDefined sqlDefined );
	
	void deleteSqlDefineds(String ids);
	
}
