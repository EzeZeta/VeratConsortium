/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import DTOS.dtoMorososGral;
import DTOS.dtoTotalGastos;
import Modelos.Consorcio;
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

    //MOROSOS GENERICOS
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

    //MOROSOS POR CONSORCIO
    public ArrayList<dtoMorososGral> getTopMorososConso(int id_consorcio) {
        dtoMorososGral mg = null;
        ArrayList<dtoMorososGral> lista = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select TOP 5 nombreConsorcio , descripcion , p.apellido +' '+ p.nombre as nombre , count(e.estado) 'Cantidad exp adeudadas', SUM(e.importe)'Importe adeudado'\n"
                    + "from Consorcios c join Ph ph on c.id_consorcio = ph.id_consorcio join Personas p on p.id_ph = ph.id_ph join Expensas e on e.id_ph = ph.id_ph\n"
                    + "where p.id_tipoPersona = 4 and e.estado = 0 and c.id_consorcio = ?\n"
                    + "group by nombreConsorcio, descripcion, apellido,nombre order by 4 desc");

            st.setInt(1, id_consorcio);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String nombreConsorcio = rs.getString(1);
                String descripcion = rs.getString(2);
                String propietario = rs.getString(3);
                int cantidadExp = rs.getInt(4);
                double importeAdeudado = rs.getDouble(5);

                mg = new dtoMorososGral(nombreConsorcio, descripcion, propietario, cantidadExp, importeAdeudado);

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

    // Obtener datos GASTOS
    public ArrayList<dtoTotalGastos> getTotalGastos() {

        ArrayList<dtoTotalGastos> lista = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select tg.detalleGasto, sum(m.importe)\n"
                    + "from Movimientos m join TiposMovimientos tm on m.id_tipoMov = tm.id_tipoMov join TiposGastos tg on m.id_tipoGasto = tg.id_tipoGasto \n"
                    + "where tm.id_tipoMov = 2\n"
                    + "group by tg.detalleGasto");

            while (rs.next()) {
                String detalleGasto = rs.getString(1);
                double importe = rs.getDouble(2);

                dtoTotalGastos tg = new dtoTotalGastos(detalleGasto, importe);

                tg.setDetalleGasto(detalleGasto);
                tg.setImporte(importe);

                lista.add(tg);
            }
            st.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorReportes.class.getName()).log(Level.SEVERE, null, ex);
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

    //RETORNA LA SUMA DE LOS INGRESOS HISTORICOS DE UN CONSORCIO
    public int getSumIngresosConso(int id_consorcio) {
        int sum = 0;
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select sum(importe)\n"
                    + "from Movimientos\n"
                    + "where id_tipoMov = 1 and id_consorcio = ?");

            st.setInt(1, id_consorcio);

            ResultSet rs = st.executeQuery();

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

    //RETORNA LA SUMA DE LOS INGRESOS DE UN CONSORCIO EN UN PERIODO DE FECHAS DADO
    public int getSumIngresosConsoFilt(int id_consorcio, String fechaD, String fechaH) {
        int sum = 0;
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select sum(importe)\n"
                    + "from Movimientos\n"
                    + "where id_tipoMov = 1 and id_consorcio = ? and fecha between ? and ?");

            st.setInt(1, id_consorcio);
            st.setString(2, fechaD);
            st.setString(3, fechaH);

            ResultSet rs = st.executeQuery();

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

    //RETORNA LA SUMA DE LOS GASOTS DE UN CONSORCIO EN UN PERIODO DE FECHAS DADO
    public int getSumEgresosConsoFilt(int id_consorcio, String fechaD, String fechaH) {
        int sum = 0;
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select sum(importe)\n"
                    + "from Movimientos\n"
                    + "where id_tipoMov = 2 and id_consorcio = ? and fecha between ? and ? ");

            st.setInt(1, id_consorcio);
            st.setString(2, fechaD);
            st.setString(3, fechaH);

            ResultSet rs = st.executeQuery();

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

    //RETORNA LA SUMA DE LOS GASOTS HISTORICOS DE UN CONSORCIO 
    public int getSumEgresosConso(int id_consorcio) {
        int sum = 0;
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select sum(importe)\n"
                    + "from Movimientos\n"
                    + "where id_tipoMov = 2 and id_consorcio = ? ");

            st.setInt(1, id_consorcio);

            ResultSet rs = st.executeQuery();

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

    //CONTADOR DE EXPENSAS PARA REPORTE DE CONSORCIO
    //RETORNA LA CANTIDAD DE EXPENSAS ADEUDADAS HISTORICAS DE UN CONSORCIO
    public int getCantExpAdeuCon(int id_consorcio) {
        int count = 0;
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select count(*)from Expensas e join Ph ph "
                    + "on e.id_ph = ph.id_ph join Consorcios c on c.id_consorcio = ph.id_consorcio\n"
                    + "where e.estado = 0 and c.id_consorcio = ?");

            st.setInt(1, id_consorcio);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                count = rs.getInt(1);

            }
            count = rs.getInt(1);

            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorExpensas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;

    }

    //RETORNA LA CANTIDAD DE EXPENSAS ADEUDADAS DE UN CONSORCIO EN UN PERIODO DE FECHAS DADO
    public int getCantExpAdeuFilt(int id_consorcio, String fechaD, String fechaH) {
        int count = 0;
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select count(*)from Expensas e join Ph ph on "
                    + "e.id_ph = ph.id_ph join Consorcios c on c.id_consorcio = ph.id_consorcio\n"
                    + "where e.estado = 0 and c.id_consorcio = ? and e.fecha between ? and ?");

            st.setInt(1, id_consorcio);
            st.setString(2, fechaD);
            st.setString(3, fechaH);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                count = rs.getInt(1);

            }
            count = rs.getInt(1);

            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorExpensas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;

    }

    //RETORNA LA CANTIDAD DE EXPENSAS PAGADAS HISTORICAS DE UN CONSORCIO
    public int getCantExpPagaCon(int id_consorcio) {
        int count = 0;
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select count(*)from Expensas e join Ph ph on e.id_ph = "
                    + "ph.id_ph join Consorcios c on c.id_consorcio = ph.id_consorcio\n"
                    + "where e.estado = 1 and c.id_consorcio = ?");

            st.setInt(1, id_consorcio);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                count = rs.getInt(1);

            }
            count = rs.getInt(1);

            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorExpensas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;

    }

    //RETORNA LA CANTIDAD DE EXPENSAS PAGADAS DE UN CONSORCIO EN UN PERIODO DE FECHAS DADO
    public int getCantExpPagFilt(int id_consorcio, String fechaD, String fechaH) {
        int count = 0;
        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select count(*)from Expensas e join "
                    + "Ph ph on e.id_ph = ph.id_ph join Consorcios c on c.id_consorcio = ph.id_consorcio\n"
                    + "where e.estado = 1 and c.id_consorcio = ? and e.fecha between ? and ?");

            st.setInt(1, id_consorcio);
            st.setString(2, fechaD);
            st.setString(3, fechaH);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                count = rs.getInt(1);

            }
            count = rs.getInt(1);

            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorExpensas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;

    }

}
