/**
 * authority-mgr.js
 */
define('authority-mgr',['jquery','base','liger.all','authority'],function(require, exports, module){
	var Base = require("base");
	var $ = require("jquery");
	require("liger.all")($);
	var ctx = Base.common.utils.getContextPath();
	var typeEnum = {0:'超级管理员',1:'普通管理员',2:'高级用户',3:'普通用户',4:'过期用户'};//TODO 来自远程服务器
	var AuthorityUtils = require('authority')
	var CRUD_ENUM = AuthorityUtils.CRUD_ENUM;
	initAuthorityList();

	/**
	 * initAuthorityList
	 */
	function initAuthorityList(){
		$("#authorityList").ligerGrid({
			root:'datas',
			url: ctx + "/auth/fetch.do?usrOrRole=" + $("#usrOrRole").val()+"&id="+$("#id").val(), 
	        columns: [ 
	        { display: '主键', hide:true, name:'id', align: 'left', width: 120 } ,
	        { display: '名称', name: 'name', minWidth: 150 , editor: { type: 'text' }},
	        { display: '是否私有', name:'isPrivate', width: 150, align: 'left', editor: { type: 'text' }},
	        { display: '[查询]', name: 'query', width: 40, align: 'left',render:function(rowData){
	        	if(rowData && rowData['query'] || rowData['weightValue'] >= CRUD_ENUM.READ ){
	        		rowData['query'] = true;
        			return "<input type='checkbox' checked name='query' value='8' />";
        		}else{
        			return "<input type='checkbox' name='query' value='8' />";
        		}
	        }, editor: { type: 'checkbox' }
	        },
	        { display: '[新增]', name: 'add', width: 40, align: 'left',render:function(rowData){
	        	if(rowData && rowData['add']  || rowData['weightValue'] >= CRUD_ENUM.ADD ){
	        		rowData['add'] = true;
        			return "<input type='checkbox' checked name='add' value='8' />";
        		}else{
        			return "<input type='checkbox' name='add' value='8' />";
        		}
        	}, editor: { type: 'checkbox' }
        },
	        { display: '[修改]', name: 'modify', width: 40, align: 'left',render:function(rowData){
        		if(rowData && rowData['modify']  || rowData['weightValue'] >= CRUD_ENUM.MODIFY ){
        			rowData['modify'] = true;
        			return "<input type='checkbox' checked name='modify' value='8' />";
        		}else{
        			return "<input type='checkbox' name='modify' value='8' />";
        		}
        		
        	}, editor: { type: 'checkbox' }
        },
	        { display: '[删除]', name: 'delete', width: 40, align: 'left',render:function(rowData){
	        	
        		if(rowData && rowData['delete']  || rowData['weightValue'] >= CRUD_ENUM.DELETE ){
        			rowData['delete'] = true;
        			return "<input type='checkbox' checked name='delete' value='8' />";
        		}else{
        			return "<input type='checkbox' name='delete' value='8' />";
        		}
        	}, editor: { type: 'checkbox'}
        }
	        ], data: [],sortName: 'id',
	        width: '99.8%', height: '99.9%', rownumbers:false,
	        fixedCellHeight:true,  enabledEdit: true, checkbox: true,
	        toolbar:{ items: [ { text: '删除', click: del , icon:'delete'} , { line:true },
	                           { text: '查看', click: showDetail , icon:'query'}, { line:true },
	                           { text: '保存', click: save , icon:'query'}]  },
	                           onBeforeSubmitEdit:function(editParam){
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
					var authoriesWouldDelete =  authorityGridManager.getSelectedRows();
					var ids = '';
					for(var i = 0 ; i < authoriesWouldDelete.length; i++){
						ids += authoriesWouldDelete[i].id;
						if(i+1 < authoriesWouldDelete.length){
							ids += ',';
						}
					}
					
					$.ajax({
			    		url: ctx+ '/auth/delete.do',
			    		type : 'POST',
			    		dataType : 'json',
			    		data : {data:ids},
			    		success : function(backData) {
			    			if(backData){
			    				$.ligerDialog.tip({  title: '提示信息',content:'记录已经删除！'});
			    				authorityGridManager.reload();
			    			}
			    		}
			        });
				}});
	       /* $.ajax({
	    		url: ctx+ '/auth/delete.do',
	    		type : 'POST',
	    		dataType : 'json',
	    		data : param,
	    		success : function(backData) {
	    			if(backData){
	    				$.ligerDialog.tip({  title: '提示信息',content:'记录已经删除！'});
	    				$roleList.reload();
	    			}
	    		}
	        });*/
		}
		
		/**
		 * 查看详情
		 */
		function showDetail(){
			$.ligerDialog.warn(liger.toJSON(authorityGridManager.getUpdated()));
		}
		
		
		/**
		 * save 
		 */
		function save(){
			
			var authorityArray = authorityGridManager.getUpdated();
			for(var i = 0; i < authorityArray.length; i++){
				authorityArray[i] = AuthorityUtils.manager.calculater(authorityArray[i]);
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