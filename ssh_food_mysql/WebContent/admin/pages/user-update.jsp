<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<form action="userUpdate.action" method="post" >
	
		<input type="hidden" name="page" value="${param.page}"/>

		<input type="hidden" name="user.id" value="${user.id}"/>
		<input type="hidden" name="user.username" value="${user.username}"/>
		<input type="hidden" name="user.password" value="${user.password}"/>
		
		Name：${user.username}<br>
		Telephone：<input type="text" name="user.phone" value="${user.phone}" required="required"/>
		<input type="submit" value="Modify"/><s:actionerror/>
		
	</form>
	
</body>
</html>
