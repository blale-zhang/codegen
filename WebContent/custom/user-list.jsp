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
	<div id="form" class="liger-form l-form">
	</div>
	<div class="l-loading" id="pageloading" style="display: block;">
	</div>
	<div id="dataGrid" style="margin: 0px; padding: 0px;"></div>
	<div style="display: none;"></div>
</body>
<script src="${ctx}/custom/js/user-list.js" type="text/javascript"></script>
<script type="text/javascript">
	// 	seajs.use([ '../custom/js/user-list' ]);//这句会把js引入
	seajs.use([ 'user-list' ]);
</script>
</html>