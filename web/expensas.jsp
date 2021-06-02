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
        <h1 class="container-md">Expensas </h1><br>
        <div class="container-md">     
            <table class="table table-striped">
                <th style="text-align: center">Nro</th>
                <th style="text-align: center">Fecha</th>
                <th style="text-align: center">Estado</th>
                <th style="text-align: center">Ver</th>
                    <c:forEach var="pro" items="${lista}" >
                    <tr style="text-align: center">
                        <td>${pro.id_expensa}</td>
                        <td>${pro.fecha}</td>
                        
                        <c:choose>
                            <c:when test="${pro.estado != true}"> <td>Adeudada</td> </c:when>
                            <c:otherwise> <td>Abonada</td>  </c:otherwise>
                            </c:choose>
                        <td>
                            <button class="btn btn-outline-dark" onclick="window.location = 'impresionExpensaServlet?id_expensa=${pro.id_expensa}';"><img src="img/lupa.png" height="35" width="35"></button>  
                        </td>

                    </tr>

                </c:forEach>
            </table>
        </div>


        <div class="container-md">
            <a class=" btn btn-dark" onclick="atras()">Volver</a>
        </div>

        <div>
            <jsp:include page="/footer.jsp"/>
        </div>

<script language="javascript">
            function atras() {
                history.back();
            }
            function actualizar() {
                location.reload();
            }
            function adelante() {
                history.forward();
            }
        </script>  




    </body>
</html>