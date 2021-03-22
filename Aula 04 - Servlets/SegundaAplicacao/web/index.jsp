<%-- 
    Document   : index
    Created on : 22/03/2021, 09:30:06
    Author     : souza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Formulário Teste</h1>
        <form name="teste" action="Controller" method="post">
             <input type="text" name="nome" placeholder="Nome"><br>
             <input type="text" name="sobrenome" placeholder="Sobrenome"><br>
             <input type="submit" name="enviar" value="Enviar">
        </form>
    </body>
</html>
