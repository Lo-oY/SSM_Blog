<%--
  Created by IntelliJ IDEA.
  User: liangyong
  Date: 2017/10/16
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="UTF-8" http-equiv="content-type" content="text/html"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="../static/bootstrap3/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <!--   <link rel="stylesheet" href="static/bootstrap3/css/bootstrap.min.css"> -->
    <link rel="stylesheet" href="../static/bootstrap3/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="../static/css/blog.css">
    <script src="../static/bootstrap3/js/jquery-3.1.0.min.js"></script>
    <script src="../static/bootstrap3/js/bootstrap.min.js"></script>
    <title>播客主页</title>
</head>
<body>
<div class="container" style="width:70%;margin-top:20px">
    <div class="row">
        <jsp:include page="common/header.jsp"/>
    </div>
    <div class="row">
        <jsp:include page="common/nav.jsp"/>
    </div>
    <div class="row">
        <div class="col-md-8">
            <jsp:include page="foreground/blog/blogList.jsp"/>
        </div>
        <div class="col-md-4 left">
            <jsp:include page="foreground/blog/blogRigth.jsp"/>
        </div>
    </div>
    <div class="row">
        <jsp:include page="common/footer.jsp"/>
    </div>
</div>
</body>
</html>
