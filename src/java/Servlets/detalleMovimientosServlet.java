/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DTOS.dtoObtenerMovimientos;
import Gestores.GestorMovimientos;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.util.calendar.Gregorian;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "detalleMovimientosServlet", urlPatterns = {"/detalleMovimientosServlet"})
public class detalleMovimientosServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_consorcio = Integer.parseInt(request.getParameter("id_consorcio"));

        GestorMovimientos gm = new GestorMovimientos();
        ArrayList<DTOS.dtoObtenerMovimientos> lista = gm.listadoMovimientos(id_consorcio);
        request.setAttribute("lista", lista);

        double saldoInicial = gm.getSaldoInicial(id_consorcio);
        double ingresos = gm.getIngresos(id_consorcio);
        double gastos = gm.getGastos(id_consorcio);

        double saldoCaja = 0;
        saldoCaja = (saldoInicial + ingresos) - gastos;
        request.setAttribute("saldoCaja", saldoCaja);

        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/detalleMovimientos.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_consorcio1 = Integer.parseInt(request.getParameter("txtId"));
        String id_consorcio = request.getParameter("txtId");
        String nombreConsorcio = request.getParameter("nombreConsorcio");
        String fechaD = request.getParameter("fechaDesde");
        String fechaH = request.getParameter("fechaHasta");
        
                 
        GestorMovimientos gm = new GestorMovimientos();
        
        ArrayList<dtoObtenerMovimientos> lista = gm.listadoMovFiltro(id_consorcio1, fechaD, fechaH);
        
       
        
         
        

        double saldoInicial = gm.getSaldoInicial(id_consorcio1);
        double ingresos = gm.getIngresos(id_consorcio1);
        double gastos = gm.getGastos(id_consorcio1);

        double saldoCaja = 0;
        
        saldoCaja = (saldoInicial + ingresos) - gastos;
        
        request.setAttribute("saldoCaja", saldoCaja);
        request.setAttribute("id_consorcio", id_consorcio);
        request.setAttribute("nombreConsorcio", nombreConsorcio);
        request.setAttribute("lista", lista);        
        request.setAttribute("saldoCaja", saldoCaja);

        

        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/detalleMovimientos.jsp");
        rd.forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
