<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- a linha abaixo faz a inclusão de um outro arquivo no arquivo atual --%>
<c:import url="topo.jsp" />

<div class="alert-success text-center espaco">
    Página Inicial da Aplicação
</div>

<c:import url="rodape.jsp" />