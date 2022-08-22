/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author pc-casa
 */
public class Producto {
    
    
  public int ID_PRODUCTO;
  public String NOMBRE;
  public String DESCRIPCIÓN;
  public String FECHA_ORDEN;
  public int ID_EMPLEADO;
  public int ID_PROVEEDOR;
  public int PRECIO;
  public int CANTIDAD;

    public Producto() {
    }

    public Producto(int ID_PRODUCTO, String NOMBRE, String DESCRIPCIÓN, String FECHA_ORDEN, int ID_EMPLEADO, int ID_PROVEEDOR, int PRECIO, int CANTIDAD) {
        this.ID_PRODUCTO = ID_PRODUCTO;
        this.NOMBRE = NOMBRE;
        this.DESCRIPCIÓN = DESCRIPCIÓN;
        this.FECHA_ORDEN = FECHA_ORDEN;
        this.ID_EMPLEADO = ID_EMPLEADO;
        this.ID_PROVEEDOR = ID_PROVEEDOR;
        this.PRECIO = PRECIO;
        this.CANTIDAD = CANTIDAD;
    }

    public int getID_PRODUCTO() {
        return ID_PRODUCTO;
    }

    public void setID_PRODUCTO(int ID_PRODUCTO) {
        this.ID_PRODUCTO = ID_PRODUCTO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getDESCRIPCIÓN() {
        return DESCRIPCIÓN;
    }

    public void setDESCRIPCIÓN(String DESCRIPCIÓN) {
        this.DESCRIPCIÓN = DESCRIPCIÓN;
    }

    public String getFECHA_ORDEN() {
        return FECHA_ORDEN;
    }

    public void setFECHA_ORDEN(String FECHA_ORDEN) {
        this.FECHA_ORDEN = FECHA_ORDEN;
    }

    public int getID_EMPLEADO() {
        return ID_EMPLEADO;
    }

    public void setID_EMPLEADO(int ID_EMPLEADO) {
        this.ID_EMPLEADO = ID_EMPLEADO;
    }

    public int getID_PROVEEDOR() {
        return ID_PROVEEDOR;
    }

    public void setID_PROVEEDOR(int ID_PROVEEDOR) {
        this.ID_PROVEEDOR = ID_PROVEEDOR;
    }

    public int getPRECIO() {
        return PRECIO;
    }

    public void setPRECIO(int PRECIO) {
        this.PRECIO = PRECIO;
    }

    public int getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(int CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    
    
}
