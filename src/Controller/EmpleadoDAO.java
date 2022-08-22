/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Conexion.Conexion;
import Model.Cliente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import Model.Empleado;
import Model.ProveedorRut;
import Templates.GestionProductosAdmin;
import java.util.ArrayList;

/**
 *
 * @author pc-casa
 */
public class EmpleadoDAO {

    private Connection cone;

    public EmpleadoDAO() {
        cone = new Conexion().getCone();
    }

    public int AgregarEmpleado(int Rut,String Nombre,String Apellido,String Usuario,String Clave,int Tipo) {
        try {
            CallableStatement cs  =cone.prepareCall( "{call SP_AGREGAR_EMPLEADO(?,?,?,?,?,?,?)}");
            cs.setInt(1, Rut);
            cs.setString(2, Nombre);
            cs.setString(3, Apellido);
            cs.setString(4, Usuario);
            cs.setString(5, Clave);
            cs.setInt(6, Tipo);
            cs.registerOutParameter(7, Types.NUMERIC);
            cs.execute();
            
            return cs.getInt(7);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return 0;
        }
    }

    public int FinalizarTrabajo(String diagnostico, String estado, String rut,int valor,String id_mecanico,String hora) {
        try {
            CallableStatement cs  =cone.prepareCall( "{call SP_FINALIZAR_TRABAJO(?,?,?,?,?,?,?)}");
            cs.setString(1, diagnostico);
            cs.setString(2, estado);
            cs.setString(3, rut);
            cs.setInt(4, valor);
            cs.setString(5, id_mecanico);
            cs.setString(6, hora);
            cs.registerOutParameter(7, Types.NUMERIC);
            cs.execute();
            
            return cs.getInt(7);
        } catch (Exception e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return 0;
        }

    }
    public int Modificar(int Rut,String Nombre,String Apellido,String Usuario,String Clave,int Tipo) {
        try {
            CallableStatement cs  =cone.prepareCall( "{call SP_MODIFICAR_EMPLEADO(?,?,?,?,?,?,?)}");
            cs.setInt(1, Rut);
            cs.setString(2, Nombre);
            cs.setString(3, Apellido);
            cs.setString(4, Usuario);
            cs.setString(5, Clave);
            cs.setInt(6, Tipo);
            cs.registerOutParameter(7, Types.NUMERIC);
            cs.execute();
            
            return cs.getInt(7);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return 0;
        }
    }

    public ArrayList<Empleado> Listado() {
        try {
            String sql = "select e.rut_empleado,e.nombre,e.apellido,e.usuario,e.contrasenia,t.tipo_empleado from  empleado e inner join tipo_empleado t on e.tipo_empleado_id_tipo_empleado = t.id_tipo_empleado";
            PreparedStatement st = cone.prepareCall(sql);
            ArrayList<Empleado> lista = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            Empleado emp = null;
            while (rs.next()) {
                emp = new Empleado();
                
                emp.setRutEmpleado(rs.getString(1));
                emp.setNombreEmpleado(rs.getString(2));
                emp.setApellidoEmpleado(rs.getString(3));
                emp.setUsuarioEmpleado(rs.getString(4));
                emp.setContrasenaEmpleado(rs.getString(5));
                emp.setTipoEmpleado(rs.getString(6));
                
                
                
                lista.add(emp);

            }
            return lista;
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
            return null;
        }
    }
    public Empleado GetEmpleado(String rut){
        try{
        String sql = "select e.rut_empleado,e.nombre,e.apellido,e.usuario,e.contrasenia,t.tipo_empleado from  empleado e inner join tipo_empleado t on e.tipo_empleado_id_tipo_empleado = t.id_tipo_empleado where e.rut_empleado = ? ";
            PreparedStatement st = cone.prepareCall(sql);
            st.setString(1, rut);
            Empleado emp = new Empleado();
            ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    emp.setRutEmpleado(rs.getString(1));
                    emp.setNombreEmpleado(rs.getString(2));
                    emp.setApellidoEmpleado(rs.getString(3));
                    emp.setUsuarioEmpleado(rs.getString(4));
                    emp.setContrasenaEmpleado(rs.getString(5));
                    emp.setTipoEmpleado(rs.getString(6));
                }

            return emp;
         } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
            return null;
        }
    }
    public ArrayList Login(String usuario,String clave) {
        try {
            CallableStatement cs  =cone.prepareCall( "{call SP_USUARIO_LOGIN(?,?,?,?,?)}");
            cs.setString(1, usuario);
            cs.setString(2, clave);
            cs.registerOutParameter(3, Types.VARCHAR);
            cs.registerOutParameter(4, Types.VARCHAR);
            cs.registerOutParameter(5, Types.VARCHAR);
            cs.execute();
            
            ArrayList lista = new ArrayList();
            
            lista.add(cs.getString(3));
            lista.add(cs.getString(5));
            
            return lista;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }
    
     public int RealizarPedido(int id_producto,String nombre,String descripcion,int id_empleado,String nombreProveedor,int precio,int cantidad) {
        try {
            
            String sql = "select id_proveedor from proveedor where nombre||' '||apellido = ?";
            PreparedStatement st = cone.prepareCall(sql);
            st.setString(1, nombreProveedor);
            ProveedorRut emp = new ProveedorRut();
            ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    emp.setRut(Integer.valueOf(rs.getString(1)));
                }
            
            CallableStatement cs  =cone.prepareCall( "{call SP_REALIZAR_PEDIDO(?,?,?,?,?,?,?,?)}");
            cs.setInt(1, id_producto);
            cs.setString(2, nombre);
            cs.setString(3, descripcion);
            cs.setInt(4, id_empleado);
            cs.setInt(5, emp.getRut());
            cs.setInt(6, precio);
            cs.setInt(7, cantidad);
            cs.registerOutParameter(8, Types.NUMERIC);
            cs.execute();
            
            return cs.getInt(8);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return 0;
        }
    }

}
