/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Bastian
 */
public class EmpleadoParametros {
    private String rutEmpleado;
    private String nombreEmpleado;
    private String tipoEmpleado;

    public EmpleadoParametros(String rutEmpleado, String nombreEmpleado, String tipoEmpleado) {
        this.rutEmpleado = rutEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.tipoEmpleado = tipoEmpleado;
    }

    public String getRutEmpleado() {
        return rutEmpleado;
    }

    public void setRutEmpleado(String rutEmpleado) {
        this.rutEmpleado = rutEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }
     
}
