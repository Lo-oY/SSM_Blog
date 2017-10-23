<%--
  Created by IntelliJ IDEA.
  User: liangyong
  Date: 2017/10/23
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Custom DataGrid Pager - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="../../static/jquery-easyui-1.5.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../../static/jquery-easyui-1.5.3/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../../static/css/app.css">
    <script type="text/javascript" src="../../static/jquery-easyui-1.5.3/jquery.min.js"></script>
    <script type="text/javascript" src="../../static/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../../static/js/clientPaging.js"></script>
    <title>编写博客</title>
</head>
<body>
    <div  class="easyui-panel">
        <table>
            <tr>
                <td>博客标题</td>
                <input class="easyui-textbox" name="title" id="title"/>
            </tr>
            <tr>
                <td>博客类别</td>
                <input class="easyui-textbox" name="typeId" id="titleId"/>
            </tr>
            <tr>
                <td>博客内容</td>
                <input class="easyui-textbox" name="cotent" id="cotent"/>
            </tr>
            <tr>
                <td>博客关键字</td>
                <input class="easyui-textbox" name="keywords" id="keywords"/>
            </tr>


        </table>
    </div>
</body>
</html>
