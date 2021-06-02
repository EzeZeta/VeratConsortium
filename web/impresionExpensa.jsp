<!DOCTYPE html>
<html lang="en">
  <head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-grid.min.css" type="text/css"/>
        <link rel="stylesheet" href="css/bootstrap-reboot.css" type="text/css">
        <link rel="Stylesheet" href="css/style.css">

        

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title >Verat Consortium</title>
  </head>
  <body class="container-md">
      
            
            
        
    <header class="clearfix">
        
        
        
        
      <div id="logo">          
          <img src="img/helmet.png"> Powered by Verat Consortium
      </div>
      <div id="company">
        <h2 class="name"> ${impre.nombreConsorcio}</h2>
        <div>${impre.direccionConsorcio}</div>
        <div>CUIT: ${impre.cuit}</div>
        
        
      </div>
     
    </header>
    <main>
      <div id="details" class="clearfix">
        <div id="client">
          <div class="to">Propietario:</div>
          <h2 class="name">${impre.nombrePropietario}</h2>
          
        </div>
        <div id="invoice">
          <h1>Expensa Nro: ${impre.id_expensa}</h1>
          <div class="date">Fecha de emision: ${impre.fecha}</div>
          
        </div>
      </div>
      <table class="table-striped" border="0" cellspacing="0" cellpadding="0">
        <thead>
          <tr>
            <th class="desc">VENCIMIENTO</th>
            <th class="desc">DESCRIPCION</th>            
            <th class="total">IMPORTE</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td class="desc">${impre.vencimiento}</td>
            <td class="desc">Expensas ordinarias del mes en curso.</td>
            
            <td class="total"> <img src="img/ar.png" width="25" height="25" > AR$${impre.importe}</td>
          </tr>
          
          
        </tbody>
        <tfoot>
          
          
        </tfoot>
      </table>
          <div><h3>Muchas gracias!</h3></div>
      <div id="notices">
        <div>INFORMACION:</div>
        <div class="notice">El pago fuera de término implica el cobro de $300 extra en concepto de mora.</div>
        
      </div>
    </main>
      <br>
     <br>
              
      <script>
            //Imprimir pantalla
            function imprimir() {
                window.print('');
            }

            
        </script>
        <div class="container-md">
      <button class="btn btn-outline-light" onclick="imprimir()"><img src="img/printer.png" height="35" width="35"></button>
      
      
      <button class="btn btn-outline-dark" onclick="window.location = 'listaExpensaServlet?id_ph=${impre.id_ph}';">Volver</button>  
                        
        </div>
  </body>
</html>