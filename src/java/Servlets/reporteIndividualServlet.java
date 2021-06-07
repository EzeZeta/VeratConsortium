/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DTOS.dtoMorososGral;
import Gestores.GestorMovimientos;
import Gestores.GestorReportes;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
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
@WebServlet(name = "reporteIndividualServlet", urlPatterns = {"/reporteIndividualServlet"})
public class reporteIndividualServlet extends HttpServlet {

    
    

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
        GestorReportes gr = new GestorReportes();
        
        int gastos = gr.getSumEgresosConso(id_consorcio);
        request.setAttribute("gasto", gastos);
        
        int deuda = gr.getCantExpAdeuCon(id_consorcio);
        request.setAttribute("deuda", deuda);
        
        int pagada = gr.getCantExpPagaCon(id_consorcio);
        request.setAttribute("pagada", pagada);
        
        int ingresos = gr.getSumIngresosConso(id_consorcio);
        request.setAttribute("ingresos", ingresos);
        
        
        ArrayList<dtoMorososGral> lista = gr.getTopMorososConso(id_consorcio);
        
        request.setAttribute("lista", lista);
        
        GestorMovimientos gm = new GestorMovimientos();
        
        ArrayList<DTOS.dtoObtenerMovimientos> listaMov = gm.listadoMovimientos(id_consorcio);
        request.setAttribute("listaMov", listaMov);

        double saldoInicial = gm.getSaldoInicial(id_consorcio);
        double ingresos1 = gm.getIngresos(id_consorcio);
        double gastos1 = gm.getGastos(id_consorcio);

        double saldoCaja = 0;
        saldoCaja = (saldoInicial + ingresos1) - gastos1;
        request.setAttribute("saldoCaja", saldoCaja);
        
        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/reporteConso.jsp");
        rd.forward(request, response);
        
        
        
        
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
        
        int id_consorcio = Integer.parseInt(request.getParameter("id_con"));
        double saldoCaja = Double.parseDouble(request.getParameter("saldo"));
        String fechaD = request.getParameter("fechaD");
        String fechaH = request.getParameter("fechaH");
        
        GestorReportes gr = new GestorReportes();
        
        int gastos = gr.getSumEgresosConsoFilt(id_consorcio, fechaD, fechaH);
        request.setAttribute("gasto", gastos);
        request.setAttribute("saldoCaja", saldoCaja);
        
        int ingresos = gr.getSumIngresosConsoFilt(id_consorcio, fechaD, fechaH);
        request.setAttribute("ingresos", ingresos);
        
        int cantAdeu = gr.getCantExpAdeuFilt(id_consorcio, fechaD, fechaH);
        request.setAttribute("deuda", cantAdeu);
        
        int cantPaga = gr.getCantExpPagFilt(id_consorcio, fechaD, fechaH);
        request.setAttribute("pagada", cantPaga);
        
        request.setAttribute("fechaDesde", fechaD);
        request.setAttribute("fechaHasta", fechaH);
            
        
        
        
        
        GestorMovimientos gm = new GestorMovimientos();
        ArrayList<DTOS.dtoObtenerMovimientos> listaMov = gm.listadoMovFiltro(id_consorcio, fechaD, fechaH);
        request.setAttribute("listaMov", listaMov);
        
        ArrayList<dtoMorososGral> lista = gr.getTopMorososConso(id_consorcio);        
        request.setAttribute("lista", lista);
        
        
        
        
        
        
        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/reporteConso.jsp");
        rd.forward(request, response);
        
        
        
        
        
        
        
        
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
