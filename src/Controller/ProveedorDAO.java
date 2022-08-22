/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Conexion.Conexion;
import Model.Cliente;
import Model.Producto;
import Model.ProductosProveedor;
import Model.Proveedor;
import Templates.GestionProductosAdmin;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Bastian
 */
public class ProveedorDAO {
       private Connection cone;
    
    public ProveedorDAO() {
        cone = new Conexion().getCone();
    }
    
    public ArrayList<Proveedor> Listado() {
        try {
            String sql = "SELECT id_proveedor,NOMBRE||' '||apellido FROM PROVEEDOR";
            PreparedStatement st = cone.prepareCall(sql);
            ArrayList<Proveedor> lista = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Proveedor pro = new Proveedor();
                pro.setRut(rs.getString(1));
                pro.setNombre(rs.getString(2));
                lista.add(pro);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
            return null;
        }
    }
    public ArrayList<ProductosProveedor> GetProductosProveedor(String nombre) {
        try {
            String sql = "select p.* from prod_prov p inner join prod_prov_proveedor pr on pr.prod_prov_id_producto = p.id_producto inner join proveedor prove on prove.id_proveedor = pr.proveedor_id_proveedor where prove.nombre||' '||prove.apellido = ?";
            PreparedStatement st = cone.prepareCall(sql);
            st.setString(1, nombre);
            ArrayList<ProductosProveedor> lista = new ArrayList<>();
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                ProductosProveedor prod = new ProductosProveedor();
                prod.setID(rs.getInt(1));
                prod.setNombre(rs.getString(2));
                prod.setDescripcion(rs.getString(3));
                prod.setFamilia(rs.getString(4));
                prod.setFecha_Ve(rs.getString(5));
                prod.setPrecio(rs.getInt(6));
                prod.setStock(rs.getInt(7));
                lista.add(prod);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
            return null;
        }
    }
    
}
