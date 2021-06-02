
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-grid.min.css" type="text/css"/>
        <link rel="stylesheet" href="css/bootstrap-reboot.css" type="text/css">

        <link  rel="icon"   href="img/helmet.ico" />
        <jsp:include page="/adminHeaderNavbarLayout.jsp"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title >Verat Consortium</title>
    </head>
    <body>

       
        <div class="container-md"> 
            <h1 class="container-fluid" >Movimientos</h1>
            <h3 class="container-fluid">           
                <small class="text-muted">Elegí tu opción.</small>
            </h3>
            <div/>

            <div class="container-md" > 
                
                <%!           
                int id_consorcio;
                String nombreConsorcio;
                %>
                <%
                nombreConsorcio = request.getParameter("nombre");
                id_consorcio = Integer.parseInt(request.getParameter("id_consorcio"));
                %>
                
                <h4> <%= nombreConsorcio %></h4>
                <button class="btn btn-outline-dark" onclick="window.location = 'listaDptosIngresosServlet?id_consorcio=<%= id_consorcio %>&nombreConsorcio=<%=nombreConsorcio%>';" >Nuevo Ingreso</button>
                <button class="btn btn-outline-dark" onclick="window.location = 'nuevoGasto.jsp?id_consorcio=<%= id_consorcio %>&nombreConsorcio=<%=nombreConsorcio%>';" >Nuevo Gasto</button>
                <button class="btn btn-outline-dark" onclick="window.location = 'detalleMovimientosServlet?id_consorcio=<%= id_consorcio %>&nombreConsorcio=<%=nombreConsorcio%>';" >Detalle Movimientos</button>
                <button class="btn btn-outline-dark" onclick="window.location = 'detalleMovimientosServlet?id_consorcio=<%= id_consorcio %>&nombreConsorcio=<%=nombreConsorcio%>';" >Cierre de Mes</button>

                

            </div><br>
            <div class="container-md">

                <a class=" btn btn-dark" onclick="atras()">Volver</a>


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
</html>
