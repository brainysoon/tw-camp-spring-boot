<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>Hello Fireman!</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/table.css"/>
</head>
<body>
<h1>All Firemen!</h1>
<div>
    <table cellspacing="0">
        <thead>
        <tr class="table-header">
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td><c:out value="${employee.id}"/></td>
                <td><c:out value="${employee.name}"/></td>
                <td><c:out value="${employee.gender}"/></td>
                <td><c:out value="${employee.age}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>