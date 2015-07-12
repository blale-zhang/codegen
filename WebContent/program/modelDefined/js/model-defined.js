
/**
 * model-defined.js
 */

define('model-defined',['jquery','base','liger.messageBox','liger.dialog','liger.all'],function(require, exports, module){
	var Base = require("base");
	var $ = require("jquery");
	require("liger.all")($);
	var ctx = Base.common.utils.getContextPath();
	
	var typeEnum = {0:'超级管理员',1:'普通管理员',2:'高级用户',3:'普通用户',4:'过期用户'};//TODO 来自远程服务器
	var $form = $("#form").ligerForm({
		                 inputWidth: 170, labelWidth: 90, space: 40,
		                  fields: [
		                  { name: "id", type: "hidden" },
		                  { display: "名称", name: "name", newline: true, type: "text" },
		                  {  name: "ownerId", type: "hidden"}
		                  ],buttons:[{
		              	  	text:'保存',
		            		click : function() {
		            			save();
		            		}
		                },{
		            	  	text:'设值',
		            		click : function() {
		            			var form = liger.get("form");
		            	        form.setData({id:'ddd',name:'dddd',type:'type'});
		            		}
		                },{
		            	  	text:'查询',
		            		click : function() {
		            			var form = liger.get("form");
		            			$list.loadData(form.getData());
		            		}
		                }]
						}); 
	
	var $list = $("#dataGrid").ligerGrid({
		url: ctx + "/model/findModelDefinedByPage.do",
		root:'datas',
        columns: [ { display: '主键', hide: true, name:'id', align:'left', width: 120 } ,
        { display: '名称', name: 'name', minWidth: 80 , editor: { type: 'text' } }
        ], data: [], pageSize: 20, sortName: 'name',
		width : '98%',
		height : '98%',
		checkbox : true,
		rownumbers : false,
		isScroll : true,
		toolbar:{ items: [ { text: '增加', click: add , icon:'add'}, { line:true },
                          { text: '修改', click: modify }, { line:true },
                          { text: '删除', click: del }, { line:true },
                          { text: '编辑属性', click: addAttr }]
                      },
        fixedCellHeight: false, enabledEdit: true, clickToEdit: true

    });
    $("#pageloading").hide();
    
    /**
     * 
     */
    function add(){
    	 $list.addEditRow();
    }  
    
    /**
     * 保存到后台
     */
    function save(){

        var data = {model:liger.toJSON($list.getAdded())};
        $.ajax({
    		url: ctx+ '/model/saveModel.do',
    		type : 'POST',
    		dataType : 'json',
    		data : data,
    		success : function(backData) {
    			if(backData || backData.length){
    				$list.reload();
    			}
    		}
    	});
	
    }
    
    
    /**
     * 
     */
    function modify(){
    	var row = $list.getSelectedRow();
        if (!row) { alert('请选择行'); return; }
        $list.beginEdit(row);
    }
    
    /**
     * 
     */
    function del(){
    	 $.ligerDialog.confirm('是否删除所选记录', function (yes) {
    		var rows =  $list.getSelectedRows();
			
			var ids = [];
			 
			for(var i = 0; i < rows.length; i++ ){
				
				ids.push(rows[i].id);
				if(i+1 < rows.length){
					ids.push(',');
				}
				
			}
			var param = {ids:ids.join('')};
	        $.ajax({
	    		url: ctx+ '/model/delete.do',
	    		type : 'POST',
	    		dataType : 'json',
	    		data : param,
	    		success : function(backData) {
	    			if(backData){
	    				$.ligerDialog.tip({  title: '提示信息',content:'记录已经删除！'});
	    				$list.deleteSelectedRow();
	    			}
	    		}
	        });
    	});
    }
    
    function addAttr(){
    	
    	var rows =  $list.getSelectedRows();
    	if(!(rows && rows.length)){
    		$.ligerDialog.warn("请选择要编辑的模型！");
    		return;
    	}
    	$.ligerDialog.open({
			height : 500,
			url : ctx + '/program/modelDefined/model-properties-defined.jsp?modelDefinedId='+rows[0].id,
			width : 900,
			showMax : true,
			showToggle : true,
			showMin : true,
			isResize : true,
			slide : true,
			title:'编辑属性'
		}); 
 
    	
    }

    /**
     * 分发权限
     */
    function dispathAuthority(){
    	
    	$.ligerDialog.open({
			height : 500,
			url : ctx+'/custom/authority-mgr.jsp',
			width : 900,
			showMax : true,
			showToggle : true,
			showMin : true,
			isResize : true,
			slide : true,
			title:'添加权限'
		}); 
    }

});