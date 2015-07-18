package org.blade.personal.utils;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * 用过滤器验证登陆,看session是否有效
 */
public class SessionFilter implements Filter {
	private static final Logger log = Logger.getLogger(SessionFilter.class.getName());
	FilterConfig fc;

	public void destroy() {
		// 消毁方法
	}


	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hreq = (HttpServletRequest) request;
		String ctx = hreq.getContextPath();
		String urlwrong = ctx + "/login/toAjaxLogin.do";
		
		HttpServletResponse hres = (HttpServletResponse) response;
		HttpSession session = hreq.getSession();
		if (session != null && session.getAttribute("userInfo") != null) {
			log.info("session is exist");
			chain.doFilter(request, response);
		} else {
			String pass = "toAjaxLogin.do";
			if(!hreq.getRequestURL().toString().endsWith("login.jsp") || !hreq.getRequestURL().toString().endsWith(pass) ){
				boolean allow = false;
				allow = hreq.getRequestURL().toString().endsWith("login.jsp") || !hreq.getRequestURL().toString().endsWith(pass) ;
				if(!allow){
					log.info("session not exist");
					hres.sendRedirect(urlwrong);//重定向到该url
					return;
				}
			}
			chain.doFilter(request, response);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig) 初使化过滤器
	 */
	public void init(FilterConfig fc) throws ServletException {
		this.fc = fc;
	}

}

