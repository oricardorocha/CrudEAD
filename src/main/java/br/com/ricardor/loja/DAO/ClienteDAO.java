package br.com.ricardor.loja.DAO;

import br.com.ricardor.loja.model.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends GenericDAO {
    
    public void salvar(Cliente cliente) throws SQLException {
        String insert = "INSERT INTO CLIENTE(NOME, TELEFONE) "
                + "VALUES (?,?)";
        
        save(insert, cliente.getNome(), cliente.getTelefone());
    }
    
    public void excluir(int id) throws SQLException {
        String delete = "DELETE FROM CLIENTE WHERE id = ?";
        
        delete(delete, id);
    }
    
    public void alterar(Cliente cliente) throws SQLException {
        String update = "UPDATE CLIENTE "
                + "SET NOME = ?, TELEFONE = ? "
                + "WHERE id = ?";
        update(update, cliente.getId(), cliente.getNome(), cliente.getTelefone());
    }
    
    public List<Cliente> findClientes() throws SQLException {
        List<Cliente> clientes = new ArrayList<Cliente>();

        String select = "SELECT * FROM CLIENTE";

        PreparedStatement stmt = 
			getConnection().prepareStatement(select);
			
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Cliente cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setTelefone(rs.getString("telefone"));
            clientes.add(cliente);
        }

        rs.close();
        stmt.close();

        return clientes;
    }

    public Cliente findByName(String nome) throws SQLException {
        String select = "SELECT * FROM CLIENTE WHERE nome = ?";
        Cliente cliente = null;
        PreparedStatement stmt = 
			getConnection().prepareStatement(select);
			
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setTelefone(rs.getString("telefone"));
        }

        rs.close();
        stmt.close();
        return cliente;
    }
    
    public Cliente findById(int id) throws SQLException {
        String select = "SELECT * FROM CLIENTE WHERE id = ?";
        Cliente cliente = null;
        PreparedStatement stmt = 
			getConnection().prepareStatement(select);
			
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            cliente = new Cliente();
            cliente.setId(rs.getInt("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setTelefone(rs.getString("telefone"));
        }

        rs.close();
        stmt.close();
        return cliente;
    }
    
    private void soma(int i){
        return;
    }
}
