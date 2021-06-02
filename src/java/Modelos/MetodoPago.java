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
public class MetodoPago {
    
    private int id_metPago;
    private String detalle;

    public MetodoPago(int id_metPago, String detalle) {
        this.id_metPago = id_metPago;
        this.detalle = detalle;
    }

    public int getId_metPago() {
        return id_metPago;
    }

    public void setId_metPago(int id_metPago) {
        this.id_metPago = id_metPago;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    
    
    
    
}
