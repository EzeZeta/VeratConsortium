/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Gestores.GestorMovimientos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "detalleMovimientosServlet2", urlPatterns = {"/detalleMovimientosServlet2"})
public class detalleMovimientosServlet2 extends HttpServlet {

   
   

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
