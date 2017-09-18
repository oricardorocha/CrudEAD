/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ricardor.loja;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteConexao {
    
    static final String DATABASE_URL = "jdbc:mysql://localhost/loja";
    static final String QUERYCLIENTES = "SELECT id, nome FROM cliente";
    
    public static void main(String args[]) {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        
        String nome;
        int id;
        
        try {
            conn = DriverManager.getConnection(DATABASE_URL, "root", "admin");
            
            statement = conn.createStatement();
            rs = statement.executeQuery(QUERYCLIENTES);
            
            while (rs.next()) {
                nome = rs.getString("nome");
                id = rs.getInt("id");
                
                System.out.printf("Cliente: id: %d Nome: %s \n", id, nome);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
                statement.close();
                conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        
    }
}
