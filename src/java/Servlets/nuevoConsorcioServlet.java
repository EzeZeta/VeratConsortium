/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Gestores.GestorConsorcios;
import Modelos.Consorcio;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "nuevoConsorcioServlet", urlPatterns = {"/nuevoConsorcioServlet"})
public class nuevoConsorcioServlet extends HttpServlet {

    
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombreCons = request.getParameter("txtNombre");
        String direccion = request.getParameter("txtDireccion");
        String cuit = request.getParameter("txtCuit");
        String nombreEnc = request.getParameter("txtNombreEnc");
        String apellidoEnc = request.getParameter("txtApellidoEnc");
        String telefono = request.getParameter("txtTelEnc");
        String mail = request.getParameter("txtMail");
        double saldoInicial = Double.parseDouble(request.getParameter("txtSaldoInicial"));
        boolean estado = true;
        
        Consorcio cons = new Consorcio(0, nombreCons, direccion, cuit, nombreEnc, apellidoEnc, telefono, mail, estado, saldoInicial);
        
        GestorConsorcios gc = new GestorConsorcios();
        gc.agregarConsorcio(cons);
        
        RequestDispatcher rc = request.getServletContext().getRequestDispatcher("/listaConsorciosServlet");
        rc.forward(request, response);

        
        
        
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
