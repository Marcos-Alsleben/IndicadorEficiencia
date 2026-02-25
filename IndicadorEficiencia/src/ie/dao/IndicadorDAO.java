/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie.dao;

import ie.jdbc.ConnectionFactory;
import ie.model.Indicador;
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
public class IndicadorDAO {

    private final Connection con;

    public IndicadorDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

//Metodo CadastrarIndicador
    public void cadastrarIndicador(Indicador obj) {
        try {

            //1 passo  - criar o comando sql
            String sql = "insert into indicador (id_funcionario, pedido, qtd_artes, status, id_cliente, data,"
                    + "criado, modificado) values (?,?,?,?,?,?,?,?)";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId_funcionario());
            stmt.setString(2, obj.getPedido());
            stmt.setInt(3, obj.getQtd_artes());
            stmt.setString(4, obj.getStatus());
            stmt.setInt(5, obj.getId_cliente());
            stmt.setString(6, obj.getData());
            stmt.setString(7, obj.getCriado());
            stmt.setString(8, obj.getModificado());

            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            con.close();

            //JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }

//Metodo AlterarIndicador
    public void alterarIndicador(Indicador obj) {
        try {

            //1 passo  - criar o comando sql
            String sql = "update indicador set id_funcionario=?, pedido=?, qtd_artes=?, status=?, id_cliente=?, data=?,"
                    + "criado=?, modificado=? where id_indicador=? ";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId_funcionario());
            stmt.setString(2, obj.getPedido());
            stmt.setInt(3, obj.getQtd_artes());
            stmt.setString(4, obj.getStatus());
            stmt.setInt(5, obj.getId_cliente());
            stmt.setString(6, obj.getData());
            stmt.setString(7, obj.getCriado());
            stmt.setString(8, obj.getModificado());
            stmt.setInt(9, obj.getId_indicador());

            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            con.close();

            //JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }

//Metodo ExcluirIndicador
    public void excluirIndicador(Indicador obj) {
        try {

            //1 passo  - criar o comando sql
            String sql = "delete from indicador where id_indicador=?";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId_indicador());

            //3 passo - executar o comando sql
            stmt.execute();
            stmt.close();
            con.close();

            // JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }

//Metodo ListarIndicador
    public List<Indicador> ListarIndicador() {

        try {

            // Passo 1 criar a lista
            List<Indicador> lista = new ArrayList<>();

            // Passo 2 criar o comando sql, organizar e executar
            String sql = "SELECT id_indicador as idIndicador, funcionario.id_funcionario as idDesigner, funcionario.nome as Designer,\n"
                    + "pedido as Pedido, qtd_artes as NºArtes, status as Status, cliente.id_cliente as idCliente,\n"
                    + "cliente.nome as Cliente, data as Data, indicador.criado as Criado, indicador.modificado as Modificado\n"
                    + "FROM indicadoreficiencia.indicador\n"
                    + "INNER JOIN indicadoreficiencia.cliente ON indicador.id_cliente = cliente.id_cliente\n"
                    + "INNER JOIN indicadoreficiencia.funcionario ON indicador.id_funcionario = funcionario.id_funcionario\n"
                    + "ORDER by abs(indicador.data) desc;";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Indicador obj = new Indicador();

                obj.setId_indicador(rs.getInt("idIndicador"));
                obj.setId_funcionario(rs.getInt("idDesigner"));
                obj.setFuncionario(rs.getString("Designer"));
                obj.setPedido(rs.getString("Pedido"));
                obj.setQtd_artes(rs.getInt("NºArtes"));
                obj.setStatus(rs.getString("Status"));
                obj.setId_cliente(rs.getInt("idCliente"));
                obj.setCliente(rs.getString("Cliente"));
                obj.setData(rs.getString("Data"));
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

//Metodo PesquisarIndicador
    public List<Indicador> pesquisarIndicador(String pesquisa) {

        try {

            // Passo 1 criar a lista
            List<Indicador> lista = new ArrayList<>();

            // Passo 2 criar o comando sql, organizar e executar
            String sql = "SELECT id_indicador as idIndicador, funcionario.id_funcionario as idDesigner, funcionario.nome as Designer,\n"
                    + "pedido as Pedido, qtd_artes as NºArtes, status as Status, cliente.id_cliente as idCliente,\n"
                    + "cliente.nome as Cliente, data as Data, indicador.criado as Criado, indicador.modificado as Modificado\n"
                    + "FROM indicadoreficiencia.indicador\n"
                    + "INNER JOIN indicadoreficiencia.cliente ON indicador.id_cliente = cliente.id_cliente\n"
                    + "INNER JOIN indicadoreficiencia.funcionario ON indicador.id_funcionario = funcionario.id_funcionario\n"
                    + "WHERE funcionario.nome LIKE ?\n"
                    + "OR Pedido LIKE ?\n"
                    + "OR Status LIKE ?\n"
                    + "OR cliente.nome LIKE ?\n"
                    + "ORDER by abs(indicador.data) desc;";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + pesquisa + "%");
            stmt.setString(2, "%" + pesquisa + "%");
            stmt.setString(3, "%" + pesquisa + "%");
            stmt.setString(4, "%" + pesquisa + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Indicador obj = new Indicador();

                obj.setId_indicador(rs.getInt("idIndicador"));
                obj.setId_funcionario(rs.getInt("idDesigner"));
                obj.setFuncionario(rs.getString("Designer"));
                obj.setPedido(rs.getString("Pedido"));
                obj.setQtd_artes(rs.getInt("NºArtes"));
                obj.setStatus(rs.getString("Status"));
                obj.setId_cliente(rs.getInt("idCliente"));
                obj.setCliente(rs.getString("Cliente"));
                obj.setData(rs.getString("Data"));
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

    public boolean pesquisaBooleana(String pesquisa) throws SQLException {
        String sql = "SELECT EXISTS (SELECT 1 FROM indicadoreficiencia.indicador WHERE pedido = ?) AS pedido_existe;";
        boolean resultado = false;

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, pesquisa);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    resultado = rs.getInt("pedido_existe") == 1;
                }
            }
        } finally {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }

        return resultado;
    }

//Metodo ListarResumo
    public List<Indicador> ListarResumo(String ano) {

        try {

            // Passo 1 criar a lista
            List<Indicador> lista = new ArrayList<>();

            // Passo 2 criar o comando sql, organizar e executar
            String sql = "SELECT f.nome AS Designer,\n"
                    + "    SUM(CASE WHEN MONTH(i.data) = 1 THEN i.qtd_artes ELSE 0 END) AS Jan,\n"
                    + "    SUM(CASE WHEN MONTH(i.data) = 2 THEN i.qtd_artes ELSE 0 END) AS Fev,\n"
                    + "    SUM(CASE WHEN MONTH(i.data) = 3 THEN i.qtd_artes ELSE 0 END) AS Mar,\n"
                    + "    SUM(CASE WHEN MONTH(i.data) = 4 THEN i.qtd_artes ELSE 0 END) AS Abr,\n"
                    + "    SUM(CASE WHEN MONTH(i.data) = 5 THEN i.qtd_artes ELSE 0 END) AS Mai,\n"
                    + "    SUM(CASE WHEN MONTH(i.data) = 6 THEN i.qtd_artes ELSE 0 END) AS Jun,\n"
                    + "    SUM(CASE WHEN MONTH(i.data) = 7 THEN i.qtd_artes ELSE 0 END) AS Jul,\n"
                    + "    SUM(CASE WHEN MONTH(i.data) = 8 THEN i.qtd_artes ELSE 0 END) AS Ago,\n"
                    + "    SUM(CASE WHEN MONTH(i.data) = 9 THEN i.qtd_artes ELSE 0 END) AS `Set`,\n"
                    + "    SUM(CASE WHEN MONTH(i.data) = 10 THEN i.qtd_artes ELSE 0 END) AS `Out`,\n"
                    + "    SUM(CASE WHEN MONTH(i.data) = 11 THEN i.qtd_artes ELSE 0 END) AS Nov,\n"
                    + "    SUM(CASE WHEN MONTH(i.data) = 12 THEN i.qtd_artes ELSE 0 END) AS Dez,\n"
                    + "    ROUND(SUM(i.qtd_artes) / 12, 2) AS Media,\n"
                    + "    SUM(i.qtd_artes) AS Total\n"
                    + "FROM indicadorEficiencia.indicador i\n"
                    + "JOIN indicadorEficiencia.funcionario f \n"
                    + "    ON i.id_funcionario = f.id_funcionario\n"
                    + "WHERE YEAR(i.data) = ?\n"
                    + "GROUP BY f.nome\n"
                    + "ORDER BY f.nome;";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, ano);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Indicador obj = new Indicador();

                obj.setDesigner(rs.getString("Designer"));
                obj.setJan(rs.getInt("Jan"));
                obj.setFev(rs.getInt("Fev"));
                obj.setMar(rs.getInt("Mar"));
                obj.setAbr(rs.getInt("Abr"));
                obj.setMai(rs.getInt("Mai"));
                obj.setJun(rs.getInt("Jun"));
                obj.setJul(rs.getInt("Jul"));
                obj.setAgo(rs.getInt("Ago"));
                obj.setSet(rs.getInt("Set"));
                obj.setOut(rs.getInt("Out"));
                obj.setNov(rs.getInt("Nov"));
                obj.setDez(rs.getInt("Dez"));
                obj.setMedia(rs.getFloat("Media"));
                obj.setTotal(rs.getInt("Total"));

                lista.add(obj);

            }
            con.close();
            return lista;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }

    }

//Metodo ListarAnos
    public List<Indicador> ListarAnos() {

        try {

            // Passo 1 criar a lista
            List<Indicador> lista = new ArrayList<>();

            // Passo 2 criar o comando sql, organizar e executar
            String sql = "SELECT DISTINCT YEAR(criado) AS Ano\n"
                    + "FROM indicadorEficiencia.indicador\n"
                    + "ORDER BY Ano DESC;";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Indicador obj = new Indicador();

                obj.setAno(rs.getString("ano"));

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
