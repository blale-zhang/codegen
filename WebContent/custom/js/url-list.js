/**
 * user-list.js
 */
define('url-list',['jquery','base','liger.messageBox','liger.dialog','liger.all'],function(require, exports, module){
	var Base = require("base");
	var $ = require("jquery");
	require("liger.all")($);
	var ctx = Base.common.utils.getContextPath();
	
	/**
	 * 初始化表单按钮
	 */
	function initFormBtns(){
		
		var btns = [];
		
		btns.push({ text:'保存', click : function() {
    			var form = liger.get("form");
    			var data = form.getData();
    			var param = {data:liger.toJSON(data)};
    	        $.ajax({
		    		url: ctx+ '/url/save.do',
		    		type : 'POST',
		    		dataType : 'json',
		    		data : param,
		    		success : function(backData) {
		    			if(backData){
		    				$roleList.reload();
		    			}
		    		}
    	        });
    		}
        });
		
		btns.push({ text:'清空', click : function() {
				var form = liger.get("form");
	        	form.setData({id:'',name:'',type:1,parentId: 1});
			}
		});
		
		return btns;
	}
	var $form = $("#form").ligerForm({
		                 inputWidth: 170, labelWidth: 90, space: 40,
		                  fields: [
		                  { name: "id", type: "hidden" },
		                  { display: "名称", name: "name", newline: true, type: "text" , group: "Url信息", groupicon: 'groupicon'}, 
		                  { display: "url", name: "url", newline: false, type: "text"},
		                  { display: "类型", name: "type", newline: true, type: "select", 
		                	  options:{
		                		  data : [{text:'按钮',id:'1'},{text:'页面',id:'2'},{text:'链接',id:'3'},{text:'默认',id:'0'}]}
		                  } ,
		                  { display: "上级", name: "parentId", newline: false, type: "select", 
		                	  options:{
			                      width: 180,
			                      selectBoxWidth: 200,
			                      selectBoxHeight: 200, valueField: 'id',textFiel:'name', 
			                      tree: { url: ctx + '/url/queryForChileren.do?id=0', ajaxType: 'post',
			                    	  single:true,
			                    	  textFieldName:'name',
			                    	  idFieldName:'id',
			                    	  checkbox:false,
			                    	  isLeaf : function(data)
			                          {
			                    		  debugger;
			                              if (!data) return false;
			                              return data.type == "parentId";
			                          },delay: function(e)
			                          {
			                        	  debugger;
			                              var data = e.data;
			                              return { url: ctx + '/url/queryForChileren.do?id=' + data.id };
			                             
			                          }
			                      }
		                	  }}],buttons:initFormBtns()
						}); 
	var param = {};
	var $roleList = $("#dataGrid").ligerGrid({
		url: ctx + "/url/fetchTree.do",
		root:'datas',
        columns: [ 
        { display: '主键', hide:true, name:'id', align: 'left', width: 120 } ,
        { display: '名称', name: 'name',id:"name", minWidth: 150 },
        { display: 'url', name: 'url', width: 150, align: 'left'},
        { display: '上级', name: 'parent_id', width: 150, align: 'left'},
        { display: '类型', name: 'type', width: 150, align: 'left'}
        ], data: [], pageSize: 20, sortName: 'id',
        width: '98%', height: '98%', checkbox: true, rownumbers:false,
        fixedCellHeight:false,tree: { columnId: 'name' },
        toolbar:{ items: [ { text: '查询', click: query , icon:'add'}, { line:true },
                           { text: '修改', click: modify }, { line:true },
                           { text: '删除', click: del } ]
                       }
    });
	/**
	 * 查询
	 */
	function query(){
		$.ligerDialog.success('查询');
		
		
		
	} 
	
	/**
	 * 修改
	 */
	function modify(){
		var data = $roleList.getSelectedRow();
		if(!data){
			$.ligerDialog.warn('请选择要修改的记录');
			return;
		}
		var form = liger.get("form");
//		console.log(data);
		form.setData(data);
	}
	
	/**
	 * 删除记录
	 */
	function del(){
		$.ligerDialog.confirm('是否删除所选记录', function (yes){
			if(yes){
				var rows =  $roleList.getSelectedRows();
				var param = {user:liger.toJSON(rows)};
		        $.ajax({
		    		url: ctx+ '/url/delete.do',
		    		type : 'POST',
		    		dataType : 'json',
		    		data : param,
		    		success : function(backData) {
		    			if(backData){
		    				$.ligerDialog.tip({  title: '提示信息',content:'记录已经删除！'});
		    				$roleList.reload();
		    			}
		    		}
		        });
			}
		
		});
	
	}

    $("#pageloading").hide();
    

});