/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import DTOS.dtoDatosImpresionExpensa;
import Modelos.Expensa;
import Modelos.Ph;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class GestorExpensas {

    //Declaro e inicializo mis datos de conexion 
    private String CONN = "jdbc:sqlserver://DESKTOP-OHQD2TT:1433;databaseName=VERAT_CONSORTIUM";
    private String USER = "sa";
    private String PASS = "1986";

//     Armo un constructor para que siempre que instancie el gestor se ejecute el Class.forName
    public GestorExpensas() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorExpensas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Agregar nuevo Expensas
    public void agregarExpensa(Expensa nuevaExpensa) {

        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("insert into Expensas (id_ph, fecha, vencimiento,importe ,estado) values(?,?,?,?,?)");

            st.setInt(1, nuevaExpensa.getPh().getId_ph());
            st.setDate(2, new java.sql.Date(nuevaExpensa.getFecha().getTime()));
            st.setDate(3, new java.sql.Date(nuevaExpensa.getVencimiento().getTime()));
            st.setDouble(4, nuevaExpensa.getImporteExpensa());
            st.setBoolean(5, nuevaExpensa.isEstado());

            st.executeUpdate();
            st.close();

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorExpensas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Listado de Expensas por PH
    public ArrayList<Expensa> listadoExpensas(int id_ph) {

        ArrayList<Expensa> lista = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select * from Expensas e join Ph ph on e.id_ph = ph.id_ph  where e.id_ph = ?");

            st.setInt(1, id_ph);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                int id_expensa = rs.getInt(1);
                int id_ph1 = rs.getInt(2);
                Date fecha = rs.getDate(3);
                Date vencimiento = rs.getDate(4);
                double importeExpensa = rs.getDouble(5);
                boolean estado = rs.getBoolean(6);
                int id_ph2 = rs.getInt(7);
                String descripcion = rs.getString(8);
                double importe = rs.getDouble(9);
                int id_consorcio = rs.getInt(10);
                boolean ocupado = rs.getBoolean(11);
                boolean estadoPh = rs.getBoolean(12);

                Ph ph = new Ph(id_ph2, descripcion, importe, id_consorcio, ocupado, estadoPh);
                Expensa ex = new Expensa(id_expensa, ph, fecha, vencimiento, importeExpensa, estado);

                ex.setId_expensa(id_expensa);
                ex.setPh(ph);
                ex.setFecha(fecha);
                ex.setVencimiento(vencimiento);
                ex.setEstado(estado);

                lista.add(ex);
            }
            st.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorExpensas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    // Obtener DATOS EXPENSA PARA DIBUJAR HTML
    public dtoDatosImpresionExpensa getExpensaPrint(int id_expensa) {

        dtoDatosImpresionExpensa impresion = null;
        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select e.id_expensa, ph.descripcion, c.nombreConsorcio, c.direccionConsorcio, p.nombre +' '+ p.apellido as nombrePropietario,\n"
                    + "e.fecha, e.vencimiento, e.importe, ph.id_ph, c.cuit\n"
                    + "from Personas p join Ph ph on p.id_ph = ph.id_ph join Expensas e on ph.id_ph = e.id_ph join Consorcios c on c.id_consorcio = ph.id_consorcio join \n"
                    + "TiposPersonas tp on tp.id_tipoPersona = p.id_tipoPersona\n"
                    + "where p.id_tipoPersona = 4 and  e.id_expensa = ? and p.estado = 1");

            st.setInt(1, id_expensa);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                int id_expensa1 = rs.getInt(1);
                String descripcion = rs.getString(2);
                String nombreConsorcio = rs.getString(3);
                String direccionConsorcio = rs.getString(4);
                String nombrePropietario = rs.getString(5);
                Date fecha = rs.getDate(6);
                Date vencimiento = rs.getDate(7);
                double importeExp = rs.getDouble(8);
                int id_ph = rs.getInt(9);
                String cuit = rs.getString(10);

                impresion = new dtoDatosImpresionExpensa(id_expensa1, descripcion, nombreConsorcio, direccionConsorcio, nombrePropietario, fecha, vencimiento, importeExp, id_ph, cuit);

            }
            st.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorExpensas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return impresion;
    }

    public ArrayList<Expensa> listadoExpensasAdeudadas(int id_ph) {

        ArrayList<Expensa> lista = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select * from Expensas e join Ph ph on e.id_ph = ph.id_ph  where e.estado = 0 and e.id_ph = ? ");

            st.setInt(1, id_ph);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                int id_expensa = rs.getInt(1);
                int id_ph1 = rs.getInt(2);
                Date fecha = rs.getDate(3);
                Date vencimiento = rs.getDate(4);
                double importeExpensa = rs.getDouble(5);
                boolean estado = rs.getBoolean(6);
                int id_ph2 = rs.getInt(7);
                String descripcion = rs.getString(8);
                double importe = rs.getDouble(9);
                int id_consorcio = rs.getInt(10);
                boolean ocupado = rs.getBoolean(11);
                boolean estadoPh = rs.getBoolean(12);

                Ph ph = new Ph(id_ph2, descripcion, importe, id_consorcio, ocupado, estadoPh);

                Expensa ex = new Expensa(id_expensa, ph, fecha, vencimiento, importeExpensa, estado);

                ex.setId_expensa(id_expensa);
                ex.setPh(ph);
                ex.setFecha(fecha);
                ex.setVencimiento(vencimiento);
                ex.setImporteExpensa(importeExpensa);
                ex.setEstado(estado);

                lista.add(ex);
            }
            st.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorExpensas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public int getCountExpAdeu() {
        int cant = 0;
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select count(*)as adeudada from Expensas where estado = 0");

            while (rs.next()) {

                cant = rs.getInt(1);

            }
            cant = rs.getInt(1);

            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorExpensas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    public int getCountExpPagadas() {
        int cant = 0;
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select count(*)as adeudada from Expensas where estado = 1");

            while (rs.next()) {

                cant = rs.getInt(1);

            }
            cant = rs.getInt(1);

            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorExpensas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cant;

    }

    public int getSumIngresos() {
        int sum = 0;
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select sum(importe)\n"
                    + "from Movimientos\n"
                    + "where id_tipoMov = 1");

            while (rs.next()) {

                sum = rs.getInt(1);

            }
            sum = rs.getInt(1);

            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorExpensas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sum;

    }

    public int getSumEgresos() {
        int sum = 0;
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select sum(importe)\n"
                    + "from Movimientos\n"
                    + "where id_tipoMov = 2");

            while (rs.next()) {

                sum = rs.getInt(1);

            }
            sum = rs.getInt(1);

            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorExpensas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sum;

    }

}
