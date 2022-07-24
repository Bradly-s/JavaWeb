<%--
  Created by IntelliJ IDEA.
  User: swf
  Date: 2022/7/23
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>更新货物信息</title>
</head>
<body>
<h3>更新货物信息</h3>
<form action="/JavaWebTest/updateServlet" method="post">


    <input type="hidden" name="id" value="${ carGo.id }">
    货物名称：<input name="name" value="${ carGo.name }"><br>
    货物规格：<input name="standard" value="${ carGo.standard }"><br>
    货物数量：<input name="number" value="${ carGo.number }"><br>
    存放位置：<textarea rows="5" cols="20" name="location" >${ carGo.location }</textarea><br>
    货物描述：<textarea rows="5" cols="20" name="introduction" >${ carGo.introduction }</textarea><br>


    <input type="submit" value="提交">
</form>
</body>
</html>
