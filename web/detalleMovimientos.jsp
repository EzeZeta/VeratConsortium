<%-- 
    Document   : propietarios
    Created on : 21 abr. 2021, 19:57:30
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





        <jsp:include page="/adminHeaderNavbarLayout.jsp"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title >Verat Consortium</title>
    </head>
    <body >
        <%! int id_consorcio;
        String nombreConsorcio;%>


        <% id_consorcio = Integer.parseInt(request.getParameter("id_consorcio"));
            nombreConsorcio = request.getParameter("nombreConsorcio");
        %>
        <h1 class="container-md">Detalle movimientos <%=nombreConsorcio%> </h1><br>

        <div class="container-md">
            <a>Filtros</a><form action="detalleMovimientosServlet" method="POST" >
                <table id="tablaFiltro">
                    <tr><td>Desde</td><td><input type="date" name="fechaDesde"></td> 
                        <td>Hasta</td><td><input type="date" name="fechaHasta"></td>
                        
                        <td><input type="text" name="txtId" value="<%=id_consorcio%>" hidden /></td>
                        <td><input type="text" name="nombreConsorcio" value="<%=nombreConsorcio%>" hidden /></td>
                        <td><input class="btn btn-outline-dark" type="submit" value="Filtrar"> </td>

                    </tr>
                </table>
            </form>

        </div>



        <br>
        <div class="col-12">
            
            <div class="container-md"> 
                
                <table class="container-md">
                    <c:choose>
                        <c:when test="${saldoCaja >= 0 }"> <td style="color:green"><h4>Saldo de caja a la fecha: AR$ ${saldoCaja}</h4></td> </c:when>
                        <c:otherwise> <td style="color:red" ><h4>Saldo de caja a la fecha: AR$ ${saldoCaja}</h4></td>  </c:otherwise>
                    </c:choose> 
                </table>
            </div>

            <div class="container-md">     
                <table class="table table-striped" id="tabla" style="text-align: center">

                    <thead>
                        <tr>
                            <td colspan="4">
                                <input id="buscar" type="text" class="form-control" placeholder="Buscar en la tabla" /> 
                            </td>


                        </tr>
                    <th style="text-align: center">Tipo</th><th style="text-align: center">Fecha</th>
                    <th style="text-align: center">Origen</th><th style="text-align: center">Importe</th><th style="text-align: center">Metodo</th><th style="text-align: left">Detalle</th>
                    </thead>

                    
                    
                    
                    <tbody>
                        <c:forEach var="pro" items="${lista}" >
                            <tr style="text-align: center">
                                <td>${pro.tipoMov.descripcion}</td>
                                <td>${pro.fecha}</td>
                                <c:choose>
                                    <c:when test="${pro.ph.descripcion != null  }"> <td>${pro.ph.descripcion}</td> </c:when>
                                    <c:otherwise> <td> Edificio </td>  </c:otherwise>
                                </c:choose> 

                                <c:choose>
                                    <c:when test="${pro.tipoMov.id_tipoMov == 1 }"> <td style="color:green">${pro.importe}</td> </c:when>
                                    <c:otherwise> <td style="color:red" > -${pro.importe}</td>  </c:otherwise>
                                </c:choose> 

                                <c:choose>
                                    <c:when test="${pro.metPago.detalle != null}"> <td>${pro.metPago.detalle}</td> </c:when>
                                    <c:otherwise> <td>-</td>  </c:otherwise>
                                </c:choose>
                                <td style="text-align: left ">${pro.detalle}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>


        <div class="container-md">
            
            <button class="btn btn-dark" onclick="atras()" >Volver</button>
        </div>

        <div>
            <jsp:include page="/footer.jsp"/>
        </div>

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
