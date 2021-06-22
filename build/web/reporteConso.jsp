<%-- 
    Document   : reporte
    Created on : 18 may. 2021, 21:42:52
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">




        <!-- Bootstrap CSS -->


        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-grid.min.css" type="text/css"/>
        <link rel="stylesheet" href="css/bootstrap-reboot.css" type="text/css">

        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <jsp:include page="/adminHeaderNavbarLayout.jsp"/> 

        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.2.0/chart.js"></script>


        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.3.2/chart.min.js"></script>


        <jsp:useBean id="conso" scope="request" class="Gestores.GestorExpensas"/>
        <jsp:useBean id="moro" scope="request" class="Gestores.GestorReportes"/>
        <jsp:useBean id="con" scope="request" class="Gestores.GestorConsorcios"/>
    </head>
    <body>
        <div class="container-fluid">
            <div class="container-fluid">              
                <c:choose>
                    <c:when test="${saldoCaja >= 0 }"><h4 style="color:green">Saldo: AR$ ${saldoCaja}</h4> </c:when>
                    <c:otherwise><h4 style="color:red">Saldo: AR$ ${saldoCaja}</h4> </c:otherwise>
                </c:choose>                
            </div>

            <div class="container-fluid">
                <a>Filtros</a><form action="reporteIndividualServlet" method="POST" >
                    <table id="tablaFiltro">
                        <tr><td>Desde</td><td><input type="date" name="fechaD"></td> 
                            <td>Hasta</td><td><input type="date" name="fechaH"></td>
                            <td hidden><input id="id" name="id_con" hidden></td>
                            <td hidden ><input name="saldo" value="${saldoCaja}"></td>
                            <td><input class="btn btn-outline-dark" type="submit" value="Filtrar"> </td>
                        </tr>
                    </table>
                </form>
            
            </div>
                            
                            <div class="container-fluid " style="float: left">
                
                <a class=" btn btn-dark" href="reporte.jsp">Volver</a>
                <button class="btn btn-outline-light" onclick="imprimir()"><img src="img/printer.png" height="35" width="35"></button>
            </div>
        </div>
                            
                            

        <div class=" container container-fluid">
            <div class="container-md">
                                <c:choose>
                <c:when test="${fechaDesde != null}"><p class="container-fluid">Datos filtrados por fecha desde: ${fechaDesde} hasta: ${fechaHasta}</> </c:when>
                <c:otherwise></c:otherwise>
            </c:choose> 
                            </div>
            <div class="container col-12">
                <h2 class="container-md ">Indicadores</h2>
                <table > 
                    <tr>
                        <td style="text-align: center "><canvas  id="cantidad" width="300" height="300"></canvas>Expensas Cobradas / Adeudadas</td>
                        <td style="text-align: center "><canvas  id="movimientos" width="300" height="300"></canvas>Ingresos / Gastos</td>
                    </tr>
                </table>
            </div>

            

            




            <div class="container container-fluid " >     
                <h2 class="container-md ">Detalle movimientos</h2>
                <table class="table table-striped" id="tabla" style="text-align: center">
                    <thead>
                        <tr>
                            <td colspan="6">
                                <input id="buscar" type="text" class="form-control" placeholder="Buscar en la tabla" /> 
                            </td>
                        </tr>
                    <th style="text-align: center">Tipo</th><th style="text-align: center">Fecha</th>
                    <th style="text-align: center">Origen</th><th style="text-align: center">Importe</th><th style="text-align: center">Metodo</th><th style="text-align: left">Detalle</th>
                    </thead>
                    <tbody>
                        <c:forEach var="pro" items="${listaMov}" >
                            <tr style="text-align: center">
                                <td hidden> <input id="id_consorcio" type="text" style="text-align: left" value="${pro.id_consorcio}" hidden></td>
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

            <div class="container container-fluid" > 
                <h2 class="container-md ">Top 5 Inquilinos morosos</h2>
                <table class="table table-striped">
                    <tr style="text-align: center">
                        <th>Consorcio</th>
                        <th>Ph</th>
                        <th>Propietario</th>
                        <th>Cant. Exp. Adeudadas</th>
                        <th>Importe adeudado</th>            
                    </tr>
                    <c:forEach var="pro" items="${lista}" > 
                        <tr style="text-align: center">

                            <td style="text-align: center">${pro.nombreConsorcio}</td>
                            <td>${pro.descripcion}</td>
                            <td style="text-align: center">${pro.propietario}</td>
                            <td>${pro.cantidadExp}</td>
                            <td style="text-align: center">AR$ ${pro.importeAdeudado}</td>
                        </tr>
                    </c:forEach>
                </table>            
            </div>





            








    </body>
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
<script>
    var ctx = document.getElementById("movimientos").getContext("2d");
    var myChart = new Chart(ctx, {
        type: "doughnut",
        data: {
            labels: ['Gastos:$' +${gasto}, 'Ingresos:$' +${ingresos}],
            datasets: [{
                    data: [${gasto},${ingresos}],
                    backgroundColor: ['rgb(241, 148, 138)', 'rgb(133, 193, 233 )']
                }]
        },
        options: {
            responsive: false,
            maintainAspectRatio: true
        }
    });
        </script>


        <script>
            var ctx = document.getElementById("cantidad").getContext("2d");
            var myChart = new Chart(ctx, {
                type: "doughnut",
                data: {
                    labels: ['Adeudadas:' +${deuda}, 'Cobradas:' +${pagada}],
                    datasets: [{
                            data: [${deuda},${pagada}],
                            backgroundColor: ['rgb(241, 148, 138)', 'rgb(133, 193, 233 )']
                        }]
                },
                options: {
                    responsive: false,
                    maintainAspectRatio: true
                }
            });
    </script>

    <script>

        let idCons = Array
                .from(document.querySelectorAll("input[type=text][id=id_consorcio]"))
                .map(e => e.value.split()[0]); // extraigo el id del value


        document.getElementById("id").value = idCons[0];





    </script>

    <script>
        //Imprimir pantalla
        function imprimir() {
            window.print('');
        }


        </script>









</html>

