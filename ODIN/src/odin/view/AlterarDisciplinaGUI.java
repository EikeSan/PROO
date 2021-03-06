/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odin.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import odin.bo.DisciplinaBO;
import odin.bo.UsuarioBO;
import odin.dao.*;
import odin.model.Professor;
import odin.model.Usuario;

/**
 *
 * @author Francisco
 */
public class AlterarDisciplinaGUI extends javax.swing.JFrame {

    /**
     * Creates new form AlterarDisciplinaGUI
     */
    public AlterarDisciplinaGUI() {
        initComponents();
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
        jTable1 = new javax.swing.JTable();
        recebeNome = new javax.swing.JTextField();
        recebeCodigo = new javax.swing.JTextField();
        recebeCargaHoraria = new javax.swing.JTextField();
        botao_SalvarDisciplina = new javax.swing.JButton();
        botao_cancelarDisciplina = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alterar disciplina");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código da disciplina", "Nome da disciplina", "Carga horária"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        recebeCodigo.setEnabled(false);

        botao_SalvarDisciplina.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        botao_SalvarDisciplina.setText("Alterar");
        botao_SalvarDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_SalvarDisciplinaActionPerformed(evt);
            }
        });

        botao_cancelarDisciplina.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        botao_cancelarDisciplina.setText("Cancelar");
        botao_cancelarDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_cancelarDisciplinaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(recebeCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(recebeNome, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(recebeCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(botao_SalvarDisciplina)
                .addGap(106, 106, 106)
                .addComponent(botao_cancelarDisciplina)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recebeCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recebeNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(recebeCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botao_SalvarDisciplina)
                    .addComponent(botao_cancelarDisciplina))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void gerarTabela(String[] campos, Object[] dados) {
        DefaultTableModel model = new DefaultTableModel(null, campos);
        jTable1.setModel(model);
        recebeCodigo.setText(dados[0].toString());
        recebeNome.setText(dados[1].toString());
        recebeCargaHoraria.setText(dados[2].toString());
    }
    /* public boolean isVinculado(String nome){
        
     }*/

    

    

    
    private void botao_SalvarDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_SalvarDisciplinaActionPerformed
        // TODO add your handling code here:
        DisciplinaBO disciplinaBO = new DisciplinaBO();
        int codigo = Integer.parseInt(recebeCodigo.getText());
        String nomeDisciplina = recebeNome.getText();
        int cargaHoraria = Integer.parseInt(recebeCargaHoraria.getText());

        try {
            disciplinaBO.alterarDisciplina(codigo, nomeDisciplina, cargaHoraria);
        } catch (SQLException ex) {
            Logger.getLogger(AlterarDisciplinaGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Alteração bem sucedida!");
        dispose();
    }//GEN-LAST:event_botao_SalvarDisciplinaActionPerformed

    private void botao_cancelarDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_cancelarDisciplinaActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_botao_cancelarDisciplinaActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
       
    }//GEN-LAST:event_formComponentShown

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AlterarDisciplinaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarDisciplinaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarDisciplinaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarDisciplinaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarDisciplinaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_SalvarDisciplina;
    private javax.swing.JButton botao_cancelarDisciplina;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField recebeCargaHoraria;
    private javax.swing.JTextField recebeCodigo;
    private javax.swing.JTextField recebeNome;
    // End of variables declaration//GEN-END:variables
}
