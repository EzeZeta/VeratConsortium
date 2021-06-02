<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Verat Consortium</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-grid.min.css" type="text/css"/>
        <link rel="stylesheet" href="css/bootstrap-reboot.css" type="text/css">
        <jsp:include page="/adminHeaderNavbarLayout.jsp"/>
    </head>
    <body>

        <div class="container-md" >
            <h1>Nuevo PH</h1>
            <div>
                <form action="nuevoPhServlet" method="POST" >
                    <table>
                        
                        <tr><td>Nomenclatura</td><td><input type="text" name="txtNomenclatura"></td></tr>
                        <tr><td>Importe </td><td><input type="number" name="txtImporte"></td></tr>
                        <tr><td>Consorcio </td><td><input type="text" name="txtConsorcio" value="<jsp:getProperty name="cons" property="nombreConsorcio"  ></jsp:getProperty >" disabled></td></tr>
                        <input type="text" name="txtId_Cons" value="<jsp:getProperty name="cons" property="id_consorcio"></jsp:getProperty>" hidden>       
                        

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