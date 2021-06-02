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
public class Consorcio {
    private int id_consorcio;
    private String nombre;
    private String direccion;
    private String cuit;
    private String nombreEnc;
    private String apellidoEnc;
    private String telefono;
    private String mail;
    private boolean estado;
    private double saldoInicial;

    public Consorcio(int id_consorcio, String nombre, String direccion, String cuit, String nombreEnc, String apellidoEnc, String telefono, String mail, boolean estado, double saldoInicial) {
        this.id_consorcio = id_consorcio;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cuit = cuit;
        this.nombreEnc = nombreEnc;
        this.apellidoEnc = apellidoEnc;
        this.telefono = telefono;
        this.mail = mail;
        this.estado = estado;
        this.saldoInicial = saldoInicial;
    }

    public int getId_consorcio() {
        return id_consorcio;
    }

    public void setId_consorcio(int id_consorcio) {
        this.id_consorcio = id_consorcio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getNombreEnc() {
        return nombreEnc;
    }

    public void setNombreEnc(String nombreEnc) {
        this.nombreEnc = nombreEnc;
    }

    public String getApellidoEnc() {
        return apellidoEnc;
    }

    public void setApellidoEnc(String apellidoEnc) {
        this.apellidoEnc = apellidoEnc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    


    
    
    
    
}
