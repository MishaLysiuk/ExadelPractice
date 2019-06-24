<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
    <title>Hello world: </title>
</head>
<body>
<h2>${message}</h2>
<table>
    <c:forEach events="${events}" var="event">
        <tr>
            <td>${event.millisec}</td>
            <td>${event.type}</td>
            <td>${event.message}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>