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
public class dtoObtenerConsorcio {
    
    
    private int id_consorcio;
    private String nombreConsorcio;

    public dtoObtenerConsorcio(int id_consorcio, String nombreConsorcio) {
        this.id_consorcio = id_consorcio;
        this.nombreConsorcio = nombreConsorcio;
    }

    

    public int getId_consorcio() {
        return id_consorcio;
    }

    public void setId_consorcio(int id_consorcio) {
        this.id_consorcio = id_consorcio;
    }

    public String getNombreConsorcio() {
        return nombreConsorcio;
    }

    public void setNombreConsorcio(String nombreConsorcio) {
        this.nombreConsorcio = nombreConsorcio;
    }
    
    
    
}
