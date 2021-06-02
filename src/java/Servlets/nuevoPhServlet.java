/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DTOS.dtoObtenerConsorcio;
import Gestores.GestorConsorcios;
import Modelos.Consorcio;
import Modelos.Ph;
import java.io.IOException;
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
@WebServlet(name = "nuevoPhServlet", urlPatterns = {"/nuevoPhServlet"})
public class nuevoPhServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        
        int id_consorcio = Integer.parseInt(request.getParameter("id_consorcio"));

        GestorConsorcios gc = new GestorConsorcios();

        dtoObtenerConsorcio c = gc.obtenerConsorcio(id_consorcio);

        request.setAttribute("cons", c);
        
              
        RequestDispatcher rc = request.getServletContext().getRequestDispatcher("/nuevoPh.jsp");
        rc.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_consorcio = Integer.parseInt(request.getParameter("txtId_Cons"));
        String descripcion = request.getParameter("txtNomenclatura");
        double importeExp = Double.parseDouble(request.getParameter("txtImporte"));
//        String nombreConsorcio = request.getParameter("txtConsorcio");
        
        Ph nuevoPh = new Ph(0, descripcion, importeExp, id_consorcio, false, true);
        
        GestorConsorcios gc = new GestorConsorcios();
        
        gc.agregarPh(nuevoPh);
        
        
        GestorConsorcios gc1 = new GestorConsorcios();
        
        ArrayList<Ph> lista= gc1.listadoPhCompleto(id_consorcio);
        
        
        
        request.setAttribute("lista", lista);
        request.setAttribute("consorcio", id_consorcio);
        
        RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/ph.jsp");
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
