<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>top</title>

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
                background: #33ff33;  
            }
            a {
                text-transform:none;
                text-decoration:none;
            } 
            a:hover {
                text-decoration:underline;
            }
        </style>
    </head>

    <body bgcolor="gold">
        <h1 style="text-align: center;">ORGANIC STORE</h1>
        <div style="font-size: 10pt;">
            <c:choose>
                <c:when test="${empty session_user }">
                    <a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">Login</a> |&nbsp; 
                    <a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">Register</a>|&nbsp;
                    <a href="<c:url value='/jsps/main.jsp'/>" target="_parent">Home</a>|&nbsp;
                    <a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">Master Login</a>|&nbsp;
                </c:when>
                <c:otherwise>
                    Hello：${session_user.username }&nbsp;&nbsp;|&nbsp;&nbsp;
                    <a href="<c:url value='/jsps/cart/list.jsp'/>" target="body">Shopping Cart</a>&nbsp;&nbsp;|&nbsp;&nbsp;
                    <a href="<c:url value='/OrderServlet?method=myOrders'/>" target="body">My Orders</a>&nbsp;&nbsp;|&nbsp;&nbsp;
                    <a href="<c:url value='/UserServlet?method=quit'/>" target="_parent">Login Out</a>
                    <br/>
                </c:otherwise>
            </c:choose>
        </div>
    </body>
</html>
