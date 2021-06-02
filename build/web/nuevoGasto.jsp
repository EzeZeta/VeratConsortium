<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="conso" scope="request" class="Gestores.GestorBD"/>
<jsp:useBean id="mov" scope="request" class="Gestores.GestorMovimientos"/>

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
            <h1>Nuevo Gasto</h1>
            <div>
                <form action="nuevoGastoServlet" method="POST" >
                    <table>
                        <%!
                            int id_consorcio;
                            String nombreConsorcio;
                                                                                                                                %>
                        <%
                            nombreConsorcio = request.getParameter("nombreConsorcio");
                            id_consorcio = Integer.parseInt(request.getParameter("id_consorcio"));
                        %>

                        <tr><td>Consorcio </td><td><input type="text" name="txtConsorcio" value="<%=nombreConsorcio%>" disabled></td><input type="text" name="txtIdConsorcio" value="<%=id_consorcio%>" hidden ></td></tr>
                        <tr><td>Fecha</td><td><input type="date" name="fecha"></td></tr>
                        <tr><td> Tipo Gasto</td><td>
                                <select name="cboTipoGasto">
                                    <c:forEach var="tg" items="${mov.listadoTipoGasto()}">
                                        <option value="${tg.id_tipoGasto}"> ${tg.detalleGasto}
                                        </c:forEach>
                                </select>
                            </td></tr> 
                        <tr><td>Importe</td><td><input type="number" name="txtImporte"></td></tr>
                        <tr><td>Detalle</td><td><textarea  name="txtDetalle"></textarea></td>
                    </table>
                    <input type="submit" value="Cargar" class="btn btn-dark">
                    
                           
                </form>
                        

            </div>
            <button class="btn btn-dark" onclick=" atras()">Cancelar</button>
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
    <footer>
        <jsp:include page="/footer.jsp"/>
    </footer>
</html>
