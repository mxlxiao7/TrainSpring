<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Spring MVC Hello World</title>
</head>

<body>
<h2>All Persons in System</h2>

<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Age</th>
        <th>Sex</th>
    </tr>
    <c:forEach var="p" items="${personList}">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.age}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>