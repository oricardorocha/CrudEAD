package br.com.ricardor.loja.controller;

import br.com.ricardor.loja.DAO.ClienteDAO;
import br.com.ricardor.loja.model.Cliente;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteController {
    
    public void salvar(String nome, String telefone) 
		throws SQLException, ParseException 
	{
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setTelefone(telefone);

        new ClienteDAO().salvar(cliente);
    }

    public void alterar(int id, String nome, String telefone) 
		throws ParseException, SQLException 
	{
        
	Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setNome(nome);
        cliente.setTelefone(telefone);

        new ClienteDAO().alterar(cliente);
    }

    public List<Cliente> listarClientes() {
        ClienteDAO dao = new ClienteDAO();
        try {
            return dao.findClientes();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
				"Problemas ao localizar cliente\n" + 
				e.getLocalizedMessage()
			);
        }
        return null;
    }

    public void excluir(int id) throws SQLException {
        new ClienteDAO().excluir(id);
    }

    public Cliente buscaClientePorNome(String nome) throws SQLException {
        ClienteDAO dao = new ClienteDAO();
        return dao.findByName(nome);
    }
    
    public Cliente buscaClientePorId(int id) throws SQLException {
        ClienteDAO dao = new ClienteDAO();
        return dao.findById(id);
    }
}
