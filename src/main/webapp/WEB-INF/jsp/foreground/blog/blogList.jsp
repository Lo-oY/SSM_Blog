<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<div class="col-md-8">
    <div class='blog_list'>
        <c:forEach items="${postList}" var="post">
            <div class="blogs">
                <ul>
                    <h3>${post.title}</h3>
                    <p>${fn:substring(post.cotent,0,100 )}...</p>
                    <div class="author">
                        <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
                        <span><fmt:formatDate value="${post.postTime }" type="date" pattern="yyyy-MM-dd HH:mm"/></span>
                        <span class="glyphicon glyphicon-folder-open" aria-hidden="true"></span>
                        <span>${post.postType.name}</span>
                        <span class="glyphicon glyphicon-tag" aria-hidden="true"></span>
                        <span>${post.keywords}</span>

                    </div>
                </ul>
            </div>
        </c:forEach>
    </div>
</div>