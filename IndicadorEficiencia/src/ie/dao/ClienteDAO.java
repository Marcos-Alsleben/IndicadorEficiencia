/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie.dao;

import ie.jdbc.ConnectionFactory;
import ie.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author mrs_a
 */
public class ClienteDAO {

private Connection con;

    public ClienteDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    // Metodo Cadastrar Cliente
    public void CadastrarCliente(Cliente obj) {
        try {

            //1 passo  - criar o comando sql
            String sql = "insert into cliente (nome, criado, modificado) "
                    + " values (?,?,?)";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCriado());
            stmt.setString(3, obj.getModificado());

            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            con.close();

            //JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }
    }

//Metodo AlterarCliente
    public void alterarCliente(Cliente obj) {
        try {

            //1 passo  - criar o comando sql
            String sql = "update cliente set nome=?, criado=?, modificado=? where id_cliente=?";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCriado());
            stmt.setString(3, obj.getModificado());
            stmt.setInt(4, obj.getId_cliente());

            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            con.close();

            //JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }

//Metodo ExcluirCliente
    public void excluirCliente(Cliente obj) {
        try {

            //1 passo  - criar o comando sql
            String sql = "delete from cliente where id_cliente=?";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId_cliente());

            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            con.close();

            //JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }

//Metodo ListarCliente
    public List<Cliente> listarCliente() {

        try {

            // Passo 1 criar a lista
            List<Cliente> lista = new ArrayList<>();

            // Passo 2 criar o comando sql, organizar e executar
            String sql = "select * from cliente ORDER BY nome asc";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Cliente obj = new Cliente();

                obj.setId_cliente(rs.getInt("id_cliente"));
                obj.setNome(rs.getString("Nome"));
                obj.setCriado(rs.getString("Criado"));
                obj.setModificado(rs.getString("Modificado"));

                lista.add(obj);

            }
            con.close();
            return lista;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }

    }


//Metodo ResgatarId_cliente
    public List<Cliente> RetornaId_cliente(String nome){
        
        try {
            //Cria a Lista
            List<Cliente> lista = new ArrayList<>();
            
            //Cria comando sql
            String sql = "SELECT * FROM cliente where "
                    + "nome =? order by criado asc limit 1;";
            
            //Conecta ao banco de dados e organiza o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);                      
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                                       
                Cliente obj = new Cliente();
                obj.setId_cliente(rs.getInt("id_cliente"));
                obj.setNome(rs.getString("Nome"));
                obj.setCriado(rs.getString("Criado"));
                obj.setModificado(rs.getString("Modificado"));
                                
                //Executa
                lista.add(obj);
                
            }
            con.close();
            return lista;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }
    }
    
}
