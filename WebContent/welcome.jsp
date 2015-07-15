<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${ctx}/component/jquery-ui-1.10.4.custom/css/ui-lightness/jquery-ui-1.10.4.custom.min.css"></link>
<%@ include file="/common/custom.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctx}/css/base.css"></link>
<link rel="stylesheet" type="text/css" href="${ctx}/css/layout.css"></link>
<title>布局练习</title>
</head>
<body>

	<div name="head" class="head">这是头部</div>

	<div name="left" class="left">
		<!-- 这是左部，css2的 display:inline;与 float:left 好似有些区别，在试验的过程中，inline宽度以文字宽为准 
		而float:left;则是以width.-->
		<div id='accordionContainer'>
			<h3>设计管理</h3>
			<div>
				<p>你有重要消息未查看！</p>
			</div>
			<h4>后台管理</h4>
			<div>
				<p></p>
			</div>
			<!-- <h4>Section 3</h4>
			<div>
				<p></p>
				<ul>
					<li>List item one</li>
					<li>List item two</li>
					<li>List item three</li>
				</ul> 
			</div>-->
		</div>
		<div id="datepicker"></div>
	</div>
	<div name="center" class="center">

		<div id="tabs">
			<ul>
				<li><a href="#fragment-1">One</a></li>
				<li><a href="#fragment-2">Two</a></li>
				<li><a href="#fragment-3">Three</a></li>
			</ul>
			<div id="fragment-1">Lorem ipsum dolor sit amet, consectetuer
				adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet
				dolore magna aliquam erat volutpat.Lorem ipsum dolor sit amet, consectetuer
				adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet
				dolore magna aliquam erat volutpat.Lorem ipsum dolor sit amet, consectetuer
				adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet
				dolore magna aliquam erat volutpat.</div>
			<div id="fragment-2">Lorem ipsum dolor sit amet, consectetuer
				adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet
				dolore magna aliquam erat volutpat.</div>
			<div id="fragment-3">Lorem ipsum dolor sit amet, consectetuer
				adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet
				dolore magna aliquam erat volutpat.</div>
		</div>

	</div>
	<div name="foot" class="foot">底部</div>
</body>

<script type="text/javascript" src="${ctx}/js/layout.js">
	
</script>
<script type="text/javascript">
	// 加载一个模块，在加载完成时，执行回调
	seajs.use([ 'layout' ]);
</script>
</html>