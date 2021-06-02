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
        <script src="sweetalert2.all.min.js"></script>
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>


        <jsp:include page="/adminHeaderNavbarLayout.jsp"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title >Verat Consortium</title>
    </head>
    <body >
        <h1 class="container-md">Listado de Consorcios</h1><br>
        <div class="container-md">     
            <table class="table table-striped">
                <th style="text-align: center" hidden>ID</th><th style="text-align: center">Nombre</th>
                <th style="text-align: center">Direccion</th><th style="text-align: center">Cuit</th>
                <th style="text-align: center">Encargado</th>
                <th style="text-align: center">Telefono</th><th style="text-align: center">Mail</th>
                <th style="text-align: center">Eliminar</th><th style="text-align: center">Departamentos</th>
                    <c:forEach var="pro" items="${lista}" >
                    <tr style="text-align: center">
                        <td hidden>${pro.id_consorcio}</td>
                        <td>${pro.nombre}</td>
                        <td>${pro.direccion}</td>
                        <td>${pro.cuit}</td>
                        <td>${pro.nombreEnc} ${pro.apellidoEnc}</td>
                        <td>${pro.telefono}</td>
                        <td>${pro.mail}</td>

                        <td>
                            <button class="btn btn-outline-dark" onclick=" confirmarEliminar(${pro.id_consorcio});">Eliminar</button>  
                        </td>
                        <td>
                            <button  class="btn btn-outline-dark" onclick="window.location = 'listaPhServlet?id_consorcio=${pro.id_consorcio}';" >Listar PH</button>              
                        </td>
                    </tr>

                </c:forEach>
            </table>
        </div>


        <div class="container-md"><button class="btn btn-dark"  onclick="window.location = 'nuevoConsorcio.jsp';" >Nuevo Consorcio</button>
            <a class=" btn btn-dark" href="vistaAdmin.jsp">Volver</a>
        </div>

        <div>
            <jsp:include page="/footer.jsp"/>
        </div>

        <script>

            function confirmarEliminar(id_consorcio) {
                var id_consorcio1 = id_consorcio;

                Swal.fire({
                    title: 'Estas seguro?',
                    text: "Si eliminas el consorcio, se eliminaran los ph",
                    icon: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#3085d6',
                    cancelButtonColor: '#d33',
                    confirmButtonText: 'Si, eliminar!'
                }).then((result) => {

                    if (result.isConfirmed) {
                        

                window.location = 'eliminarConsorciosServlet?id_consorcio='+ id_consorcio1;

                    }
                });
            }




        </script>






    </body>
</html>