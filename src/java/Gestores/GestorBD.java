/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Modelos.Consorcio;
import Modelos.Ph;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelos.TipoDocu;
import Modelos.TipoPersona;

/**
 *
 * @author Usuario
 */
public class GestorBD {

    //Declaro e inicializo mis datos de conexion 
    private String CONN = "jdbc:sqlserver://DESKTOP-OHQD2TT:1433;databaseName=VERAT_CONSORTIUM";
    private String USER = "sa";
    private String PASS = "1986";

    // Armo un constructor para que siempre que instancie el gestor se ejecute el Class.forName
    public GestorBD() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    //Listado de Tipos de DOUMENTOS para armar combo
    public ArrayList<TipoDocu> listadoTiposDocu() {
        
        ArrayList<TipoDocu> lista = new ArrayList<>();
        try {
            
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from TiposDocu");
            
            while (rs.next()) {
                int id_tipoDocu = rs.getInt(1);
                String descripcion = rs.getString(2);
                
                TipoDocu tipoDocu = new TipoDocu(id_tipoDocu, descripcion);
                tipoDocu.setId_tipoDocu(id_tipoDocu);
                tipoDocu.setDescripcion(descripcion);
                
                lista.add(tipoDocu);
            }
            st.close();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    //Listado TIPOS DE PERSONA para armar combo
    public ArrayList<TipoPersona> listadoTipoPersona() {
        
        ArrayList<TipoPersona> lista = new ArrayList<>();
        try {
            
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from TiposPersonas");
            
            while (rs.next()) {
                int id_tipoPersona = rs.getInt(1);
                String descripcion = rs.getString(2);
                
                TipoPersona tipoPersona = new TipoPersona(id_tipoPersona, descripcion);
                tipoPersona.setId_tipoPersona(id_tipoPersona);
                tipoPersona.setDescripcion(descripcion);
                
                lista.add(tipoPersona);
            }
            st.close();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    //Listado de CONSORCIOS para armar combo
    public ArrayList<Consorcio> listadoConsorcios() {
        
        ArrayList<Consorcio> lista = new ArrayList<>();
        try {
            
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from Consorcios where estado = 1");
            
            while (rs.next()) {
                int id_consorcio = rs.getInt(1);
                String nombre = rs.getString(2);
                String direccion = rs.getString(3);
                String cuit = rs.getString(4);
                String nombreEnc = rs.getString(5);
                String apellidoEnc =rs.getString(6);
                String telefono = rs.getString(7);
                String mail = rs.getString(8);
                boolean estado = rs.getBoolean(9);
                double saldoInicial = rs.getDouble(10);
                
                Consorcio consorcio = new Consorcio(id_consorcio, nombre, direccion, cuit, nombreEnc, apellidoEnc, telefono, mail, estado, saldoInicial);
                                
                consorcio.setId_consorcio(id_consorcio);
                consorcio.setNombre(nombre);
                consorcio.setDireccion(direccion);
                consorcio.setCuit(cuit);
                consorcio.setNombreEnc(nombreEnc);
                consorcio.setApellidoEnc(apellidoEnc);
                consorcio.setTelefono(telefono);
                consorcio.setMail(mail);
                consorcio.setEstado(estado);
                
                lista.add(consorcio);
            }
            st.close();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    //Listado de PH para armar combo
    public ArrayList<Ph> listadoPh() {
        
        ArrayList<Ph> lista = new ArrayList<>();
        try {
            
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from Ph where estado = 1 and ocupado = 0");
            
            while (rs.next()) {
                int id_ph = rs.getInt(1);
                String descripcion = rs.getString(2);
                double importeExp = rs.getDouble(3);
                int id_consorcio = rs.getInt(4);
                boolean ocupado = rs.getBoolean(5);
                boolean estado = rs.getBoolean(6);
                Ph ph = new Ph(id_ph, descripcion, importeExp, id_consorcio,ocupado,estado);
                
                ph.setId_ph(id_ph);
                ph.setDescripcion(descripcion);
                ph.setImporteExp(importeExp);
                ph.setId_consorcio(id_consorcio);
                ph.setOcupado(ocupado);
                ph.setEstado(estado);
                
                
                lista.add(ph);
            }
            st.close();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    //Nueva expensa
    
    
    
    
    
    
    
    
    
}
