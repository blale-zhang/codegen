/**
 * layout.js
 */

define('layout',['jquery','base','jqueryUi'],function(require, exports, module){
	
	var Base = require("base");
	var $ = require("jquery");
	require("jqueryUi")($);
	var ctx = Base.common.utils.getContextPath();
	$( "#accordionContainer" ).accordion({icons: { "header": "ui-icon-plus", "activeHeader": "ui-icon-minus"}});
	$( "#datepicker" ).datepicker({ autoSize: true });
	$( "#datepicker" ).datepicker( "hide" );
	$( "#tabs" ).tabs({ active: 1, heightStyle: "fill" });
});