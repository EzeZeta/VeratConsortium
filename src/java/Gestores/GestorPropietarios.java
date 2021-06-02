/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Modelos.Consorcio;
import Modelos.Persona;
import Modelos.Ph;
import Modelos.TipoDocu;
import Modelos.TipoPersona;
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
public class GestorPropietarios {

    //Declaro e inicializo mis datos de conexion 
    private String CONN = "jdbc:sqlserver://DESKTOP-OHQD2TT:1433;databaseName=VERAT_CONSORTIUM";
    private String USER = "sa";
    private String PASS = "1986";

//     Armo un constructor para que siempre que instancie el gestor se ejecute el Class.forName
    public GestorPropietarios() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Listado de Propietarios
    public ArrayList<Persona> listadoPropietarios() {

        ArrayList<Persona> lista = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select p.id_persona,p.id_consorcio, c.nombreConsorcio,ph.descripcion, p.nombre, \n"
                    + "p.apellido,td.id_tipoDocu, td.descripcion,p.documento, p.telefono, p.mail, p.estado\n"
                    + "from Personas p join TiposDocu td on p.id_tipoDocu = td.id_tipoDocu join \n"
                    + "Ph ph on p.id_ph = ph.id_ph join Consorcios c on\n"
                    + "c.id_consorcio = p.id_consorcio\n"
                    + "where id_tipoPersona = 4 and p.estado = 1 order by 3 ");

            while (rs.next()) {
                int id_persona = rs.getInt(1);
                int id_consorcio = rs.getInt(2);
                String nombreConsorcio = rs.getString(3);
                String dpto = rs.getString(4);
                String nombre = rs.getString(5);
                String apellido = rs.getString(6);
                int idTD = rs.getInt(7);
                String descDoc = rs.getString(8);
                String documento = rs.getString(9);
                String telefono = rs.getString(10);
                String mail = rs.getString(11);
                boolean estado = rs.getBoolean(12);

                TipoDocu td = new TipoDocu(idTD, descDoc);
                td.setId_tipoDocu(idTD);
                td.setDescripcion(descDoc);

                Ph ph = new Ph(0, dpto, 0, 0, true, true);
                ph.setDescripcion(dpto);

                Consorcio cons = new Consorcio(id_consorcio, nombreConsorcio, "", "", "", "", "", "", true,0);
                cons.setId_consorcio(id_consorcio);
                cons.setNombre(nombreConsorcio);

                Persona listaPropietario = new Persona(id_persona, null,
                        nombre, apellido, td, documento, telefono, mail, ph, estado, cons, "");

                listaPropietario.setId_persona(id_persona);
                listaPropietario.setNombre(nombre);
                listaPropietario.setApellido(apellido);
                listaPropietario.setTipoDocu(td);
                listaPropietario.setDocumento(documento);
                listaPropietario.setTelefono(telefono);
                listaPropietario.setMail(mail);
                listaPropietario.setPh(ph);
                listaPropietario.setEstado(estado);
                listaPropietario.setConsorcio(cons);

                lista.add(listaPropietario);
            }
            st.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    //Agregar nuevo PROPIETARIO
    public void agregarPropietario(Persona nuevaPersona) {

        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("insert into Personas ( id_tipoPersona, "
                    + "nombre, apellido, id_tipoDocu, documento, telefono, mail, id_ph, "
                    + "estado, id_consorcio, especialidad)\n"
                    + "values (?,?,?,?,?,?,?,?,?,?,?)");

            st.setInt(1, 4);
            st.setString(2, nuevaPersona.getNombre());
            st.setString(3, nuevaPersona.getApellido());
            st.setInt(4, nuevaPersona.getTipoDocu().getId_tipoDocu());
            st.setString(5, nuevaPersona.getDocumento());
            st.setString(6, nuevaPersona.getTelefono());
            st.setString(7, nuevaPersona.getMail());
            st.setInt(8, nuevaPersona.getPh().getId_ph());
            st.setBoolean(9, nuevaPersona.isEstado());
            st.setInt(10, nuevaPersona.getConsorcio().getId_consorcio());
            st.setString(11, "");

            st.executeUpdate();
            st.close();

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorPropietarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Editar Propietario
    public void editarPropietario(Persona nuevaPersona) {

        try {
            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            PreparedStatement st = conn.prepareStatement("UPDATE Personas set nombre = ?, apellido = ?, "
                    + "documento = ?, telefono = ?, mail = ?"
                    + " where id_persona = ?");
            st.setString(1, nuevaPersona.getNombre());
            st.setString(2, nuevaPersona.getApellido());
            st.setString(3, nuevaPersona.getDocumento());
            st.setString(4, nuevaPersona.getTelefono());
            st.setString(5, nuevaPersona.getMail());
            st.setInt(6, nuevaPersona.getId_persona());

            st.executeUpdate();
            st.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorPropietarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Obtener Propietario para EDITAR
    public Persona getPropietarioEdicion(int id_persona) {

        Persona p = null;
        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("select id_persona, p.id_tipoPersona, nombre, apellido, "
                    + "p.id_tipoDocu, documento, p.telefono, p.mail, p.id_ph, p.id_consorcio from  Personas p join TiposDocu tp on p.id_tipoDocu = tp.id_tipoDocu join Ph ph \n"
                    + "on p.id_ph = ph.id_ph join Consorcios c on c.id_consorcio = p.id_consorcio join \n"
                    + "TiposPersonas tper on tper.id_tipoPersona = p.id_tipoPersona\n"
                    + "where p.id_persona = ? ");

            st.setInt(1, id_persona);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                int id_per = rs.getByte(1);
                int id_tipoPersona = rs.getInt(2);
                String nombre = rs.getString(3);
                String apellido = rs.getString(4);
                int id_tipoDocu = rs.getInt(5);
                String documento = rs.getString(6);
                String telefono = rs.getString(7);
                String mail = rs.getString(8);
                int id_ph = rs.getInt(9);
                int id_consorcio = rs.getInt(10);

                TipoPersona tp = new TipoPersona(id_tipoPersona, "");
                TipoDocu td = new TipoDocu(id_tipoDocu, "");
                Ph ph = new Ph(id_ph, "", 0, id_consorcio, true , true);
                Consorcio con = new Consorcio(id_consorcio, "", "", "", "", "", "", "", true,0);

                p = new Persona(id_per, tp, nombre, apellido, td, documento, telefono, mail, ph, true, con, "");

            }
            st.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorPropietarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    // BAJA logica PROPIETARIO
    public void bajaLogicaPropietario(int id_persona) {

        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            PreparedStatement st = conn.prepareStatement("UPDATE Personas set estado = 0 where id_persona = ?");
            st.setInt(1, id_persona);
            st.executeUpdate();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorPropietarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    
}
