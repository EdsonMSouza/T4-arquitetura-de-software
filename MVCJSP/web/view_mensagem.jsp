<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <!-- Vamos chamar a JSTL para mostrar o valor
                 enviado pelo Controller
            -->
            <c:out value="${msg}" />
        </h1>
    </body>
</html>
