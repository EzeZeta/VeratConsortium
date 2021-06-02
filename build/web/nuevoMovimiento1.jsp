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
        <h1 class="container-md">Selecciona el consorcio</h1><br>
        <div class="container-md">     
            <table class="table table-striped">
                <th style="text-align: center" hidden>ID</th><th style="text-align: center">Nombre</th>
                <th style="text-align: center">Seleccionar</th>
                    <c:forEach var="pro" items="${lista}" >
                    <tr style="text-align: center">
                        <td hidden>${pro.id_consorcio}</td>
                        <td>${pro.nombre}</td>


                        <td>
                            <button class="btn btn-outline-dark" onclick="window.location = 'nuevoMovimiento2.jsp?id_consorcio=${pro.id_consorcio }&nombre=${pro.nombre}';" ><img src="img/condo.png" height="35" width="35"></button>  
                        </td>

                    </tr>

                </c:forEach>
            </table>
        </div>


        <div class="container-md">
            <a class=" btn btn-dark" onclick=" atras() ">Volver</a>
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