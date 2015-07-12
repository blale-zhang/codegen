package org.blade.personal.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/packageDefined/*")
public class PackageDefinedController {

	
	@RequestMapping("toPackageDefined")
	public ModelAndView showRoleAuthority(){
		ModelAndView to = new ModelAndView("role-authority");
		to.addObject("title", "包管理");
		return to;
	}
	
	/**
	 * 抓取权限
	 * @param reqParam
	 * @return
	 */
	@ResponseBody
	@RequestMapping("fetch")
	public List fetch(@RequestParam Map reqParam){
		Long id = MapUtils.getLong(reqParam, "id");
		int usrOrRole = MapUtils.getIntValue(reqParam, "usrOrRole");
		
		Map e = new HashMap();
		List tree = new ArrayList();
		e.put("id", 1);e.put("name", "net");e.put("pId", 0);
		tree.add(e);
		e = new HashMap();
		e.put("id", 2);e.put("name", "oschina");e.put("pId", 1);
		tree.add(e); 
		e = new HashMap();
		e.put("id", 3);e.put("name", "blade");e.put("pId", 2);
		tree.add(e);
		return tree;
		
		
		//以对应的节点找到对应的文件
	}
	
	/**
	 * 添加包
	 * @param reqParam
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addPkg")
	public Map addPackage(@RequestParam Map data){
		
		System.out.println(data);
		
		return data;
	}
}
