/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Gestores.GestorConsorcios;
import Modelos.Consorcio;
import Modelos.Ph;
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
@WebServlet(name = "nuevaExpensaServlet1", urlPatterns = {"/nuevaExpensaServlet1"})
public class nuevaExpensaServlet1 extends HttpServlet {

  
    

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
        
        GestorConsorcios gestor = new GestorConsorcios();
        ArrayList<Consorcio> lista = gestor.listadoConsorcios();

        request.setAttribute("lista", lista);

        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/nuevaExpensa1.jsp");
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
        
//        int id_consorcio = Integer.parseInt(request.getParameter("cboConso"));
//        GestorConsorcios gc = new GestorConsorcios();
//        
//        ArrayList<Ph> lista = gc.listadoPhCombo(id_consorcio);    
//        
//        
//        request.setAttribute("lista", lista);
//        
//        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/nuevaExpensa1.jsp");
//        rd.forward(request, response);
        
//        GestorConsorcios gestor = new GestorConsorcios();
//        ArrayList<Consorcio> lista = gestor.listadoConsorcios();
//
//        request.setAttribute("lista", lista);
//
//        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/nuevaExpensa1.jsp");
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
