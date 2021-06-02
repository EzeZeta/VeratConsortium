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
public class Persona {
    private int id_persona;
    private TipoPersona tipoPersona;
    private String nombre;
    private String apellido;
    private TipoDocu tipoDocu;
    private String documento;
    private String telefono;
    private String mail;
    private Ph ph;
    private boolean estado;
    private Consorcio consorcio;
    private String especialidad;
    
    
    

    public Persona(int id_persona, TipoPersona tipoPersona, String nombre, String apellido, TipoDocu tipoDocu, String documento, String telefono, String mail, Ph ph, boolean estado, Consorcio consorcio, String especialidad) {
        this.id_persona = id_persona;
        this.tipoPersona = tipoPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocu = tipoDocu;
        this.documento = documento;
        this.telefono = telefono;
        this.mail = mail;
        this.ph = ph;
        this.estado = estado;
        this.consorcio = consorcio;
        this.especialidad = especialidad;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public TipoDocu getTipoDocu() {
        return tipoDocu;
    }

    public void setTipoDocu(TipoDocu tipoDocu) {
        this.tipoDocu = tipoDocu;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
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

    public Ph getPh() {
        return ph;
    }

    public void setPh(Ph ph) {
        this.ph = ph;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Consorcio getConsorcio() {
        return consorcio;
    }

    public void setConsorcio(Consorcio consorcio) {
        this.consorcio = consorcio;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    
    
    
    
    
    
    
}
