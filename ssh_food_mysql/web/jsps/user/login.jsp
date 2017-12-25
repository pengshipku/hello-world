<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <h:head>

        <title>Login In</title>

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
 
            body{
                text-align:center;
            }
            .table{
                width:1024px;
                height:10%;
                border:1px solid gray;/*固定边框,1像素*/
                border-collapse: collapse;/*单线的列表边框*/
            }
            .table td{
                border:1px solid gray;/*固定边框,1像素*/
            }
            iframe {
                width: 100%;
                height: 100%;
            }
        </style>

    </h:head>

    <body bgcolor="yellow" align="center">
        <table class="table" align="center">

            <tr style="background: #4682B4; height: 120px; ">
                <td colspan="2" align="center">
                    <iframe frameborder="0" src="<c:url value='/jsps/top.jsp'/>" name="top"></iframe>
                </td>
            </tr>
        </table>

    <tr>
        <td>
            <div align="center" >
                <h1 style=" font: 500">Login</h1>
                <p style="color: red; font-weight: 900">${msg }</p>
                <form action="<c:url value='/UserServlet'/>" method="post" target="_top">

                    <input type="hidden" name="method" value="login"/>
                    UserName：<input type="text" name="username" value="${user.username }"/>
                    <br/><br/>
                    Password：<input type="password" name="password" value="${user.password}"/>
                    <br/><br/>
                     &nbsp; &nbsp; &nbsp;<input type="submit" value="Login In"/>
                </form>
            </div>
        </td>
    </tr>


</body>
</html>
