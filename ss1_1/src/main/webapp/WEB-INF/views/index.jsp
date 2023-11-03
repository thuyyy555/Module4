<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculation</title>
</head>
<body>
<h1>Calculation</h1>
<form action="/vnd" method="post">
    Tỉ giá: <input type="number" name="gia" required>
    Lượng USD: <input type="number" name="usd" required>
    OK<input type="submit">
</form>
Kết quả: <c:out value="${result}"/>
</body>
</html>