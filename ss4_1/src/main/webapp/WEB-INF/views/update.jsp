<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Email Settings</title>
</head>
<body>
<form:form modelAttribute="email" method="POST" action="update">
    Language: <form:select path="language" items="${languageArray}"/><br/>
    Page Size: <form:select path="pageSize" items="${pageSizeArray}"/><br/>
    Spams filter: <form:checkbox path="filter" /><br/>
    Signature: <form:input path="signature" /><br/>
    <input type="submit" value="Submit" />
</form:form>
</body>
</html>