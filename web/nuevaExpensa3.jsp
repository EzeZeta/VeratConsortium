<%-- 
    Document   : editarInquilino
    Created on : 26 abr. 2021, 19:51:33
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>




<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Verat Consortium</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="CSS/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-grid.min.css" type="text/css"/>
        <link rel="stylesheet" href="css/bootstrap-reboot.css" type="text/css">
        <link rel="stylesheet" href="js/sweetAlert.js"/>
        <jsp:include page="/adminHeaderNavbarLayout.jsp"/>

    </head>
    <body>

        <div class="container-md" >
            <h1>Nueva Expensa</h1>
            <div>
                <form action="nuevaExpensaServlet3" method="POST" >
                    <table>


                        <input type="text" name="txtId_Ph" value="<jsp:getProperty name="lista" property="id_ph"></jsp:getProperty>" hidden /></td></tr>
                            <tr><td>Fecha</td><td><input type="date" name="fecha"></td></tr>                
                            <tr><td>Vencimiento</td><td><input type="date" name="vencimiento"></td></tr>
                            <tr><td>Dpto </td><td><input type="text" name="txtDpto" value="<jsp:getProperty name="lista" property="descripcion"></jsp:getProperty>"disabled/></td></tr>
                        <tr><td>Importe </td><td><input type="text" name="txtImporteExpensa" value="<jsp:getProperty name="lista" property="importeExp"></jsp:getProperty>"/></td></tr>


                    </table>  <br>

                    <input type="submit" value="Liquidar" class="btn btn-dark"  >

                    <input class="btn btn-dark" type="button" value="Cancelar" name="Boton1" onclick="atras();">

                </form>
            </div>
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
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@10"></script>
        <script src="js/sweetAlert.js"></script> 

    </body>
    <footer>

    </footer>
</html>

