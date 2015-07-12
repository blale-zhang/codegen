package org.blade.personal.controller;

import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.blade.personal.manager.ModelDefinedManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 代码产生器
 * @author ZGF
 *
 */
@Controller
@RequestMapping("/CodeGenerator/*")
public class CodeGeneratorContoller {

	@Autowired
	private ModelDefinedManager modelDefinedManager;
	
	public String generating(@RequestParam Map param){
		
		Long id = MapUtils.getLong(param, "id");
		modelDefinedManager.findByIdAndGeneratCode(id);
		return null;
	}
}
