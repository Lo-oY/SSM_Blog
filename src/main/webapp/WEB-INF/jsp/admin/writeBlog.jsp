<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: liangyong
  Date: 2017/10/23
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Custom DataGrid Pager - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="../../static/jquery-easyui-1.5.3/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="../../static/jquery-easyui-1.5.3/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="../../static/css/app.css">
    <script type="text/javascript" src="../../static/jquery-easyui-1.5.3/jquery.min.js"></script>
    <script type="text/javascript" src="../../static/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="../../static/js/clientPaging.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="../../static/ueditor1_4_3_3/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="../../static/ueditor1_4_3_3/ueditor.all.min.js">
    </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8"
            src="../../static/ueditor1_4_3_3/lang/zh-cn/zh-cn.js"></script>
    <%--<script src="/admin/globalVariableServlet"/>--%>
    <title>编写博客</title>
</head>
<body>
<div id="p" class="easyui-panel" title="编写博客" style="padding: 10px;">

    <table cellspacing="20px">
        <tr>
            <td width="80px">博客标题：</td>
            <td><input type="text" id="title" name="title" style="width:400px"/></td>
        </tr>
        <tr>
            <td>所属类别：</td>
            <%--<td><select id="blogTypeId" class="easyui-combobox"--%>
            <%--name="blogType.id" style="width:154px" editable="false"--%>
            <%--panelHeight="auto">--%>
            <%--<option value="">请选择博客类别...</       option>--%>
            <%--<c:forEach items="${postTypeList }" var="postType">--%>
            <%--<option value="${postType.id }">${postType.name }</option>--%>
            <%--</c:forEach>--%>
            <%--</select></td>--%>
            <td>
                <input class="easyui-combobox"
                       type="text"
                       name="blogTypeId"
                       id="blogTypeId"
                       data-options="
					url:'/postType/listAll.json',
					method:'get',
					valueField:'id',
					textField:'name',
					panelHeight:'auto'
			">
            </td>
        </tr>
        <tr>
            <td align="top">博客内容：</td>
            <td>
                <script id="editor" name="content" type="text/plain"
                        style="width:95%; height:300px;"></script>
            </td>
        </tr>
        <tr>
            <td>关键字：</td>
            <td><input type="text" id="keywords" name="keywords"
                       style="width:400px"/>&nbsp;&nbsp;&nbsp;多个关键字的话请用空格隔开
            </td>
        </tr>
        <tr>
            <td></td>
            <td><a href="javascript:submitData()" class="easyui-linkbutton"
                   data-options="iconCls:'icon-submit'">发布博客</a></td>
        </tr>
    </table>
</div><!-- 实例化编辑器 -->
<script type="text/javascript">
    var ue = UE.getEditor('editor');
</script>
<script type="text/javascript">
    function submitData() {
        var title = $("#title").val();
        var blogTypeId = $("#blogTypeId").combobox("getValue");
        var content = UE.getEditor('editor').getContent();
        var keywords = $("#keywords").val();

        if (title == null || title == '') {
            $.messager.alert("系统提示", "请输入标题！");
        } else if (blogTypeId == null || blogTypeId == '') {
            $.messager.alert("系统提示", "请选择博客类型！");
        } else if (content == null || content == '') {
            $.messager.alert("系统提示", "请编辑博客内容！");
        } else {
            $.post("/post/save",
                    {
                        'title': title,
                        'postType.id': blogTypeId,
                        'content': content,
                        'keywords': keywords,
                    }, function (result) {
                        if (result.success) {
                            $.messager.alert("系统提示", "博客发布成功！");
                            clearValues();
                        } else {
                            $.messager.alert("系统提示", "博客发布失败！");
                        }
                    }, "json");
        }
    }
    function clearValues() {
        $("#title").val("");
        $("#blogTypeId").combobox("setValue", "");
        UE.getEditor("editor").setContent("");
        $("#keyWord").val("");
    }
</script>
</body>
</html>
