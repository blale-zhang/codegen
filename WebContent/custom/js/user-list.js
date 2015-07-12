/**
 * user-list.js
 */
define('user-list',['jquery','base','liger.messageBox','liger.dialog','liger.all'],function(require, exports, module){
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
		    		url: ctx+ '/usr/save.do',
		    		type : 'POST',
		    		dataType : 'json',
		    		data : param,
		    		success : function(backData) {
		    			if(backData){
		    				$roleList.reload();
		    				$form.setEnabled(["name","sex", "email", "phoneNumber","age", "idCardNo", "type"], true);
		    			}
		    		}
    	        });
    		}
        });
		
		btns.push({ text:'清空', click : function() {
			var form = liger.get("form");
	        form.setData({id:'',name:'',sex:'1',phoneNumber:'', email:'',age:'',type:'1',idCardNo:''});
	        
			}
		});
		
		return btns;
	}
	var $form = $("#form").ligerForm({
		                 inputWidth: 170, labelWidth: 90, space: 40,
		                  fields: [
		                  { name: "id", type: "hidden" },
		                  { display: "用户名称", name: "name", newline: true, type: "text" , group: "用户信息", groupicon: 'groupicon'}, 
		                  { display: "性别", name: "sex", newline: false, type: "select" , options:{ data : [{text:'男',id:1},{text:'女',id:0}]}  },
		                  { display: "电子邮件", name: "email", newline: false, type: "text"  },
		                  { display: "电话号码", name: "phoneNumber", newline: false, validate:{ required: true, minlength: 11},  type: "text"  },
		                  { display: "年龄", name: "age", newline: false, type: "spinner",options:{ height: 22, type: 'int',isNegative:false }  },
		                  { display: "证件号", name: "idCardNo", newline: false, type: "text", validate:{ required: true, minlength: 18}  },
		                  {   display: "角色", name: "roleId", textField: "roleName",
		                      newline: false, type: "combobox", editor: { parms:[],
		                          selectBoxWidth: 300,
		                          selectBoxHeight: 300,
		                          textField: 'name',
		                          valeuField: 'id',
		                          condition: {
		                              fields: [
		                                  { label: '角色名称', name: 'name', type: 'text' ,width:100}
		                              ]
		                          },
		                          grid: { columns: [
						                  { display: '角色名称', name: 'name', align: 'left', width: 120, minWidth: 100 },
						                  { display: '角色类型', name: 'type', width: 120, minWidth: 100 },
						                  { display: '主键', name: 'id', minWidth: 0, hide:true }],
						                  url:ctx + "/role/fetch.do",root:'datas', pageSize: 10, isScroll: false, sortName: 'name',
		                              width: 240
		                          }
		                      }},
			                  { display: "类型", name: "type", newline: false, type: "select", options:{ data : [{text:'内部用户',id:'1'},{text:'测试用户',id:'2'},{text:'外部用户',id:'0'}]}   }
		                  ],buttons:initFormBtns()
						}); 
	var param = {};
	var $roleList = $("#dataGrid").ligerGrid({
		url: ctx + "/usr/fetch.do",
		root:'datas',
        columns: [ 
        { display: '主键', hide:true, name:'id', align: 'left', width: 120 } ,
        { display: '用户名称', name: 'name', minWidth: 150 },
        { display: '性别', name: 'sex', width: 150, align: 'left',render:function(rowData){
        	if(rowData.sex){
        		return '男'
        	}
        	return '女'
        }},
        { display: '电子邮件', name: 'email', width: 150, align: 'left'},
        { display: '电话号码', name: 'phoneNumber', width: 150, align: 'left'},
        { display: '年龄', name: 'age', width: 150, align: 'left'},
        { display: '证件号', name: 'idCardNo', width: 150, align: 'left'},
        { display: '类型', name: 'type', width: 150, align: 'left'}
        ], data: [], pageSize: 20, sortName: 'id',
        width: '98%', height: '98%', checkbox: true, rownumbers:false,
        fixedCellHeight:false,
        toolbar:{ items: [ { text: '查询', click: query , icon:'add'}, { line:true },
                           { text: '修改', click: modify }, { line:true },
                           { text: '删除',click: del }, { line:true },
                           { text: '授权', click: assignAuthorities }, { line:true },
                           { text: '权限管理', click: showAuthorityManagement }, { line:true }
                           ]
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
		var form = liger.get("form");
		form.setData(data);
	}
	
	/**
	 * 删除记录
	 */
	function del(){
		$.ligerDialog.confirm('是否删除所选用户记录, 若删除记录会把关联记录也删除!', function (yes){
			if(yes){//做成假删除，一年后才能直正删除
				var rows =  $roleList.getSelectedRows();
				var param = {user:liger.toJSON(rows)};
		        $.ajax({
		    		url: ctx+ '/usr/delete.do',
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
	
	/**
	 * 授权
	 */
	function assignAuthorities(){
		$.ligerDialog.open({ url: ctx+'/auth/usrAuthority.do',title:'授权', width: 1024, height:768, modal:true });
		
	}
	
	/**
	 * 权限管理
	 */
	function showAuthorityManagement(){
		
		var usrGridManager = $("#dataGrid").ligerGetGridManager();
		var usr = usrGridManager.getSelectedRow();
		
		if( !(usr && usr.id)){
			$.ligerDialog.warn("请选勾选用户!");
			return;
		}
		$.ligerDialog.open({ url: ctx+'/auth/authorityManagement.do?id=' + usr.id+"&usrOrRole=0", title:'权限管理', width: 1024, height:768, modal:true });
	}
	
	function assignRole(){
		var data = $roleList.getSelectedRow();
		
		//TODO 弹窗，选角色，然后勾选对应的角色
		var form = liger.get("form");
		form.setData(data);
//		$form.setEnabled(["name","sex", "email", "phoneNumber","age", "idCardNo", "type"], false);
		$form.setVisible(["roleId"], true);
	}

    $("#pageloading").hide();

});