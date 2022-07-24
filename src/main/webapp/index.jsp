<%--
  Created by IntelliJ IDEA.
  User: swf
  Date: 2022/7/23
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="button" value="新增" id="add"><br>
<hr>
<hr>
<table border="1" cellspacing="0" width="80%">
    <tr>
        <th>序号</th>
        <th>货物名称</th>
        <th>货物规格</th>
        <th>货物数量</th>
        <th>存放位置</th>
        <th>货物描述</th>
        <th>操作</th>
    </tr>

    <c:forEach items="${ arrayLists }" var="arrayList" varStatus="status" >
        <tr align="center">
            <td>${ status.count }</td>
            <td>${ arrayList.name }</td>
            <td>${ arrayList.standard }</td>
            <td>${ arrayList.number }</td>
            <td>${ arrayList.location }</td>
            <td>${ arrayList.introduction }</td>

            <td><a href="/JavaWebTest/selectByIdServlet?id=${ arrayList.id }">修改</a>
                <a href="/JavaWebTest/delServlet?id=${ arrayList.id }">删除</a></td>
        </tr>
    </c:forEach>
</table>

<script>
    document.getElementById("add").onclick = function (){
        location.href = "/JavaWebTest/addCargo.jsp";
    }
</script>

</body>
</html>
