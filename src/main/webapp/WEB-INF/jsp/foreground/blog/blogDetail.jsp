<%--
  Created by IntelliJ IDEA.
  User: cilu
  Date: 2017/11/1
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ page import="com.ly.pojo.Comment" %>
<%@ page import="com.ly.pojo.Post" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<link rel="stylesheet" href="../../../static/css/blogDetail.css">
<script type="text/javascript">
//    SyntaxHighlighter.all();

    function loadimage() {
        document.getElementById("randImage").src = "http://localhost:8080/image?" + Math.random();
    }

    function submitData() {
        var imageCode = $("#imageCode").val();
        var content = $("#content").val();
        if (content == null || content == "") {
            alert("请输入评论内容");
        } else if (imageCode == null || imageCode == "") {
            alert("请填写验证码");
        } else {
            $.post("${pageContext.request.contextPath}/post/saveComment",
                    {"content": content, "imageCode": imageCode, "postId": "${post.id}"},
                    function (result) {
                        if (result.code == 0) {
                            alert("评论已提交成功，博主审核后添加");
                            window.location.reload();
                        } else {
                            alert(result.errorInfo);
                        }
                    }, "json");
        }
    }
</script>

<div class="data_list">
    <div class="data_title">
        博客信息
    </div>
    <div>
        <div class="post_title">
            <h3>
                <strong>${post.title}</strong>
            </h3>
        </div>
        <div class="post_info">
            <div style="float: left">
                <strong>标签</strong>： ${post.keywords}

            </div>
            <div style="float: right">
                发布于：<fmt:formatDate value="${post.postTime}" type="date" pattern="yyyy-MM-dd HH:mm"/> &nbsp;&nbsp;&nbsp;&nbsp;博客类别：<a
                    href="/postType/{post.postType.id}">${post.postType.name} </a> 阅读(16) 评论(10)
            </div>
        </div>
        <!-- <div style="clear: both"/> -->
        <br/>
        <div class="line"></div>
        <div class="post_content">
            ${post.content}
        </div>
        <div class="line"></div>
        <div>${pageCode}</div>
    </div>
</div>

<div class="data_list">
    <div class="data_title">
        评论内容
    </div>
    <div>
        <div class="comment_data">
            <ul>
                <c:choose>
                    <c:when test="${post.comments.size() == 0}">
                        暂无评论
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="comment" items="${post.comments}" varStatus="status">
                            <%--${post.comments.size()}--%>
                            <div class="comment">
                               	<span><font>
                                        ${status.index+1}楼&nbsp;&nbsp;&nbsp;&nbsp;${comment.userIp }</font>
										&nbsp;&nbsp;&nbsp;&nbsp;${comment.commentContent }&nbsp;&nbsp;&nbsp;&nbsp;
										[<fmt:formatDate value="${comment.commentDate }" type="date"
                                                         pattern="yyyy-MM-dd HH:mm" />] </span>
                            </div>

                        </c:forEach>
                    </c:otherwise>
                </c:choose>


            </ul>
        </div>
    </div>
</div>

<div class="data_list">
    <div class="data_title">
        发表评论
    </div>
    <div class="publish_comment">
        <div>
            <textarea style="width: 100%" rows="3" id="content" name="content" placeholder="来说两句吧..."></textarea>
        </div>
        <div class="verCode">
            验证码:<input type="text" name="imageCode" id="imageCode"/>
            <img onclick="javascript:loadimage();" name="randImage" id="randImage" title="换一张试试"
                 src="/image"/>
        </div>
        <div class="publishButton">
            <button class="btn btn-primary" type="button" onclick="submitData()">发表评论</button>
        </div>
    </div>
</div>
