<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
</head>
<body>
<h2>Hello World</h2>

<p>
    ContextPath =  <%= request.getContextPath() %>
</p>

<p>
    ServletPath = <%= request.getServletPath() %>
</p>

<p>
    RealPath = <%= application.getRealPath("/") %>
</p>

</body>
</html>

