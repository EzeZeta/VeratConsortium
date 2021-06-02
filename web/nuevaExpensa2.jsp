<%@page import="java.util.ArrayList"%>
<%@page import="Gestores.GestorConsorcios"%>
<%@page import="java.util.Set"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-grid.min.css" type="text/css"/>
        <link rel="stylesheet" href="css/bootstrap-reboot.css" type="text/css">

        <jsp:include page="/adminHeaderNavbarLayout.jsp"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title >Verat Consortium</title>
    </head>
    <body >
        <h1 class="container-md">Elegi el Ph a liquidar</h1><br>
        <div class="container-md"> 

            <table class="table table-striped">
                <th style="text-align: center" hidden>ID</th><th style="text-align: center">Departamento</th>
                <th style="text-align: center">Crear expensa</th><th style="text-align: center">Ver expensas</th>
                    <c:forEach var="pro" items="${lista}" >
                    <tr style="text-align: center">
                        <td hidden>${pro.id_ph}</td>
                        <td>${pro.descripcion}</td>


                        <td>
                            <button class="btn btn-outline-dark" onclick="window.location = 'nuevaExpensaServlet3?id_ph=${pro.id_ph}';" ><img src="img/bill.png" height="35" width="35"></button>  
                        </td>
                        <td>
                            <button class="btn btn-outline-dark" onclick="window.location = 'listaExpensaServlet?id_ph=${pro.id_ph}';" ><img src="img/clipboard.png" height="35" width="35"></button>  
                        </td>

                    </tr>

                </c:forEach>
            </table>
        </div>



        <div class="container-md">
            <a class=" btn btn-dark" href="nuevaExpensaServlet1">Volver</a>
        </div>

        <div>
            <jsp:include page="/footer.jsp"/>
        </div>

        






    </body>
</html>