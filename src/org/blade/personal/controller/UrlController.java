package org.blade.personal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.blade.personal.manager.UrlManager;
import org.blade.personal.mode.SystemUrl;
import org.blade.personal.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/url/*")
public class UrlController {

	@Autowired
	private UrlManager urlManager;
	/**
	 * 添加角色
	 * @return
	 */
	@RequestMapping("show")
	public ModelAndView showList(){
		ModelAndView to = new ModelAndView("url-list");
		to.addObject("title", "清单");
		return to;
	}
	
	@ResponseBody
	@RequestMapping("save")
	public int saveUrl(@RequestParam Map data){
		String userJson = MapUtils.getString(data, "data");
		SystemUrl url = JSON.parseObject(userJson, SystemUrl.class);
		return urlManager.addUrl(url);
	}
	
	/**
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("fetch")
	public Map fetchUrls(@RequestParam Map data){
		
		Pager<SystemUrl> page = new Pager<SystemUrl>();
		page.setCurrentPage(MapUtils.getLong(data, "page"));
		page.setPageSize(MapUtils.getLong(data, "pagesize"));
		Map params = MapUtils.getMap(data, "params", new HashMap());
		urlManager.pagingQuery(page,params);
		data.put("datas", page.getEntities());
		data.put("Total", page.getTotalCount());
		return data;
	}
	
	@ResponseBody
	@RequestMapping("fetchTree")
	public Map fetchUrlTree(@RequestParam Map data){
		Long id = MapUtils.getLong(data, "id", null);
		Map datas= new HashMap();
		datas.put("datas", urlManager.queryForAll());
		return datas;
	}
	
	@ResponseBody
	@RequestMapping("queryForChileren")
	public List queryForChileren(@RequestParam Map data){
		Long id = MapUtils.getLong(data, "id", 0l);
		return urlManager.queryForChildren(id);
	}
	
	
	@ResponseBody
	@RequestMapping("delete")
	public int deleteUrl(@RequestParam Map reqParam){
		String userJson = MapUtils.getString(reqParam,"user");
		List<SystemUrl> urls = JSON.parseArray(userJson, SystemUrl.class); 
		return urlManager.deleteUrl(urls.get(0));
	}
}
