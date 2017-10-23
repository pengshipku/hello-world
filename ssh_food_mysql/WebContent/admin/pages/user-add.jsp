<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<form action="<s:url value="/admin/userAdd.action"/>" method="post" >

		Name：<input type="text" name="user.username" required="required"/><br>
		Password：<input type="text" name="user.password" required="required"/><br>
		Telephone：<input type="text" name="user.phone"/>
		
		<input type="submit" value="Add"/>
		
	</form><s:actionerror/>
	
</body>
</html>
