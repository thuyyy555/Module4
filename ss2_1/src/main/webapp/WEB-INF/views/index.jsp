<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Từ điển</h1>
<form action="/save" method="post">
    <input type="checkbox" id="val1" name="val1" value="Lettuce">Lettuce
    <input type="checkbox" id="val2" name="val2" value="Tomato">Tomato
    <input type="checkbox" id="val3" name="val3" value="Mustard">Mustard
    <input type="checkbox" id="val4" name="val4" value="Sproud">Sproud
    <input type="submit" value="Submit">
</form>
<c:forEach var="value" items="${list}">
    <tr><c:out value="${value}"></c:out></tr>
</c:forEach>
</body>
</html>