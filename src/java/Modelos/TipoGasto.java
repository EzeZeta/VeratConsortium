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
public class TipoGasto {
    private int id_tipoGasto;
    private String detalleGasto;

    public TipoGasto(int id_tipoGasto, String detalleGasto) {
        this.id_tipoGasto = id_tipoGasto;
        this.detalleGasto = detalleGasto;
    }

    public int getId_tipoGasto() {
        return id_tipoGasto;
    }

    public void setId_tipoGasto(int id_tipoGasto) {
        this.id_tipoGasto = id_tipoGasto;
    }

    public String getDetalleGasto() {
        return detalleGasto;
    }

    public void setDetalleGasto(String detalleGasto) {
        this.detalleGasto = detalleGasto;
    }
    
    
    
    
    
}
