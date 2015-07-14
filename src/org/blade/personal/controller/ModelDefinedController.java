package org.blade.personal.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.blade.personal.manager.ModelDefinedManager;
import org.blade.personal.mode.ModelDefined;
import org.blade.personal.mode.ModelPropertyDefined;
import org.blade.personal.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/model/*")
public class ModelDefinedController {

	@Autowired
	private ModelDefinedManager modelDefinedManager;
	
	@RequestMapping("toModelDefined")
	public ModelAndView showRoleAuthority(){
		ModelAndView to = new ModelAndView("role-authority");
		to.addObject("title", "模型定义管理");
		return to;
	}
	
	/**
	 * 抓取模型
	 * @param reqParam
	 * @return
	 */
	@ResponseBody
	@RequestMapping("findModelDefinedByPage")
	public Map findModelDefinedByPage(@RequestParam Map reqParam){
		
		Long id = MapUtils.getLong(reqParam, "id");
		
		Long pageNo = MapUtils.getLong(reqParam, "pageNo", 1l);
		Long pageSize =  MapUtils.getLong(reqParam, "pageSize",20l);
		int usrOrRole = MapUtils.getIntValue(reqParam, "usrOrRole");
		Pager<ModelDefined> pager = new Pager<ModelDefined>();
		String model = MapUtils.getString(reqParam, "modelDefined", "{}");
		
//		Map map = MapUtils.getMap(reqParam, "modelDefined", new HashMap());
		
		Map modelDefined  = JSON.parseObject(model, Map.class);
		
		pager.setPageSize(pageSize);
		pager.setCurrentPage(pageNo);
		modelDefinedManager.findModelDefinedForPage(pager, modelDefined);
		reqParam.put("total", pager.getTotalCount());
		reqParam.put("datas", pager.getEntities());
		return reqParam;
	}
	
	/**
	 * 抓取模型
	 * @param reqParam
	 * @return
	 */
	@ResponseBody
	@RequestMapping("findModelPropertyByPage")
	public Map findModelPropertyByPage(@RequestParam Map reqParam){
		
		Long id = MapUtils.getLong(reqParam, "id");
		
		Long pageNo = MapUtils.getLong(reqParam, "pageNo", 1L);
		Long pageSize =  MapUtils.getLong(reqParam, "pageSize",20L);
		int usrOrRole = MapUtils.getIntValue(reqParam, "usrOrRole");
		Pager<ModelPropertyDefined> pager = new Pager<ModelPropertyDefined>();
		String model = MapUtils.getString(reqParam, "modelProperty", "{}");
		
//		ModelPropertyDefined modelPropertyDefined  = JSON.parseObject(model, ModelPropertyDefined.class);
		
		Map modelDefined  = JSON.parseObject(model, Map.class);
		
		pager.setPageSize(pageSize);
		pager.setCurrentPage(pageNo);
		modelDefinedManager.findModelPropertyDefinedForPage(pager, modelDefined);
		modelDefinedManager.findByIdAndGeneratCode(MapUtils.getLong(modelDefined, "model_defined_id"));
		reqParam.put("total", pager.getTotalCount());
		reqParam.put("datas", pager.getEntities());
		return reqParam;
	}
	
	
	/**
	 * 抓取模型
	 * @param reqParam
	 * @return
	 */
	@ResponseBody
	@RequestMapping("saveModel")
	public int saveModel(@RequestParam Map reqParam){
		
		String model  = MapUtils.getString(reqParam, "model","{}");
		List<ModelDefined> modelDefineds  = JSON.parseArray(model, ModelDefined.class);
		//保存
		return modelDefinedManager.saveModelDefined(modelDefineds);
	}
	
	
	@ResponseBody
	@RequestMapping("saveProperty")
	public int saveProperty(@RequestParam Map reqParam){
		String properties  = MapUtils.getString(reqParam, "properties","{}");
		List<ModelPropertyDefined> modelPropertyDefined  = JSON.parseArray(properties, ModelPropertyDefined.class);
		//保存
		return modelDefinedManager.saveModelPropertyDefined(modelPropertyDefined);
	}
	
	@ResponseBody
	@RequestMapping("delete")
	public int deleteModel(@RequestParam Map reqParam){
		
		String ids = MapUtils.getString(reqParam,"ids");
		return modelDefinedManager.removeModelDefined(ids);
	}
	
	@ResponseBody
	@RequestMapping("deleteProperties")
	public int deleteModelProperties(@RequestParam Map reqParam){
		
		String ids = MapUtils.getString(reqParam,"ids");
		return modelDefinedManager.removeModelPropertyDefined(ids);
	}

}
