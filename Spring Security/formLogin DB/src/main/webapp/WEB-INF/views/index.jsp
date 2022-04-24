<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<body>

<h2>Welcome Page</h2>

    <button><a href="/login" />Login</a></button>
    <button><a href="/home" />Home</a></button>
    <sec:authorize access="isAuthenticated()">
        <form action="/logout" method="post">
            <sec:csrfInput />
            <input type="submit" value="logout">
        </form>
    </sec:authorize>

</body>
</html>
