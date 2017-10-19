<%@ page import="com.ly.pojo.Resource" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: liangyong
  Date: 2017/10/17
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Basic Layout - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="../../static/jquery-easyui-1.5.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../../static/jquery-easyui-1.5.3/themes/icon.css">
    <script type="text/javascript" src="../../static/jquery-easyui-1.5.3/jquery.min.js"></script>
    <script type="text/javascript" src="../../static/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
    <script>
        var tabSize = 0;
        function addPanel(index, title, url) {

            var tabs = $("#tabs");
            if (tabs.tabs('exists', title)) {
                tabs.tabs('select', title);
            } else {
                var content = "<div style='width: 100%;height: 100%;' id='" + index + "'><iframe id='iframe_ " + index + " ' width='100%' src='" + url + "' height='100%' frameborder='0'/></div>";
                tabs.tabs('add', {title: title, content: content, closable: true});
            }

        }
    </script>
</head>
<body class="easyui-layout" data-options="fit:true">

<div data-options="region:'north',border:false" style="height: 50px;background-color: #e0ecff;"></div>
<div data-options="region:'south',border:false" style="height:50px;background-color: #e0ecff;"></div>
<div class="easyui-panel" data-options="region:'west',multiple:false,spilt:true,title:'我的菜单'" style="width: 150px">
    <div class="easyui-accordion" data-options="fit:true">
        <c:forEach var="menu" items="${menuList}">
            <div title="${menu.title}" data-options="iconCls:'icon-add'  " style="padding: 10px;width: 100%">
                <c:forEach var="resource" items="${menu.resources}">
                    <p>
                        <a href="javascript:void(0);"
                           onclick="addPanel(${resource.id},'${resource.description}','${resource.name}')"
                           class="easyui-linkbutton"
                           style="padding: 2px;width: 100%;">
                            <span>${resource.description}</span>
                        </a>
                    </p>
                </c:forEach>
            </div>
        </c:forEach>
    </div>

</div>
<div class="easyui-panel" data-options="region:'center'" style="width: 150px">
    <div id="tabs" data-options="fit:true,onAdd:function(t,i){tabSize++;},onClose:function(t,i){tabSize--;}"
         class="easyui-tabs" style="width: 100%;">
    </div>
</div>
</body>

</html>