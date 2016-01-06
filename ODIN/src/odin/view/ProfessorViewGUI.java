/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odin.view;

import java.awt.Component;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import odin.dao.*;
import odin.model.*;

/**
 *
 * @author Eike
 */
public class ProfessorViewGUI extends javax.swing.JFrame {

    /**
     * Creates new form ProfessorViewGUI
     */
    public ProfessorViewGUI() {
        initComponents();
        cmbCodTurma.setVisible(false);
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
        tblAlunoPorDisciplina = new javax.swing.JTable();
        cmbTurmas = new javax.swing.JComboBox();
        btnSelecionarTurma = new javax.swing.JButton();
        cmbCodTurma = new javax.swing.JComboBox();
        btnAtualizar = new javax.swing.JButton();
        btnEditarAluno = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblAlunoPorDisciplina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Aluno", "Nota AV1", "Nota AV2", "Média", "Faltas"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblAlunoPorDisciplina);

        cmbTurmas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTurmas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTurmasActionPerformed(evt);
            }
        });

        btnSelecionarTurma.setText("Selecionar");
        btnSelecionarTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarTurmaActionPerformed(evt);
            }
        });

        cmbCodTurma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnEditarAluno.setText("Editar");
        btnEditarAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAlunoActionPerformed(evt);
            }
        });

        btnLogout.setText("LOGOUT");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbTurmas, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btnSelecionarTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(btnEditarAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cmbCodTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(340, 340, 340))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41))
                    .addComponent(cmbCodTurma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTurmas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSelecionarTurma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEditarAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTurmasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTurmasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTurmasActionPerformed

    private void btnSelecionarTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarTurmaActionPerformed
        // TODO add your handling code here:
       int index =cmbTurmas.getSelectedIndex();
       cmbCodTurma.setSelectedIndex(index);
       String nome = cmbCodTurma.getSelectedItem().toString();
       int codigo = Integer.parseInt(nome);
        try {
            gerarTabelaAlunos(codigo);
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorViewGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSelecionarTurmaActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
        btnSelecionarTurma.doClick();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnEditarAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAlunoActionPerformed
        // TODO add your handling code here:
        String[] colunas = {"Codigo","Aluno", "Nota AV1", "Nota AV2", "Média", "Faltas"};
        EditarNotasGUI editarNotasGUI = new EditarNotasGUI();
        
        int i = tblAlunoPorDisciplina.getSelectedRow();
        if (i < 0) {
            Component Painel;
            JOptionPane.showMessageDialog(rootPane, "Nenhuma linha selecionada!");
        }
        Object[] dados = {tblAlunoPorDisciplina.getValueAt(i, 0), tblAlunoPorDisciplina.getValueAt(i, 1), tblAlunoPorDisciplina.getValueAt(i, 2),tblAlunoPorDisciplina.getValueAt(i, 3),tblAlunoPorDisciplina.getValueAt(i, 4),tblAlunoPorDisciplina.getValueAt(i, 5)};
        editarNotasGUI.gerarTabela(colunas, dados);
        editarNotasGUI.setVisible(true);
//        editarNotasGUI.setModel(gerarModeloTabelaDisciplina());
    }//GEN-LAST:event_btnEditarAlunoActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        OdinViewGUI odinViewGUI = new OdinViewGUI();
        odinViewGUI.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed
    public void setComboBox(String cpf) throws SQLException{
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        DefaultComboBoxModel modelo2 = new DefaultComboBoxModel();
        ArrayList<Turma> turma = new ArrayList<>();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        turma = usuarioDAO.listarTurmaPorProfessor(cpf);
        for (Turma dadosTurma : turma) {
            modelo.addElement(dadosTurma.getNomeTurma());
            modelo2.addElement(dadosTurma.getCodigoTurma());
        }
        cmbTurmas.setModel(modelo);
        cmbCodTurma.setModel(modelo2);
        
    }
    
    public void gerarTabelaAlunos(int codDisciplina) throws SQLException{
        String[] colunas = {"Codigo","Aluno", "Nota AV1", "Nota AV2", "Média", "Faltas"};
        DefaultTableModel modelo = new DefaultTableModel(null, colunas);
        ArrayList<Aluno> dadosRecebidos = new ArrayList();
        AlunoDAO alunoDAO = new AlunoDAO();
        
        dadosRecebidos = alunoDAO.listarAlunosPorDisciplina(codDisciplina);
      
        for (Aluno novosAlunos : dadosRecebidos) {
            modelo.addRow(new Object[]{novosAlunos.getCodigoUsuario(),novosAlunos.getNomeUsuario(),novosAlunos.getNota1(),novosAlunos.getNota2(),novosAlunos.getNotaFinal(),novosAlunos.getFaltas()});
        }
        tblAlunoPorDisciplina.setModel(modelo);
        
    }
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
            java.util.logging.Logger.getLogger(ProfessorViewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfessorViewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfessorViewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfessorViewGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfessorViewGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnEditarAluno;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSelecionarTurma;
    private javax.swing.JComboBox cmbCodTurma;
    private javax.swing.JComboBox cmbTurmas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAlunoPorDisciplina;
    // End of variables declaration//GEN-END:variables
}
