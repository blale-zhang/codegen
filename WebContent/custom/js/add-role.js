/**
 * 
 */
/**
 * base.js
 */

define('add-role',['jquery','base','liger.messageBox','liger.dialog','liger.all'],function(require, exports, module){
	var Base = require("base");
	var $ = require("jquery");
	require("liger.all")($);
	var ctx = Base.common.utils.getContextPath();
	
	var typeEnum = {0:'超级管理员',1:'普通管理员',2:'高级用户',3:'普通用户',4:'过期用户'};//TODO 来自远程服务器
	var $form = $("#form").ligerForm({
		                 inputWidth: 170, labelWidth: 90, space: 40,
		                  fields: [
		                  { name: "id", type: "hidden" },
		                  { display: "角色名称", name: "name", newline: true, type: "text" , group: "角色信息", groupicon: 'groupicon'}, 
		                  { display: "类型", name: "type", newline: false, type: "select" ,options:{data:[{text:'超级管理员',id:'0'},
		                    {text:'普通管理员',id:'1'},{text:'高级用户',id:'2'},{text:'普通用户',id:'3'},{text:'过期用户',id:'4'}]} }
		                  ],buttons:[{
		              	  	text:'保存',
		            		click : function() {
		            	        var data = $form.getData();
		            	        alert(liger.toJSON(data));
		            	        $.extend(data,{ id :null, name:'超级管理员',type:2});
		            	        $.ajax({
		            	    		url: ctx+ '/role/save.do',
		            	    		type : 'POST',
		            	    		dataType : 'json',
		            	    		data : data,
		            	    		success : function(backData) {
		            	    			if(backData){
		            	    				$roleList.reload();
		            	    			}
		            	    		}
		            	    	});
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
		            			$roleList.loadData(form.getData());
		            		}
		                },{
		            	  	text:'设置宽高',
		            		click : function() {
		            			$roleList.setWidth(200);
		            			$roleList.setHeight(300);
		            		}
		                }]
						}); 
	
	var $roleList = $("#dataGrid").ligerGrid({
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
		width : '98%',
		height : '98%',
		checkbox : true,
		rownumbers : false,
		isScroll : true,
		toolbar:{ items: [ { text: '增加', click: add , icon:'add'}, { line:true },
                          { text: '修改', click: modify }, { line:true },
                          { text: '删除', click: del }, { line:true },
                          { text: '分配权限', click: dispathAuthority } ]
                      },
        fixedCellHeight: false

    });
    $("#pageloading").hide();
    
    /**
     * 
     */
    function add(){
    	$.ligerDialog.success('添加');
    }  
    
    /**
     * 
     */
    function modify(){
    	var row = $roleList.getSelectedRow();
    	$form.setData(row);
    }
    
    /**
     * 
     */
    function del(){
    	 $.ligerDialog.confirm('是否删除所选记录', function (yes) {
    		var rows =  $roleList.getSelectedRows();
			var param = {role:liger.toJSON(rows)};
	        $.ajax({
	    		url: ctx+ '/role/delete.do',
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