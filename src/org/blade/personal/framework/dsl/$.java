package org.blade.personal.framework.dsl;

import org.blade.personal.engine.DdlKeyWord;
import org.blade.personal.framework.orm.TypeAlies;

/**
 * $类
 * @author Thinkpad
 *
 */
public class $ {
	
	public static String orderBy(TypeAlies attr){
		String orderBy = DdlKeyWord.ORDER_BY + attr.getName() + DdlKeyWord.DESC;
	    return orderBy;
	}

}
