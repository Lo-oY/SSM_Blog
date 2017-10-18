<%--
  Created by IntelliJ IDEA.
  User: liangyong
  Date: 2017/10/17
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Basic Layout - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="../../static/jquery-easyui-1.3.5/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../../static/jquery-easyui-1.3.5/themes/icon.css">
    <script type="text/javascript" src="../../static/jquery-easyui-1.3.5/jquery.min.js"></script>
    <script type="text/javascript" src="../../static/jquery-easyui-1.3.5/jquery.easyui.min.js"></script>
    <style>
        * {
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body class="easyui-layout" data-options="fit:true">
<div data-options="region:'north'" style="height: 50px;background-color: #e0ecff;border: none"></div>
<div data-options="region:'south',split:false" style="height:50px;background-color: #e0ecff;border: none;"></div>
<div data-options="region:'west',split:false" title="West" style="width:200px; height: 100%">
    <div class="easyui-accordion">
        <div title="About Accordion" iconCls="icon-ok" style="overflow:auto;padding:10px;">
            <h3 style="color:#0099FF;">Accordion for jQuery</h3>
            <p>Accordion is a part of easyui framework for jQuery. It lets you define your accordion component on web
                page more easily.</p>
        </div>
        <div title="About easyui" iconCls="icon-reload" selected="true" style="padding:10px;">
            easyui help you build your web page easily
        </div>
    </div>
</div>
<div data-options="region:'center',iconCls:'icon-ok'">
    <iframe src="index_2.html" width="100%" height="100%"/>
</div>

</body>
</html>