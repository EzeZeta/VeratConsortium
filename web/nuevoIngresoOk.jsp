<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="conso" scope="request" class="Gestores.GestorBD"/>
<jsp:useBean id="met" scope="request" class="Gestores.GestorMovimientos"/>

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
        <%!
            String nombreConsorcio;
            String descripcion;
        %>
        <%
            nombreConsorcio = request.getParameter("nombreConsorcio");
            descripcion = request.getParameter("descripcion");
        %>






        <div class="container-md" >
            <h1>Nuevo ingreso</h1>
            <div>
                <h4><%=nombreConsorcio%>  "<%=descripcion%>" </h4>


                <table class="table" >

                    <tr><th>Importe</th><th>Fecha</th><th>Vencimiento</th><th>Recargo</th><th>Expensa</th></tr>
                            <c:forEach var="lista" items="${lista}" >
                        <tr><td><input type="checkbox" class="check" name="cbxExpensas" id="cbxId" value="${lista.importeExpensa}"> AR$${lista.importeExpensa}</td>
                            <td>${lista.fecha}</td><td>${lista.vencimiento}</td>
                            <td><input type="checkbox" class="check" name="cbxRecargo" id="idRecargo" value="300" > AR$300</td>
                            <td><input name="txtId" id="id_expensa" value="${lista.id_expensa}" disabled></td></tr>
                            </c:forEach>
                </table>

                <button class=" btn btn-outline-success"  value="Seleccionar" onclick="validarFormulario(), validarRecargo(), sumarImportes(), guardarIdExp()">Confirmar</button>
                <br>
                <br>
                <div >
                    <table>
                        <tr><td>Importe AR$ </td><td><input id="importeOk" name="importeOk" style="text-align: right" disabled></td> <td>Recargo AR$ </td><td><input id="recargoOk" name="recargoOk" style="text-align: right" disabled ></td> <td>TOTAL   AR$ </td><td><input id="totalOk" name="totalOk" style="text-align: right" disabled ></td></tr>
                        <tr></tr>
                        <tr></tr>
                    </table>
                </div>

            </div>

            <form action="cargarIngresoServlet" method="POST" >
                <br>
                <input  id="totalFinal" name="totalFinal" hidden>
                <%!
                    int id_ph;
                    int id_consorcio;
                                                                            %>
                <%
                    id_ph = Integer.parseInt(request.getParameter("id_ph"));
                    id_consorcio = Integer.parseInt(request.getParameter("id_consorcio"));
                %>
                <input name="id_ph" value="<%= id_ph%>" hidden>
                <input name="id_consorcio" value="<%= id_consorcio%>" hidden>

                <input name="id_expensa" id="id_expensa1">

                <table>           
                    <tr><td>Fecha</td><td><input type="date" name="fecha"></td></tr>
                    <tr><td> Metodo de Pago</td><td>
                            <select name="cboMetPago">
                                <c:forEach var="mp" items="${met.listadoMetodoPago()}">
                                    <option value="${mp.id_metPago}"> ${mp.detalle}
                                    </c:forEach>
                            </select>
                        </td></tr> 
                    <tr><td>Detalle</td><td><textarea  name="txtDetalle"></textarea></td> 

                </table>

                <br>
                <input type="submit" value="Cargar" class="btn btn-dark">
                <input class="btn btn-dark" type="button" value="Cancelar" name="Boton1" onclick="atras();">
            </form>
        </div>
    </body>
    <footer>
        <jsp:include page="/footer.jsp"/>
    </footer>

    <script type="text/javascript">
        function validarFormulario()
        {
            var elementos = Array.from(document.querySelectorAll("input[type=checkbox][name=cbxExpensas]:checked")).map(e => e.value);

            var suma = 0;

            if (elementos !== null) {
                for (var i = 0; i < elementos.length; i++) {
                    suma += parseInt(elementos[i]);

                }
            }
            document.getElementById("importeOk").value = suma;



            return false;
        }




    </script>

    <script type="text/javascript">
        function validarRecargo() {
            var recargos = Array.from(document.querySelectorAll("input[type=checkbox][name=cbxRecargo]:checked")).map(e => e.value);

            var sumaRecargo = 0;

            if (recargos !== null) {

                for (var i = 0; i < recargos.length; i++) {
                    sumaRecargo += parseInt(recargos[i]);
                }
            }
            document.getElementById("recargoOk").value = sumaRecargo;
            return false;
        }

        function guardarIdExp() {
            
            var expensas = Array.from(document.querySelectorAll("input[type=checkbox][name=cbxExpensas]:checked")).map(e => e.value);
            let idExp = [];
            for (var i = 0; i < expensas.length; i++) {
                idExp.push(expensas[i].txtId);
            }
            
            document.getElementById("id_expensa1").value = idExp ;
            return false;
        }

    </script>
    <script>

        function sumarImportes() {
            var total = 0;
            var uno = parseInt(document.getElementById("importeOk").value);
            var dos = parseInt(document.getElementById("recargoOk").value);

            total = uno + dos;
            document.getElementById("totalOk").value = total;
            document.getElementById("totalFinal").value = total;
            return false;
        }

    </script>



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


</html>