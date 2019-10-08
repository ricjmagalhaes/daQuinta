/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daquinta;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author toshiba
 */
public class FormTransportes extends javax.swing.JFrame {

    /**
     * Creates new form FormTransportes
     */
    static String dbName = "daquinta_teste"; //Nome do Banco criado
    
    Connection con;
    Statement stmt;
    ResultSet rs;
    int curRow = 0;
    int IDs = 1;
    DB conDB = new DB();
    boolean editar = false, criarnovo=false;
    
    
    public FormTransportes() {
        initComponents();
        DoConnect();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSaveRecord1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnDeleteRecord = new javax.swing.JButton();
        btnSaveRecord = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textMatriculaTransportes = new javax.swing.JTextField();
        textIDTransportes = new javax.swing.JTextField();
        btnFirst = new javax.swing.JButton();
        textCargaMaxTransportes = new javax.swing.JTextField();
        btnNext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnNewRecord = new javax.swing.JButton();
        btnUpdateRecord = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        textCaixasMaxTransportes = new javax.swing.JTextField();
        textNotasTransportes = new javax.swing.JScrollPane();
        jtextNotasTransportes = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transportes");
        setResizable(false);

        btnSaveRecord1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/118.png"))); // NOI18N
        btnSaveRecord1.setText("Cancelar");
        btnSaveRecord1.setMaximumSize(new java.awt.Dimension(111, 41));
        btnSaveRecord1.setMinimumSize(new java.awt.Dimension(111, 41));
        btnSaveRecord1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveRecord1ActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/66.png"))); // NOI18N
        jLabel9.setText("Clientes | Restaurantes");

        btnDeleteRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/9.png"))); // NOI18N
        btnDeleteRecord.setText("Eliminar");
        btnDeleteRecord.setMaximumSize(new java.awt.Dimension(111, 41));
        btnDeleteRecord.setMinimumSize(new java.awt.Dimension(111, 41));
        btnDeleteRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteRecordActionPerformed(evt);
            }
        });

        btnSaveRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/7.png"))); // NOI18N
        btnSaveRecord.setText("Guardar");
        btnSaveRecord.setMaximumSize(new java.awt.Dimension(111, 41));
        btnSaveRecord.setMinimumSize(new java.awt.Dimension(111, 41));
        btnSaveRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveRecordActionPerformed(evt);
            }
        });

        jLabel2.setText("Matricula");

        jLabel1.setText("ID:");

        jLabel3.setText(" Carga MAX/kg");

        jLabel4.setText("Notas");

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/92.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/98.png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/94.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnNewRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/8.png"))); // NOI18N
        btnNewRecord.setText("Novo");
        btnNewRecord.setMaximumSize(new java.awt.Dimension(111, 41));
        btnNewRecord.setMinimumSize(new java.awt.Dimension(111, 41));
        btnNewRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewRecordActionPerformed(evt);
            }
        });

        btnUpdateRecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/2.png"))); // NOI18N
        btnUpdateRecord.setText("Editar");
        btnUpdateRecord.setMaximumSize(new java.awt.Dimension(111, 41));
        btnUpdateRecord.setMinimumSize(new java.awt.Dimension(111, 41));
        btnUpdateRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateRecordActionPerformed(evt);
            }
        });

        btnPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/99.png"))); // NOI18N
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        jtextNotasTransportes.setColumns(20);
        jtextNotasTransportes.setRows(5);
        textNotasTransportes.setViewportView(jtextNotasTransportes);

        jLabel5.setText("Carga Qtd Caixas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(textIDTransportes, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textNotasTransportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(68, 68, 68)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel5)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(textMatriculaTransportes, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                            .addComponent(textCaixasMaxTransportes)
                                            .addComponent(textCargaMaxTransportes))))
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPrevious)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnNext)
                                .addGap(18, 18, 18)
                                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNewRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSaveRecord1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnUpdateRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDeleteRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSaveRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(textIDTransportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textMatriculaTransportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnSaveRecord1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textCargaMaxTransportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textCaixasMaxTransportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textNotasTransportes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNewRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdateRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDeleteRecord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSaveRecord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnPrevious)
                        .addComponent(btnFirst)
                        .addComponent(btnNext)
                        .addComponent(btnLast)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveRecord1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveRecord1ActionPerformed
        // TODO add your handling code here:
        if (criarnovo == true) { //Is new
            criarnovo = false;
            btnFirst.setEnabled(true);
            btnPrevious.setEnabled(true);
            btnNext.setEnabled(true);
            btnLast.setEnabled(true);
            btnUpdateRecord.setEnabled(true);
            btnDeleteRecord.setEnabled(true);
            btnNewRecord.setEnabled(true);

            btnSaveRecord.setEnabled(true);
        } else if (editar == true) {
            editar = false;
            btnFirst.setEnabled(true);
            btnPrevious.setEnabled(true);
            btnNext.setEnabled(true);
            btnLast.setEnabled(true);
            btnUpdateRecord.setEnabled(true);
            btnDeleteRecord.setEnabled(true);
            btnNewRecord.setEnabled(true);
        } else {
            closeApplication();
        }



    }//GEN-LAST:event_btnSaveRecord1ActionPerformed

    private void btnDeleteRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteRecordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteRecordActionPerformed

    private void btnSaveRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveRecordActionPerformed
        // TODO add your handling code here:
        try {

            curRow = rs.getRow();
            rs.absolute(curRow);

            int ID = Integer.valueOf(textIDTransportes.getText());
            String matricula = textMatriculaTransportes.getText();
            int carga = Integer.valueOf(textCargaMaxTransportes.getText());
            int caixas = Integer.valueOf(textCaixasMaxTransportes.getText());
            int tipo;// = Integer.valueOf(textTipoTransportes.getText());
            
           
            String notas = jtextNotasTransportes.getText();

            if (criarnovo == true) { //Is new
                criarnovo = false;
                conDB.inserirTransporteNovo(matricula, carga, caixas, notas);
            } else if (editar == true) {
                editar = false;
                conDB.inserirTransporteEditar(ID, matricula, carga, caixas, notas);
            }




            btnFirst.setEnabled(true);
            btnPrevious.setEnabled(true);
            btnNext.setEnabled(true);
            btnLast.setEnabled(true);
            btnUpdateRecord.setEnabled(true);
            btnDeleteRecord.setEnabled(true);
            btnNewRecord.setEnabled(true);

            btnSaveRecord.setEnabled(true);

            JOptionPane.showMessageDialog(FormTransportes.this, "Guardado");
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }//GEN-LAST:event_btnSaveRecordActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        btnFirst.setEnabled(true);
        btnNext.setEnabled(true);
        btnPrevious.setEnabled(false);
        btnFirst.setEnabled(false);
        try {
            rs.first();
            int id_col = rs.getInt("idtransportes");
                String matricula = rs.getString("matricula");
                int qtdCarga = rs.getInt("qtdcarga");
                int qtdcaixas = rs.getInt("qtdcaixas");
                String notas = rs.getString("notas");

                
                textIDTransportes.setText(Integer.toString(id_col));
                textMatriculaTransportes.setText(matricula);
                textCargaMaxTransportes.setText(Integer.toString(qtdCarga));
                textCaixasMaxTransportes.setText(Integer.toString(qtdcaixas));     
                jtextNotasTransportes.setText(notas);
                

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(FormTransportes.this, err.getMessage());
        }
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:

        try {
            if (rs.next()) {
                btnLast.setEnabled(true);
                btnNext.setEnabled(true);
                btnPrevious.setEnabled(true);
                btnFirst.setEnabled(true);
                int id_col = rs.getInt("idtransportes");
                String matricula = rs.getString("matricula");
                int qtdcarga = rs.getInt("qtdcarga");
                int qtdcaixas = rs.getInt("qtdcaixas");
                String notas = rs.getString("notas");

               
                textIDTransportes.setText(Integer.toString(id_col));
                textMatriculaTransportes.setText(matricula);
                textCargaMaxTransportes.setText(Integer.toString(qtdcarga));
                textCaixasMaxTransportes.setText(Integer.toString(qtdcaixas));     
                jtextNotasTransportes.setText(notas);
                
            } else {
                rs.previous();
                btnLast.setEnabled(false);
                btnNext.setEnabled(false);
                btnPrevious.setEnabled(true);
                btnFirst.setEnabled(true);
                JOptionPane.showMessageDialog(FormTransportes.this, "Não existem mais Transportes");
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(FormTransportes.this, err.getMessage());
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        btnLast.setEnabled(false);
        btnNext.setEnabled(false);
        btnPrevious.setEnabled(true);
        btnFirst.setEnabled(true);
        try {

            rs.last();
            int id_col = rs.getInt("idtransportes");
                String matricula = rs.getString("matricula");
                int qtdcarga = rs.getInt("qtdcarga");
                int qtdcaixas = rs.getInt("tipo");
                String notas = rs.getString("notas");
                    
                textIDTransportes.setText(Integer.toString(id_col));
                textMatriculaTransportes.setText(matricula);
                textCargaMaxTransportes.setText(Integer.toString(qtdcarga));
                textCaixasMaxTransportes.setText(Integer.toString(qtdcaixas));     
                jtextNotasTransportes.setText(notas);
                
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(FormTransportes.this, err.getMessage());
        }
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnNewRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewRecordActionPerformed
        // TODO add your handling code here:
        try {
            criarnovo = true;
            
            textMatriculaTransportes.setEnabled(true);
            textCargaMaxTransportes.setEnabled(true);
            
            textNotasTransportes.setEnabled(true);
            rs.last();
            int id_col = rs.getInt("idTransportes");
            //curRow = rs.getRow();
            textIDTransportes.setEnabled(false);
            textIDTransportes.setText(Integer.toString(id_col + 1));
            textMatriculaTransportes.setText("");
            textCargaMaxTransportes.setText("");
            textCaixasMaxTransportes.setText("");
            jtextNotasTransportes.setText("");
           
            btnFirst.setEnabled(false);
            btnPrevious.setEnabled(false);
            btnNext.setEnabled(false);
            btnLast.setEnabled(false);

            btnDeleteRecord.setEnabled(false);
            btnNewRecord.setEnabled(false);

            btnSaveRecord.setEnabled(true);

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }//GEN-LAST:event_btnNewRecordActionPerformed

    private void btnUpdateRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateRecordActionPerformed
        // TODO add your handling code here:
        try {
            editar = true;
            textIDTransportes.setEnabled(false);
            textMatriculaTransportes.setEnabled(true);
            textCargaMaxTransportes.setEnabled(true);
            //textTipoTransportes.setEnabled(true);
            textNotasTransportes.setEnabled(true);
            
            int id_col = rs.getInt("idtransportes");
           

        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }//GEN-LAST:event_btnUpdateRecordActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        try {
            if (rs.previous()) {
                 
                 btnLast.setEnabled(true);
               
                btnPrevious.setEnabled(true);
                btnFirst.setEnabled(true);
                int id_col = rs.getInt("idtransportes");
                String matricula = rs.getString("matricula");
                int qtdcarga = rs.getInt("qtdcarga");
                int qtdcaixas = rs.getInt("qtdcaixas");
                String notas = rs.getString("notas");
                
                textIDTransportes.setText(Integer.toString(id_col));
                textMatriculaTransportes.setText(matricula);
                textCargaMaxTransportes.setText(Integer.toString(qtdcarga));
                textCaixasMaxTransportes.setText(Integer.toString(qtdcaixas));     
                jtextNotasTransportes.setText(notas);
            } else {
                
                btnNext.setEnabled(true);
                btnPrevious.setEnabled(false);
                btnFirst.setEnabled(false);
                JOptionPane.showMessageDialog(FormTransportes.this, "Inicio!");
            }

    
        } catch (SQLException err) {

            JOptionPane.showMessageDialog(FormTransportes.this, err.getMessage());
        }
    }//GEN-LAST:event_btnPreviousActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ClassNotFoundException {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }  catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTransportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTransportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTransportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FormTransportes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeleteRecord;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNewRecord;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSaveRecord;
    private javax.swing.JButton btnSaveRecord1;
    private javax.swing.JButton btnUpdateRecord;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jtextNotasTransportes;
    private javax.swing.JTextField textCaixasMaxTransportes;
    private javax.swing.JTextField textCargaMaxTransportes;
    private javax.swing.JTextField textIDTransportes;
    private javax.swing.JTextField textMatriculaTransportes;
    private javax.swing.JScrollPane textNotasTransportes;
    // End of variables declaration//GEN-END:variables

    private void DoConnect() {
        try {
            
            String host = "jdbc:mysql://localhost:3306/" + dbName;
            String uName = "root";
            String uPass ="admin";
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmt = con.createStatement();
            String sql = "SELECT * FROM transportes";
            rs = stmt.executeQuery(sql);
            
            rs.next();
            int id_col = rs.getInt("idtransportes");
            String matricula = rs.getString("matricula");
            int qtdcarga = rs.getInt("qtdcarga");
            int qtdcaixas = rs.getInt("qtdcaixas");
            String notas = rs.getString("notas");
          
            textIDTransportes.setText(Integer.toString(id_col));
            textMatriculaTransportes.setText(matricula);
            textCargaMaxTransportes.setText(Integer.toString(qtdcarga));
            textCaixasMaxTransportes.setText(Integer.toString(qtdcaixas));     
            jtextNotasTransportes.setText(notas);
           
           
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(FormTransportes.this, err.getMessage());
        }
    }
    private void closeApplication() {
        dispose();
    } 
}

