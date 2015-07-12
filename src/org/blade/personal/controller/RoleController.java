package org.blade.personal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.blade.personal.manager.RoleManager;
import org.blade.personal.mode.Role;
import org.blade.personal.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/role/*")
public class RoleController {

	@Autowired
	private RoleManager roleManager;

	/**
	 * 添加角色
	 * @return
	 */
	@RequestMapping("add")
	public ModelAndView addRoles(){
		ModelAndView to = new ModelAndView("add-role");
		to.addObject("title", "添加");
		return to;
	}
	
	@ResponseBody
	@RequestMapping("save")
	public int saveRoles(@RequestParam Map data){
		
		Role role = new Role();
		Long id = MapUtils.getLong(data, "id");
		String name = MapUtils.getString(data, "name");
		Integer type = MapUtils.getInteger(data, "type");
		role.setId(id);	
		role.setName(name);
		role.setType(type);	
		return roleManager.save(role);
	}
	
	/**
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("fetch")
	public Map fetchRoles(@RequestParam Map data){
		
		Pager<Role> page = new Pager<Role>();
		page.setCurrentPage(MapUtils.getLong(data, "page"));
		page.setPageSize(MapUtils.getLong(data, "pagesize"));
		Map param = MapUtils.getMap(data, "param",new HashMap());
		roleManager.pagingQuery(page,param);
		data.put("datas", page.getEntities());
		data.put("Total", page.getTotalCount());
		return data;
	}
	
	@ResponseBody
	@RequestMapping("delete")
	public int deleteRole(@RequestParam Map reqParam){
		String roleJson = MapUtils.getString(reqParam,"role");
		List<Role> roles = JSON.parseArray(roleJson, Role.class); 
		String ids = MapUtils.getString(reqParam, "ids", "-1");
		return roleManager.removeByIds(ids);
	}
}
