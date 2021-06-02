/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Modelos.Consorcio;
import DTOS.dtoObtenerConsorcio;
import Modelos.Ph;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
public class GestorConsorcios {

    //Declaro e inicializo mis datos de conexion 
    private String CONN = "jdbc:sqlserver://DESKTOP-OHQD2TT:1433;databaseName=VERAT_CONSORTIUM";
    private String USER = "sa";
    private String PASS = "1986";

//     Armo un constructor para que siempre que instancie el gestor se ejecute el Class.forName
    public GestorConsorcios() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorConsorcios.class.getName()).log(Level.SEVERE, null, ex);
        }

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
                String apellidoEnc = rs.getString(6);
                String telefono = rs.getString(7);
                String mail = rs.getString(8);
                boolean estado = rs.getBoolean(9);
                double saldoInicial = rs.getDouble(10);

                Consorcio consorcio = new Consorcio(id_consorcio, nombre, direccion, cuit, nombreEnc,apellidoEnc, telefono, mail, estado, saldoInicial);
                consorcio.setId_consorcio(id_consorcio);
                consorcio.setNombre(nombre);
                consorcio.setDireccion(direccion);
                consorcio.setCuit(cuit);
                consorcio.setNombreEnc(nombreEnc);
                consorcio.setApellidoEnc(apellidoEnc);
                consorcio.setTelefono(telefono);
                consorcio.setMail(mail);
                consorcio.setEstado(estado);
                consorcio.setSaldoInicial(saldoInicial);

                lista.add(consorcio);
            }
            st.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorConsorcios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    //Agregar nuevo Consorcio
    public void agregarConsorcio(Consorcio nuevoConsorcio) {

        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("insert into Consorcios (nombreConsorcio, "
                    + "direccionConsorcio, cuit, nombreEncargado, apellidoEncargado, telefono, mail, estado, saldoInicial) values(?,?,?,?,?,?,?,?,?)");

            st.setString(1, nuevoConsorcio.getNombre());
            st.setString(2, nuevoConsorcio.getDireccion());
            st.setString(3, nuevoConsorcio.getCuit());
            st.setString(4, nuevoConsorcio.getNombreEnc());
            st.setString(5, nuevoConsorcio.getApellidoEnc());
            st.setString(6, nuevoConsorcio.getTelefono());
            st.setString(7, nuevoConsorcio.getMail());
            st.setBoolean(8, true);
            st.setDouble(9, nuevoConsorcio.getSaldoInicial());
            st.executeUpdate();
            st.close();

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorConsorcios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Baja logica CONSORCIOS
    public void bajaLogicaConsorcio(int id_consorcio) {

        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            PreparedStatement st = conn.prepareStatement("UPDATE Consorcios set estado = 0 where id_consorcio = ?");
            st.setInt(1, id_consorcio);
            st.executeUpdate();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorConsorcios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     // Baja logica PH
    public void bajaLogicaPH(int id_consorcio) {

        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            PreparedStatement st = conn.prepareStatement("UPDATE Ph set estado = 0 where id_consorcio = ?");
            st.setInt(1, id_consorcio);
            st.executeUpdate();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorConsorcios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Obtener consorcio para nuevo PH
    public dtoObtenerConsorcio obtenerConsorcio(int id_consorcio) {

        DTOS.dtoObtenerConsorcio c = null;
        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select id_consorcio , nombreConsorcio from "
                    + "Consorcios where id_consorcio = ?");

            st.setInt(1, id_consorcio);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                int id_consorcio1 = rs.getInt(1);
                String nombreConsorcio = rs.getString(2);

                c = new DTOS.dtoObtenerConsorcio(id_consorcio1, nombreConsorcio);

            }
            st.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorConsorcios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    //Listado de PH para armar combo
    public ArrayList<Ph> listadoPh() {

        ArrayList<Ph> lista = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from Ph where ocupado = 0");

            while (rs.next()) {
                int id_ph = rs.getInt(1);
                String descripcion = rs.getString(2);
                double importeExp = rs.getDouble(3);
                int id_consorcio = rs.getInt(4);
                boolean ocupado = rs.getBoolean(5);
                boolean estado = rs.getBoolean(5);
                Ph ph = new Ph(id_ph, descripcion, importeExp, id_consorcio, ocupado, estado);

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
            Logger.getLogger(GestorConsorcios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    //Listado de PH para armar combo
    public ArrayList<Ph> listadoPhCompleto(int id_Consorcio) {

        ArrayList<Ph> lista = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select p.id_ph, p.descripcion, p.importeExp, p.id_consorcio,c.nombreConsorcio, p.ocupado, p.estado\n"
                    + "from Consorcios c join Ph p on c.id_consorcio = p.id_consorcio where p.id_consorcio = ?");

            st.setInt(1, id_Consorcio);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int id_ph = rs.getInt(1);
                String descripcion = rs.getString(2);
                double importeExp = rs.getDouble(3);
                int id_consorcio = rs.getInt(4);

                boolean ocupado = rs.getBoolean(6);
                boolean estado = rs.getBoolean(7);
                Ph ph = new Ph(id_ph, descripcion, importeExp, id_consorcio, ocupado, estado);

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
            Logger.getLogger(GestorConsorcios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    //Listado de PH para armar combo en Expensas
    public ArrayList<Ph> listadoPhCombo(int id_Consorcio) {

        ArrayList<Ph> lista = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select * from Ph where id_consorcio = ?");

            st.setInt(1, id_Consorcio);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int id_ph = rs.getInt(1);
                String descripcion = rs.getString(2);
                double importeExp = rs.getDouble(3);
                int id_consorcio = rs.getInt(4);
                boolean ocupado = rs.getBoolean(5);
                boolean estado = rs.getBoolean(6);
                Ph ph = new Ph(id_ph, descripcion, importeExp, id_consorcio, ocupado, estado);

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
            Logger.getLogger(GestorConsorcios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    // Agregar nuevo PH
    public void agregarPh(Ph nuevoPh) {

        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("insert into Ph (descripcion, importeExp, "
                    + "id_consorcio, ocupado, estado) values(?,?,?,0,1)");

            st.setString(1, nuevoPh.getDescripcion());
            st.setDouble(2, nuevoPh.getImporteExp());
            st.setInt(3, nuevoPh.getId_consorcio());

            st.executeUpdate();
            st.close();

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorConsorcios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Obtener PH para Nueva Expensa
    public Ph getPh(int id_ph) {

        Ph ph = null;
        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select * \n"
                    + "from Ph where id_ph = ?");

            st.setInt(1, id_ph);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                int id_ph1 = rs.getInt(1);
                String descripcion = rs.getString(2);
                double importeExp = rs.getDouble(3);
                int id_consorcio = rs.getInt(4);
                boolean ocupado = rs.getBoolean(5);
                boolean estado = rs.getBoolean(6);
                           

                ph = new Ph(id_ph1,descripcion ,importeExp ,id_consorcio, ocupado, estado);

            }
            st.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorConsorcios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ph;
    }

}
