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
public class dtoMorososGral {
    
    private String nombreConsorcio;
    private String descripcion;
    private String propietario;
    private int cantidadExp;
    private double importeAdeudado;

    public dtoMorososGral(String nombreConsorcio, String descripcion, String propietario, int cantidadExp, double importeAdeudado) {
        this.nombreConsorcio = nombreConsorcio;
        this.descripcion = descripcion;
        this.propietario = propietario;
        this.cantidadExp = cantidadExp;
        this.importeAdeudado = importeAdeudado;
    }

    public String getNombreConsorcio() {
        return nombreConsorcio;
    }

    public void setNombreConsorcio(String nombreConsorcio) {
        this.nombreConsorcio = nombreConsorcio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public int getCantidadExp() {
        return cantidadExp;
    }

    public void setCantidadExp(int cantidadExp) {
        this.cantidadExp = cantidadExp;
    }

    public double getImporteAdeudado() {
        return importeAdeudado;
    }

    public void setImporteAdeudado(double importeAdeudado) {
        this.importeAdeudado = importeAdeudado;
    }
    
    
    
    
    
}
