/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.InputStream;

/**
 *
 * @author Aprendiz
 */
public class RegistroBeansP {
    
    private int id;
    private String nombre;
    private InputStream foto;
    private float costo;
    private int cantidad;
    private String descripcion;
    private int estado;
    private int id_categoria;
    
    
    public RegistroBeansP(){
        
    }
    public RegistroBeansP(int id, String nombre, InputStream foto, float costo, int cantidad, String descripcion, int estado, int categoria) {
        
        this.id = id;
        this.nombre = nombre;
        this.foto = foto;
        this.costo = costo;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.estado = estado;
        this.id_categoria = categoria;

    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public InputStream getFoto() {
        return foto;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public int getEstado() {
        return estado;
    }

    public int getCategoria() {
        return id_categoria;
    }
    
    

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setCategoria(int categoria) {
        this.id_categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public float getCosto() {
        return costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   
}
