<%--
  Created by IntelliJ IDEA.
  User: swf
  Date: 2022/7/23
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加货物</title>
</head>
<body>

    <h3>添加货物</h3>
    <form action="/JavaWebTest/addServlet" method="post">
        货物名称：<input name="name"><br>
        货物规格：<input name="standard"><br>
        货物数量：<input name="number"><br>
        存放位置：<textarea rows="5" cols="20" name="location"></textarea><br>
        货物描述：<textarea rows="5" cols="20" name="introduction"></textarea><br>

        <input type="submit" value="提交">
    </form>
</body>
</html>
