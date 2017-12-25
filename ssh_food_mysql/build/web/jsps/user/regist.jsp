<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>

        <title>Register</title>

        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">    
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <meta http-equiv="content-type" content="text/html;charset=utf-8">
        <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->
        <style>

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

    </head>

    <body align="center" bgcolor="yellow">
        <table class="table" align="center">

            <tr style="background: #4682B4; height: 120px; ">
                <td colspan="2" align="center">
                    <iframe frameborder="0" src="<c:url value='/jsps/top.jsp'/>" name="top"></iframe>
                </td>
            </tr>
             </table>

            <tr>
                <td align="center" >
                    
                        <h1>Register</h1>
                        <p style="color: red; font-weight: 900">${msg }</p>
                        <form action="<c:url value='/UserServlet'/>" method="post">
                            <input type="hidden" name="method" value="regist"/>
                            UserName：<input type="text" name="username" value="${user.username }"/>
                            <font color="red">${errors.username }</font>
                            <br/><br/>
                            
                            Password：<input type="password" name="password" value="${user.password }"/>
                            <font color="red">${errors.password }</font>
                            <br/><br/>
                            
                            Email：&nbsp;<input type="text" name="email" value="${user.email }"/>
                            <font color="red">${errors.email }</font>
                            <br/><br/>
                            
                             &nbsp; &nbsp; &nbsp;<input type="submit" value="Register"/>
                        </form>
                    </div>
                </td>
            </tr>
       
    </body>
</html>
