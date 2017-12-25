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
                    orders：8691b4150a0641e7a8729fd5e668820c　the deal time：2016-12-22 15:56:53　sum：<font color="red"><b>126.4</b></font>	have accepted the express（finish）
                </td>
            </tr>
            <tr bordercolor="rgb(78,78,78)" align="center">
                <td width="15%">
                    <div><img src="<c:url value='/farming products_img/5.JPG'/>" height="75"/></div>
                </td>
                <td>product name：red bean</td>
                <td>unit price：63.2$</td>
                <td>seller：孙鑫</td>
                <td>amount：2</td>
                <td>subtotal：126.4$</td>
            </tr>




            <tr bgcolor="rgb(78,78,78)" bordercolor="rgb(78,78,78)" style="color: white;">
                <td colspan="6">
                    orders：153839427aa94f359fe51932d9f9e383　the deal time：2016-12-23 15:02:31　sum：<font color="red"><b>63.2</b></font>　
                    <a href="javascript:alert('deliveried successfully！')">Have deliveried</a>
                </td>
            </tr>
            <tr bordercolor="rgb(78,78,78)" align="center">
                <td width="15%">
                    <div><img src="<c:url value='/farming products_img/4.JPG'/>" height="75"/></div>
                </td>
                <td>product name：cabbage</td>
                <td>unit price：63.2$</td>
                <td>seller：陈华雄</td>
                <td>amount：1</td>
                <td>subtotal：63.2$</td>
            </tr>




            <tr bgcolor="rgb(78,78,78)" bordercolor="rgb(78,78,78)" style="color: white;">
                <td colspan="6">
                    order：d1b85bfc71564b18bf7802582a9fd934　the deal time：2016-12-21 15:01:01　sum：<font color="red"><b>137.0</b></font>	have accepted the express（finish）
                </td>
            </tr>
            <tr bordercolor="rgb(78,78,78)" align="center">
                <td width="15%">
                    <div><img src="<c:url value='/farming products_img/3.JPG'/>" height="75"/></div>
                </td>
                <td>product name：carrot</td>
                <td>unit price：68.5$</td>
                <td>seller：qdmmy6</td>
                <td>amount：2</td>
                <td>subtotal：137.0$</td>
            </tr>



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
