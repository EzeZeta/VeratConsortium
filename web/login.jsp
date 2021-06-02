<%-- 
    Document   : login
    Created on : 19 abr. 2021, 20:11:09
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <link rel="stylesheet" href="css/styles.css"/>            
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        
        <jsp:include page="/headerNavbarLayout.jsp"/> 
        
        

        <title>Verat Consortium</title>

    </head>


    <body>

        <%-- Validacion de datos de acceso--%>
        <div class="container-fluid ">    
            <% if (request.getAttribute("mensajeError") != null && !request.getAttribute("mensajeError").equals("")) {%>
            <h2 class="display-6"> ${mensajeError} </h2>
            <% }%>   

        </div>

        <div class=" col-md-4 container login-form " style="text-align: center"  >

            <form action="LoginServlet" method="post" > 			
                <div class="row">
                    <div class="col-md-12 login-form-header">
                        <p class="login-form-font-header">Carga tus datos de acceso<p>
                    </div>
                </div> <br>
                <div class="row">
                    <div class="col-md-12 login-from-row">
                        <input name="txtUsuario" type="text" placeholder="Usuario" required/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 login-from-row">
                        <input name="txtPass" type="password" placeholder="Contraseña" required/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 login-from-row">
                        <input class="btn btn-outline-dark" type="submit" value="Iniciar sesion">
                    </div>
                </div>
            </form>
        </div>



    </body>
    <jsp:include page="/footer.jsp"/>
</html>