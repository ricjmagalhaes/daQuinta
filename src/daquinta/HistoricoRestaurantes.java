/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daquinta;

import java.sql.*;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author toshiba
 */
public class HistoricoRestaurantes extends javax.swing.JFrame {

    /**
     * Creates new form HistoricoRestaurantes
     */
    static String dbName = "daquinta_teste"; //Nome do Banco criado
       
     Connection con, con2;
    Statement stmt, stmt2;
    ResultSet rs, rsProdutos;
    String produto, restaurante;
    boolean controlTabela = false;
    public HistoricoRestaurantes() {
        initComponents();
        ConConnect();
        //tabela();
        combobox();
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        daquinta_testePUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("daquinta_testePU").createEntityManager();
        restaurantesQuery = java.beans.Beans.isDesignTime() ? null : daquinta_testePUEntityManager.createQuery("SELECT r FROM Restaurantes r");
        restaurantesList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : restaurantesQuery.getResultList();
        jComboBoxRestaurante = new javax.swing.JComboBox();
        jComboBoxProduto = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BETA TESTES");

        jButton1.setText("Organizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable2.setColumnSelectionAllowed(true);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, restaurantesList, jTable2);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${id}"));
        columnBinding.setColumnName("Id");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${morada}"));
        columnBinding.setColumnName("Morada");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nif}"));
        columnBinding.setColumnName("Nif");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${telefone}"));
        columnBinding.setColumnName("Telefone");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${gps}"));
        columnBinding.setColumnName("Gps");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${historico}"));
        columnBinding.setColumnName("Historico");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        jScrollPane2.setViewportView(jTable2);
        jTable2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBoxRestaurante, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxRestaurante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(53, 53, 53))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       
        produto = jComboBoxProduto.getSelectedItem().toString();
        restaurante = jComboBoxRestaurante.getSelectedItem().toString();
        
        //listarNovaProcura();
        listarNovaProcuraTabela();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HistoricoRestaurantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoricoRestaurantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoricoRestaurantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoricoRestaurantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new HistoricoRestaurantes().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager daquinta_testePUEntityManager;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBoxProduto;
    private javax.swing.JComboBox jComboBoxRestaurante;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private java.util.List<daquinta.Restaurantes> restaurantesList;
    private javax.persistence.Query restaurantesQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void ConConnect() {
   
        try {
    
            String host = "jdbc:mysql://localhost:3306/daquinta_teste";
            String uName = "root";
            String uPass ="admin";
            con = DriverManager.getConnection(host, uName, uPass);
             stmt = con.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
     private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;

    private void combobox() {
         try {
            String sql2 = "SELECT * FROM produtos";
                
            rsProdutos = stmt.executeQuery(sql2);
            rsProdutos.next();
            rsProdutos.beforeFirst();
            while (rsProdutos.next()){  
                jComboBoxProduto.addItem(rsProdutos.getString("Nome"));
            }  
            String sql3 = "SELECT * FROM restaurantes";

            rsProdutos = stmt.executeQuery(sql3);
            rsProdutos.next();
            rsProdutos.beforeFirst();
            while (rsProdutos.next()){  
                jComboBoxRestaurante.addItem(rsProdutos.getString("Nome"));
            }  
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    private void tabela() {
        Vector columnNames = new Vector();
        Vector data = new Vector();
        JPanel p = new JPanel();
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        if (controlTabela==true) {
            layout.removeLayoutComponent(rootPane);
            /*layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 25, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, javax.swing.GroupLayout.DEFAULT_SIZE))
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, javax.swing.GroupLayout.DEFAULT_SIZE)
                    .addGap(0, 25, Short.MAX_VALUE))
            );*/
        }
        
        try {
    
            
            String sql = "SELECT * FROM compras";
            stmt = con.createStatement();
            rs = stmt.executeQuery( sql );
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            for (int i = 1; i <= columns; i++) {
                if (md.getColumnName(i).equals("restaurante_id"))
                    columnNames.addElement( md.getColumnName(i) );
                else if (md.getColumnName(i).equals("produto_id"))
                    columnNames.addElement( md.getColumnName(i) );
                else if (md.getColumnName(i).equals("quantidade"))
                    columnNames.addElement( md.getColumnName(i) );
                
               
            }
            
            while (rs.next()) {
                Vector row = new Vector(columns);
                for (int i = 1; i <= columns; i++){
                   if (md.getColumnName(i).equals("restaurante_id"))
                        row.addElement( rs.getObject(i) );
                   else if (md.getColumnName(i).equals("produto_id"))
                        row.addElement( rs.getObject(i) );
                    else if (md.getColumnName(i).equals("quantidade"))    
                        row.addElement( rs.getObject(i) );
                }
            data.addElement( row );
            }
            
            
            rs.close();
            //stmt.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        JTable table = new JTable(data, columnNames);
        TableColumn col;
        for (int i = 0; i < table.getColumnCount(); i++) {
            col = table.getColumnModel().getColumn(i);
            col.setMaxWidth(250);
        }
        JScrollPane scrollPane = new JScrollPane( table );
        p.add( scrollPane );
        
        //HistoricoRestaurantes f=new HistoricoRestaurantes();
        
        /*JFrame f = new JFrame();
        
        f.add(p);
        f.setSize(600,400);
        f.setVisible(true);*/
        jScrollPane1 = new javax.swing.JScrollPane();
        
        jScrollPane1.setViewportView(table);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, javax.swing.GroupLayout.DEFAULT_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, javax.swing.GroupLayout.DEFAULT_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );
        controlTabela = true;
    }

    private void listarNovaProcura() {
        Vector columnNames = new Vector();
        Vector data = new Vector();
        JPanel p = new JPanel();
       
        
        try {
    
            String host = "jdbc:mysql://localhost:3306/daquinta_teste";
            String uName = "root";
            String uPass ="admin";
            con = DriverManager.getConnection(host, uName, uPass);
            String sql = "select restaurantes.Nome,produto_id,quantidade from "
                    + "compras inner join restaurantes on restaurante_id = "
                    + "restaurantes.ID  where restaurantes.Nome='"+ restaurante + "'";
            
            stmt = con.createStatement();
            rs = stmt.executeQuery( sql );
            
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            for (int i = 1; i <= columns; i++) {
                if (md.getColumnName(i).equals("restaurante_id"))
                    columnNames.addElement( md.getColumnName(i) );
                else if (md.getColumnName(i).equals("produto_id"))
                    columnNames.addElement( md.getColumnName(i) );
                else if (md.getColumnName(i).equals("quantidade"))
                    columnNames.addElement( md.getColumnName(i) );
                
               
            }
            
            while (rs.next() ) {
                Vector row = new Vector(columns);
                for (int i = 1; i <= columns; i++){
                   if (md.getColumnName(i).equals("restaurante_id"))
                        row.addElement( rs.getObject(i) );
                   else if (md.getColumnName(i).equals("produto_id"))
                        row.addElement( rs.getObject(i) );
                    else if (md.getColumnName(i).equals("quantidade"))    
                        row.addElement( rs.getObject(i) );
                }
            data.addElement( row );
            }
            
            
            rs.close();
            //stmt.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        JTable table = new JTable(data, columnNames);
        TableColumn col;
        for (int i = 0; i < table.getColumnCount(); i++) {
            col = table.getColumnModel().getColumn(i);
            col.setMaxWidth(250);
        }
        JScrollPane scrollPane = new JScrollPane( table );
        p.add( scrollPane );
        
        //HistoricoRestaurantes f=new HistoricoRestaurantes();
        
        /*JFrame f = new JFrame();
        
        f.add(p);
        f.setSize(600,400);
        f.setVisible(true);*/
        jScrollPane1 = new javax.swing.JScrollPane();
        
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 25, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, javax.swing.GroupLayout.DEFAULT_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, javax.swing.GroupLayout.DEFAULT_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );
    }

    private void listarNovaProcuraTabela() {
        Vector data = new Vector();
         try {
    
            String host = "jdbc:mysql://localhost:3306/" + dbName;
            String uName = "root";
            String uPass ="admin";
            con = DriverManager.getConnection(host, uName, uPass);
            String sql = "select restaurantes.Nome,produto_id,quantidade from "
                    + "compras inner join restaurantes on restaurante_id = "
                    + "restaurantes.ID  where restaurantes.Nome='"+ restaurante + "'";
            
            stmt = con.createStatement();
            rs = stmt.executeQuery( sql );
            Integer numcols = jTable2.getRowCount();
            
            jTextField1.setText(numcols.toString());
            /*ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            
            while (rs.next() ) {
                
                for (int i = 1; i <= columns; i++){
                   
                }
            data.addElement( row );
            }
            
            JTable table = new JTable(data, null);
            
            JScrollPane scrollPane = new JScrollPane( table );
            jTable2.add(scrollPane);
           
            
            
        
          rs.close();*/
            //stmt.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
