/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Gestores.GestorConsorcios;
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
@WebServlet(name = "listaDptosIngresosServlet", urlPatterns = {"/listaDptosIngresosServlet"})
public class listaDptosIngresosServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_consorcio = Integer.parseInt(request.getParameter("id_consorcio"));
        String nombre = request.getParameter("nombreConsorcio");
        
        GestorConsorcios gc = new GestorConsorcios();
        
        ArrayList<Ph> lista= gc.listadoPhCompleto(id_consorcio);
        
        
        
        request.setAttribute("lista", lista);
        request.setAttribute("nombreConsorcio", nombre);
        request.setAttribute("consorcio", id_consorcio);
        
        
        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/elegirPhIngresos.jsp");
        rd.forward(request, response);
        
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        
        
        
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
