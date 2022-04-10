<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<body>

<h2>Welcome to Home Page</h2>
<h2>Israfil</h2>
    <button><a href="/" />Welcome page</a></button>
    <sec:authorize access="isAuthenticated()">
        <form action="/logout" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" value="logout">
        </form>
    </sec:authorize>

</body>
</html>
