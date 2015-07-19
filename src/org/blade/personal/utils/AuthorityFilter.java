package org.blade.personal.utils;

import java.io.IOException;
import java.util.Map;
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

public class AuthorityFilter implements Filter {
	
	private static final Logger log = Logger.getLogger(SessionFilter.class.getName());

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		 	HttpServletRequest hreq = (HttpServletRequest) request;  
	        String ctx = hreq.getContextPath();  
	        System.out.println("==ctx=="+ctx);  
	        String urlwrong = ctx + "/login/toAjaxLogin.do";
	          
	        HttpServletResponse hres = (HttpServletResponse) response;  
	        HttpSession session = hreq.getSession(); 

	        //首先要有登录,其次要有权限,权限过滤要进行请求区别，如果是ajax则提示无权限，或者直接跳到登录界面
			if (session != null && session.getAttribute(KeyWords.USER_INFO) != null) {
				log.info("session is exist");
				// 这里写权限过滤逻辑
		    	// authority filter logic
	        	Map<String,Map> authorities = (Map<String,Map>)session.getAttribute(KeyWords.USER_AUTH);
	        	String url = hreq.getRequestURL().toString();
	        	url = url.substring(url.indexOf(hreq.getContextPath())+ hreq.getContextPath().length(), url.length());
	            if(!authorities.containsKey(url)){
	                hres.sendRedirect(urlwrong);//重定向到该url  
	                return;
	            }
			}
			chain.doFilter(request, response);
	}  

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
