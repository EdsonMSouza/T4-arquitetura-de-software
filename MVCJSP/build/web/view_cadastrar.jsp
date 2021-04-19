<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- a linha abaixo faz a inclusão de um outro arquivo no arquivo atual --%>
<c:import url="topo.jsp" />

<div class="alert-success text-center espaco">
    Cadastrar Usuário
</div>

<form name="cadastrar" method="post" action="Controller">
    <div class="row">
        <div class="col-md-5 mb-3">
            <label>RA</label>
            <input type="text" class="form-control" name="ra" />
        </div>
    </div>
    <div class="row">
        <div class="col-md-5 mb-3">
            <label>NOME</label>
            <input type="text" class="form-control" name="nome" />
        </div>
    </div>
    <div class="row">
        <div class="col-md-5 mb-3">
            <label>CURSO</label>
            <input type="text" class="form-control" name="curso" />
        </div>
    </div>
    <div class="row">
        <div class="col-md-5 mb-3">
            <input type="hidden" name="operacao" value="Inserir" />
            <input
                type="submit"
                class="form-control btn btn-primary"
                name="bt_enviar"
                value="Cadastrar"/>
        </div>
    </div>
    <span class="erro"><c:out value = "${mensagem}" /></span>
</form>

<c:import url="rodape.jsp" />