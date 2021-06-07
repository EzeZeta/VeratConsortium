/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOS;

/**
 *
 * @author Usuario
 */
public class dtoTotalGastos {
    
    private String detalleGasto;
    private double importe;

    public dtoTotalGastos(String detalleGasto, double importe) {
        this.detalleGasto = detalleGasto;
        this.importe = importe;
    }

    public String getDetalleGasto() {
        return detalleGasto;
    }

    public void setDetalleGasto(String detalleGasto) {
        this.detalleGasto = detalleGasto;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
    
    
    
    
}
