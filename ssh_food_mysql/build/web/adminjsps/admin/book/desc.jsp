<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'bookdesc.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
		font-size: 10pt;
		background: rgb(254,238,189);
	}
	div {
		margin:20px;
		border: solid 2px gray;
		width: 150px;
		height: 150px;
		text-align: center;
	}
	li {
		margin: 10px;
	}
</style>
  </head>
  <script type="text/javascript">
  function setMethod(method){
  	document.getElementById("method").value=method;
  }
  </script>
  <body>
  <div>
    <img src="<c:url value='/${book.image }'/>" border="0"/>
  </div>
  <form style="margin:20px;" id="form" action="<c:url value='/admin/AdminBookServlet'/>" method="post">
  	<input type="hidden" name="method" value="" id="method"/>
  	<input type="hidden" name="bid" value="${book.bid }"/>
  	product name：<input type="text" name="bname" value="${book.bname }"/><br/>
  	unit price：<input type="text" name="price" value="${book.price }"/>$<br/>
  	seller：<input type="text" name="author" value="${book.author }"/><br/>
  	category：<select style="width: 150px; height: 20px;" name="cid">
  		<c:forEach items="${categoryList }" var="c">
  		<option value="${c.cid }" <c:if test="${book.category.cid eq c.cid }">selected="selected"</c:if>>${c.cname }</option>
  		</c:forEach>
			
    	</select><br/>
  	<input type="submit" name="method" value="del" onclick="setMethod('delete');return confirm('are you sure t delete the product?');"/>
  	<input type="submit" name="method" value="mod" onclick="setMethod('edit');"/>
  </form>
  </body>
</html>
