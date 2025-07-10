/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ie.view;

import com.lowagie.text.DocumentException;
import ie.dao.FuncionarioDAO;
import ie.dao.IndicadorDAO;
import ie.model.Funcionario;
import ie.model.Indicador;
import ie.model.Utilitarios;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mrs_a
 */
public class GerenciarRegistros extends javax.swing.JPanel {

//Metodo listar Registros
    public void listarRegistros() {
        IndicadorDAO dao = new IndicadorDAO();
        List<Indicador> lista = dao.ListarIndicador();
        DefaultTableModel dados = (DefaultTableModel) jT_registros.getModel();
        dados.setNumRows(0);
        for (Indicador c : lista) {
            dados.addRow(new Object[]{
                c.getId_indicador(),
                c.getId_funcionario(),
                c.getFuncionario(),
                c.getPedido(),
                c.getQtd_artes(),
                c.getStatus(),
                c.getId_cliente(),
                c.getCliente(),
                c.getData(),
                c.getCriado(),
                c.getModificado()});
        }
    }

//Metodo Pesquisar Registros
    public void PesquisarRegistros() {

        String pesquisa = "%" + txt_pesquisa.getText() + "%";

        IndicadorDAO dao = new IndicadorDAO();
        List<Indicador> lista = dao.pesquisarIndicador(pesquisa);
        DefaultTableModel dados = (DefaultTableModel) jT_registros.getModel();
        dados.setNumRows(0);
        for (Indicador c : lista) {
            dados.addRow(new Object[]{
                c.getId_indicador(),
                c.getId_funcionario(),
                c.getFuncionario(),
                c.getPedido(),
                c.getQtd_artes(),
                c.getStatus(),
                c.getId_cliente(),
                c.getCliente(),
                c.getData(),
                c.getCriado(),
                c.getModificado()});

        }

    }

    //Metodo Alterar Registros
    public void AbrirAlterarRegistro() {
        jT_registros.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Frame parent = (Frame) SwingUtilities.getWindowAncestor(jT_registros);
                    AplicarBlur(true);
                    AlterarRegistro dialog = new AlterarRegistro(parent, true);

                    int selectedRow = jT_registros.getSelectedRow();

                    dialog.AlterarVariaveis(
                            jT_registros.getValueAt(selectedRow, 0).toString(),
                            jT_registros.getValueAt(selectedRow, 2).toString(),
                            jT_registros.getValueAt(selectedRow, 3).toString(),
                            jT_registros.getValueAt(selectedRow, 4).toString(),
                            jT_registros.getValueAt(selectedRow, 5).toString(),
                            jT_registros.getValueAt(selectedRow, 7).toString(),
                            jT_registros.getValueAt(selectedRow, 8).toString()
                    );

                    dialog.setVisible(true);
                    AplicarBlur(false);
                }
            }
        });
    }

    public void AplicarBlur(boolean ativar) {
        JPanel blurPane = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
                g2.setColor(Color.GRAY);
                g2.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        blurPane.setOpaque(false);

        // Obtém a janela que contém este JPanel
        Window janela = SwingUtilities.getWindowAncestor(this);
        if (janela instanceof JFrame) {
            JFrame frame = (JFrame) janela;
            frame.getRootPane().setGlassPane(blurPane);
            blurPane.setVisible(ativar);
            blurPane.repaint(); // Atualiza a tela
        }
    }

    public GerenciarRegistros() {
        initComponents();
        AbrirAlterarRegistro();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jT_registros = new javax.swing.JTable();
        txt_pesquisa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_cancelaPesquisa = new javax.swing.JLabel();

        jT_registros.setAutoCreateRowSorter(true);
        jT_registros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "idIndicador", "idDesigner", "Designer", "Pedido", "NºArtes", "Status", "idCliente", "Cliente", "Data", "Criado", "Modificado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jT_registros.setToolTipText("Duplo Clicke para Alterar Registro");
        jT_registros.setFocusable(false);
        jScrollPane1.setViewportView(jT_registros);
        if (jT_registros.getColumnModel().getColumnCount() > 0) {
            jT_registros.getColumnModel().getColumn(0).setMinWidth(0);
            jT_registros.getColumnModel().getColumn(0).setPreferredWidth(0);
            jT_registros.getColumnModel().getColumn(0).setMaxWidth(0);
            jT_registros.getColumnModel().getColumn(1).setMinWidth(0);
            jT_registros.getColumnModel().getColumn(1).setPreferredWidth(0);
            jT_registros.getColumnModel().getColumn(1).setMaxWidth(0);
            jT_registros.getColumnModel().getColumn(6).setMinWidth(0);
            jT_registros.getColumnModel().getColumn(6).setPreferredWidth(0);
            jT_registros.getColumnModel().getColumn(6).setMaxWidth(0);
            jT_registros.getColumnModel().getColumn(9).setMinWidth(0);
            jT_registros.getColumnModel().getColumn(9).setPreferredWidth(0);
            jT_registros.getColumnModel().getColumn(9).setMaxWidth(0);
            jT_registros.getColumnModel().getColumn(10).setMinWidth(0);
            jT_registros.getColumnModel().getColumn(10).setPreferredWidth(0);
            jT_registros.getColumnModel().getColumn(10).setMaxWidth(0);
        }

        txt_pesquisa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_pesquisa.setToolTipText("Pesquisa");
        txt_pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pesquisaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_pesquisaKeyTyped(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/img/adicionar32_orig.png"))); // NOI18N
        jLabel1.setToolTipText("Adicionar Registro");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/img/pdf32_orig.png"))); // NOI18N
        jLabel2.setToolTipText("Gerar PDF");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });

        btn_cancelaPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/img/cancelar24_orig.png"))); // NOI18N
        btn_cancelaPesquisa.setToolTipText("Pesquisar");
        btn_cancelaPesquisa.setEnabled(false);
        btn_cancelaPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancelaPesquisaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_cancelaPesquisaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_cancelaPesquisaMouseExited(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(txt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancelaPesquisa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(btn_cancelaPesquisa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/img/adicionar32_sat.png")));

    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/img/adicionar32_orig.png")));

    }//GEN-LAST:event_jLabel1MouseExited

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/img/pdf32_sat.png")));

    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/img/pdf32_orig.png")));

    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

        AplicarBlur(true);

        Frame parent = (Frame) SwingUtilities.getWindowAncestor(this);
        NovoRegistro dialog = new NovoRegistro(parent, true);
        dialog.setVisible(true);

        AplicarBlur(false);


    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_pesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesquisaKeyReleased
        if (!"".equals(txt_pesquisa.getText())) {
            btn_cancelaPesquisa.setEnabled(true);
        } else {
            btn_cancelaPesquisa.setEnabled(false);
        }
        PesquisarRegistros();

    }//GEN-LAST:event_txt_pesquisaKeyReleased

    private void btn_cancelaPesquisaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelaPesquisaMouseEntered

        btn_cancelaPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/img/cancelar24_sat.png")));

    }//GEN-LAST:event_btn_cancelaPesquisaMouseEntered

    private void btn_cancelaPesquisaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelaPesquisaMouseExited

        btn_cancelaPesquisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ie/img/cancelar24_orig.png")));

    }//GEN-LAST:event_btn_cancelaPesquisaMouseExited

    private void btn_cancelaPesquisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelaPesquisaMouseClicked

        if (btn_cancelaPesquisa.isEnabled()) {
            txt_pesquisa.setText("");
            PesquisarRegistros();
            btn_cancelaPesquisa.setEnabled(false);
        }
    }//GEN-LAST:event_btn_cancelaPesquisaMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked

   Utilitarios utl = new Utilitarios();
        try {
            utl.gerarPDF(jT_registros, "TB_Registros de Apontamentos.pdf", Arrays.asList("Designer", "Pedido", "NºArtes", "Status", "Cliente",
                    "Data", "Criado", "Modificado"), "Indicador de Eficiência");
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(GerenciarRegistros.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jLabel2MouseClicked

    private void txt_pesquisaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesquisaKeyTyped

String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0987654321-_";
        char keyChar = evt.getKeyChar();

        if (Character.isLetter(keyChar)) {
            keyChar = Character.toUpperCase(keyChar);
            evt.setKeyChar(keyChar);
        } else if (!caracteres.contains(Character.toUpperCase(keyChar) + "")) {
            evt.consume();
        }

    }//GEN-LAST:event_txt_pesquisaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_cancelaPesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jT_registros;
    private javax.swing.JTextField txt_pesquisa;
    // End of variables declaration//GEN-END:variables
}
