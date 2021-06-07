/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Gestores.GestorMovimientos;
import Modelos.MetodoPago;
import Modelos.Movimiento;
import Modelos.TipoMovimiento;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "cargarIngresoServlet", urlPatterns = {"/cargarIngresoServlet"})
public class cargarIngresoServlet extends HttpServlet {

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

        String idExpensas = request.getParameter("id_expensa");
        double totalFinal = Double.parseDouble(request.getParameter("totalFinal"));
        int id_ph = Integer.parseInt(request.getParameter("id_ph"));
        int id_consorcio = Integer.parseInt(request.getParameter("id_consorcio"));
        String fecha = request.getParameter("fecha");
        List<Integer> testList = new ArrayList<Integer>();

        String[] arrOfStr = idExpensas.split(" ");
        for (String a : arrOfStr) {

            GestorMovimientos gm = new GestorMovimientos();
            int id = Integer.parseInt(a);
            gm.cambiarEstExpensa(id);

        }

        Date fechaIng = null;
        try {
            fechaIng = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(cargarIngresoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        int id_metPago = Integer.parseInt(request.getParameter("cboMetPago"));

        String detalle = request.getParameter("txtDetalle");

        TipoMovimiento tm = new TipoMovimiento(1, "");
        MetodoPago mp = new MetodoPago(id_metPago, "");

        Movimiento nuevoMovimiento = new Movimiento(0, tm, totalFinal, fechaIng, id_ph, detalle, 0, id_consorcio, null, mp);

        GestorMovimientos gm = new GestorMovimientos();

        gm.agregarIngreso(nuevoMovimiento);
        
        String idCons = String.valueOf(id_consorcio);
        
        request.setAttribute("id_consorcio", idCons);
        
        
        
        RequestDispatcher rc = request.getServletContext().getRequestDispatcher("/detalleMovimientosServlet2");
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
