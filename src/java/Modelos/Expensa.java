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
public class Expensa {
    private int id_expensa;
    private Ph ph;
    private Date fecha;
    private Date vencimiento;
    private double importeExpensa;
    private boolean estado;

    public Expensa(int id_expensa, Ph ph, Date fecha, Date vencimiento, double importeExpensa, boolean estado) {
        this.id_expensa = id_expensa;
        this.ph = ph;
        this.fecha = fecha;
        this.vencimiento = vencimiento;
        this.importeExpensa = importeExpensa;
        this.estado = estado;
    }

    public int getId_expensa() {
        return id_expensa;
    }

    public void setId_expensa(int id_expensa) {
        this.id_expensa = id_expensa;
    }

    public Ph getPh() {
        return ph;
    }

    public void setPh(Ph ph) {
        this.ph = ph;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    public double getImporteExpensa() {
        return importeExpensa;
    }

    public void setImporteExpensa(double importeExpensa) {
        this.importeExpensa = importeExpensa;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
    
    
}
