<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<form action="<s:url value="/admin/adminAdd.action"/>" method="post" >

		Name：<input type="text" name="admin.username" required="required"/><br>
		Password：<input type="text" name="admin.password" required="required"/>
		
		<input type="submit" value="Add"/>
		
	</form><s:actionerror/>
	
</body>
</html>
