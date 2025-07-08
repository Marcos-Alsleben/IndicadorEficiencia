/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ie.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author mrs_a
 */
public class ConnectionFactory {

    public Connection getConnection() {
        try {
            //return DriverManager.getConnection("jdbc:mysql://localhost:3306/indicadoreficiencia?allowPublicKeyRetrieval=true&useSSL=false", "carton", "2574");
            return DriverManager.getConnection("jdbc:mysql://10.0.70.90:3306/indicadoreficiencia?allowPublicKeyRetrieval=true&useSSL=false", "carton", "2574");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com banco de dados: " + erro.getMessage());
            System.exit(1); // Encerra o programa
            return null; // Este retorno nunca será alcançado, mas é necessário para compilar sem erros.
        }
    }

}
