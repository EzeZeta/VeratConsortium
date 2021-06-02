/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Gestores.GestorExpensas;
import Modelos.Expensa;
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
@WebServlet(name = "listaExpensaServlet", urlPatterns = {"/listaExpensaServlet"})
public class listaExpensaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_ph = Integer.parseInt(request.getParameter("id_ph"));
        
        GestorExpensas ge = new GestorExpensas();
        ArrayList<Expensa> lista = ge.listadoExpensas(id_ph);
        request.setAttribute("lista", lista);
        
        request.setAttribute("ph",id_ph);
        
        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/expensas.jsp");
        rd.forward(request, response);
        
        

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_ph = Integer.parseInt(request.getParameter("id_ph"));
        GestorExpensas ge = new GestorExpensas();
        ArrayList<Expensa> lista = ge.listadoExpensas(id_ph);
        request.setAttribute("lista", lista);
        
        request.setAttribute("ph",id_ph);
        
        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/expensas.jsp");
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
