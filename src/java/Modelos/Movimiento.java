/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Movimiento {
    private int id_mov;
    private TipoMovimiento tipoMov;
    private double importe;
    private Date fecha;
    private int id_ph;
    private String detalle;
    private int id_expensa;
    private int id_consorcio;
    private TipoGasto tipoGasto;
    private MetodoPago metPago;

    public Movimiento(int id_mov, TipoMovimiento tipoMov, double importe, Date fecha, int id_ph, String detalle, int id_expensa, int id_consorcio, TipoGasto tipoGasto, MetodoPago metPago) {
        this.id_mov = id_mov;
        this.tipoMov = tipoMov;
        this.importe = importe;
        this.fecha = fecha;
        this.id_ph = id_ph;
        this.detalle = detalle;
        this.id_expensa = id_expensa;
        this.id_consorcio = id_consorcio;
        this.tipoGasto = tipoGasto;
        this.metPago = metPago;
    }

    public int getId_mov() {
        return id_mov;
    }

    public void setId_mov(int id_mov) {
        this.id_mov = id_mov;
    }

    public TipoMovimiento getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(TipoMovimiento tipoMov) {
        this.tipoMov = tipoMov;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId_ph() {
        return id_ph;
    }

    public void setId_ph(int id_ph) {
        this.id_ph = id_ph;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getId_expensa() {
        return id_expensa;
    }

    public void setId_expensa(int id_expensa) {
        this.id_expensa = id_expensa;
    }

    public int getId_consorcio() {
        return id_consorcio;
    }

    public void setId_consorcio(int id_consorcio) {
        this.id_consorcio = id_consorcio;
    }

    public TipoGasto getTipoGasto() {
        return tipoGasto;
    }

    public void setTipoGasto(TipoGasto tipoGasto) {
        this.tipoGasto = tipoGasto;
    }

    public MetodoPago getMetPago() {
        return metPago;
    }

    public void setMetPago(MetodoPago metPago) {
        this.metPago = metPago;
    }

   
    
    
    

    
    
    
    
}
