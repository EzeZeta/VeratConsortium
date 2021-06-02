/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Usuario
 */
public class TipoDocu {
    private int id_tipoDocu;
    private String descripcion;

    public TipoDocu(int id_tipoDocu, String descripcion) {
        this.id_tipoDocu = id_tipoDocu;
        this.descripcion = descripcion;
    }

    public int getId_tipoDocu() {
        return id_tipoDocu;
    }

    public void setId_tipoDocu(int id_tipoDocu) {
        this.id_tipoDocu = id_tipoDocu;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
