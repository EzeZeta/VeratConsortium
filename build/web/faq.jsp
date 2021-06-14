
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

        <link rel="stylesheet" href="CSS/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-grid.min.css" type="text/css"/>
        <link rel="stylesheet" href="css/bootstrap-reboot.css" type="text/css">

        <script src="sweetalert2.all.min.js"></script>
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

        <jsp:include page="/adminHeaderNavbarLayout.jsp"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title >Verat Consortium</title>
    </head>
    <body >
        <h1 class="container-md">Preguntas frecuentes</h1><br>
        <div class="container-md">     
            <table  id="tabla">

                <thead>
                    <tr><td colspan="6">
                            <input id="buscar" type="text" class="form-control" placeholder="Busca por palabras claves" /> 
                        </td> </tr>

                <th style="text-align: center">Consulta</th><th style="text-align: center">Ir</th>

                </thead>

                <tr style="text-align: left">
                    <td>¿Como comienzo?</td><td><button class="btn btn-outline-dark" onclick="onBoarding()" ><img src="img/info.png" height="20" width="20"></button></td></tr>
                <tr style="text-align: left">
                    <td>¿Como creo un consorcio?</td><td><button class="btn btn-outline-dark" onclick="nuevoCons()" ><img src="img/info.png" height="20" width="20"></button></td></tr>
                <tr style="text-align: left">
                    <td>¿Como creo un ph?</td><td><button class="btn btn-outline-dark" onclick="nuevoPh()"  ><img src="img/info.png" height="20" width="20"></button></td></tr>
                <tr style="text-align: left">
                    <td>¿Como liquido una expensa?</td><td><button class="btn btn-outline-dark" onclick="nuevaExp()" ><img src="img/info.png" height="20" width="20"></button></td></tr>
                <tr style="text-align: left">
                    <td>¿Como cargo un ingreso?</td><td><button class="btn btn-outline-dark" onclick="nuevoIngreso()"  ><img src="img/info.png" height="20" width="20"></button></td></tr>
                <tr style="text-align: left">
                    <td>¿Como cargo un gasto?</td><td><button class="btn btn-outline-dark" onclick="nuevoGasto()" ><img src="img/info.png" height="20" width="20"></button></td></tr>

            </table>
        </div>


        <div class="container-md">
            <a class=" btn btn-dark" href="vistaAdmin.jsp">Volver</a>
            <a class=" btn btn-dark" href= https://forms.gle/hcNm53qNxLRZPzoP8 target="blank" >Consultas?</a>
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

            <script>
                function onBoarding() {

                    Swal.fire(
                            'Como comienzo?',
                            'Para comenzar es necesario que crees al menos un Consorcio con sus respectivos Ph, de esta forma vas a poder comenzar a trabajar.',
                            'info'
                            );
                }
    </script>
    
    <script>
        function nuevoCons() {

            Swal.fire({
                titleText: 'Crear Nuevo Consorcio',
                text: 'Consorcios > Nuevo Consorcio > Agregar',
                imageUrl: 'img/nuevoConso.gif',
                imageHeight: 400,
                width: '900px'
            });
        }
        
        function nuevoPh() {

            Swal.fire({
                titleText: 'Crear Nuevo Ph',
                text: 'Consorcios > Listar Ph > Nuevo Ph > Agregar',
                imageUrl: 'img/nuevoPh.gif',
                imageHeight: 400,
                width: '900px',
                heigth: '800px'
            });
        }
        
        function nuevaExp() {

            Swal.fire({
                titleText: 'Crear Nueva Expensa',
                text: 'Expensas > Elegir Consorcio > Elegir Ph > Crear Expensa > Liquidar. (Recorda que podes descargarla desde el icono de la lupa)',
                imageUrl: 'img/nuevaExp.gif',
                imageHeight: 400,
                width: '900px',
                heigth: '800px'
            });
        }
        
        
        
        
        
        
        
    </script>



    </body>
</html>
