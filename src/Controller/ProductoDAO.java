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
import Model.Producto;
import Templates.GestionProductosAdmin;
import java.util.ArrayList;
/**
 *
 * @author pc-casa
 */
public class ProductoDAO {
    
      private Connection cone;

    public ProductoDAO() {
        cone = new Conexion().getCone();
    }

     public ArrayList<Producto> Listado() {
        try {
            String sql = "select * from ORD_PEDIDO";
            PreparedStatement st = cone.prepareCall(sql);
            ArrayList<Producto> lista = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Producto pro = new Producto();
                pro.setID_PRODUCTO(rs.getInt(1));
                pro.setNOMBRE(rs.getString(2));
                pro.setDESCRIPCIÓN(rs.getString(3));
                pro.setFECHA_ORDEN(rs.getString(4));
                pro.setID_EMPLEADO(rs.getInt(5));
                pro.setID_PROVEEDOR(rs.getInt(6));
                 pro.setPRECIO(rs.getInt(7));
                  pro.setCANTIDAD(rs.getInt(8));
                lista.add(pro);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
            return null;
        }
    }
      public int AgregarProducto(int idproducto,String Nombre,String descripcion,int precio,int stock,int idempleado) {
        try {
            CallableStatement cs  =cone.prepareCall( "{call SP_CONFIRMAR_PEDIDO(?,?,?,?,?,?,?)}");
            cs.setInt(1, idproducto);
            cs.setString(2, Nombre);
            cs.setString(3, descripcion);
            cs.setInt(4, precio);
            cs.setInt(5, stock);
            cs.setInt(6, idempleado);
            cs.registerOutParameter(7, Types.NUMERIC);
            cs.execute();
            
            return cs.getInt(7);
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            return 0;
        }
    }
     public int Eliminar(int id) {
        try {
            String sql = "delete from ORD_PEDIDO where id_producto = ?";
            PreparedStatement st = cone.prepareCall(sql);
            st.setInt(1, id);
            st.executeQuery();
            return 1;
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
            return 0;
        }
    }
}
