<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/context.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/common/custom.jsp"%>

<link rel="stylesheet" type="text/css" href="${ctx}/component/zTree_v3/css/demo.css"></link>
<link rel="stylesheet" type="text/css" href="${ctx}/component/zTree_v3/css/zTreeStyle/zTreeStyle.css"></link>
<%-- <script src="${ctx}/component/bootmetro-0.9.0/scripts/jquery-1.8.3.min.js" type="text/javascript"></script> --%>
<script type="text/javascript" src="${ctx}/component/zTree_v3/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${ctx}/component/zTree_v3/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="${ctx}/component/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="${ctx}/component/zTree_v3/js/jquery.ztree.exedit-3.5.js"></script>
<%-- <script src="${ctx}/component/zTree_v3/js/jquery.ztree.all-3.5.js" type="text/javascript"></script> --%>
<script src="${ctx}/program/js/package-defined.js" type="text/javascript"></script>
<style type="text/css">
	.ztree li span.button.add {margin-left:2px; margin-right: -1px; background-position:-144px 0; vertical-align:top; *vertical-align:middle}
</style>
<title>包定义</title>
</head>
<body>
	<div name="form">
		<input type="button" name="submit" id="submit" value="更新"></input> 
	
	</div>
	<div name="packageTree"><ul id="treeDemo"  class="ztree" ></div>
</body>
</html>