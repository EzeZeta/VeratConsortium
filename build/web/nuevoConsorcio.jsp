<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Verat Consortium</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="CSS/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-grid.min.css" type="text/css"/>
        <link rel="stylesheet" href="css/bootstrap-reboot.css" type="text/css">
        <jsp:include page="/adminHeaderNavbarLayout.jsp"/>
    </head>
    <body>

        <div class="container-md" >
            <h1>Nuevo Consorcio</h1>
            
            <p>Recordá crear los PH cuando crees un nuevo consorcio!</p>
            <div>
                <form action="nuevoConsorcioServlet" method="POST" >
                    <table>

                        <tr><td><strong>CONSORCIO</strong></td></tr>
                        <tr><td>Nombre</td><td><input type="text" name="txtNombre"></td></tr>
                        <tr><td>Direccion </td><td><input type="text" name="txtDireccion"></td></tr>
                        <tr><td>CUIT</td><td><input type="text" name="txtCuit"></td></tr>
                        <tr><td>Saldo inicial </td><td><input type="text" name="txtSaldoInicial"></td></tr>
                        <br>
                        <tr><td><strong>ENCARGADO</strong></td></tr>
                        <tr><td>Nombre</td><td><input type="text" name="txtNombreEnc"></td></tr>
                        <tr><td>Apellido</td><td><input type="text" name="txtApellidoEnc"></td></tr>
                        <tr><td>Telefono</td><td><input type="text" name="txtTelEnc"></td></tr>
                        <tr><td>Mail encargado</td><td><input type="text" name="txtMail"></td></tr>

                    </table>  <br>
                    <input type="submit" value="Agregar" class="btn btn-dark">
                    <td><a class="btn btn-dark"  href="listaConsorciosServlet">Cancelar</a>

                </form>
            </div>
        </div>

    </body>
    <footer>
        <jsp:include page="/footer.jsp"/>
    </footer>
</html>