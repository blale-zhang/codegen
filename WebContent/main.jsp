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
	<div name="layout" id="layout" style="width: 100%; height: 100%;">
		<div position="left">
			<div id="accordion">
				<div title="功能列表">
				</div>
				<div title="列表">
				</div>
				<div title="其他" style="padding: 10px">其他内容</div>
			</div>
		</div>
		<div position="center" id="center" style="width: 100%; height: 100%;" ></div>
	</div>
</body>
<script src="${ctx}/js/main.js" type="text/javascript"></script>

<script type="text/javascript">
	// 	seajs.use([ '../custom/js/user-list' ]);//这句会把js引入
	seajs.use([ 'main' ]);
</script>
</html>