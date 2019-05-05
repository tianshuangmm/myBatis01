<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
请求成功！

<c:forEach items="${messageList}" var="message" varStatus="status">
<tr <c:if test="${status.index%2!=0}"> style='background-color:#ECF6EE;' </c:if>>
    <td><input type="checkbox"/></td>
    <td>${status.index+1}</td>
    <td>${message.command}</td>
    <td>${message.description}</td>
    <td>
        <a href='#'>修改</a>&nbsp;&nbsp;&nbsp;
        <a href='#'>删除</a>
    </td>
</tr>
</c:forEach>
</body>
</html>
