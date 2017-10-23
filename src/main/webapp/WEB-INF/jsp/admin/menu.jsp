<%--
  Created by IntelliJ IDEA.
  User: cilu
  Date: 2017/10/19
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Custom DataGrid Pager - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="../../static/jquery-easyui-1.5.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../../static/jquery-easyui-1.5.3/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../../static/css/app.css">
    <script type="text/javascript" src="../../static/jquery-easyui-1.5.3/jquery.min.js"></script>
    <script type="text/javascript" src="../../static/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../../static/js/app.js"></script>
    <script type="text/javascript" src="../../static/js/clientPaging.js"></script>
    <script>
        $(function () {
            console.log("test");
            datagrid_clientPaging('#dg','#pager-btns');
        });
    </script>
</head>
<body>
<table id="dg" class="easyui-datagrid"
       data-options="
       animate:true,
       fitColumns:false,
       autoRowHeight:false,
       selectOnCheck:true,
       checkOnSelect:true,
       singleSelect:false,
       pagination:true,
       pageSize:10,
       url:'/admin/menu/listMenu.json',method:'get'">
    <thead>
    <tr>
        <th field="ck" checkbox="true"></th>
        <th data-options="field:'id'">菜单编号</th>
        <th data-options="field:'title'">菜单名</th>
        <th data-options="field:'description'">描述</th>
        <th data-options="field:'orderid'">排序编号</th>
        <th data-options="field:'op',width:100">操作</th>
    </tr>
    </thead>
</table>

<div id="pager-btns">
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true"></a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true"></a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true"></a>
</div>
</body>
</html>
