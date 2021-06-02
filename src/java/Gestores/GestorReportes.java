/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import DTOS.dtoMorososGral;
import Modelos.Consorcio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class GestorReportes {

    //Declaro e inicializo mis datos de conexion 
    private String CONN = "jdbc:sqlserver://DESKTOP-OHQD2TT:1433;databaseName=VERAT_CONSORTIUM";
    private String USER = "sa";
    private String PASS = "1986";

//     Armo un constructor para que siempre que instancie el gestor se ejecute el Class.forName
    public GestorReportes() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<dtoMorososGral> getTopMorososGral() {

        ArrayList<dtoMorososGral> lista = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select TOP 5 nombreConsorcio , descripcion , p.apellido +' '+ p.nombre as nombre , count(e.estado) 'Cantidad exp adeudadas', SUM(e.importe)'Importe adeudado'\n"
                    + "from Consorcios c join Ph ph on c.id_consorcio = ph.id_consorcio join Personas p on p.id_ph = ph.id_ph join Expensas e on e.id_ph = ph.id_ph\n"
                    + "where p.id_tipoPersona = 4 and e.estado = 0\n"
                    + "group by nombreConsorcio, descripcion, apellido,nombre order by 4 desc");

            while (rs.next()) {
                String nombreConsorcio = rs.getString(1);
                String descripcion = rs.getString(2);
                String propietario = rs.getString(3);
                int cantidadExp = rs.getInt(4);
                double importeAdeudado = rs.getDouble(5);
                
                dtoMorososGral mg = new dtoMorososGral(nombreConsorcio, descripcion, propietario, cantidadExp, importeAdeudado);
                
                mg.setNombreConsorcio(nombreConsorcio);
                mg.setDescripcion(descripcion);
                mg.setPropietario(propietario);
                mg.setCantidadExp(cantidadExp);
                mg.setImporteAdeudado(importeAdeudado);
                

                lista.add(mg);
            }
            st.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorReportes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

}
