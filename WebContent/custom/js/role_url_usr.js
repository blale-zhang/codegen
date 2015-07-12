/**
 * authority-mgr.js
 */
define('authority-mgr',['jquery','base','liger.all'],function(require, exports, module){
	var Base = require("base");
	var $ = require("jquery");
	require("liger.all")($);
	var ctx = Base.common.utils.getContextPath();
	var typeEnum = {0:'超级管理员',1:'普通管理员',2:'高级用户',3:'普通用户',4:'过期用户'};//TODO 来自远程服务器

	$("#portalMain").ligerPortal({
//		 draggable : true,
        columns: [{
            width: '100%',
            panels: [{
                title: 'url',
                width: '100%',
                height: 200,
                content: '<div id="urlContainer">ddd<div>'
            },
            {
                title: '角色',
                width: '100%',
                height: 200,
                content: '<div id="roleContainer">ddd<div>'
            }
            ]
        }, {
            width:  '100%',
            panels: [{
                title: '用户',
                width: '100%',
                height: 200,
                content: '<div id="usrContainer">ddd<div>'
            }
            ]
        }]
    }); 
	
	
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
	var $roleList = $("#urlContainer").ligerGrid({
		url: ctx + "/url/fetch.do",
		root:'datas',
        columns: [ 
        { display: '主键', hide:true, name:'id', align: 'left', width: 120 } ,
        { display: '名称', name: 'name', minWidth: 150 },
        { display: 'url', name: 'url', width: 150, align: 'left'},
        { display: '上级', name: 'parentId', width: 150, align: 'left'},
        { display: '类型', name: 'type', width: 150, align: 'left'}
        ], data: [], pageSize: 20, sortName: 'id',
        width: '100%', height: '170', checkbox: true, rownumbers:false,
        fixedCellHeight:false,
        toolbar:{ items: [ { text: '查询', click: query , icon:'add'}, { line:true },
                           { text: '修改', click: modify }, { line:true },
                           { text: '删除', click: del } ]
                       }
    });
	
	$("#usrContainer").ligerGrid({
		url: ctx + "/usr/fetch.do",
		root:'datas',
        columns: [ 
        { display: '主键', hide:true, name:'id', align: 'left', width: 120 } ,
        { display: '用户名称', name: 'name', minWidth: 150 },
        { display: '性别', name: 'sex', width: 150, align: 'left'},
        { display: '电子邮件', name: 'email', width: 150, align: 'left'},
        { display: '电话号码', name: 'phoneNumber', width: 150, align: 'left'},
        { display: '年龄', name: 'age', width: 150, align: 'left'},
        { display: '证件号', name: 'idCardNo', width: 150, align: 'left'},
        { display: '类型', name: 'type', width: 150, align: 'left'}
        ], data: [], pageSize: 20, sortName: 'id',
        width: '100%', height: '170', checkbox: true, rownumbers:false,
        fixedCellHeight:false,
        toolbar:{ items: [ { text: '查询', click: query , icon:'add'}, { line:true },
                           { text: '修改', click: modify }, { line:true },
                           { text: '删除', click: del }, { line:true }/*,
                           { text: '授权', click: del }, { line:true },
                           { text: '分配角色', click : assignRole}*/
                           ]
                       }
    });
	
	$("#roleContainer").ligerGrid({
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
		width : '100%',
		height : '170',
		checkbox : true,
		rownumbers : false,
		isScroll : true,
		toolbar:{ items: [ { text: '增加', click: add , icon:'add'}, { line:true },
                          { text: '修改', click: modify }, { line:true },
                          { text: '删除', click: del }, { line:true }/*,
                          { text: '分配权限', click: dispathAuthority }*/ ]
                      },
        fixedCellHeight: false

    });
	
	function add(){}
	
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
		console.log(data);
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