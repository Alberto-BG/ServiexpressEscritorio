/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Bastian
 */
public class Proveedor {
    private String rut;
    private String nombre;

    public Proveedor() {
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre)throws Exception {
        if (nombre.length()>1) {
            this.nombre = nombre;
        } else {
        }
        
    }

    public Proveedor(String rut, String nombre) {
        this.rut = rut;
        this.nombre = nombre;
    }

    
    
}
