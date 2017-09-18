package br.com.ricardor.loja.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class ConnectionDataBase {
    
    private static final String URL_MYSQL = "jdbc:mysql://localhost/loja";
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";
    private static final String USER = "root";
    private static final String PASS = "admin";
    
    public static Connection getConnection() {
        System.out.println("Conectando ao Banco de Dados");
        
        try {
            Class.forName(DRIVER_CLASS);
            return DriverManager.getConnection(URL_MYSQL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }
}
