<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Từ điển</h1>
<form action="/change" method="post">
    Nhập từ: <input type="text" name="word" required>
    <input type="submit" value="OK">
</form>
Kết quả: <c:out value="${result}"/>
</body>
</html>