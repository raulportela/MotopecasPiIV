<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="br.senac.tads.dsw.exemplosservlet.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exemplo JSP + EL + JSTL</title>
    </head>
    <body>
        <%
            Produto p1 = new Produto(1L, "Bolo de chocolate",
                    "descrição do bolo de chocolate",
                    new BigDecimal(30.0), "http://lorempixel.com/g/300/300/");
            Produto p2 = new Produto(1L, "Bolo de cenoura",
                    "descrição do bolo de cenoura", new BigDecimal(20.0), "http://lorempixel.com/g/300/300/");
            List<Produto> lista = Arrays.asList(p1, p2);
            request.setAttribute("listaProd", lista);
        %>
        <h1>Cake Web - JSP + Scriptlet + JSTL + EL</h1>
        <ul>
            <c:forEach items="${listaProd}" var="prod">
                <li>
                    <div>
                        <h3>${prod.nome}</h3>
                        <p>${prod.descricao}</p>
                        <p>${prod.precoVenda.toString()}</p>
                    </div>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>