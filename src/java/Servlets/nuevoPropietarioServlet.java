/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;


import Gestores.GestorPropietarios;
import Modelos.Consorcio;
import Modelos.Persona;
import Modelos.Ph;
import Modelos.TipoDocu;
import Modelos.TipoPersona;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "nuevoPropietarioServlet", urlPatterns = {"/nuevoPropietarioServlet"})
public class nuevoPropietarioServlet extends HttpServlet {

   
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        int tipoDocu = Integer.parseInt(request.getParameter("cboTipoDNI"));
        String nroDocumento = request.getParameter("txtNroDNI");
        String telefono = request.getParameter("txtTelefono");
        String mail = request.getParameter("txtMail");
        int id_Ph = Integer.parseInt(request.getParameter("cboPh"));
        int id_Consorcio = Integer.parseInt(request.getParameter("cboCons"));
        int id_tipoPersona = 4 ;

        TipoPersona tp = new TipoPersona(id_tipoPersona, "");
        TipoDocu td = new TipoDocu(tipoDocu, "");
        Ph ph = new Ph(id_Ph, "", 0, 0, true, true);
        Consorcio cons = new Consorcio(id_Consorcio, "", "", "", "", "", "", "", true,0);

        Persona nuevaPersona = new Persona(0, tp, nombre, apellido, td,
                nroDocumento, telefono, mail, ph, true, cons, apellido);

        GestorPropietarios gp = new GestorPropietarios();
        gp.agregarPropietario(nuevaPersona);

        RequestDispatcher rc = request.getServletContext().getRequestDispatcher("/listaPropietariosServlet");
        rc.forward(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
