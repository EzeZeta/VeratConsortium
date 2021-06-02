
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="conso" scope="request" class="Gestores.GestorBD"/>

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
            <h1>Nuevo Inquilino</h1>
            <div>
                <form action="nuevoInquilinoServlet" method="POST" >
                    <table>

                        <tr><td>Nombre </td><td><input type="text" name="txtNombre"></td></tr>
                        <tr><td>Apellido </td><td><input type="text" name="txtApellido"></td></tr>

                        <tr><td> Tipo Documento</td><td>
                                <select name="cboTipoDNI">
                                    <c:forEach var="td" items="${conso.listadoTiposDocu()}">
                                        <option value="${td.id_tipoDocu}"> ${td.descripcion}
                                        </c:forEach>
                                </select>
                            </td></tr>           

                        <tr><td>Nro Documento</td><td><input  type="number" name="txtNroDNI"></td></tr>
                        <tr><td>Telefono</td><td><input type="text" name="txtTelefono"></td></tr>
                        <tr><td>Mail</td><td><input type="text" name="txtMail"></td></tr>

                        <tr><td> Departamento </td><td>
                                <select name="cboPh">
                                    <c:forEach var="ph" items="${conso.listadoPh()}">
                                        <option value="${ph.id_ph}"> ${ph.descripcion}
                                        </c:forEach>
                                </select>
                            </td></tr>   

                        <tr><td> Consorcio </td><td>
                                <select name="cboCons">
                                    <c:forEach var="cons" items="${conso.listadoConsorcios()}">
                                        <option value="${cons.id_consorcio}"> ${cons.nombre}
                                        </c:forEach>
                                </select>
                            </td></tr>  

                    </table>  <br>
                    <input type="submit" value="Agregar" class="btn btn-dark">
                    <td><a class="btn btn-dark"  href="listaInquilinosServlet">Cancelar</a></td>
                    
                </form>
            </div>
        </div>

    </body>
    <footer>
        <jsp:include page="/footer.jsp"/>
    </footer>
</html>