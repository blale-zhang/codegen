/**
 * role-authority.js
 */
define('role-authority',['jquery','base','liger.all','authority'],function(require, exports, module){
	var Base = require("base");
	var $ = require("jquery");
	require("liger.all")($);
	var ctx = Base.common.utils.getContextPath();
	
	var AuthorityUtil =  require("authority");
	
	var typeEnum = {0:'超级管理员',1:'普通管理员',2:'高级用户',3:'普通用户',4:'过期用户'};//TODO 来自远程服务器
	
	initLayout();
	initRoleList();
	initUrlList();
	initAuthorityList();
	function initLayout(){
		 $("#layout").ligerLayout({ leftWidth: 200});
		 $("#subLayout").ligerLayout({ topHeight: '50%',bottomHeight:'50%'});
		 $("#operationLayout").ligerLayout({ leftWidth: '49.7%',rightWidth:'50.0%',allowLeftCollapse:false,allowRightCollapse:false});
		 
	}
	
	
	function initRoleList(){
		var $roleList = $("#roleList").ligerGrid({
			url: ctx + "/role/fetch.do",
			root:'datas',
	        columns: [ { display: '主键', hide: true, name:'id', align:'left', width: 120 } ,
	        { display: '角色名称', name: 'name', minWidth: 80 },
	        { display: '类型', name: 'type', width: 150, align: 'left',render:function (rowData, index, value){
	        	rowData.type_real = rowData.type;
	        	value = typeEnum[rowData.type];
	        	return value;
	        }}
	        ], data: [], pageSize: 20, sortName: 'name',
			width : '99.9%',
			height : '270',
			checkbox : true,
			rownumbers : false,
			isScroll : true,
	        fixedCellHeight: false

	    });
	    $("#pageloading").hide();
	    
	}
	
	
	/**
	 * 初始化url列表
	 */
	function initUrlList(){
		//url列表
		var urlList = $("#urlList").ligerGrid({
			url: ctx + "/url/fetchTree.do",
			root:'datas',
	        columns: [ 
	        { display: '主键', hide:true, name:'id', align: 'left', width: 120 } ,
	        { display: '名称', name: 'name', id:'name', minWidth: 150 },
	        { display: 'url', name: 'url', width: 150, align: 'left'},
	        { display: '上级', name: 'parentId', width: 150, align: 'left'},
	        { display: '类型', name: 'type', width: 150, align: 'left'}
	        ], data: [], pageSize: 20, sortName: 'id',tree: { columnId: 'name' },
	        width: '99.8%', height: '100%', checkbox: true, rownumbers:false,
	        fixedCellHeight:true,
	        toolbar:{ items: [ { text: '激活菜单', click: attachUrlToRole , icon:'add'}]  }
	    });
		 
		/**
		 * 追加权限给指定角色
		 */
		function attachUrlToRole(){
			var rows = 	urlList.getSelectedRows();
			var authorityGridManager = $("#authorityList").ligerGetGridManager();
			var usrGridManager =  $("#roleList").ligerGetGridManager();
			var usr = usrGridManager.getSelectedRow();
			if(!usr){
				$.ligerDialog.warn('请选择相应的角色');
				return;
			}
			for(var i = 0;i < rows.length;i++){
				authorityGridManager.add({name:rows[i].name,urlId:rows[i].id,roleId:usr.id});
			}
		} 
	}
	
	/**
	 * initAuthorityList
	 */
	function initAuthorityList(){
		
		$("#authorityList").ligerGrid({
			root:'datas',
	        columns: [ 
	        { display: '主键', hide:true, name:'id', align: 'left', width: 120 } ,
	        { display: '名称', name: 'name', minWidth: 150 , editor: { type: 'text' }},
	        { display: '是否私有', name:'isPrivate', width: 150, align: 'left', editor: { type: 'text' }},
	        { display: '[查询]', name: 'query', width: 40, align: 'left',render:function(rowData){
	        	if(rowData && rowData['query']){
        			return "<input type='checkbox' checked name='query' value='8' />";
        		}else{
        			return "<input type='checkbox' name='query' value='8' />";
        		}
	        }, editor: { type: 'checkbox' }
	        },
	        { display: '[新增]', name: 'add', width: 40, align: 'left',render:function(rowData){
	        	if(rowData && rowData['add']){
        			return "<input type='checkbox' checked name='add' value='8' />";
        		}else{
        			return "<input type='checkbox' name='add' value='8' />";
        		}
        	}, editor: { type: 'checkbox' }
        },
	        { display: '[修改]', name: 'modify', width: 40, align: 'left',render:function(rowData){
	        	
        		
        		if(rowData && rowData['modify']){
        			return "<input type='checkbox' checked name='modify' value='8' />";
        		}else{
        			return "<input type='checkbox' name='modify' value='8' />";
        		}
        		
        	}, editor: { type: 'checkbox' }
        },
	        { display: '[删除]', name: 'delete', width: 40, align: 'left',render:function(rowData){
	        	
        		if(rowData && rowData['delete']){
        			return "<input type='checkbox' checked name='delete' value='8' />";
        		}else{
        			return "<input type='checkbox' name='delete' value='8' />";
        		}
        	}, editor: { type: 'checkbox'}
        }
	        ], data: [],sortName: 'id',
	        width: '99.9998%', height: '100%', rownumbers:false,
	        fixedCellHeight:true,  enabledEdit: true,
	        toolbar:{ items: [ { text: '删除', click: del , icon:'delete'} , { line:true },
	                           { text: '查看', click: showDetail , icon:'query'}, { line:true },
	                           { text: '保存', click: save , icon:'query'}]  },
	                           onBeforeSubmitEdit:function(editParam){
	                        	   
	                        	   console.log(liger.toJSON(editParam));
	                        	   if((editParam.value && editParam.column.name == 'query') || 
	                        			   (editParam.record && editParam.record.query) ){
	                        	   
	                        		   return true;
	                        	   }
	                        	   if(!(editParam.record && editParam.record.query)){
	                        		   if( editParam.record['delete'] ){
	                        			   editParam.record['delete']  = false;
	                        		   }
	                        		   if( editParam.record['modify'] ){
	                        			   editParam.record['modify']  = false;
	                        		   }
	                        		   if( editParam.record['add'] ){
	                        			   editParam.record['add']  = false;
	                        		   }
	                        		   return false;
	                        	   }
	                        	   return false;
	                           },
	                           onAfterSubmitEdit:function(record,rowindex,newdata){
	                        	   alert(rowindex);
	                           }
	    });
		
		
		var authorityGridManager = $("#authorityList").ligerGetGridManager();
		
		/**
		 * 删除新增菜单
		 */
		function del(){
			
			var newAddeds = authorityGridManager.getAdded()
			$.ligerDialog.confirm('是否删除所选记录', function (yes){
				if(yes){
					authorityGridManager.deleteSelectedRow();
				}});
		}
		
		/**
		 * 查看详情
		 */
		function showDetail(){
			$.ligerDialog.warn(liger.toJSON(authorityGridManager.getAdded()));
		}
		
		
		/**
		 * save 
		 */
		function save(){
			
			var authorityArray = authorityGridManager.getAdded();
			for(var i = 0; i < authorityArray.length; i++){
				authorityArray[i] = AuthorityUtil.manager.calculater(authorityArray[i]);
			}
			var param = {data: liger.toJSON(authorityArray)}
			$.ligerDialog.confirm('确定保存这些权限吗？', function (yes){
				if(yes){
					$.ajax({
			    		url: ctx+ '/auth/save.do',
			    		type : 'POST',
			    		dataType : 'json',
			    		data : param,
			    		success : function(backData) {
			    			if(backData){
			    				$.ligerDialog.success("保存成功!")
			    			}
			    		}
					});
				}});
			 
		}
	}
	
});