<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- A linha abaixo importa o arquivo topo.jsp (vai misturar tudo) --%>
<c:import url="topo.jsp" />

    <!-- tudo via bootstrap através das "class" -->
    <div class="alert-success text-center topo">
        Página Inicial da Aplicação
    </div>
        
<%-- A linha abaixo importa o arquivo rodape.jsp (vai misturar tudo) --%>
<c:import url="rodape.jsp" />