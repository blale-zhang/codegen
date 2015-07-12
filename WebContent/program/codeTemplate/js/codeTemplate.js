/**
 * codeTemplate.js
 */
define('codeTemplate',['jquery','base','liger.all'],function(require, exports, module){
	var Base = require("base");
	var $ = require("jquery");
	require("liger.all")($);
	init();
	
	$("[name='submit']").click(function(){
		
		var content = UE.getEditor('editor').getPlainTxt();
		var codeTemplateContent = {name:"",code:"",content:content,templateId:templateId};
		 $.ajax({
	    		url: ctx+ '/codeTemplate/saveContent.do',
	    		type : 'POST',
	    		dataType : 'json',
	    		data : {templateContent:liger.toJSON(codeTemplateContent)},
	    		success : function(backData) {
	    			if(backData || backData.length){
	    				
	    			}
	    		}
	    	});
	});
	
	$("[name='saveAsDraft']").click(function(){
		saveAsDraft();
	});
	
	function saveAsDraft(){
		
        $.ajax({
    		url: ctx+ '/model/save.do',
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
	function init(){
		
		var codeTemplateContent = {templateId:templateId};
		$.ajax({
    		url: ctx+ '/codeTemplate/getTemplateContent.do',
    		type : 'POST',
    		dataType : 'json',
    		data : {templateContent:liger.toJSON(codeTemplateContent)},
    		success : function(backData) {
    			if(backData || backData.length){
    				 UE.getEditor('editor').execCommand('insertHtml', backData.content)
    				//TODO 初始化
    				
    			}
    		}
    	});
		
		
	}
	
});