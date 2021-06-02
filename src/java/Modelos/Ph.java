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
public class Ph {
    private int id_ph;
    private String descripcion;
    private double importeExp;
    private int id_consorcio;
    private boolean ocupado;
    private boolean estado;

    public Ph(int id_ph, String descripcion, double importeExp, int id_consorcio, boolean ocupado, boolean estado) {
        this.id_ph = id_ph;
        this.descripcion = descripcion;
        this.importeExp = importeExp;
        this.id_consorcio = id_consorcio;
        this.ocupado = ocupado;
        this.estado = estado;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    

    

    public int getId_ph() {
        return id_ph;
    }

    public void setId_ph(int id_ph) {
        this.id_ph = id_ph;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getImporteExp() {
        return importeExp;
    }

    public void setImporteExp(double importeExp) {
        this.importeExp = importeExp;
    }

    public int getId_consorcio() {
        return id_consorcio;
    }

    public void setId_consorcio(int id_consorcio) {
        this.id_consorcio = id_consorcio;
    }
    
    
    
    
}

