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
public class Empleado {
   
    private String rutEmpleado;
    private String nombreEmpleado;
    private String apellidoEmpleado;
    private String usuarioEmpleado;
    private String contrasenaEmpleado;
    private String TipoEmpleado;

    public Empleado() {
    }

    public Empleado(String rutEmpleado, String nombreEmpleado, String apellidoEmpleado, String usuarioEmpleado, String contrasenaEmpleado, String TipoEmpleado) {
        this.rutEmpleado = rutEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
        this.usuarioEmpleado = usuarioEmpleado;
        this.contrasenaEmpleado = contrasenaEmpleado;
        this.TipoEmpleado = TipoEmpleado;
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

    public void setNombreEmpleado(String nombreEmpleado) throws Exception {
        if (nombreEmpleado.length()>0) {
            this.nombreEmpleado = nombreEmpleado;
        } else {
            throw new Exception("Debe ingresar un nombre");
        }
        
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) throws Exception {
        if (apellidoEmpleado.length()>0) {
            this.apellidoEmpleado = apellidoEmpleado;
        } else {
            throw new Exception("Debe ingresar un apellido");
        }
        
    }

    public String getUsuarioEmpleado() {
        return usuarioEmpleado;
    }

    public void setUsuarioEmpleado(String usuarioEmpleado) throws Exception {
        if (usuarioEmpleado.length()>0) {
            this.usuarioEmpleado = usuarioEmpleado;
        } else {
            throw new Exception("Debe ingresar un nombre de usuario");
        }
        
    }

    public String getContrasenaEmpleado() {
        return contrasenaEmpleado;
    }

    public void setContrasenaEmpleado(String contrasenaEmpleado)throws Exception {
        if (contrasenaEmpleado.length()>0) {
            this.contrasenaEmpleado = contrasenaEmpleado;
        } else {
            throw new Exception("Debe ingresar una contraseña");
            
        }
        
    }

    public String getTipoEmpleado() {
        return TipoEmpleado;
    }

    public void setTipoEmpleado(String TipoEmpleado) throws Exception {
        if (TipoEmpleado.length()>0) {
            this.TipoEmpleado = TipoEmpleado;
            
        } else {
            throw new Exception("Debe ingresar un tipo de empleado");
        }
        
        
    }
    
        public static Boolean validaRut ( String rutEmpleado ) {
		Pattern pattern = Pattern.compile("^[0-9]+-[0-9kK]{1}$");
		Matcher matcher = pattern.matcher(rutEmpleado);
		if ( matcher.matches() == false ) return false;
		String[] stringRut = rutEmpleado.split("-");
		return stringRut[1].toLowerCase().equals(Cliente.dv(stringRut[0]));
	}
	
	/**
	 * Valida el dígito verificador
     * @param rutEmpleado
	 */
	public static String dv ( String rutEmpleado ) {
		Integer M=0,S=1,T=Integer.parseInt(rutEmpleado);
		for (;T!=0;T=(int) Math.floor(T/=10))
			S=(S+T%10*(9-M++%6))%11;
		return ( S > 0 ) ? String.valueOf(S-1) : "k";		
	}
    
    
}
