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
        <h4 class="container-md">Listado de Departamentos</h4><br>
        <div class="container-md">     
            <table class="table table-striped">
                <th style="text-align: center">Dpto</th>
                <th style="text-align: center">Expensas</th><th style="text-align: center">Ocupado</th>

                <c:forEach var="pro" items="${lista}" >
                    <tr style="text-align: center">
                        <td hidden>${pro.id_consorcio}</td>
                        <td hidden>${pro.id_ph}</td>
                        <td>${pro.descripcion}</td>
                        <td>$ ${pro.importeExp}</td>
                        <c:choose>
                            <c:when test="${pro.ocupado != true}"> <td> <img src="img/nope.png" height="35" width="35"> </td> </c:when>
                            <c:otherwise> <td> <img src="img/checked.png" height="35" width="35"> </td>  </c:otherwise>
                            </c:choose>

                    </tr>

                </c:forEach>
            </table>
        </div>




        <div class="container-md">
            <button  class="btn btn-dark" onclick="window.location = 'nuevoPhServlet?id_consorcio=${consorcio}';">Nuevo PH</button>

            <a class=" btn btn-dark" href="listaConsorciosServlet">Volver</a>
        </div>

        <div>
            <jsp:include page="/footer.jsp"/>
        </div>






    </body>
</html>