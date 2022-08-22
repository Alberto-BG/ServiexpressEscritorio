/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import Conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import Model.Cliente;
import Model.ClienteFecha;
import Model.ClienteParametros;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author pc-casa
 */
public class ClienteDAO {
    
    private Connection cone;

    public ClienteDAO() {
        cone = new Conexion().getCone();
    }

    public int AgregarCliente(String rut,String nombre,String apellido,String patente,int telefono,String fecha,String detalle) {
        try {
            String salida = "";
            CallableStatement cs  =cone.prepareCall( "{call SP_SLCTD_HORA(?,?,?,?,?,?,?,?)}");
            cs.setString(1, rut);
            cs.setString(2, nombre);
            cs.setString(3, apellido);
            cs.setString(4, patente);
            cs.setInt(5, telefono);
            cs.setString(6, fecha);
            cs.setString(7, detalle);
            cs.registerOutParameter(8, Types.NUMERIC);
            cs.execute();
            
            return cs.getInt(8);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return 0;
        }
    }
    

  

    public int Modificar(String rut,String nombre,String apellido,String patente,String fecha,String detalle) {
        try {
            CallableStatement cs  =cone.prepareCall( "{call SP_MODIFICAR_HORA(?,?,?,?,?,?,?)}");
            cs.setString(1, rut);
            cs.setString(2, nombre);
            cs.setString(3, apellido);
            cs.setString(4, patente);
            cs.setString(5, fecha);
            cs.setString(6, detalle);
            cs.registerOutParameter(7, Types.NUMERIC);
            cs.execute();
            
            return  cs.getInt(7);
        } catch (Exception e) {
            System.out.println("Error al modificar" + e.getMessage());
            return 0;
        }
    }

   
    public ArrayList<Cliente> Listado() {
        try {
            String sql = "select * from CLIENTE";
            PreparedStatement st = cone.prepareCall(sql);
            ArrayList<Cliente> lista = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setRutCliente(rs.getString(1));
                cli.setNombreCliente(rs.getString(2));
                cli.setApellidoCliente(rs.getString(3));
                cli.setPatenteCliente(rs.getString(4));
                lista.add(cli);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
            return null;
        }
    }
    public String TomarHora(String rutMecanico ,String rutCliente ) {
        try {
            String sql = "update res_hora set mecanico = ?,estado = 'EN PROCESO' where id_hora =(select r.id_hora from cliente c inner join bol_fac b on b.cliente_rut = c.rut inner join res_hora r on r.id_hora = b.res_hora_id_hora where b.cliente_rut= ?)";
            PreparedStatement st = cone.prepareCall(sql);
            st.setString(1, rutMecanico);
            st.setString(2, rutCliente);
            st.executeQuery();
            return "Hora tomada con exito";
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
            return "La hora no ha podido ser tomada";
        }
    }
    public ArrayList<ClienteParametros> ListadoMecanico2(String rut) {
        try {
            String sql = "select c.*,nvl(r.mecanico,'No Asignado'),r.id_hora from cliente c inner join bol_fac b on c.rut = b.cliente_rut inner join res_hora r on b.res_hora_id_hora = r.id_hora where r.mecanico = ? and r.estado = 'EN PROCESO' ";
            PreparedStatement st = cone.prepareCall(sql);
            st.setString(1, rut);
            ArrayList<ClienteParametros> lista = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            ClienteParametros cli = null;
            while (rs.next()) {
                cli = new ClienteParametros();
                cli.setRutCliente(rs.getString(1));
                cli.setNombreCliente(rs.getString(2));
                cli.setApellidoCliente(rs.getString(3));
                cli.setPatenteCliente(rs.getString(4));
                cli.setId_hora(rs.getString(6));
                lista.add(cli);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
            return null;
        }
    }
    
    public ArrayList<ClienteParametros> ListadoMecanico() {
        try {
            String sql = "select c.*,nvl(r.mecanico,'No Asignado'),r.estado from cliente c inner join bol_fac b on c.rut = b.cliente_rut inner join res_hora r on b.res_hora_id_hora = r.id_hora";
            PreparedStatement st = cone.prepareCall(sql);
            ArrayList<ClienteParametros> lista = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            
            ClienteParametros cli = null;
            while (rs.next()) {
                if (rs.getString(5).equals("No Asignado")) {
                    cli = new ClienteParametros();
                    cli.setRutCliente(rs.getString(1));
                    cli.setNombreCliente(rs.getString(2));
                    cli.setApellidoCliente(rs.getString(3));
                    cli.setPatenteCliente(rs.getString(4));
                    cli.setMecanico(rs.getString(5));
                    cli.setEstado(rs.getString(6));
                    lista.add(cli);
                }
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
            return null;
        }
    }
    public ClienteFecha ObtenerFecha(String rut) {
        try {
            String sql = "select r.fecha from  res_hora r inner join bol_fac b on b.res_hora_id_hora = r.id_hora where b.cliente_rut=?";
            PreparedStatement st = cone.prepareCall(sql);
            st.setString(1, rut);
            ResultSet rs = st.executeQuery();
            ClienteFecha cli = new ClienteFecha();
            while (rs.next()) {
                cli.setFecha(rs.getString(1));
            }
            return cli;
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
            return null;
        }
    }
    public String ValidarFecha(String f1 ) {
        try {
            CallableStatement cs  =cone.prepareCall( "{call SP_VALIDA_DATE(?,?)}");
            cs.setString(1, f1);
            cs.registerOutParameter(2, Types.VARCHAR);
            cs.execute();
            return cs.getString(2);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return "Error";
        }
    }
    


}
