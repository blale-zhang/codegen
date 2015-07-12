
/**
 * module-dependents.js
 */
define('module-dependents',['jquery','liger.base','liger.inject','liger.form',
                           'liger.grid','liger.button','base','liger.messageBox','liger.dialog','liger.all']
						,function(require, exports, module){
	var Base = require("base");
	var $ = require("jquery");
	var jqueryUi = require("jquery.ui");
	var ligerbase = require("liger.base");
	var ligerinject = require("liger.inject");
	var ligerform = require("liger.form");
	var ligergrid = require("liger.grid");
	var ligerbutton = require("liger.button");
	var ctx = Base.common.utils.getContextPath();
	
	jqueryUi($);
	ligerbase($);
	ligerinject($);
	ligerform($);
	ligergrid($);
	ligerbutton($);
	
	module.dependents = $;
});