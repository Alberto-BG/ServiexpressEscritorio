/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author pc-casa
 */
public class Conexion {
    private Connection cone;

    public Conexion() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            cone = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","C##servedb","1234");
            
        } catch (Exception e) {
            System.out.println("Error de conexión "+e.getMessage());
        }
    }

    public Connection getCone() {
        return cone;
    }

  
    
    
    
    
}
