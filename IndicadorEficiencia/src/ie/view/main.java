/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ie.view;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.UIManager;

/**
 *
 * @author mrs_a
 */
public class main extends javax.swing.JFrame {

//Metodo mostrar cardLayout do jP_CardLayout
    public void MostraCardLayout(String card) {
        CardLayout cl = (CardLayout) jP_cardLayout.getLayout();
        cl.show(jP_cardLayout, card);
    }

    public main() {
        initComponents();
        setIconImage();
        this.setLocationRelativeTo(null);
        btn_registros.setForeground(new java.awt.Color(30, 144, 255));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jl_logo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btn_registros = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btn_desigers = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btn_clientes = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btn_relatorios = new javax.swing.JLabel();
        jP_cardLayout = new javax.swing.JPanel();
        card1 = new javax.swing.JPanel();
        gerenciarRegistros1 = new ie.view.GerenciarRegistros();
        card2 = new javax.swing.JPanel();
        gerenciarFuncionario1 = new ie.view.GerenciarFuncionarios();
        card3 = new javax.swing.JPanel();
        gerenciarClientes1 = new ie.view.GerenciarClientes();
        card4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Indicador de Eficiência   Pré-impressão");
        setMinimumSize(new java.awt.Dimension(900, 450));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/img/CartonDruck 3D.png"))); // NOI18N

        jPanel2.setMinimumSize(new java.awt.Dimension(140, 65));
        jPanel2.setPreferredSize(new java.awt.Dimension(140, 65));

        btn_registros.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_registros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/img/lista32_orig.png"))); // NOI18N
        btn_registros.setText(" Registros");
        btn_registros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_registrosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_registrosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_registrosMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btn_registros)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(btn_registros)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel3.setMinimumSize(new java.awt.Dimension(140, 65));
        jPanel3.setPreferredSize(new java.awt.Dimension(140, 65));

        btn_desigers.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_desigers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/img/usuario32_orig.png"))); // NOI18N
        btn_desigers.setText(" Designers");
        btn_desigers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_desigersMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_desigersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_desigersMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btn_desigers)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(btn_desigers)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel4.setMinimumSize(new java.awt.Dimension(140, 65));
        jPanel4.setPreferredSize(new java.awt.Dimension(140, 65));

        btn_clientes.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/img/cliente32_orig.png"))); // NOI18N
        btn_clientes.setText(" Clientes");
        btn_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_clientesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_clientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_clientesMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btn_clientes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(btn_clientes)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel5.setMinimumSize(new java.awt.Dimension(140, 65));
        jPanel5.setPreferredSize(new java.awt.Dimension(140, 65));

        btn_relatorios.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_relatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/img/relatorio32_orig.png"))); // NOI18N
        btn_relatorios.setText(" Relatórios");
        btn_relatorios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_relatoriosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_relatoriosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_relatoriosMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btn_relatorios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(btn_relatorios)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jl_logo)
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jl_logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jP_cardLayout.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout card1Layout = new javax.swing.GroupLayout(card1);
        card1.setLayout(card1Layout);
        card1Layout.setHorizontalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gerenciarRegistros1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
        );
        card1Layout.setVerticalGroup(
            card1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gerenciarRegistros1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        jP_cardLayout.add(card1, "card1");

        javax.swing.GroupLayout card2Layout = new javax.swing.GroupLayout(card2);
        card2.setLayout(card2Layout);
        card2Layout.setHorizontalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gerenciarFuncionario1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
        );
        card2Layout.setVerticalGroup(
            card2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gerenciarFuncionario1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        jP_cardLayout.add(card2, "card2");

        javax.swing.GroupLayout card3Layout = new javax.swing.GroupLayout(card3);
        card3.setLayout(card3Layout);
        card3Layout.setHorizontalGroup(
            card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gerenciarClientes1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
        );
        card3Layout.setVerticalGroup(
            card3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gerenciarClientes1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        jP_cardLayout.add(card3, "card3");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Relatórios em desenvolvimento");

        javax.swing.GroupLayout card4Layout = new javax.swing.GroupLayout(card4);
        card4.setLayout(card4Layout);
        card4Layout.setHorizontalGroup(
            card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        card4Layout.setVerticalGroup(
            card4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(card4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jP_cardLayout.add(card4, "card4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jP_cardLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jP_cardLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_registrosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_registrosMouseEntered

        btn_registros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/img/lista36_orig.png")));

    }//GEN-LAST:event_btn_registrosMouseEntered

    private void btn_registrosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_registrosMouseExited

        btn_registros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/img/lista32_orig.png")));

    }//GEN-LAST:event_btn_registrosMouseExited

    private void btn_registrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_registrosMouseClicked

        btn_registros.setForeground(new java.awt.Color(30, 144, 255));
        btn_desigers.setForeground(new java.awt.Color(221, 221, 221));
        btn_clientes.setForeground(new java.awt.Color(221, 221, 221));
        btn_relatorios.setForeground(new java.awt.Color(221, 221, 221));

        gerenciarRegistros1.listarRegistros();

        MostraCardLayout("card1");


    }//GEN-LAST:event_btn_registrosMouseClicked

    private void btn_desigersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_desigersMouseClicked

        btn_registros.setForeground(new java.awt.Color(221, 221, 221));
        btn_desigers.setForeground(new java.awt.Color(30, 144, 255));
        btn_clientes.setForeground(new java.awt.Color(221, 221, 221));
        btn_relatorios.setForeground(new java.awt.Color(221, 221, 221));

        MostraCardLayout("card2");

    }//GEN-LAST:event_btn_desigersMouseClicked

    private void btn_desigersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_desigersMouseEntered

        btn_desigers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/img/usuario36_orig.png")));

    }//GEN-LAST:event_btn_desigersMouseEntered

    private void btn_desigersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_desigersMouseExited

        btn_desigers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/img/usuario32_orig.png")));

    }//GEN-LAST:event_btn_desigersMouseExited

    private void btn_clientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clientesMouseClicked

        btn_registros.setForeground(new java.awt.Color(221, 221, 221));
        btn_desigers.setForeground(new java.awt.Color(221, 221, 221));
        btn_clientes.setForeground(new java.awt.Color(30, 144, 255));
        btn_relatorios.setForeground(new java.awt.Color(221, 221, 221));

        MostraCardLayout("card3");

    }//GEN-LAST:event_btn_clientesMouseClicked

    private void btn_clientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clientesMouseEntered

        btn_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/img/cliente36_orig.png")));

    }//GEN-LAST:event_btn_clientesMouseEntered

    private void btn_clientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_clientesMouseExited

        btn_clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/img/cliente32_orig.png")));

    }//GEN-LAST:event_btn_clientesMouseExited

    private void btn_relatoriosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_relatoriosMouseClicked

        btn_registros.setForeground(new java.awt.Color(221, 221, 221));
        btn_desigers.setForeground(new java.awt.Color(221, 221, 221));
        btn_clientes.setForeground(new java.awt.Color(221, 221, 221));
        btn_relatorios.setForeground(new java.awt.Color(30, 144, 255));

        MostraCardLayout("card4");

    }//GEN-LAST:event_btn_relatoriosMouseClicked

    private void btn_relatoriosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_relatoriosMouseEntered

        btn_relatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/img/relatorio36_orig.png")));

    }//GEN-LAST:event_btn_relatoriosMouseEntered

    private void btn_relatoriosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_relatoriosMouseExited

        btn_relatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/img/relatorio32_orig.png")));

    }//GEN-LAST:event_btn_relatoriosMouseExited

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        gerenciarClientes1.listarClientes();
        gerenciarFuncionario1.listarFuncionarios();
        gerenciarRegistros1.PesquisarRegistros();

    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        FlatMacDarkLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ie/img/logo512_orig.png")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_clientes;
    private javax.swing.JLabel btn_desigers;
    private javax.swing.JLabel btn_registros;
    private javax.swing.JLabel btn_relatorios;
    private javax.swing.JPanel card1;
    private javax.swing.JPanel card2;
    private javax.swing.JPanel card3;
    private javax.swing.JPanel card4;
    private ie.view.GerenciarClientes gerenciarClientes1;
    private ie.view.GerenciarFuncionarios gerenciarFuncionario1;
    private ie.view.GerenciarRegistros gerenciarRegistros1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jP_cardLayout;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel jl_logo;
    // End of variables declaration//GEN-END:variables
}
