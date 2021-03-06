/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odin.view;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import odin.dao.AlunoDAO;
import odin.dao.UsuarioDAO;
import odin.model.Aluno;

/**
 *
 * @author Francisco
 */
public class VincularAlunosGUI extends javax.swing.JFrame {

    /**
     * Creates new form VincularAlunosGUI
     */
    public VincularAlunosGUI() {
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
        tabelaAlunosNaoVinculados = new javax.swing.JTable();
        text_vincularAlunoCodigoTurma = new javax.swing.JTextField();
        text_vincularAlunoNomeTurma = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaAlunosVinculados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botao_cancelarVincularAluno = new javax.swing.JButton();
        botao_vincularAluno = new javax.swing.JButton();
        botao_desvincularAluno = new javax.swing.JButton();
        botao_vincularAlunoAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        tabelaAlunosNaoVinculados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaAlunosNaoVinculados);

        text_vincularAlunoCodigoTurma.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        text_vincularAlunoCodigoTurma.setEnabled(false);

        text_vincularAlunoNomeTurma.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        text_vincularAlunoNomeTurma.setEnabled(false);

        tabelaAlunosVinculados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tabelaAlunosVinculados);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Alunos vinculados:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Alunos não vinculados:");

        botao_cancelarVincularAluno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botao_cancelarVincularAluno.setText("Cancelar");
        botao_cancelarVincularAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_cancelarVincularAlunoActionPerformed(evt);
            }
        });

        botao_vincularAluno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botao_vincularAluno.setText("Vincular aluno");
        botao_vincularAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_vincularAlunoActionPerformed(evt);
            }
        });

        botao_desvincularAluno.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botao_desvincularAluno.setText("Desvincular aluno");
        botao_desvincularAluno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_desvincularAlunoActionPerformed(evt);
            }
        });

        botao_vincularAlunoAtualizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        botao_vincularAlunoAtualizar.setText("Atualizar tabelas");
        botao_vincularAlunoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_vincularAlunoAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(301, 301, 301))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(botao_desvincularAluno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botao_vincularAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(botao_cancelarVincularAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(botao_vincularAlunoAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(text_vincularAlunoCodigoTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(text_vincularAlunoNomeTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(341, 341, 341))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_vincularAlunoCodigoTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_vincularAlunoNomeTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(botao_vincularAluno)
                        .addGap(18, 18, 18)
                        .addComponent(botao_desvincularAluno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botao_vincularAlunoAtualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botao_cancelarVincularAluno)
                        .addGap(41, 41, 41))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botao_vincularAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_vincularAlunoActionPerformed
        // TODO add your handling code here:
        AlunoDAO alunoDAO = new AlunoDAO();
        int i = tabelaAlunosNaoVinculados.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada!");
        } else {
            try {
                alunoDAO.vincularAlunoPorTurma(Integer.parseInt(text_vincularAlunoCodigoTurma.getText()), Integer.parseInt(tabelaAlunosNaoVinculados.getValueAt(i, 0).toString()));
                gerarTabelaAlunosNaoVinculados();
                gerarTabelaAlunosVinculados(Integer.parseInt(text_vincularAlunoCodigoTurma.getText()));
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro " + e.getMessage());
            }
        }
    }//GEN-LAST:event_botao_vincularAlunoActionPerformed

    private void botao_desvincularAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_desvincularAlunoActionPerformed
        // TODO add your handling code here:
        AlunoDAO alunoDAO = new AlunoDAO();
        int i = tabelaAlunosVinculados.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada!");
        } else {
            try {
                alunoDAO.desvincularAluno(Integer.parseInt(tabelaAlunosVinculados.getValueAt(i, 0).toString()), Integer.parseInt(text_vincularAlunoCodigoTurma.getText()));
                gerarTabelaAlunosVinculados(Integer.parseInt(text_vincularAlunoCodigoTurma.getText()));
                gerarTabelaAlunosNaoVinculados();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro " + e.getMessage());
            }
        }
    }//GEN-LAST:event_botao_desvincularAlunoActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        try {
            gerarTabelaAlunosNaoVinculados();
            gerarTabelaAlunosVinculados(Integer.parseInt(text_vincularAlunoCodigoTurma.getText()));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher tabela de alunos não vinculados ");
        }
    }//GEN-LAST:event_formComponentShown

    private void botao_cancelarVincularAlunoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_cancelarVincularAlunoActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_botao_cancelarVincularAlunoActionPerformed

    private void botao_vincularAlunoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_vincularAlunoAtualizarActionPerformed
        // TODO add your handling code here:
        try{
        gerarTabelaAlunosNaoVinculados();
        gerarTabelaAlunosVinculados(Integer.parseInt(text_vincularAlunoCodigoTurma.getText()));
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERRO "+e.getMessage());
        }
    }//GEN-LAST:event_botao_vincularAlunoAtualizarActionPerformed

    public void gerarTabelaAlunosVinculados(int codDisciplina) throws SQLException {
        String[] colunas = {"Codigo", "Aluno", "Nota AV1", "Nota AV2", "Média", "Faltas"};
        DefaultTableModel modelo = new DefaultTableModel(null, colunas);
        ArrayList<Aluno> dadosRecebidos = new ArrayList();
        AlunoDAO alunoDAO = new AlunoDAO();

        dadosRecebidos = alunoDAO.listarAlunosPorDisciplina(codDisciplina);

        for (Aluno novosAlunos : dadosRecebidos) {
            modelo.addRow(new Object[]{novosAlunos.getCodigo_aluno(), novosAlunos.getNomeUsuario(), novosAlunos.getNota1(), novosAlunos.getNota2(), novosAlunos.getNotaFinal(), novosAlunos.getFaltas()});
        }
        tabelaAlunosVinculados.setModel(modelo);

    }

    public boolean isVinculado(int codigoAluno) throws SQLException {
        boolean isAchou = false;
        ArrayList<Aluno> dadosRecebidos = new ArrayList();
        AlunoDAO alunoDAO = new AlunoDAO();

        dadosRecebidos = alunoDAO.listarAlunosPorDisciplina(Integer.parseInt(text_vincularAlunoCodigoTurma.getText()));
        
        for (Aluno novosAlunos : dadosRecebidos) {
            if (novosAlunos.getCodigo_aluno() == codigoAluno) {
                isAchou = true;
                break;
            }
        }
        return isAchou;
    }

    public void gerarTabelaAlunosNaoVinculados() throws SQLException {
        String[] colunas = {"Codigo", "Aluno", "CPF"};
        DefaultTableModel modelo = new DefaultTableModel(null, colunas);
        ArrayList<Aluno> dadosRecebidos = new ArrayList<>();
        AlunoDAO alunoDAO = new AlunoDAO();
        dadosRecebidos = alunoDAO.listarAlunos();
        for (Aluno novosAlunos : dadosRecebidos) {
            if (!isVinculado(novosAlunos.getCodigo_aluno())) {
                modelo.addRow(new Object[]{novosAlunos.getCodigo_aluno(), novosAlunos.getNomeUsuario(), novosAlunos.getCPFUsuario()});
            }
        }
        tabelaAlunosNaoVinculados.setModel(modelo);
    }

    public void receberDados(String codigoTurma, String nomeTurma) {
        text_vincularAlunoCodigoTurma.setText(codigoTurma);
        text_vincularAlunoNomeTurma.setText(nomeTurma);
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
            java.util.logging.Logger.getLogger(VincularAlunosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VincularAlunosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VincularAlunosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VincularAlunosGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VincularAlunosGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_cancelarVincularAluno;
    private javax.swing.JButton botao_desvincularAluno;
    private javax.swing.JButton botao_vincularAluno;
    private javax.swing.JButton botao_vincularAlunoAtualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaAlunosNaoVinculados;
    private javax.swing.JTable tabelaAlunosVinculados;
    private javax.swing.JTextField text_vincularAlunoCodigoTurma;
    private javax.swing.JTextField text_vincularAlunoNomeTurma;
    // End of variables declaration//GEN-END:variables
}
