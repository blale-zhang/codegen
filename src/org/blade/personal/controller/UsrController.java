package org.blade.personal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.blade.personal.manager.UserManager;
import org.blade.personal.mode.User;
import org.blade.personal.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/usr/*")
public class UsrController {

	@Autowired
	private UserManager userManager;
	/**
	 * 添加角色
	 * @return
	 */
	@RequestMapping("show")
	public ModelAndView showList(){
		ModelAndView to = new ModelAndView("user-list");
		to.addObject("title", "清单");
		return to;
	}
	
	@ResponseBody
	@RequestMapping("save")
	public int saveRoles(@RequestParam Map data){
		String userJson = MapUtils.getString(data, "data");
		User user = JSON.parseObject(userJson, User.class);
		return userManager.saveUser(user);
	}
	
	/**
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("fetch")
	public Map fetchRoles(@RequestParam Map data){
		
		Pager<User> page = new Pager<User>();
		page.setCurrentPage(MapUtils.getLong(data, "page"));
		page.setPageSize(MapUtils.getLong(data, "pagesize"));
		Map param = MapUtils.getMap(data, "params", new HashMap());
		userManager.pagingQuery(page,param);
		data.put("datas", page.getEntities());
		data.put("Total", page.getTotalCount());
		return data;
	}
	
	@ResponseBody
	@RequestMapping("delete")
	public int deleteRole(@RequestParam Map reqParam){
		String userJson = MapUtils.getString(reqParam,"user");
		List<User> users = JSON.parseArray(userJson, User.class); 
		return userManager.deleteUser(users.get(0));
	}
}
