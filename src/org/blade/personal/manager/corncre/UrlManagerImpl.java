package org.blade.personal.manager.corncre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.MapUtils;
import org.blade.personal.dao.SystemUrlDao;
import org.blade.personal.manager.UrlManager;
import org.blade.personal.mode.SystemUrl;
import org.blade.personal.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional("transactionManager")
@Service("UrlManager")
public class UrlManagerImpl implements UrlManager{

	@Autowired
	private SystemUrlDao systemUrlDao;
	@Override
	public int addUrl(SystemUrl url) {
		
		return systemUrlDao.add(url);
	}

	@Override
	public void updateUrl(SystemUrl url) {

		systemUrlDao.update(url);
	}

	@Override
	public int deleteUrl(SystemUrl url) {
		
		int effected = systemUrlDao.delete(url.getId());
		
		//如果被删除的url并非 叶子节点的话，需要把 朴删除URL的子节点绑定到 最近的祖先上去。
		if(effected > 0){
			
			List <SystemUrl> children = systemUrlDao.queryForList("select * from sys_url where 1=1 and parent_id = " + url.getId());

			for(SystemUrl sysUrl : children){
				systemUrlDao.update(sysUrl);
			}
		}
		
		return effected;
	}

	@Override
	public void pagingQuery(Pager<SystemUrl> page,Map params) {
		
		this.systemUrlDao.pagingQuery(page,params);
	}
	
	@Override
	public List<SystemUrl> queryForChildren(Long id) {
		
		return this.systemUrlDao.queryForChildren(id);
	}
	
	@Override
	public List<Map> queryForAll() {
		
		List<Map> list = systemUrlDao.queryForAll();
		//映射id与记录成为  {id : record}
		Map<String,Map> map = new HashMap<String,Map>();
		for(Map su : list){
				map.put(MapUtils.getString(su, "id"), su);
		}
		
		//收集
		Map<String,Map> picking = new HashMap<String,Map>();
		for(Map su : list){
			String parentId = MapUtils.getString(su, "parent_id");
			boolean removed =  MapUtils.getBoolean(su, "removed",false);
			if("0" .equals(parentId)  && !removed){//父id为0，此时为root
				picking.put(MapUtils.getString(su, "id"), su);
				su.put("removed", true);//标记为删除,不可真删除，否则会报currencyXXXX的异常
			}
		}
		
		//构建树
		for(Map su : list){
			String parentId = MapUtils.getString(su, "parent_id");
			boolean removed =  MapUtils.getBoolean(su, "removed",false);
			if(!"0" .equals(parentId) && !removed){
				Map parent = map.get(parentId);//取出映射中的记录
				if( parent.containsKey("children") ){//是否有子节点，有把当前记录作为子节点
					List<Map> children = (List<Map>)parent.get("children");
					children.add(su);
					
				}else{//无，则添加子节点容器,再把当前记录作为子节点
					List<Map> children = new ArrayList<Map>();
					children.add(su);
					parent.put("children", children);
				}
				//标记为删除,不可真删除，否则会报currencyXXXX的异常
				su.put("removed", true);
			}
		}
		
		//转为list
		List<Map> result = new ArrayList();
		Set<String> keySet = picking.keySet();
		for(String key : keySet){
			Map resultItem = map.get(key);
			result.add(map.get(key));
		}
		
		return result;
	}
	
	
	
	
	public static void main(String[] args) {
		
		Map<String,Map> map = new HashMap<String,Map>();
		map.put("ddd", new HashMap());
		map.remove("ddd");
		System.out.println(map);
	}

}
