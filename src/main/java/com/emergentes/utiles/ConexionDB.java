
package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {
    static public String driver = "com.mysql.jdbc.Driver";
    static public String url = "jdbc:mysql://localhost:3306/bd_internet";
    static public String usuario= "root";
    static public String password= "";
    
    protected Connection conn = null ;
    
    public ConexionDB(){
        try {
            Class.forName(driver);
            try {
                conn = DriverManager.getConnection(url,usuario ,password);
            } catch (SQLException ex) {
               System.out.println("Error en el driver :"+ ex.getMessage());
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al ralizar la conexion :"+ ex.getMessage());
        }
    }
    
    public Connection conectar(){
        return conn;
    }
     public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerra la conexion: "+ ex.getMessage());
        }
    }         
                       
}

