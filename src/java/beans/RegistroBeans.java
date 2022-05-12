/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Aprendiz
 */
public class RegistroBeans {
    
    private int id;
    private String nombres;
    private String contacto;
    private String correo;
    private String pass;
    private String rol;
    private int estado = 1;
    
    public RegistroBeans(){
        
    }
    public RegistroBeans( String nombres, String contacto, String correo, String pass, int estado) {
        
        
        this.nombres = nombres;
        this.contacto = contacto;
        this.correo = correo;
        this.pass = pass;
        this.estado = estado;

    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
    public int getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
    
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombre) {
        this.nombres = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getEmail() {
        return correo;
    }

    public void setEmail(String email) {
        this.correo = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
