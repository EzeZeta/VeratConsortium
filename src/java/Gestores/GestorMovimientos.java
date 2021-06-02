/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import DTOS.dtoObtenerMovimientos;
import Modelos.MetodoPago;
import Modelos.Movimiento;
import Modelos.Ph;
import Modelos.TipoGasto;
import Modelos.TipoMovimiento;
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
public class GestorMovimientos {
    
    //Declaro e inicializo mis datos de conexion 
    private String CONN = "jdbc:sqlserver://DESKTOP-OHQD2TT:1433;databaseName=VERAT_CONSORTIUM";
    private String USER = "sa";
    private String PASS = "1986";

//     Armo un constructor para que siempre que instancie el gestor se ejecute el Class.forName
    public GestorMovimientos() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorMovimientos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    //Agregar nuevo MOVIMIENTO
    public void agregarIngreso(Movimiento nuevoMovimiento) {

        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("insert into Movimientos (id_tipoMov, importe, fecha, id_ph, "
                    + "detalle, id_expensa,id_consorcio, id_metPago) values (?,?,?,?,?,?,?,?)");

            
            st.setInt(1, nuevoMovimiento.getTipoMov().getId_tipoMov());
            st.setDouble(2, nuevoMovimiento.getImporte());
            st.setDate(3, new java.sql.Date(nuevoMovimiento.getFecha().getTime()));
            st.setInt(4, nuevoMovimiento.getId_ph());
            st.setString(5, nuevoMovimiento.getDetalle());
            st.setInt(6, nuevoMovimiento.getId_expensa());
            st.setInt(7, nuevoMovimiento.getId_consorcio());
            st.setInt(8, nuevoMovimiento.getMetPago().getId_metPago());
                    

            st.executeUpdate();
            st.close();

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorMovimientos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    //Obtener listado TipoGasto para combo
    
    public ArrayList<TipoGasto> listadoTipoGasto() {
        
        ArrayList<TipoGasto> lista = new ArrayList<>();
        try {
            
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from TiposGastos");
            
            while (rs.next()) {
                int id_tipoGasto = rs.getInt(1);
                String detalleGasto = rs.getString(2);
                
                TipoGasto tipoGasto = new TipoGasto(id_tipoGasto, detalleGasto);
                
                tipoGasto.setId_tipoGasto(id_tipoGasto);
                tipoGasto.setDetalleGasto(detalleGasto);
                
                
                
                lista.add(tipoGasto);
            }
            st.close();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(GestorMovimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
     //Obtener listado METODO PAGO para combo
    
    public ArrayList<MetodoPago> listadoMetodoPago() {
        
        ArrayList<MetodoPago> lista = new ArrayList<>();
        try {
            
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("Select * from MetodosPagos");
            
            while (rs.next()) {
                int id_metPago = rs.getInt(1);
                String detalle = rs.getString(2);
                
                MetodoPago mp = new MetodoPago(id_metPago, detalle);
                
                mp.setId_metPago(id_metPago);
                mp.setDetalle(detalle);
                
                
                
                lista.add(mp);
            }
            st.close();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(GestorMovimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
     //Obtener listado MOVIMIENTOS
       
    public ArrayList<dtoObtenerMovimientos> listadoMovimientos(int id_consorcio) {

        ArrayList<dtoObtenerMovimientos> lista = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select * from Movimientos m "
                    + "left join TiposGastos tg  on m.id_tipoGasto = tg.id_tipoGasto "
                    + "left join TiposMovimientos tm on m.id_tipoMov = tm.id_tipoMov left "
                    + "join MetodosPagos mp on m.id_metPago = mp.id_metPago left join Ph "
                    + "ph on m.id_ph = ph.id_ph where m.id_consorcio = ? order by 4");

            st.setInt(1, id_consorcio);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                int id_movimiento = rs.getInt(1);
                int id_tipoMov = rs.getInt(2);
                double importe = rs.getDouble(3);
                Date fecha = rs.getDate(4);
                int id_ph = rs.getInt(5);    
                String detalle = rs.getString(6);
                int id_expensa = rs.getInt(7);
                int id_consorcio1 = rs.getInt(8);
                int id_tipoGasto = rs.getInt(9);
                int id_metPago = rs.getInt(10);
                int id_tipoGasto1 = rs.getInt(11);
                String detalleGasto = rs.getString(12);
                int id_tipoMov1 = rs.getInt(13);
                String descripcionTM = rs.getString(14); 
                int id_metPago1 = rs.getInt(15);
                String detalleMP = rs.getString(16);
                int id_ph2 = rs.getInt(17);
                String descripcionPh = rs.getString(18); 
                
                TipoMovimiento tm = new TipoMovimiento(id_tipoMov, descripcionTM);
                Ph ph = new Ph(id_ph2, descripcionPh, 0, 0, true, true);
                TipoGasto tg = new TipoGasto(id_tipoGasto, detalleGasto);
                MetodoPago mp = new MetodoPago(id_metPago, detalleMP);
                dtoObtenerMovimientos obtenerMov = new dtoObtenerMovimientos(id_movimiento, tm, importe, fecha, ph, detalle, id_expensa, id_consorcio, tg, mp);
                
                obtenerMov.setId_mov(id_movimiento);
                obtenerMov.setTipoMov(tm);
                obtenerMov.setImporte(importe);
                obtenerMov.setFecha(fecha);
                obtenerMov.setPh(ph);
                obtenerMov.setDetalle(detalle);
                obtenerMov.setId_expensa(id_expensa);
                obtenerMov.setId_consorcio(id_consorcio);
                obtenerMov.setTipoGasto(tg);
                obtenerMov.setMetPago(mp);
                              
                lista.add(obtenerMov);
            }
            st.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorMovimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    //Obtener listado MOVIMIENTOS
       
    public ArrayList<dtoObtenerMovimientos> listadoMovFiltro(int id_consorcio, String fechaD, String fechaH) {

        ArrayList<dtoObtenerMovimientos> lista = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select * from Movimientos m "
                    + "left join TiposGastos tg  on m.id_tipoGasto = tg.id_tipoGasto left"
                    + " join TiposMovimientos tm on m.id_tipoMov = tm.id_tipoMov left join "
                    + "MetodosPagos mp on m.id_metPago = mp.id_metPago left join Ph ph on m.id_ph "
                    + "= ph.id_ph where m.id_consorcio = ? and m.fecha between ? and ? order by 4");

            st.setInt(1, id_consorcio);
            st.setString(2, fechaD);
            st.setString(3, fechaH);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                int id_movimiento = rs.getInt(1);
                int id_tipoMov = rs.getInt(2);
                double importe = rs.getDouble(3);
                Date fecha = rs.getDate(4);
                int id_ph = rs.getInt(5);    
                String detalle = rs.getString(6);
                int id_expensa = rs.getInt(7);
                int id_consorcio1 = rs.getInt(8);
                int id_tipoGasto = rs.getInt(9);
                int id_metPago = rs.getInt(10);
                int id_tipoGasto1 = rs.getInt(11);
                String detalleGasto = rs.getString(12);
                int id_tipoMov1 = rs.getInt(13);
                String descripcionTM = rs.getString(14); 
                int id_metPago1 = rs.getInt(15);
                String detalleMP = rs.getString(16);
                int id_ph2 = rs.getInt(17);
                String descripcionPh = rs.getString(18); 
                
                TipoMovimiento tm = new TipoMovimiento(id_tipoMov, descripcionTM);
                Ph ph = new Ph(id_ph2, descripcionPh, 0, 0, true, true);
                TipoGasto tg = new TipoGasto(id_tipoGasto, detalleGasto);
                MetodoPago mp = new MetodoPago(id_metPago, detalleMP);
                dtoObtenerMovimientos obtenerMov = new dtoObtenerMovimientos(id_movimiento, tm, importe, fecha, ph, detalle, id_expensa, id_consorcio1, tg, mp);
                
                obtenerMov.setId_mov(id_movimiento);
                obtenerMov.setTipoMov(tm);
                obtenerMov.setImporte(importe);
                obtenerMov.setFecha(fecha);
                obtenerMov.setPh(ph);
                obtenerMov.setDetalle(detalle);
                obtenerMov.setId_expensa(id_expensa);
                obtenerMov.setId_consorcio(id_consorcio1);
                obtenerMov.setTipoGasto(tg);
                obtenerMov.setMetPago(mp);
                              
                lista.add(obtenerMov);
            }
            st.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorMovimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    
    
    
    
    //Agregar nuevo GASTO
    public void agregarGasto(Movimiento nuevoMovimiento) {

        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("insert into Movimientos (id_tipoMov, importe,fecha,detalle,id_consorcio, id_tipoGasto ) values (?,?,?,?,?,?)");

            
            st.setInt(1, nuevoMovimiento.getTipoMov().getId_tipoMov());
            st.setDouble(2, nuevoMovimiento.getImporte());
            st.setDate(3, new java.sql.Date(nuevoMovimiento.getFecha().getTime()));
            st.setString(4, nuevoMovimiento.getDetalle());          
            st.setInt(5, nuevoMovimiento.getId_consorcio());
            st.setInt(6, nuevoMovimiento.getTipoGasto().getId_tipoGasto());
                    

            st.executeUpdate();
            st.close();

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorMovimientos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public double getIngresos(int id_consorcio) {

        double ingresos = 0;
        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select SUM(importe) from Movimientos where id_tipoMov = 1 and id_consorcio = ?");

            st.setInt(1, id_consorcio);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                double ingresos1 = rs.getDouble(1);
                

                ingresos = ingresos1;

            }
            st.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorMovimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ingresos;
    }
    
    public double getGastos(int id_consorcio) {

        double gastos = 0;
        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select SUM(importe) from Movimientos where id_tipoMov = 2 and id_consorcio = ?");

            st.setInt(1, id_consorcio);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                double gastos1 = rs.getDouble(1);
                

                gastos = gastos1;

            }
            st.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorMovimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gastos;
    }
    
    public double getSaldoInicial(int id_consorcio) {

        double saldoInicial = 0;
        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select saldoInicial from Consorcios where id_consorcio = ?");

            st.setInt(1, id_consorcio);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                double saldo1 = rs.getDouble(1);
                

                saldoInicial = saldo1;

            }
            st.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorMovimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return saldoInicial;
    }
    
    
    
    
}
