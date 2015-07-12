package org.blade.personal.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * spring mvc utils
 * @author Thinkpad
 *
 */
public class SpringMvcUtils {

	/**
	 * 获取request
	 * @return
	 */
	public static HttpServletRequest getRequest(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}
	
	/**
	 * 获取HttpSession
	 * @return
	 */
	public static HttpSession getHttpSession(){
		
		return getRequest().getSession();
	}

}
