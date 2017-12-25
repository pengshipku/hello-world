<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>Menu</title>

        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">    
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->
        <script type="text/javascript" src="<c:url value='/menu/mymenu.js'/>"></script>
        <link rel="stylesheet" href="<c:url value='/menu/mymenu.css'/>" type="text/css" media="all">
        <script language="javascript">
            var bar1 = new Q6MenuBar("bar1", "ITCAST Organic farming product online market");
            function load() {
                bar1.colorStyle = 2;
                bar1.config.imgDir = "<c:url value='/menu/img/'/>";
                bar1.config.radioButton = false;
                bar1.add("category manage", "check category", "<c:url value='/admin/AdminCategoryServlet?method=findAll'/>", "body");
                bar1.add("category manage", "add category", "<c:url value='/adminjsps/admin/category/add.jsp'/>", "body");

                bar1.add("product manage", "check products", "<c:url value='/admin/AdminBookServlet?method=findAll'/>", "body");
                bar1.add("product manage", "add product", "<c:url value='/admin/AdminBookServlet?method=preAdd'/>", "body");

                bar1.add("orders manage", "all orders", "<c:url value='/adminjsps/admin/order/list.jsp'/>", "body");
                bar1.add("orders manage", "unpay orders", "<c:url value='/adminjsps/admin/order/list_2.jsp'/>", "body");
                bar1.add("orders manage", "paied orders", "<c:url value='/adminjsps/admin/order/list_3.jsp'/>", "body");
                bar1.add("orders manage", "orders of not accept express", "<c:url value='/adminjsps/admin/order/list_4.jsp'/>", "body");
                bar1.add("orders manage", "orders of finished ", "<c:url value='/adminjsps/admin/order/list_1.jsp'/>", "body");

                var d = document.getElementById("menu");
                d.innerHTML = bar1.toString();
            }
        </script>

    </head>

    <body onload="load()" style="margin: 0px; background: rgb(254,238,189);">
        <div id="menu"></div>

    </body>
</html>
