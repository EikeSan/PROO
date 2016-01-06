/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odin.view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import odin.dao.UsuarioDAO;

/**
 *
 * @author Francisco
 */
public class AlterarTurmaGUI extends javax.swing.JFrame {

    /**
     * Creates new form AlterarTurmaGUI
     */
    public AlterarTurmaGUI() {
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
        tabelaAlterarTurma = new javax.swing.JTable();
        text_alterarCodigoTurma = new javax.swing.JTextField();
        text_alterarNomeTurma = new javax.swing.JTextField();
        botao_alterarCancelar = new javax.swing.JButton();
        botao_alterarConfirmar = new javax.swing.JButton();
        text_alterarVincularNomeDisciplina = new javax.swing.JTextField();
        text_alterarVincularCodigoDisciplina = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabelaVincularDisciplina = new javax.swing.JTable();
        botao_alterarVincularDisciplina = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaVincularProfessor = new javax.swing.JTable();
        text_alterarVincularNomeProfessor = new javax.swing.JTextField();
        text_alterarVincularCodigoProfessor = new javax.swing.JTextField();
        botao_alterararVincularDisciplina1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabelaAlterarTurma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código da turma", "Nome da turma"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaAlterarTurma);
        if (tabelaAlterarTurma.getColumnModel().getColumnCount() > 0) {
            tabelaAlterarTurma.getColumnModel().getColumn(0).setPreferredWidth(1);
        }

        text_alterarCodigoTurma.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        text_alterarCodigoTurma.setEnabled(false);

        text_alterarNomeTurma.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        botao_alterarCancelar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botao_alterarCancelar.setText("Cancelar");
        botao_alterarCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_alterarCancelarActionPerformed(evt);
            }
        });

        botao_alterarConfirmar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        botao_alterarConfirmar.setText("Alterar");
        botao_alterarConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_alterarConfirmarActionPerformed(evt);
            }
        });

        text_alterarVincularNomeDisciplina.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        text_alterarVincularNomeDisciplina.setEnabled(false);

        text_alterarVincularCodigoDisciplina.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        text_alterarVincularCodigoDisciplina.setEnabled(false);
        text_alterarVincularCodigoDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_alterarVincularCodigoDisciplinaActionPerformed(evt);
            }
        });

        tabelaVincularDisciplina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Código da disciplina", "Nome da disciplina", "Carga Horária"
            }
        ));
        jScrollPane4.setViewportView(tabelaVincularDisciplina);

        botao_alterarVincularDisciplina.setText("Vincular Disciplina");
        botao_alterarVincularDisciplina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_alterarVincularDisciplinaActionPerformed(evt);
            }
        });

        tabelaVincularProfessor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código do professor", "Nome"
            }
        ));
        jScrollPane5.setViewportView(tabelaVincularProfessor);

        text_alterarVincularNomeProfessor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        text_alterarVincularNomeProfessor.setEnabled(false);

        text_alterarVincularCodigoProfessor.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        text_alterarVincularCodigoProfessor.setEnabled(false);

        botao_alterararVincularDisciplina1.setText("Vincular Professor");
        botao_alterararVincularDisciplina1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_alterararVincularDisciplina1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(text_alterarVincularCodigoDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(text_alterarVincularNomeDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botao_alterarVincularDisciplina)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botao_alterarConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(text_alterarVincularCodigoProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(text_alterarVincularNomeProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(text_alterarCodigoTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(text_alterarNomeTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(112, 112, 112)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botao_alterarCancelar)
                            .addComponent(botao_alterararVincularDisciplina1)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botao_alterarCancelar)
                        .addGap(83, 83, 83))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_alterarCodigoTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_alterarNomeTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_alterarVincularNomeDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botao_alterarVincularDisciplina)
                            .addComponent(text_alterarVincularCodigoDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(botao_alterarConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text_alterarVincularCodigoProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text_alterarVincularNomeProfessor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botao_alterararVincularDisciplina1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botao_alterarCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_alterarCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_botao_alterarCancelarActionPerformed

    private void botao_alterarConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_alterarConfirmarActionPerformed
        // TODO add your handling code here:
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        if (!text_alterarNomeTurma.getText().isEmpty()){
            usuarioDAO.alterarTurma(Integer.parseInt(text_alterarCodigoTurma.getText()), text_alterarNomeTurma.getText());
            usuarioDAO.alterarProfessorPorTurma(Integer.parseInt(text_alterarVincularCodigoProfessor.getText()), Integer.parseInt(text_alterarVincularCodigoDisciplina.getText()), Integer.parseInt(text_alterarCodigoTurma.getText()));
            JOptionPane.showMessageDialog(null, "Turma alterada com sucesso!");
            dispose();
        }else
            JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente");
        
    }//GEN-LAST:event_botao_alterarConfirmarActionPerformed

    private void text_alterarVincularCodigoDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_alterarVincularCodigoDisciplinaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_alterarVincularCodigoDisciplinaActionPerformed

    private void botao_alterarVincularDisciplinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_alterarVincularDisciplinaActionPerformed
        // TODO add your handling code here:
        int i = tabelaVincularDisciplina.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada!");
        }
        text_alterarVincularCodigoDisciplina.setText(tabelaVincularDisciplina.getValueAt(i, 0).toString());
        text_alterarVincularNomeDisciplina.setText(tabelaVincularDisciplina.getValueAt(i, 1).toString());
    }//GEN-LAST:event_botao_alterarVincularDisciplinaActionPerformed

    private void botao_alterararVincularDisciplina1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_alterararVincularDisciplina1ActionPerformed
        // TODO add your handling code here:
        int i = tabelaVincularProfessor.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada!");
        }
        text_alterarVincularCodigoProfessor.setText(tabelaVincularProfessor.getValueAt(i, 0).toString());
        text_alterarVincularNomeProfessor.setText(tabelaVincularProfessor.getValueAt(i, 1).toString());
    }//GEN-LAST:event_botao_alterararVincularDisciplina1ActionPerformed
    public void receberDados(String codigoTurma,String nomeTurma,String codigoDisciplina,String nomeDisciplina,String codigoProfessor,String nomeProfessor,DefaultTableModel modeloProfessores,DefaultTableModel modeloDisciplinas){
        tabelaVincularDisciplina.setModel(modeloDisciplinas);
        tabelaVincularProfessor.setModel(modeloProfessores);
        text_alterarCodigoTurma.setText(codigoTurma);
        text_alterarNomeTurma.setText(nomeTurma);
        text_alterarVincularCodigoProfessor.setText(codigoProfessor);
        text_alterarVincularNomeProfessor.setText(nomeProfessor);
        text_alterarVincularCodigoDisciplina.setText(codigoDisciplina);
        text_alterarVincularNomeDisciplina.setText(nomeDisciplina);
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
            java.util.logging.Logger.getLogger(AlterarTurmaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarTurmaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarTurmaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarTurmaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarTurmaGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_alterarCancelar;
    private javax.swing.JButton botao_alterarConfirmar;
    private javax.swing.JButton botao_alterarVincularDisciplina;
    private javax.swing.JButton botao_alterararVincularDisciplina1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tabelaAlterarTurma;
    private javax.swing.JTable tabelaVincularDisciplina;
    private javax.swing.JTable tabelaVincularProfessor;
    private javax.swing.JTextField text_alterarCodigoTurma;
    private javax.swing.JTextField text_alterarNomeTurma;
    private javax.swing.JTextField text_alterarVincularCodigoDisciplina;
    private javax.swing.JTextField text_alterarVincularCodigoProfessor;
    private javax.swing.JTextField text_alterarVincularNomeDisciplina;
    private javax.swing.JTextField text_alterarVincularNomeProfessor;
    // End of variables declaration//GEN-END:variables
}