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
public class RegistroBeansCat {
    
    private int id;
    private String nombre;
    private int estado;
    
    
    public RegistroBeansCat(){
        
    }
    public RegistroBeansCat(int id, String nombre, int estado) {
        
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEstado() {
        return estado;
    }

}
