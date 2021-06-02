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
public class TipoMovimiento {
    private int id_tipoMov;
    private String descripcion;

    public TipoMovimiento(int id_tipoMov, String descripcion) {
        this.id_tipoMov = id_tipoMov;
        this.descripcion = descripcion;
    }

    public int getId_tipoMov() {
        return id_tipoMov;
    }

    public void setId_tipoMov(int id_tipoMov) {
        this.id_tipoMov = id_tipoMov;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
