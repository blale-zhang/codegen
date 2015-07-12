package org.blade.personal.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.collections.MapUtils;
import org.blade.personal.manager.AuthorityManager;
import org.blade.personal.mode.Authority;
import org.blade.personal.mode.User;
import org.blade.personal.utils.Pager;
import org.blade.personal.utils.SpringMvcUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/auth/*")
public class AuthorityController {

	/**
	 * Is a usr, then 0
	 */
	private static final int  IS_USR  = 0;
	
	/**
	 * Is a  role, then 1
	 */
	private static final int  IS_ROLE  = 1;

	
	@Autowired
	private AuthorityManager authorityManager;
	/**
	 * 跳转角色权限管理
	 * @return
	 */
	@RequestMapping("roleAuthority")
	public ModelAndView showRoleAuthority(){
		ModelAndView to = new ModelAndView("role-authority");
		to.addObject("title", "角色权限管理");
		return to;
	}
	
	/**
	 * 跳转角色权限管理
	 * @return
	 */
	@RequestMapping("show")
	public ModelAndView showList(){
		ModelAndView to = new ModelAndView("role-authority");
		to.addObject("title", "角色权限管理");
		return to;
	}
	
	/**
	 * 跳转用户权限管理
	 * @return
	 */
	@RequestMapping("usrAuthority")
	public ModelAndView showUsrAuthority(){
		ModelAndView to = new ModelAndView("usr-authority");
		to.addObject("title", "用户权限管理");
		return to;
	}
	
	/**
	 * 跳转到权限管理 ，请求时需带id和usrOrRole标识
	 * @return
	 */
	@RequestMapping("authorityManagement")
	public ModelAndView showAuthorityMgr(@RequestParam Map param){
		
		ModelAndView to = new ModelAndView("authority-mgr");
		to.addObject("title", "权限管理");
		Set<String> keySet = param.keySet();
		for(String key : keySet){
			to.addObject(key, param.get(key));
		}
		return to;
	}
	
	/**
	 * 保存
	 * @param data
	 * @return
	 */
	@ResponseBody
	@RequestMapping("save")
	public int save(@RequestParam Map data){
		String authorities = MapUtils.getString(data, "data");
		 List<Authority> authorityList =  JSON.parseArray(authorities, Authority.class);
		 
		return authorityManager.batchSave(authorityList);
	}
	
	/**
	 * 抓取权限
	 * @param reqParam
	 * @return
	 */
	@ResponseBody
	@RequestMapping("fetch")
	public Map fetch(@RequestParam Map reqParam){
		Long id = MapUtils.getLong(reqParam, "id");
		int usrOrRole = MapUtils.getIntValue(reqParam, "usrOrRole");
		Long pageSize = MapUtils.getLong(reqParam, "pagesize");
		Long currentPage = MapUtils.getLong(reqParam, "page");
		Pager<Authority> page = new Pager<Authority>();
		page.setPageSize(pageSize);
		page.setCurrentPage(currentPage);
		
		if(usrOrRole == IS_USR){//用户
			authorityManager.pagingQueryAuthoritiesForUsr(page, id);
		}else if(usrOrRole == IS_ROLE){//角色
			authorityManager.pagingQueryAuthoritiesForRole(page, id);
		}
		reqParam.put("total", page.getTotalCount());
		reqParam.put("datas", page.getEntities());
		return reqParam;
	}
	
	@ResponseBody
	@RequestMapping("delete")
	public int delete(@RequestParam Map reqParam){
		String authoIds = MapUtils.getString(reqParam,"data");
		return authorityManager.deleteAuthority(authoIds);
	}
	
	/**
	 * 加载导航
	 * @param reqParam
	 * @return
	 */
	@ResponseBody
	@RequestMapping("loadNavigation")
	public List loadNavigation(@RequestParam Map reqParam){
		
		//从session里取比较安全
		HttpSession session = SpringMvcUtils.getHttpSession();
		User user  = (User) session.getAttribute("userInfo");
		if(null != user){
			Long id = user.getId();
			long parentId = MapUtils.getIntValue(reqParam, "parentId", 0);
			long authId = MapUtils.getIntValue(reqParam, "authId", 0);
			int type = MapUtils.getIntValue(reqParam, "type", 2);
			List navigations = authorityManager.queryNavigation(parentId,authId,type,user);
			return navigations;
		} 
		
		return Collections.EMPTY_LIST;
		
	}
	
}
