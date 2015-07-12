/**
 *  sql-defined.js
 *  //首先查出所有的业务表
 *  //勾选其中要查询的表，选择连接务件
 *  //选择一系列的查询配置条件（排序，分组，对列进行sum,count,max,min等函数操作）
 *  //最终形成一条sql，或是一个视图。
 *  //保存整个配置，用于引用到别的查询当中
 */
define('sql-defined',['jquery','base','liger.all'],function(require, exports, module){
	var Base = require("base");
	var $ = require("jquery");
	require("liger.all")($);
	var ctx = Base.common.utils.getContextPath();
	
	var $list = $("#dataGrid").ligerGrid({
		url: ctx + "/model/fetch.do",
		root:'datas',
        columns: [ { display: '主键', hide: true, name:'id', align:'left', width: 120 } ,
        { display: '表名称', name: 'name', minWidth: 80 }
        ], data: [], pageSize: 20, sortName: 'name',
		width : '98%',
		height : '98%',
		checkbox : true,
		rownumbers : false,
		isScroll : true,
		toolbar:{ items: [ { text: '增加表格', click: add , icon:'add'}, { line:true },
                          { text: '修改', click: modify }, { line:true },
                          { text: '删除', click: del }]
                      },
        fixedCellHeight: false

    });
    $("#pageloading").hide();
    
    /**
     * 
     */
    function add(){
    	var tableSelector = null;
    	function getSelectedTable(){
    		var rows = tableSelector.getSelectedRows();
    		console.log(rows);
    		$list.addRow(rows);
    	}
    	if(! tableSelector ){
    		tableSelector = $("#tableAdd").ligerGrid({
        		url: ctx + "/model/findModelDefinedByPage.do",
        		root:'datas',
                columns: [ { display: '主键', hide: true, name:'id', align:'left', width: '100%' } ,
                { display: '表名称', name: 'name', minWidth: 80 }
                ], data: [], pageSize: 20, sortName: 'name',
        		width : '98%',
        		height : '80%',
        		checkbox : false,
        		rownumbers : false,
        		isScroll : true,
        		toolbar:{ items: [{ text: '确定', click: getSelectedTable , icon:'add'}
                                  ]
                              },
                fixedCellHeight: false
            });
        	$.ligerDialog.open({ target: $("#tableAdd"),title:'添加表格' ,width: 600,height:500,modal:false});
        } 
    	

    	
    }
    	
    
    /**
     * 
     */
    function modify(){
    	var row = $list.getSelectedRow();
    	if(!row){
    		$.ligerDialog.warn("请选择要修改的表！");
    		return;
    	}
    }
    
    /**
     * 
     */
    function del(){
    	 $.ligerDialog.confirm('是否删除所选记录', function (yes) {
    		var rows =  $list.getSelectedRows();
//    		$list.
    		//假如多表连接查询，这里删除了表，则后台关联要重新配置
    		});
    }
    
    function addAttr(){
    	
    	$.ligerDialog.open({
			height : 500,
			url : ctx + '/program/modelDefined/model-properties-defined.jsp',
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


