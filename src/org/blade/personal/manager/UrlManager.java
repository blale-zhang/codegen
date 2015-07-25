package org.blade.personal.manager;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.blade.personal.mode.SystemUrl;
import org.blade.personal.utils.Pager;

/**
 * system url manager
 * 
 * @author zgf
 *
 */

public interface UrlManager {
	public  static final Logger LOG = Logger.getLogger(UrlManager.class.getName());

	int addUrl(SystemUrl url);

	void updateUrl(SystemUrl url);

	/**
	 * Delete system URL
	 * @param url
	 * @return
	 */
	int deleteUrl(SystemUrl url);

	public void pagingQuery(Pager<SystemUrl> page, Map params);

	/**
	 * Query child of assigning id
	 * 
	 * @param parentId
	 *            The URL id
	 * @return
	 */
	List queryForChildren(Long parentId);

	/**
	 * Query all the URL
	 * 
	 * @return
	 */
	List queryForAll();
}
