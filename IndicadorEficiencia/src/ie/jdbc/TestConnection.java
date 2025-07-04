/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ie.jdbc;

import javax.swing.JOptionPane;

/**
 *
 * @author mrs_a
 */
public class TestConnection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {

            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Conectado com sucesso ao Banco de Dados indicadoreficiencia!");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possível se conectar ao Banco de Dados indicadoreficiencia: " + erro);
        }

    }

}
