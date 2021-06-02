/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gestores;

import Modelos.Persona;
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
public class GestorProveedores {

    //Declaro e inicializo mis datos de conexion 
    private String CONN = "jdbc:sqlserver://DESKTOP-OHQD2TT:1433;databaseName=VERAT_CONSORTIUM";
    private String USER = "sa";
    private String PASS = "1986";

//     Armo un constructor para que siempre que instancie el gestor se ejecute el Class.forName
    public GestorProveedores() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Listado de Proveedores
    public ArrayList<Persona> listadoProveedores() {

        ArrayList<Persona> lista = new ArrayList<>();
        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select p.id_persona,  p.nombre, p.apellido, p.documento, p.telefono, p.mail, p.especialidad\n"
                    + "from Personas p join TiposPersonas tp on p.id_tipoPersona = tp.id_tipoPersona join TiposDocu td on p.id_tipoDocu = td.id_tipoDocu\n"
                    + "where tp.id_tipoPersona = 6 and estado = 1   ");

            while (rs.next()) {
                int id_persona = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String documento = rs.getString(4);
                String telefono = rs.getString(5);
                String mail = rs.getString(6);
                String especialidad = rs.getString(7);

                Persona listaProveedor = new Persona(id_persona, null, nombre, apellido, null, documento, telefono, mail, null, true, null, especialidad);
                listaProveedor.setId_persona(id_persona);
                listaProveedor.setNombre(nombre);
                listaProveedor.setApellido(apellido);
                listaProveedor.setDocumento(documento);
                listaProveedor.setTelefono(telefono);
                listaProveedor.setMail(mail);
                listaProveedor.setEspecialidad(especialidad);

                lista.add(listaProveedor);
            }
            st.close();
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    //Agregar nuevo PROVEEDOR
    public void agregarProveedor(Persona nuevaPersona) {

        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);

            PreparedStatement st = conn.prepareStatement("insert into Personas ( id_tipoPersona, "
                    + "nombre, apellido, id_tipoDocu, documento, telefono, mail,"
                    + "estado, especialidad)\n"
                    + "values (?,?,?,?,?,?,?,?,?)");

            st.setInt(1, 6);
            st.setString(2, nuevaPersona.getNombre());
            st.setString(3, nuevaPersona.getApellido());
            st.setInt(4, nuevaPersona.getTipoDocu().getId_tipoDocu());
            st.setString(5, nuevaPersona.getDocumento());
            st.setString(6, nuevaPersona.getTelefono());
            st.setString(7, nuevaPersona.getMail());
            st.setBoolean(8, nuevaPersona.isEstado());
            st.setString(9, nuevaPersona.getEspecialidad());

            st.executeUpdate();
            st.close();

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(GestorProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // BAJA logica PROVEEDOR
    public void bajaLogicaProveedor(int id_persona) {

        try {

            Connection conn = DriverManager.getConnection(CONN, USER, PASS);
            PreparedStatement st = conn.prepareStatement("UPDATE Personas set estado = 0 where id_persona = ?");
            st.setInt(1, id_persona);
            st.executeUpdate();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(GestorProveedores.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
