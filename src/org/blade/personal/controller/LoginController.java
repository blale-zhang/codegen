package org.blade.personal.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.MapUtils;
import org.blade.personal.manager.AuthorityManager;
import org.blade.personal.manager.UserManager;
import org.blade.personal.mode.User;
import org.blade.personal.utils.SpringMvcUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * login controller
 * @author zgf
 *
 */
@Controller
@RequestMapping("/login/*")
public class LoginController {
	
	/**
	 * 用户名与密码无效
	 */
	private static final int PASSWORD_OR_USRNAME_INVALID = 0;
	private static final int FAIL = 0;
	private static final int ERROR = 0;
	private static final int SUCCESS = 1;
	private static final int CODE_INALID = 2;


	@Autowired
	private UserManager userManager;
	
	@Autowired
	private AuthorityManager authorityManager;

	@RequestMapping("toLogin")
	public ModelAndView toLogin(){
		
		ModelAndView to = new ModelAndView("login");
		to.addObject("title", "用户登录");
		//TODO post code to client
		HttpSession session = SpringMvcUtils.getHttpSession();
		session.setAttribute("code", "1111");
		//产生验证码
		
		return to;
	}
	
	@RequestMapping("toAjaxLogin")
	public ModelAndView toAjaxLogin(){
		
		ModelAndView to = new ModelAndView("ajaxLogin");
		to.addObject("title", "用户登录");
		//TODO post code to client
		HttpSession session = SpringMvcUtils.getHttpSession();
		session.setAttribute("code", "1111");
		//产生验证码
		
		return to;
	}
	
	
	
	@RequestMapping("login")
	public ModelAndView logining(@RequestParam Map data){
		String usrName = MapUtils.getString(data, "userName");
		String password = MapUtils.getString(data, "password");
		String code = MapUtils.getString(data, "code");
		ModelAndView to = null;
		User user =userManager.getUserByNameAndPassword(usrName, password);
		if(null != user){
			HttpSession session = SpringMvcUtils.getHttpSession();
			session.setAttribute("userInfo", user);
			//TODO query the authorities of current user.
			session.setAttribute("userAuth", authorityManager.queryAllTheAuthorities(user.getId()));
			to = new ModelAndView("../main");
		}else{
			to = new ModelAndView("404");
		}
		return to;
	}
	
	/***
	 * ajax 请求方式的登录
	 * 
	 * @param data
	 */
	@ResponseBody
	@RequestMapping("ajaxLogin")
	public int ajaxLogin(@RequestParam Map data){
		
		String usrName = MapUtils.getString(data, "userName");
		String password = MapUtils.getString(data, "password");
		String code = MapUtils.getString(data, "code");
		HttpSession session = SpringMvcUtils.getHttpSession();
		if (code.equals(session.getAttribute("code"))){
			User user =userManager.getUserByNameAndPassword(usrName, password);
			if(null != user){
				session.setAttribute("userInfo", user);
				//TODO query the authorities of current user.
				session.setAttribute("userAuth", authorityManager.queryAllTheAuthorities(user.getId()));
				return SUCCESS;
			}else{
				return PASSWORD_OR_USRNAME_INVALID;
			}
		}
		return CODE_INALID;
		
	}
}
