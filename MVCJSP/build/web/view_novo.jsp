<%-- 
    Document   : view_novo
    Created on : 05/04/2021, 09:44:59
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
        <h1>Hello World!</h1>
        <ul>
            <li><a href="Controller?op=novo">Novo</a></li>
            <li><a href="Controller?op=pesquisar">Pesquisar</a></li>
            <li><a href="Controller?op=listar">Listar</a></li>
        </ul>
        <form action="Controller" method="POST">
            <input type="text" name="ra" placeholder="Digite seu RA"/>
        </form>
    </body>
</html>
