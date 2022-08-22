/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Bastian
 */
public class ClienteParametros {
    private String rutCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String patenteCliente;
    private String mecanico;
    private String estado;
    private String id_hora;

    public ClienteParametros() {
    }

    public ClienteParametros(String rutCliente, String nombreCliente, String apellidoCliente, String patenteCliente, String mecanico, String estado, String id_hora) {
        this.rutCliente = rutCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.patenteCliente = patenteCliente;
        this.mecanico = mecanico;
        this.estado = estado;
        this.id_hora = id_hora;
    }

    public String getRutCliente() {
        return rutCliente;
    }

    public void setRutCliente(String rutCliente) {
        this.rutCliente = rutCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getPatenteCliente() {
        return patenteCliente;
    }

    public void setPatenteCliente(String patenteCliente) {
        this.patenteCliente = patenteCliente;
    }

    public String getMecanico() {
        return mecanico;
    }

    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getId_hora() {
        return id_hora;
    }

    public void setId_hora(String id_hora) {
        this.id_hora = id_hora;
    }

    
    
}
