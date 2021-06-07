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
            <div class="container col-6" style = "float: left">
                <h2 class="container-md ">Indicadores generales</h2>
                <table > 
                    <tr>
                        <td style="text-align: center "><canvas  id="myC" width="300" height="300"></canvas>Expensas Cobradas / Adeudadas</td>
                        <td style="text-align: center "><canvas  id="prueba" width="300" height="300"></canvas>Ingresos / Gastos</td>
                    </tr>
                </table>
            </div>    

            <div class="container col-6" style="float: right"> 
                <h2 class="container-md ">Top 5 Inquilinos morosos</h2>
                <table class="table table-striped">
                    <tr>
                        <th>Consorcio</th>
                        <th>Ph</th>
                        <th>Propietario</th>
                        <th>Cant. Exp. Adeudadas</th>
                        <th>Importe adeudado</th>            
                    </tr>
                    <c:forEach var="pro" items="${moro.topMorososGral}" > 
                        <tr style="text-align: center">
                            <td style="text-align: left">${pro.nombreConsorcio}</td>
                            <td>${pro.descripcion}</td>
                            <td style="text-align: left">${pro.propietario}</td>
                            <td>${pro.cantidadExp}</td>
                            <td style="text-align: right">AR$ ${pro.importeAdeudado}</td>
                        </tr>
                    </c:forEach>
                </table>            
            </div>
        </div>

        <br>
        <div class="container-fluid">
            <div class="container-fluid">
                <div class="col-6"> 
                    <h2 class="container-md ">Reportes por Consorcio</h2>
                    <table>

                        <c:forEach var="pro" items="${con.listadoConsorcios()}" > 

                            <td style="text-align: center" hidden>${pro.id_consorcio}</td>
                            <td>
                                <button class="btn btn-outline-dark" onclick="window.location = 'reporteIndividualServlet?id_consorcio=${pro.id_consorcio }';" > ${pro.nombre} <img src="img/condo.png" height="35" width="35"></button>  
                            </td>                            
                        </c:forEach>
                    </table>            
                </div>

            </div>


            <div class="container-sm " style="float: left">
                <br><br>
                <a class=" btn btn-dark" href="vistaAdmin.jsp">Volver</a>
            </div>


        </div>





    </body>




    <script>
        var ctx = document.getElementById("prueba").getContext("2d");
        var myChart = new Chart(ctx, {
            type: "doughnut",
            data: {
                labels: ['Gastos:$' +${conso.sumEgresos}, 'Ingresos:$' +${conso.sumIngresos}],
                datasets: [{
                        data: [${conso.sumEgresos},${conso.sumIngresos}],
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
        var ctx = document.getElementById('myC');
        var myChart = new Chart(ctx, {
            type: 'doughnut',
            data: {
                labels: ['Adeudadas: ' +${conso.countExpAdeu}, 'Cobradas: ' +${conso.countExpPagadas}],
                datasets: [{
                        label: 'Expensas Cobradas Vs Adeudadas',
                        data: [${conso.countExpAdeu}, ${conso.countExpPagadas}],
                        backgroundColor: [
                            'rgb(241, 148, 138)', 'rgb(133, 193, 233 )'

                        ],
                        borderWidth: 3
                    }]
            },
            options: {
                responsive: false,
                maintainAspectRatio: true
            }
        });
    </script>




</html>











