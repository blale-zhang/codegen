<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/context.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/common/custom.jsp"%>
<title>${title}</title>
</head>
<body>
	<form action="${ctx}/helloworld/fileUpload.do" method="POST"
		enctype="multipart/form-data">
		<table>
						<tbody name="template">
				<tr>
					<td><input name="userName" type="text"></input></td>
					<td><input type="password" name="password"></input></td>
				</tr>
				<tr>
					<td><input type="file" name="myfiles"></input></td>
					<td><input type="button" value="-" name="remove"></input><input
						type="button" value="+" name="add"></input></td>
				</tr>
			</tbody>
			<tbody name="template">
				<tr>
					<td><input name="userName" type="text"></input></td>
					<td><input type="password" name="password"></input></td>
				</tr>
				<tr>
					<td><input type="file" name="myfiles"></input></td>
					<td><input type="button" value="-" name="remove"></input><input
						type="button" value="+" name="add"></input></td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="添加新用户" />
	</form>
</body>
<script src="${ctx}/custom/js/file-upload.js" type="text/javascript"></script>
<script type="text/javascript">
	// 	seajs.use([ '../custom/js/user-list' ]);//这句会把js引入
	seajs.use([ 'file-upload' ]);
</script>
</html>