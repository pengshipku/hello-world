<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<form action="userReset.action" method="post" >

		<input type="hidden" name="user.id" value="${user.id}"/>
		
		Name: ${user.username}<br>
		Password：<input type="text" name="user.password" value="" required="required"/>
		
		<input type="submit" value="Reset"/><s:actionerror/>
		
	</form>
	
</body>
</html>
