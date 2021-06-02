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

        <div class="container-fluid"> 
            <h1 class="container-fluid" >Administracion de caja</h1>
            <h3 class="container-fluid">           
                <small class="text-muted">Gestiona los movimientos y crea expensas.</small>
            </h3>
            <div/>

            <div class="container-fluid" >         

                <a class="btn btn-outline-dark" href="listaPropietariosServlet">Nuevo Movimiento</a>
                <a class="btn btn-outline-dark" href="nuevaExpensaServlet1">Nueva Expensa</a>

            </div><br>
            <div class="container-md">
                
                <a class=" btn btn-dark" href="vistaAdmin.jsp">Volver</a>
                
                
            </div>

    </body>
</html>