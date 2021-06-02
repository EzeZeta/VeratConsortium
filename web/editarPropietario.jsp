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
        <jsp:include page="/adminHeaderNavbarLayout.jsp"/>
    </head>
    <body>

        <div class="container-md" >
            <h1>Editar Propietario</h1>
            <div>
                <form action="editarPropietarioServlet" method="POST" >
                    <table>
                        <input number="number" name="txtId_persona" value="<jsp:getProperty name="editProp" property="id_persona"></jsp:getProperty>" hidden />
                        <tr><td>Nombre </td><td><input type="text" name="txtNombre" value="<jsp:getProperty name="editProp" property="nombre"></jsp:getProperty>"></td></tr>
                        <tr><td>Apellido </td><td><input type="text" name="txtApellido" value="<jsp:getProperty name="editProp" property="apellido"></jsp:getProperty>" ></td></tr>
                        <tr><td>Nro Documento</td><td><input  type="text" name="txtNroDNI" value="<jsp:getProperty name="editProp" property="documento"></jsp:getProperty>"></td></tr>
                        <tr><td>Telefono</td><td><input type="text" name="txtTelefono"value="<jsp:getProperty name="editProp" property="telefono"></jsp:getProperty>"></td></tr>
                        <tr><td>Mail</td><td><input type="text" name="txtMail"value="<jsp:getProperty name="editProp" property="mail"></jsp:getProperty>"></td></tr>
                        
                        </table>  <br>
                        <input type="submit" value="Guardar" class="btn btn-dark">
                        <a class=" btn btn-dark" href="listaPropietariosServlet">Cancelar</a>
                    </form>
                </div>
            </div>

        </body>
        <footer>
        <jsp:include page="/footer.jsp"/>
    </footer>
</html>
