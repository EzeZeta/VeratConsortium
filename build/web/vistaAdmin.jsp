<%-- 
    Document   : vistaAdmin
    Created on : 19 abr. 2021, 20:10:08
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-grid.min.css" type="text/css"/>
        <link rel="stylesheet" href="css/bootstrap-reboot.css" type="text/css">

        <link  rel="icon"   href="img/helmet.ico" />

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title >Verat Consortium</title>

        <jsp:include page="/adminHeaderNavbarLayout.jsp"/>
    </head>

    <div class="container-fluid" style="text-align: center" >
        <body>

            <div class="container-fluid"> 
                <h1 class="container-fluid" >Bienvenido a tu perfil</h1>
                <h3 class="container-fluid">           
                    <small class="text-muted">Administracion de datos.</small>
                </h3>
                <div/>

                <div class="container-fluid" >         
                    <a class="btn btn-outline-dark" href="listaConsorciosServlet">Consorcios</a>
                    <a class="btn btn-outline-dark" href="listaPropietariosServlet">Propietarios</a>
                    <a class="btn btn-outline-dark" href="listaInquilinosServlet">Inquilinos</a>
                    <a class="btn btn-outline-dark" href="listaProveedoresServlet">Proveedores</a>                    
                    <a class="btn btn-outline-dark" href="nuevoMovimientoServlet1">Caja</a>
                    <a class="btn btn-outline-dark" href="nuevaExpensaServlet1">Expensas</a>
                    <a class="btn btn-outline-dark" href="reporte.jsp">Reportes</a>
                    

                </div>

        </body>
        <jsp:include page="/footer.jsp"/>
    
</html>
