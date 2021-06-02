/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Gestores.GestorMovimientos;
import Modelos.Movimiento;
import Modelos.TipoGasto;
import Modelos.TipoMovimiento;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "nuevoGastoServlet", urlPatterns = {"/nuevoGastoServlet"})
public class nuevoGastoServlet extends HttpServlet {

  
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_consorcio = Integer.parseInt(request.getParameter("txtIdConsorcio"));
        
        String fecha = request.getParameter("fecha");
        
        Date fechaGasto = null;
        try {
            fechaGasto = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(nuevoGastoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        int id_tipoGasto = Integer.parseInt(request.getParameter("cboTipoGasto"));
        
        double importe = Double.parseDouble(request.getParameter("txtImporte"));
        
        String detalle = request.getParameter("txtDetalle");
        
        TipoMovimiento tm = new TipoMovimiento(2, "");
        
        TipoGasto tg = new TipoGasto(id_tipoGasto, "");
        
        Movimiento nuevoMovimiento = new Movimiento(0, tm, importe, fechaGasto, 0, detalle, 0, id_consorcio, tg, null);
        
        
        GestorMovimientos gm = new GestorMovimientos();
        
        gm.agregarGasto(nuevoMovimiento);
        
//        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/reporte.jsp");
//        rd.forward(request, response);
        
        
        
        
        
        
        
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
