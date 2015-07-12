/**
 * login.js
 */
define('login',['jquery','base','liger.all'],function(require, exports, module){
	var Base = require("base");
	var $ = require("jquery");
	require("liger.all")($);
	var ctx = Base.common.utils.getContextPath();
	
	/*
	 * 登录
	 */
	function login(){
		
		var param = {userName:$("#userName").val(),password:$("#password").val(),code:$("#code").val()};
	    $.ajax({
			url: ctx + '/login/ajaxLogin.do',
			type : 'POST',
			dataType : 'json',
			data : param ,
			success : function(backData) {
				if(backData == 1){
					window.location = ctx + "/main.jsp";
				}else if(backData == 0){
					$.ligerDialog.warn("帐号或密码错误!");
				}else {
					$.ligerDialog.warn("验证码错误!");
				}
			}
	    });
	}
	
	$("[name='submit']").click(function(){
		login();
	})
	
	
});


