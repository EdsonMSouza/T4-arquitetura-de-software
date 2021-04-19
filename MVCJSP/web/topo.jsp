<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Alunos</title>
        <link rel="stylesheet" href="assets/css/bootstrap.min.css" type="text/css">

        <style type="text/css">
            .espaco{
                margin: 0 0 20px 0;
            }

            .erro{
                color: red;
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
                                <a class="nav-item nav-link" href="view_cadastrar.jsp">Novo</a>
                                <a class="nav-item nav-link" href="view_pesquisar.jsp">Pesquisa</a>
                                <a class="nav-item nav-link" href="Controller">Listar Todos</a>
                            </div>
                        </div>
                    </nav>