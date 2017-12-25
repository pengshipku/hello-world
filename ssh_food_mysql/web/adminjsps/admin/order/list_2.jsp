<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>the list of orders </title>

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
            * {
                font-size: 11pt;
            }
            div {
                border: solid 2px rgb(78,78,78);
                width: 75px;
                height: 75px;
                text-align: center;
            }
            li {
                margin: 10px;
            }
        </style>
    </head>

    <body style="background: rgb(254,238,189);">
        <h1>my orders</h1>

        <table border="1" width="100%" cellspacing="0" background="black">






            <tr bgcolor="rgb(78,78,78)" bordercolor="rgb(78,78,78)" style="color: white;">
                <td colspan="6">
                    orders：o1　the deal time：2016-12-23 12:47:41　sum：<font color="red"><b>100.0</b></font>　unpaid
                </td>
            </tr>
            <tr bordercolor="rgb(78,78,78)" align="center">
                <td width="15%">
                    <div><img src="<c:url value='/farming products_img/2.JPG'/>" height="75"/></div>
                </td>
                <td>product name：tomato</td>
                <td>unit price：75.6$</td>
                <td>seller：qdmmy6</td>
                <td>amount：2</td>
                <td>subtotal：300.0$</td>
            </tr>
            <tr bordercolor="rgb(78,78,78)" align="center">
                <td width="15%">
                    <div><img src="<c:url value='/farming products_img/1.JPG'/>" height="75"/></div>
                </td>
                <td>product name：eggplant</td>
                <td>unit price：68.5$</td>
                <td>seller：qdmmy6</td>
                <td>amount：3</td>
                <td>subtotal：500.0$</td>
            </tr>
        </table>
    </body>
</html>
