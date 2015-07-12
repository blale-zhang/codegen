/**
 * model-properties-defined.js
 */

define('model-properties-defined',['jquery','base','liger.all'],function(require, exports, module){
	var Base = require("base");
	var $ = require("jquery");
	require("liger.all")($);
	var ctx = Base.common.utils.getContextPath();
	var modelProperties = {model_defined_id:modelDefinedId}
	var $list = $("#dataGrid").ligerGrid({
		url: ctx + "/model/findModelPropertyByPage.do",
		root:'datas',
		parms:{modelProperty:liger.toJSON(modelProperties)},
        columns: [ { display: '主键', hide: true, name:'id', align:'left', width: 120 } ,
                   { display: '访问权限', name: 'vistiControl', minWidth: 80 ,editor: { type: 'text' }},
                   { display: '数据类型', name: 'dataType', minWidth: 80,editor: { type: 'text' } },
                   { display: '属性名', name: 'propertyName', minWidth: 80,editor: { type: 'text' } },
                   { display: '默认值', name: 'defaultValue', minWidth: 80,editor: { type: 'text' } },
                   { display: '所属人', hide: true, name: 'ownerId', minWidth: 80,editor: { type: 'text' } },
                   { display: '所属模型', hide: true, name: 'modeDefinedId', minWidth: 80,editor: { type: 'text' } },
                   { display: '注释', name: 'propertyComment', minWidth: 380,editor: { type: 'text' } }
        ], data: [{}], pageSize: 20, sortName: 'propertyName',enabledEdit: true,clickToEdit: false,
		width : '98%',
		height : '98%',
		checkbox : true,
		rownumbers : false,
		isScroll : true,
		toolbar:{ items: [ { text: '保存', click: save }, { line:true },
		                   { text: '增加', click: add , icon:'add'}, { line:true },
                          { text: '删除', click: del }, { line:true },
                          { text: '查看代码', click: previewCode }]
                      },
        fixedCellHeight: false,enabledEdit: true, clickToEdit: true

    });
    $("#pageloading").hide();
    
    /**
     * 
     */
    function add(){
    	var manager = $("#dataGrid").ligerGetGridManager();
            manager.addRow({
                id : null,
                vistiControl: 1,
                dataType: 'java.lang.String',
                propertyName:"name",
                defaultValue : "zhangSan",
                ownerId : 25,
                modeDefinedId: new Date(1306108800000),
                propertyComment : "2343434"
            });
    }  
    
    /**
     * 保存
     */
    function save(){
    	var rows = $list.getData();
    	for(var i = 0; i < rows.length ; i++){
    		//绑定模型
    		rows[i].modelDefinedId = modelProperties.model_defined_id;
    	}
    	var param = {properties:liger.toJSON(rows)};
    	$.ajax({
		url: ctx+ '/model/saveProperty.do',
		type : 'POST',
		dataType : 'json',
		data : param ,
		success : function(backData) {
			if(backData){
				$.ligerDialog.tip({  title: '提示信息',content:'记录已经删除！'});
				$list.reload();
			}
		}
    });
    	
    }
    
    
    /**
     * 预览代码
     */
    function previewCode(){
    	$.ligerDialog.alert("查看代码，建设中")
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
			var param = {role:liger.toJSON(rows)};
	       /* $.ajax({
	    		url: ctx+ '/role/delete.do',
	    		type : 'POST',
	    		dataType : 'json',
	    		data : param,
	    		success : function(backData) {
	    			if(backData){
	    				$.ligerDialog.tip({  title: '提示信息',content:'记录已经删除！'});
	    				$list.reload();
	    			}
	    		}
	        });*/
    		});
    }
    
    function addAttr(){
    	
/*    	$.ligerDialog.open({
			height : 500,
			url : ctx+'/custom/authority-mgr.jsp',
			width : 900,
			showMax : true,
			showToggle : true,
			showMin : true,
			isResize : true,
			slide : true,
			title:'添加权限'
		}); */
    	
        var row = $list.getSelectedRow();
        if (!row) { alert('请选择行'); return; }
        $list.beginEdit(row);
 
    	
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