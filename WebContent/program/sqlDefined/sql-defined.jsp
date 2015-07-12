<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/context.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${ctx}/component/LigerUI/Source/lib/ligerUI/skins/Aqua/css/ligerui-all.css"></link>
<%@ include file="/common/custom.jsp"%>
<title>${title}</title>
</head>
<body>
	<div id="dataGrid" style="margin: 0px; padding: 0px;"></div>
	<div style="display: none;"></div>
	<div id="joinCondition" name="joinCondition"></div>
	<div id="showColumn" name="showColumn"></div>
	<div id="whereCondition" name="whereCondition"></div>
	<!--  添加表格	 -->
	<div id="tableAdd" name="tableAdd" style="margin: 0px; padding: 0px;display: none;"></div>
</body>
<script src="${ctx}/program/sqlDefined/js/sql-defined.js" type="text/javascript"></script>
<script type="text/javascript">
	// 	seajs.use([ '../custom/js/add-role' ]);//这句会把js引入
	seajs.use([ 'sql-defined' ]);
</script>
</html>