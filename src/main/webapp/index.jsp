<%--
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="controller" method="post">
    <input type="hidden" name="time" value="${System.currentTimeMillis()}"/>
    <input type="submit" name="Submit" value="push"/>
</form>
</body>
</html>
