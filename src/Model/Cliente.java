/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author pc-casa
 */
public class Cliente {
    private String rutCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private String patenteCliente;
    private String idHora;

    public Cliente() {
    }

    public Cliente(String rutCliente, String nombreCliente, String apellidoCliente, String patenteCliente) {
        this.rutCliente = rutCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.patenteCliente = patenteCliente;
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
    
      /*public void setMarca(String marca) throws Exception {
        if (marca.length()>2) {
            this.marca = marca;
        }else{
            throw new Exception("LA MARCA SER MAYOR A 2 CARACTERES");
        }        
    }*/

    public void setNombreCliente(String nombreCliente) throws Exception{
        if (nombreCliente!=null) {
            this.nombreCliente = nombreCliente;
            
        } else {
            throw new Exception("Debe ingresar un nombre");
            
        }
        
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) throws Exception {
        if (apellidoCliente!=null) {
            this.apellidoCliente = apellidoCliente;
        } else {
            throw new Exception("Debe ingresar un apellido");
        }
        
            
         
        
    }

    public String getPatenteCliente() {
        
        return patenteCliente;
    }

    /**
     *
     * @param patenteCliente
     * @throws Exception
     */
    public void setPatenteCliente(String patenteCliente) throws Exception {
       
            this.patenteCliente = patenteCliente;
        
            
        
    }
    
    public static Boolean validaRut ( String rutCliente ) {
		Pattern pattern = Pattern.compile("^[0-9]+-[0-9kK]{1}$");
		Matcher matcher = pattern.matcher(rutCliente);
		if ( matcher.matches() == false ) return false;
		String[] stringRut = rutCliente.split("-");
		return stringRut[1].toLowerCase().equals(Cliente.dv(stringRut[0]));
	}
	
	/**
	 * Valida el dígito verificador
	 */
	public static String dv ( String rutCliente ) {
		Integer M=0,S=1,T=Integer.parseInt(rutCliente);
		for (;T!=0;T=(int) Math.floor(T/=10))
			S=(S+T%10*(9-M++%6))%11;
		return ( S > 0 ) ? String.valueOf(S-1) : "k";		
	}
	
}

   

   

