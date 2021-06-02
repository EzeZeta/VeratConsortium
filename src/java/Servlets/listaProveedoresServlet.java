/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Gestores.GestorProveedores;
import Modelos.Persona;
import java.io.IOException;
import static java.lang.System.out;
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
@WebServlet(name = "listaProveedoresServlet", urlPatterns = {"/listaProveedoresServlet"})
public class listaProveedoresServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
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
        
        
       GestorProveedores gestor = new GestorProveedores();
       ArrayList<Persona> lista = gestor.listadoProveedores();
       
               
        request.setAttribute("lista", lista);
        
        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/proveedores.jsp");
        rd.forward(request, response);
    }

   
    
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
       GestorProveedores gestor = new GestorProveedores();
       ArrayList<Persona> lista = gestor.listadoProveedores();
       
               
        request.setAttribute("lista", lista);
        
        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/proveedores.jsp");
        rd.forward(request, response);
    }
     
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
