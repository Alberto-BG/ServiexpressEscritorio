/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Bastian
 */
public class ProductosProveedor {
    private int ID;
    private String Nombre;
    private String Descripcion;
    private String Familia;
    private String Fecha_Ve;
    private int precio;
    private int Stock;

    public ProductosProveedor() {
    }

    public ProductosProveedor(int ID, String Nombre, String Descripcion, String Familia, String Fecha_Ve, int precio, int Stock) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Familia = Familia;
        this.Fecha_Ve = Fecha_Ve;
        this.precio = precio;
        this.Stock = Stock;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getFamilia() {
        return Familia;
    }

    public void setFamilia(String Familia) {
        this.Familia = Familia;
    }

    public String getFecha_Ve() {
        return Fecha_Ve;
    }

    public void setFecha_Ve(String Fecha_Ve) {
        this.Fecha_Ve = Fecha_Ve;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    
    
}
