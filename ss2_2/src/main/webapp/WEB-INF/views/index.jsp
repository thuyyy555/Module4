<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculate" method="post" onsubmit="setOperation()">
    <input type="number" id="num1" name="num1" required>
    <input type="number" id="num2" name="num2" required>
    <input type="hidden" id="operation" name="operation">
    <input type="submit" value="Addition" onclick="setValue('Addition')">
    <input type="submit" value="Subtraction" onclick="setValue('Subtraction')">
    <input type="submit" value="Multiplication" onclick="setValue('Multiplication')">
    <input type="submit" value="Division" onclick="setValue('Division')">
</form>
<p>Kết quả: <c:out value="${result}"></c:out></p>
<p><c:out value="${badRes}"></c:out></p>
<script>
    function setValue(operation) {
        document.getElementById("operation").value = operation;
    }
</script>
</body>
</html>