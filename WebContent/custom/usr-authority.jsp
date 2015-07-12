<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/context.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${ctx}/component/LigerUI/Source/lib/ligerUI/skins/Aqua/css/ligerui-all.css"></link>
<link rel="stylesheet" type="text/css" href="${ctx}/component/jquery-ui-1.10.4.custom/css/ui-lightness/jquery-ui-1.10.4.custom.min.css"></link>
<%@ include file="/common/custom.jsp"%>
<title>${title}</title>
<style type="text/css">
body {
	padding: 5px;
	margin: 0;
	padding-bottom: 15px;
}

#layout {
	width: 100%;
	margin: 0;
	padding: 0;
}

.l-page-top {
	height: 80px;
	background: #f8f8f8;
	margin-bottom: 3px;
}

h4 {
	margin: 20px;
}
</style>
</head>
<body >
	<div name="layout" id="layout" style="width:100%;height:100%;">
		<!-- <div position="left">
			<div id="treeGrid" name ="treeGrid"></div>
		</div> -->
		<div position="center" title="用户权限管理">
			<div id="subLayout" name="subLayout">
				<div position="center">
					<div name="roleList" id="roleList"></div>
				</div>
				<div position="bottom">
					
					<div id="operationLayout" name="operationLayout">
						<div position="left" title="功能菜单">
							<div name="urlList" id="urlList"></div>
						</div>
						<div position="right" title="权限">
							<div name="authorityList" id="authorityList"></div>
						</div>
					</div>
				</div>
			</div>
			
		</div>
	</div>
</body>
<script src="${ctx}/custom/js/usr-authority.js" type="text/javascript"></script>
<script src="${ctx}/custom/js/authority.js" type="text/javascript"></script>

<script type="text/javascript">
	// 	seajs.use([ '../custom/js/user-list' ]);//这句会把js引入
	seajs.use([ 'usr-authority' ]);
</script>
</html>