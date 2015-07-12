<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/context.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${ctx}/component/LigerUI/Source/lib/ligerUI/skins/Aqua/css/ligerui-all.css"></link>
<link rel="stylesheet" type="text/css"
	href="${ctx}/component/jquery-ui-1.10.4.custom/css/ui-lightness/jquery-ui-1.10.4.custom.min.css"></link>
<%@ include file="/common/custom.jsp"%>
<title>${title}</title>
</head>
<body>
	<div id="layout" style="width: 100%; height: 100%;">
		<div position="top">
		</div>
		<div position="left">
			<div id="treeGrid" name="treeGrid"></div>
		</div>
		<div position="center" title="用户权限管理"></div>
		<div position="right" title="权限"></div>
		<div position="bottom"></div>
	</div>
</body>
<script src="${ctx}/custom/js/sys-main.js" type="text/javascript"></script>

<script type="text/javascript">
	// 	seajs.use([ '../custom/js/user-list' ]);//这句会把js引入
	seajs.use([ 'sys-main' ]);
</script>
</html>