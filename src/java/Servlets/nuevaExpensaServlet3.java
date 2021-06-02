/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;


import Gestores.GestorConsorcios;
import Gestores.GestorExpensas;
import Modelos.Expensa;
import Modelos.Ph;
import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "nuevaExpensaServlet3", urlPatterns = {"/nuevaExpensaServlet3"})
public class nuevaExpensaServlet3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_ph = Integer.parseInt(request.getParameter("id_ph"));
       

        GestorConsorcios gc = new GestorConsorcios();

        Ph p = gc.getPh(id_ph);
          

        request.setAttribute("lista", p);
      
        
        

        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/nuevaExpensa3.jsp");
        rd.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id_ph = Integer.parseInt(request.getParameter("txtId_Ph"));
        
        String fecha = request.getParameter("fecha");
        String vencimiento = request.getParameter("vencimiento");
                     
        
        Date fechaLiq = null;
        try {
            fechaLiq = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(nuevaExpensaServlet3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        Date fVen = null;
        
        try {
            fVen = new SimpleDateFormat("yyyy-MM-dd").parse(vencimiento);
        } catch (ParseException ex) {
            Logger.getLogger(nuevaExpensaServlet3.class.getName()).log(Level.SEVERE, null, ex);
        }
        double importeExpensa = Double.parseDouble(request.getParameter("txtImporteExpensa"));
        
                     
        
        Ph ph = new Ph(id_ph, "", 0, 0, true, true);

        Expensa nuevaExpensa = new Expensa(id_ph, ph, fechaLiq, fVen,importeExpensa ,false);

        GestorExpensas ge = new GestorExpensas();

        ge.agregarExpensa(nuevaExpensa);
        
        GestorExpensas ge1 = new GestorExpensas();
        
        ArrayList<Expensa> lista = ge1.listadoExpensas(id_ph);
        
        request.setAttribute("lista", lista);
        
        request.setAttribute("ph",id_ph);
       
             
       RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/expensas.jsp");
       rd.forward(request, response);
       

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
