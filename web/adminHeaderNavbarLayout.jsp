<%-- 
    Document   : navBarAdminLayout
    Created on : 26 oct. 2020, 19:37:47
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-grid.min.css" type="text/css"/>
    <link rel="stylesheet" href="css/bootstrap-reboot.css" type="text/css">
    <link  rel="icon"   href="img/helmet.ico" />



    <title>Verat Consortium</title>
  </head>
  <body style="background-image: url(img/fondo.jpg)  " >      
      <div class="navbar, text-md-right">
          <ul class="nav justify-content-end">
                                                                       
            <li class="nav-item">
              <a class="nav-link" href="LoginServlet" style="color: grey">Administracion</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/VeratConsortium/cerrarSesionServlet" style="color: grey" >Cerrar Sesion</a>
            </li>
            
        </ul>
          
      </div>
      <h1 class="display-4"> <img src="img/helmet.png" height="100" width="100"> Verat Consortium </h1>
      
        
  </body>
</html>