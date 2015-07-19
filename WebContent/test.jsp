<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/context.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Metronic | Admin Dashboard Template</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="../../../fonts.googleapis.com/css-family=Open+Sans-400,300,600,700&subset=all" tppabs="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=all" rel="stylesheet" type="text/css"/>
<link href="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/plugins/font-awesome/css/font-awesome.min.css" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/plugins/bootstrap/css/bootstrap.min.css" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/plugins/uniform/css/uniform.default.css" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL PLUGIN STYLES -->
<link href="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/plugins/gritter/css/jquery.gritter.css" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/plugins/gritter/css/jquery.gritter.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/plugins/bootstrap-daterangepicker/daterangepicker-bs3.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/plugins/fullcalendar/fullcalendar/fullcalendar.css" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/plugins/fullcalendar/fullcalendar/fullcalendar.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/plugins/jqvmap/jqvmap/jqvmap.css" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/plugins/jqvmap/jqvmap/jqvmap.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/plugins/jquery-easy-pie-chart/jquery.easy-pie-chart.css" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/plugins/jquery-easy-pie-chart/jquery.easy-pie-chart.css" rel="stylesheet" type="text/css"/>
<!-- END PAGE LEVEL PLUGIN STYLES -->
<!-- BEGIN THEME STYLES -->
<link href="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/css/style-metronic.css" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/css/style-metronic.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/css/style.css" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/css/style.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/css/style-responsive.css" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/css/style-responsive.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/css/plugins.css" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/css/plugins.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/css/pages/tasks.css" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/css/pages/tasks.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/css/themes/default.css" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color"/>
<link href="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/css/print.css" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/css/print.css" rel="stylesheet" type="text/css" media="print"/>
<link href="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/css/custom.css" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/css/custom.css" rel="stylesheet" type="text/css"/>
<!-- END THEME STYLES -->
<link rel="shortcut icon" href="favicon.ico" tppabs="http://www.keenthemes.com/preview/metronic_admin/favicon.ico"/>

<script type="text/javascript">
	var ctx = "${ctx}";
</script>
</head>

<!-- BEGIN BODY -->
<body class="login">

<div class="page-container">
	<!-- BEGIN SIDEBAR -->
	<div class="page-sidebar-wrapper">
		<div class="page-sidebar navbar-collapse collapse" id="menu">
		</div>
	</div>
</div>


<!-- END COPYRIGHT -->
<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
<!-- BEGIN CORE PLUGINS -->
<!--[if lt IE 9]>
	<script src="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/plugins/respond.min.js"></script>
	<script src="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/plugins/excanvas.min.js"></script> 
	<![endif]-->
<script src="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/plugins/jquery-1.10.2.min.js" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/plugins/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/plugins/jquery-migrate-1.2.1.min.js" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
<script src="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/plugins/bootstrap/js/bootstrap.min.js" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/plugins/bootstrap-hover-dropdown/bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/plugins/jquery.blockui.min.js" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/plugins/jquery.cokie.min.js" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/plugins/uniform/jquery.uniform.min.js" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script src="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/plugins/jquery-validation/dist/jquery.validate.min.js" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/plugins/jquery-validation/dist/jquery.validate.min.js" type="text/javascript"></script>
<script type="text/javascript" src="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/plugins/select2/select2.min.js" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/plugins/select2/select2.min.js"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/scripts/core/app.js" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/scripts/core/app.js" type="text/javascript"></script>
<script src="${ctx}/component/MetroNic_2.0.2-bootstrap3.1.1/assets/scripts/custom/login.js" tppabs="http://www.keenthemes.com/preview/metronic_admin/assets/scripts/custom/login.js" type="text/javascript"></script>
<!-- END PAGE LEVEL SCRIPTS -->
<script>
		jQuery(document).ready(function() {     
		  App.init();
		  Login.init();
		});
	</script>
<!-- END JAVASCRIPTS -->
<script type="text/javascript">  var _gaq = _gaq || [];  _gaq.push(['_setAccount', 'UA-37564768-1']);  _gaq.push(['_setDomainName', 'keenthemes.com']);  _gaq.push(['_setAllowLinker', true]);  _gaq.push(['_trackPageview']);  (function() {    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;    ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);  })();</script></body>
<!-- END BODY -->

<script type="text/javascript" src="${ctx}/js/jQuery-menu.js">
</script>

<script type="text/javascript">
$("#menu").menu({
	url: ctx + '/auth/loadNavigation.do',
	param:{parentId:25,type:2},
	ctx:ctx
});

var menu = $("#menu");
menu.append("<div> dereadf </div>");
console.log(menu);
</script>
</body>
</html>