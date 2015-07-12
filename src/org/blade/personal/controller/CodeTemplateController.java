package org.blade.personal.controller;

import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.blade.personal.manager.ClassTemplateManager;
import org.blade.personal.mode.ClassTemplateContent;
import org.blade.personal.mode.ClassTemplateDefined;
import org.blade.personal.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/codeTemplate/*")
public class CodeTemplateController {

	@Autowired
	private ClassTemplateManager classTemplateManager;
	
	/**
	 * 保存为草稿
	 * @return
	 */
	@ResponseBody
	@RequestMapping("save")
	public int save(@RequestParam Map reqParam){
		
		String classTemplate  = MapUtils.getString(reqParam, "templateContent","{}");
		
		ClassTemplateDefined classTemplateDefined =  JSON.parseObject(classTemplate, ClassTemplateDefined.class);
		return classTemplateManager.saveClassTemplateDefined(classTemplateDefined);
	}
	
	
	@ResponseBody
	@RequestMapping("fetch")
	public Map query(@RequestParam Map reqParam){
		
		String classTemplate  = MapUtils.getString(reqParam, "classTemplate","{}");
		long pageNo  = MapUtils.getLong(reqParam, "pageNo",1L);
		long pageSize  = MapUtils.getLong(reqParam, "pageSize",20L);
		
//		ClassTemplateDefined classTemplateDefined = JSON.parseObject(classTemplate, ClassTemplateDefined.class);
		
		Map classTemplateDefined = JSON.parseObject(classTemplate, Map.class);
		Pager<ClassTemplateDefined> page = new Pager<ClassTemplateDefined>();
		page.setCurrentPage(pageNo);
		page.setPageSize(pageSize);
		classTemplateManager.queryForPage(page,classTemplateDefined);
		reqParam.put("total", page.getTotalCount());
		reqParam.put("datas", page.getEntities());
		return reqParam;

	}
	
	@ResponseBody
	@RequestMapping("saveContent")
	public int saveContent(@RequestParam Map reqParam){
		
		String classTemplate  = MapUtils.getString(reqParam, "templateContent","{}");
		ClassTemplateContent classTemplateContent = JSON.parseObject(classTemplate, ClassTemplateContent.class);

		return classTemplateManager.saveClassTemplateContent(classTemplateContent);
	}
	
	
	@ResponseBody
	@RequestMapping("getTemplateContent")
	public ClassTemplateContent getTemplateContent(@RequestParam Map reqParam){
		
		String templateContent  = MapUtils.getString(reqParam, "templateContent","{}");
		ClassTemplateContent classTemplateContent = JSON.parseObject(templateContent, ClassTemplateContent.class);

		return classTemplateManager.queryClassTemplateContent(classTemplateContent);
	}
	
	public static void main(String[] args) {
		
		ClassTemplateDefined classTemplateDefined = JSON.parseObject("{\"name\":\"ddd\",\"type\":\"1\"}", ClassTemplateDefined.class);
		
		System.out.println(JSON.toJSON(classTemplateDefined).toString());
	}
}
