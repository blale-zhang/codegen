package org.blade.personal.controller;

import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.blade.personal.manager.UserManager;
import org.blade.personal.mode.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

/**
 * regiest Controller
 * @author zgf
 *
 */
@Controller
@RequestMapping("/regiest")
public class RegiestController {

	@Autowired
	private UserManager userManager;

	private static final int USER_EXIST = 0;
	private static final int USER_NOT_EXIST = 1;
	private static final int SUCCESS = 1;
	private static final int FAIL = 1;
	
	/**
	 * 跳转到注册页
	 * @return
	 */
	@RequestMapping("regiesting")
	public ModelAndView toRegiesting(){
		ModelAndView to = new ModelAndView("user-regiest");
		to.addObject("title", "用户注册");
		return to;
	}
	
	/**
	 * 注册
	 * @param data 请求参数
	 */
	@RequestMapping("regiest")
	public int regiest(@RequestParam Map data){
		
		String userJson = MapUtils.getString(data, "userInfo");
		User user = JSON.parseObject(userJson, User.class);
		int count = userManager.getUserCountByName(user.getName());
		if(count > 0){
			return this.USER_EXIST;
		}
		return userManager.addUser(user);
	}
	
}
