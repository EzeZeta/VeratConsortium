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
@WebServlet(name = "ingresoEleccionPhServlet", urlPatterns = {"/ingresoEleccionPhServlet"})
public class ingresoEleccionPhServlet extends HttpServlet {

    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String descripcion = request.getParameter("descripcion");
        String nombreConsorcio = request.getParameter("nombreConsorcio");
        
        int id_ph = Integer.parseInt(request.getParameter("id_ph"));
        
        int id_consorcio = Integer.parseInt(request.getParameter("id_consorcio"));
        GestorExpensas ge = new GestorExpensas();
        
        ArrayList<Expensa> lista = ge.listadoExpensasAdeudadas(id_ph);
        
        request.setAttribute("nombreConsorcio",nombreConsorcio); 
        request.setAttribute("descripcion",descripcion);
        request.setAttribute("id_consorcio",id_consorcio);
        
        request.setAttribute("lista", lista);
        request.setAttribute("id_ph", id_ph);
        
        
        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/nuevoIngresoOk.jsp");
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
