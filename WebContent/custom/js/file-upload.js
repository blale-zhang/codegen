/**
 * file-upload.js
 */
define('file-upload',['jquery','base'],function(require, exports, module){
	var Base = require("base");
	var $ = require("jquery");
	var ctx = Base.common.utils.getContextPath();
	
	var $p = $('<p/>').append($("[name='template']").first().clone());
	var templateDoc = $p.html();
	
	$(document).on('click',"[name='remove']",function(){
		var $this = $(this);
		if($("[name='remove']").length > 1 ){
			$this.parent().parent().parent().remove();
		}
	});
	
	$(document).on('click',"[name='add']",function(){
		var $this = $(this);
		$this.parent().parent().parent().parent().append(templateDoc);
	});
});