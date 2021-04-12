<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MVC JSP</title>
        <!-- A linha abaixo faz a importação do framework Bootstrap -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css" type="text/css">
        
        <style type="text/css">
            .topo{
                margin-top: 10px;
            }
        </style>
    </head>
    <body>
        <div class="container"><!-- Bloco principal -->
            <div class="row"><!-- Cria uma linha no grid -->
                <div class="col-md-8 mb-3" style="margin: auto;"><!-- Criando a barra superior (Menu) -->
                    <!-- Cria barra de navegação -->
                    <nav class="navbar navbar-expand-lg navbar-light bg-light">
                        <a class="navbar-brand" href="#">Cadastro de Alunos (MVC)</a>
                        <!-- Cria os links no menu -->
                        <div class="collapse navbar-collapse" id="navbarNavMarkup">
                            <!-- Cria a barra de navegação para os links -->
                            <div class="navbar-nav">
                                <a class="nav-item nav-link" href="view_novo.jsp">Novo</a>
                                <a class="nav-item nav-link" href="Controller?op=pesquisar">Pesquisar</a>
                                <a class="nav-item nav-link" href="#">Listar Todos</a>
                            </div>
                        </div>
                    </nav>
