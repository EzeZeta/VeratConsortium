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

        <%!
            int id_consorcio;
            String nombreConsorcio;
        %>
        <%
            nombreConsorcio = request.getParameter("nombreConsorcio");
            id_consorcio = Integer.parseInt(request.getParameter("id_consorcio"));
        %>





        <h1 class="container-md">Elegi el ph a cargar ingreso.</h1><br>
        
        <div class="container-md"> 
            <h4> <%=nombreConsorcio%></h4>

            <table class="table table-striped">
                <th style="text-align: center" hidden>ID</th><th style="text-align: center">Departamento</th>
                <th style="text-align: center">Seleccionar</th>
                    <c:forEach var="pro" items="${lista}" >
                    <tr style="text-align: center">
                        <td hidden>${pro.id_ph}</td>
                        <td>${pro.descripcion}</td>
                        <td hidden>${pro.id_consorcio}</td>
                                          
                        


                        <td>
                            <button class="btn btn-outline-dark" onclick="window.location = 'ingresoEleccionPhServlet?id_ph=${pro.id_ph}&id_consorcio=${pro.id_consorcio}&descripcion=${pro.descripcion}&nombreConsorcio=<%=nombreConsorcio%>';" ><img src="img/casa.png" height="35" width="35"></button>  
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
