/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTOS;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class dtoDatosImpresionExpensa {
    
    private int id_expensa;
    private String descripcion;
    private String nombreConsorcio;
    private String direccionConsorcio;
    private String nombrePropietario;
    private Date fecha;
    private Date vencimiento;
    private double importe;
    private int id_ph;
    private String cuit;

    public dtoDatosImpresionExpensa(int id_expensa, String descripcion, String nombreConsorcio, String direccionConsorcio, String nombrePropietario, Date fecha, Date vencimiento, double importe, int id_ph, String cuit) {
        this.id_expensa = id_expensa;
        this.descripcion = descripcion;
        this.nombreConsorcio = nombreConsorcio;
        this.direccionConsorcio = direccionConsorcio;
        this.nombrePropietario = nombrePropietario;
        this.fecha = fecha;
        this.vencimiento = vencimiento;
        this.importe = importe;
        this.id_ph = id_ph;
        this.cuit = cuit;
    }

    public int getId_expensa() {
        return id_expensa;
    }

    public void setId_expensa(int id_expensa) {
        this.id_expensa = id_expensa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreConsorcio() {
        return nombreConsorcio;
    }

    public void setNombreConsorcio(String nombreConsorcio) {
        this.nombreConsorcio = nombreConsorcio;
    }

    public String getDireccionConsorcio() {
        return direccionConsorcio;
    }

    public void setDireccionConsorcio(String direccionConsorcio) {
        this.direccionConsorcio = direccionConsorcio;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
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

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public int getId_ph() {
        return id_ph;
    }

    public void setId_ph(int id_ph) {
        this.id_ph = id_ph;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
    
    

       
    
    
    
    
    
    
    
    
    
    
    
    
}
