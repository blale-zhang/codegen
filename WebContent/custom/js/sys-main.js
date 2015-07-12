/**
 * sys-main.js
 */
define('sys-main',['jquery','base','liger.all'],function(require, exports, module){
	var Base = require("base");
	var $ = require("jquery");
	require("liger.all")($);
	var ctx = Base.common.utils.getContextPath();
	
	var typeEnum = {0:'超级管理员',1:'普通管理员',2:'高级用户',3:'普通用户',4:'过期用户'};//TODO 来自远程服务器
	
	initLayout();
	initMenu();
	
	
	function initLayout(){
		 $("#layout").ligerLayout({ leftWidth: 200});
		 $("#subLayout").ligerLayout({ topHeight: '50%',bottomHeight:'50%'});
		 $("#operationLayout").ligerLayout({ leftWidth: '49.7%',rightWidth:'50.0%',allowLeftCollapse:false,allowRightCollapse:false});
		 
	}

	
	
	var data = [{"text":"company1","id":"1","type":"company"},{"text":"company2","id":"2","type":"company"},{"text":"company3","id":"3","type":"company"},{"text":"company4","id":"4","type":"company"},{"text":"company5","id":"5","type":"company"},{"text":"company6","id":"6","type":"company"},{"text":"company7","id":"7","type":"company"},{"text":"company8","id":"8","type":"company"},{"text":"company9","id":"9","type":"company"},{"text":"company10","id":"10","type":"company"}];
	
	
	
	
	/**
	 * 初始化菜单
	 */
	function initMenu(){
		
		$("#treeGrid").ligerTree({ data:data, nodeWidth : 40, onClick:function(data,target){
			
			
			
			
		}})
		
		
	}
	
	
});