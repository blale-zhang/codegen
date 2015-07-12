<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="${ctx}/component/seajs-2.2.1/dist/sea.js" id="seajsnode"></script>
<script type="text/javascript">

	var ctx = '${ctx}';
	
	seajs.config({
		base : '${ctx}/js',
		alias : {
			'jquery' : 'jquery.js',
			'bootstrap' : 'bootstrap.js',
			'jqueryUi' : 'jquery-ui.js',
			'liger.all' : 'ligerui.all.js',
			'liger.base' : 'ligerui.base.js',
			'liger.inject' : 'ligerui.inject.js',
			'liger.form' : 'ligerui.form.js',
			'liger.grid' : 'ligerui.grid.js',
			'liger.button':'ligerui.button.js',
			'liger.checkBox':'ligerui.checkBox.js',
			'liger.checkBoxList':'ligerui.checkBoxList.js',
			'liger.comboBox':'ligerui.comboBox.js',
			'jquery.ui':'jquery-ui-1.10.4.custom.min.js',
			'liger.messageBox':'liger.messageBox.js',
			'liger.dialog':'ligerui.dialog.js',
			'jquery-1.3.2':'jquery-1.3.2.min.js'
		}
	});
	
	define('base',function(require, exports, module){
		
		var Base = {}
		Base.common = {};
		Base.common.utils = {};
		Base.common.utils.getContextPath = function() {return '${ctx}';};
		module.exports = Base;
	});
	
</script>