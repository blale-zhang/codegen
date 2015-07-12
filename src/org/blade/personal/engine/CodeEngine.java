package org.blade.personal.engine;

import org.blade.personal.mode.ModelDefined;


/**
 * 代码引擎
 * @author Thinkpad
 *
 */
public interface CodeEngine {

	/**
	 * 生成
	 * @return
	 */
	public String generate(ModelDefined modeDefined);
}
