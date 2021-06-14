<%-- 
    Document   : proveedores
    Created on : 20 abr. 2021, 00:10:55
    Author     : Usuario
--%>


<%@page import="Modelos.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Gestores.GestorProveedores"%>
<%@page import="java.util.Set"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-grid.min.css" type="text/css"/>
        <link rel="stylesheet" href="css/bootstrap-reboot.css" type="text/css">

        <link  rel="icon"   href="img/helmet.ico" />

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title >Verat Consortium</title>
    <jsp:include page="/adminHeaderNavbarLayout.jsp"/>
    </head>

    <body>
        <h1 class="container-md">Listado de Proveedores</h1><br>
        <div class="container-md">     
            <table class="table table-striped" id="tabla">
                <thead>
                <tr><td colspan="4">
                            <input id="buscar" type="text" class="form-control" placeholder="Buscar en la tabla" /> 
                        </td> </tr>
                
                
                <th style="text-align: center" hidden="">ID</th>
                <th style="text-align: center">Nombre</th><th style="text-align: center">Apellido</th><th style="text-align: center">CUIT</th>
                <th style="text-align: center">Telefono</th><th style="text-align: center">Mail</th><th style="text-align: center">Especialidad</th>
                <th style="text-align: center">Eliminar</th>
                </thead>
                
                    <c:forEach var="pro" items="${lista}" >
                    <tr style="text-align: center">

                        <td>${pro.nombre}</td>
                        <td>${pro.apellido}</td>
                        <td>${pro.documento}</td>
                        <td>${pro.telefono}</td>
                        <td>${pro.mail}</td>
                        <td>${pro.especialidad}</td>
                        <td>
                            <button class="btn btn-outline-dark" onclick="window.location = 'eliminarProveedorServlet?id_persona=${pro.id_persona }';" >Eliminar</button>  
                        </td>

                    </tr>

                </c:forEach>
            </table>
        </div>


        <div class="container-md"><button class="btn btn-dark"  onclick="window.location = 'nuevoProveedor.jsp';" >Nuevo Proveedor</button>
            <a class=" btn btn-dark" href="vistaAdmin.jsp">Volver</a>
        </div>






<jsp:include page="/footer.jsp"/>

<script>
            var table = document.querySelector('#tabla');
            var tableBody = table.querySelector('tbody');
            var input = document.querySelector('#buscar');

            var originalRows = [
                ...table.querySelectorAll('tbody tr')
            ].map(row => {
                var newRow = document.createElement('tr');
                newRow.innerHTML = row.innerHTML;

                return newRow;
            });

            input.addEventListener('input', evt => {
                var value = evt.target.value;
                var rows = originalRows
                        .filter(row => {
                            var cells = [...row.querySelectorAll('td')];
                            return (
                                    evt.target.value === ''
                                    || cells.find(cell => {
                                        return cell.textContent.includes(value);
                                    })
                                    );
                        })
                        .map(row => row.outerHTML);

                tableBody.innerHTML = rows.join('');
                if (value !== '') {
                    tableBody.querySelectorAll('tr td').forEach(row => {
                        var text = row.textContent;
<!--var html = text.replace(new RegExp(value, 'g'),`<strong>${value}</strong>`);-->
                    row.innerHTML = html;
                });

            }
        });

        </script>






    </body>
</html>
