<%--
  Created by IntelliJ IDEA.
  User: liangyong
  Date: 2017/10/17
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理员登陆</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        body {
            background: #E9E9E9;
        }

        #login {
            width: 400px;
            height: 250px;
            background: #FFF;
            margin: 200px auto;
            position: relative;
        }

        #login h1 {
            text-align: center;
            position: absolute;
            left: 120px;
            top: -40px;
            font-size: 21px;
        }

        #login form p {
            text-align: center;
        }

        #name, #password {
            width: 200px;
            height: 30px;
            border: solid #ccc 1px;
            border-radius: 3px;
            margin-bottom: 30px;
            padding-left: 32px;
        }

        #name {
            background: url(../../static/img/user.png) rgba(0, 0, 0, .1) no-repeat;
            margin-top: 50px;
        }

        #password {
            background: url(../../static/img/pwd.png) rgba(0, 0, 0, .1) no-repeat;
        }

        #submit {
            width: 232px;
            height: 30px;
            background: rgba(0, 0, 0, .1);
        }
    </style>
</head>
<body>
<div id="login">
    <h1>管理员登陆</h1>
    <form id="login-form" action="/admin/login" method="post">
        <p><input id="name" type="text" name="name"></p>
        <p><input id="password" type="password" name="password"></p>
        <p><input id="submit" type="submit" value="登陆"></P>
    </form>
</div>
</body>
</html>
