/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package daquinta;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author toshiba
 */
public class FormEtapaI extends javax.swing.JFrame {

    /**
     * Creates new form FormEtapaI
     */
    static String dbName = "daquinta_teste"; //Nome do Banco criado
    
    
    Connection con, con2;
    Statement stmt, stmt2;
    
    int curRow = 0;
    int IDs = 1;
    int totalProdutos, totalRestaurantes, totalProdutores;
    String [] totalNomesProdutos, totalNomesProdutosA,totalNomesProdutosB,totalNomesProdutosC,totalNomesProdutosD,totalNomesProdutosE,totalNomesProdutosF,totalNomesProdutosG,totalNomesProdutosH, totalNomesProdutosSeg,totalNomesProdutosTer,totalNomesProdutosQua,totalNomesProdutosQui,totalNomesProdutosSex;
    Integer []totalQuantidadeProdutos,totalQuantidadeProdutosA, totalQuantidadeProdutosB, totalQuantidadeProdutosC, totalQuantidadeProdutosD, totalQuantidadeProdutosE, totalQuantidadeProdutosF, totalQuantidadeProdutosG, totalQuantidadeProdutosH, totalQuantidadeProdutosSeg, totalQuantidadeProdutosTer, totalQuantidadeProdutosQua, totalQuantidadeProdutosQui, totalQuantidadeProdutosSex;
    String [] RAItemListSeg, RAItemListTer, RAItemListQua, RAItemListQui, RAItemListSex;
    String [] RBItemListSeg,RBItemListTer,RBItemListQua,RBItemListQui,RBItemListSex;
    String [] RCItemListSeg,RCItemListTer,RCItemListQua,RCItemListQui,RCItemListSex;
    String [] RDItemListSeg,RDItemListTer,RDItemListQua,RDItemListQui,RDItemListSex;
    String [] REItemListSeg,REItemListTer,REItemListQua,REItemListQui,REItemListSex;
    String [] RFItemListSeg,RFItemListTer,RFItemListQua,RFItemListQui,RFItemListSex;
    String [] RGItemListSeg,RGItemListTer,RGItemListQua,RGItemListQui,RGItemListSex;
    String [] RHItemListSeg,RHItemListTer,RHItemListQua,RHItemListQui,RHItemListSex;
    Integer[] RAItemList2Seg,RAItemList2Ter, RAItemList2Qua, RAItemList2Qui, RAItemList2Sex;
    Integer[] RBItemList2Seg,RBItemList2Ter, RBItemList2Qua, RBItemList2Qui, RBItemList2Sex;
    Integer[] RCItemList2Seg,RCItemList2Ter, RCItemList2Qua, RCItemList2Qui, RCItemList2Sex;
    Integer[] RDItemList2Seg,RDItemList2Ter, RDItemList2Qua, RDItemList2Qui, RDItemList2Sex;
    Integer[] REItemList2Seg,REItemList2Ter, REItemList2Qua, REItemList2Qui, REItemList2Sex;
    Integer[] RFItemList2Seg,RFItemList2Ter, RFItemList2Qua, RFItemList2Qui, RFItemList2Sex;
    Integer[] RGItemList2Seg,RGItemList2Ter, RGItemList2Qua, RGItemList2Qui, RGItemList2Sex;
    Integer[] RHItemList2Seg,RHItemList2Ter, RHItemList2Qua, RHItemList2Qui, RHItemList2Sex;
   
    //Variaveis para etapa I
    int [] produtosArmazemStock;
    int [][] stockProdutosTotal;
    int [] stockProdutosArmazenaveis;
    int [][] ofertaProdutoDia;
    int [][][] subConjuntoClientesEncomendas;
    int [][] numeroDiasClienteProduto, quantidadeClienteProduto, ofertasDisponivelDiaSemanaFrescos, ofertasDisponivelDiaSemanaArmazenaveis;
    int [][][] quantidadeProdutoDisponibilizar;
    int [][] historicoEncomendas;
    int [][] historicoEncomendasEntregues;
    int [][] fraccaoEncomendas;
    
    //Variaveis gerais do Projecto
    int [][] quantidadeProdutoDiponibilizarDepoisT; //y_ik
    
    DB conDB = new DB();
    boolean editar = false, criarnovo=false;
    //data 
    java.util.Date date = new java.util.Date();
    java.util.Date date2 = new java.util.Date();
       
    Integer ano=date.getYear()+1900;
  
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
   
    Calendar cal = Calendar.getInstance();
    Calendar calUk = Calendar.getInstance(Locale.UK);  
   
    JComboBox cbIdDisciplina, cbDisciplina; 
    
    int restaurante;
    Integer getWeekofYear = calUk.get( Calendar.WEEK_OF_YEAR );
    Integer getMonthogYear = calUk.get( Calendar.MONTH);
        
    public FormEtapaI() {
        initComponents();
        try {
            String host = "jdbc:mysql://localhost:3306/"+dbName;
            String uName = "root";
            String uPass ="admin";
            con = DriverManager.getConnection(host, uName, uPass);
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(FormEtapaI.this, err.getMessage());
        }
            
        if (getWeekofYear==1) jComboBoxWeek.setSelectedIndex(1);
        else jComboBoxWeek.setSelectedIndex(getWeekofYear-1);
        jComboBoxAno.setSelectedIndex(ano-2011);
        jLabelSemana.setText(getWeekofYear.toString());
        jLabelData.setText(dateFormat.format(date).toString());
        
        
        //etapai();
        etapi_b(); //MEtodo da Etapa 1
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

        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        jListQui3 = new javax.swing.JList();
        jScrollPane33 = new javax.swing.JScrollPane();
        jListQua6 = new javax.swing.JList();
        jScrollPane15 = new javax.swing.JScrollPane();
        jListQua2 = new javax.swing.JList();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane53 = new javax.swing.JScrollPane();
        jListSexTotal = new javax.swing.JList();
        btnCancel = new javax.swing.JButton();
        jScrollPane42 = new javax.swing.JScrollPane();
        jListTotal7 = new javax.swing.JList();
        jScrollPane51 = new javax.swing.JScrollPane();
        jListQuaTotal = new javax.swing.JList();
        jLabel49 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jListQui2 = new javax.swing.JList();
        jScrollPane32 = new javax.swing.JScrollPane();
        jListTer6 = new javax.swing.JList();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane43 = new javax.swing.JScrollPane();
        jListSeg8 = new javax.swing.JList();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane44 = new javax.swing.JScrollPane();
        jListTer8 = new javax.swing.JList();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane49 = new javax.swing.JScrollPane();
        jListSegTotal = new javax.swing.JList();
        jComboBoxWeek = new javax.swing.JComboBox();
        jScrollPane35 = new javax.swing.JScrollPane();
        jListSex6 = new javax.swing.JList();
        jScrollPane36 = new javax.swing.JScrollPane();
        jListTotal6 = new javax.swing.JList();
        jScrollPane29 = new javax.swing.JScrollPane();
        jListQui5 = new javax.swing.JList();
        jLabelSemana = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jListTotal1 = new javax.swing.JList();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane46 = new javax.swing.JScrollPane();
        jListQui8 = new javax.swing.JList();
        jScrollPane13 = new javax.swing.JScrollPane();
        jListSex2 = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane37 = new javax.swing.JScrollPane();
        jListSeg7 = new javax.swing.JList();
        jScrollPane50 = new javax.swing.JScrollPane();
        jListTerTotal = new javax.swing.JList();
        jScrollPane8 = new javax.swing.JScrollPane();
        jListQua1 = new javax.swing.JList();
        jScrollPane38 = new javax.swing.JScrollPane();
        jListTer7 = new javax.swing.JList();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListSeg5 = new javax.swing.JList();
        jScrollPane40 = new javax.swing.JScrollPane();
        jListQui7 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListSeg2 = new javax.swing.JList();
        jScrollPane12 = new javax.swing.JScrollPane();
        jListTotal2 = new javax.swing.JList();
        jScrollPane7 = new javax.swing.JScrollPane();
        jListTer1 = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListSeg3 = new javax.swing.JList();
        jScrollPane10 = new javax.swing.JScrollPane();
        jListSex1 = new javax.swing.JList();
        jScrollPane45 = new javax.swing.JScrollPane();
        jListQua8 = new javax.swing.JList();
        jScrollPane21 = new javax.swing.JScrollPane();
        jListTotal3 = new javax.swing.JList();
        jScrollPane16 = new javax.swing.JScrollPane();
        jListTer2 = new javax.swing.JList();
        jLabel17 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jScrollPane54 = new javax.swing.JScrollPane();
        jListTotal9 = new javax.swing.JList();
        jScrollPane20 = new javax.swing.JScrollPane();
        jListSex3 = new javax.swing.JList();
        jLabel48 = new javax.swing.JLabel();
        jScrollPane26 = new javax.swing.JScrollPane();
        jListTotal4 = new javax.swing.JList();
        jScrollPane39 = new javax.swing.JScrollPane();
        jListQua7 = new javax.swing.JList();
        jScrollPane28 = new javax.swing.JScrollPane();
        jListQua5 = new javax.swing.JList();
        jScrollPane18 = new javax.swing.JScrollPane();
        jListQua3 = new javax.swing.JList();
        jLabel43 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jListTer3 = new javax.swing.JList();
        jScrollPane41 = new javax.swing.JScrollPane();
        jListSex7 = new javax.swing.JList();
        jScrollPane22 = new javax.swing.JScrollPane();
        jListTer4 = new javax.swing.JList();
        jScrollPane23 = new javax.swing.JScrollPane();
        jListQua4 = new javax.swing.JList();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane30 = new javax.swing.JScrollPane();
        jListSex5 = new javax.swing.JList();
        jScrollPane31 = new javax.swing.JScrollPane();
        jListTotal5 = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListSeg1 = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jBtnPesquisa = new javax.swing.JButton();
        jScrollPane52 = new javax.swing.JScrollPane();
        jListQuiTotal = new javax.swing.JList();
        jScrollPane6 = new javax.swing.JScrollPane();
        jListSeg6 = new javax.swing.JList();
        jScrollPane9 = new javax.swing.JScrollPane();
        jListQui1 = new javax.swing.JList();
        jScrollPane24 = new javax.swing.JScrollPane();
        jListQui4 = new javax.swing.JList();
        jLabelData = new javax.swing.JLabel();
        jScrollPane27 = new javax.swing.JScrollPane();
        jListTer5 = new javax.swing.JList();
        jScrollPane48 = new javax.swing.JScrollPane();
        jListTotal8 = new javax.swing.JList();
        jScrollPane25 = new javax.swing.JScrollPane();
        jListSex4 = new javax.swing.JList();
        jScrollPane34 = new javax.swing.JScrollPane();
        jListQui6 = new javax.swing.JList();
        jScrollPane47 = new javax.swing.JScrollPane();
        jListSex8 = new javax.swing.JList();
        jComboBoxAno = new javax.swing.JComboBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        jListSeg4 = new javax.swing.JList();
        btnEtapaII = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Etapa I");
        setResizable(false);

        jLabel45.setText("Restaurante “D. Isilda”");

        jLabel46.setText("Restaurante “Malagueta”");

        jScrollPane19.setViewportView(jListQui3);

        jScrollPane33.setViewportView(jListQua6);

        jScrollPane15.setViewportView(jListQua2);

        jLabel42.setText("Restaurante “O Parque”");

        jListSexTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane53.setViewportView(jListSexTotal);

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/118.png"))); // NOI18N
        btnCancel.setText("Cancelar");
        btnCancel.setMaximumSize(new java.awt.Dimension(111, 41));
        btnCancel.setMinimumSize(new java.awt.Dimension(111, 41));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jListTotal7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane42.setViewportView(jListTotal7);

        jListQuaTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane51.setViewportView(jListQuaTotal);

        jLabel49.setText("Totais");

        jScrollPane14.setViewportView(jListQui2);

        jScrollPane32.setViewportView(jListTer6);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/97.png"))); // NOI18N
        jLabel20.setText("Etapa I");
        jLabel20.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jScrollPane43.setViewportView(jListSeg8);

        jLabel7.setText("Sexta");

        jScrollPane44.setViewportView(jListTer8);

        jLabel6.setText("Quinta");

        jLabel5.setText("Quarta");

        jLabel4.setText("Terça");

        jLabel3.setText("Segunda");

        jListSegTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane49.setViewportView(jListSegTotal);

        jComboBoxWeek.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55" }));

        jScrollPane35.setViewportView(jListSex6);

        jListTotal6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane36.setViewportView(jListTotal6);

        jScrollPane29.setViewportView(jListQui5);

        jLabelSemana.setText("jLabel17");

        jListTotal1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane11.setViewportView(jListTotal1);

        jLabel18.setText("Semana:");

        jScrollPane46.setViewportView(jListQui8);

        jScrollPane13.setViewportView(jListSex2);

        jLabel1.setText("Centro Social de Palmela");

        jScrollPane37.setViewportView(jListSeg7);

        jListTerTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane50.setViewportView(jListTerTotal);

        jScrollPane8.setViewportView(jListQua1);

        jScrollPane38.setViewportView(jListTer7);

        jScrollPane5.setViewportView(jListSeg5);

        jScrollPane40.setViewportView(jListQui7);

        jScrollPane2.setViewportView(jListSeg2);

        jListTotal2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane12.setViewportView(jListTotal2);

        jScrollPane7.setViewportView(jListTer1);

        jScrollPane3.setViewportView(jListSeg3);

        jScrollPane10.setViewportView(jListSex1);

        jScrollPane45.setViewportView(jListQua8);

        jListTotal3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane21.setViewportView(jListTotal3);

        jScrollPane16.setViewportView(jListTer2);

        jLabel17.setText("DATA:");

        jLabel47.setText("Vale dos Pintassilgos");

        jListTotal9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane54.setViewportView(jListTotal9);

        jScrollPane20.setViewportView(jListSex3);

        jLabel48.setText("Santa Casa da Misericórdia");

        jListTotal4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane26.setViewportView(jListTotal4);

        jScrollPane39.setViewportView(jListQua7);

        jScrollPane28.setViewportView(jListQua5);

        jScrollPane18.setViewportView(jListQua3);

        jLabel43.setText("Restaurante “Champanheria”");

        jScrollPane17.setViewportView(jListTer3);

        jScrollPane41.setViewportView(jListSex7);

        jScrollPane22.setViewportView(jListTer4);

        jScrollPane23.setViewportView(jListQua4);

        jLabel8.setText("Total");

        jScrollPane30.setViewportView(jListSex5);

        jListTotal5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane31.setViewportView(jListTotal5);

        jScrollPane1.setViewportView(jListSeg1);

        jLabel2.setText("Semana");

        jLabel44.setText("Restaurante “Três15Dias”");

        jBtnPesquisa.setText("Pesquisa");
        jBtnPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisaActionPerformed(evt);
            }
        });

        jListQuiTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane52.setViewportView(jListQuiTotal);

        jScrollPane6.setViewportView(jListSeg6);

        jScrollPane9.setViewportView(jListQui1);

        jScrollPane24.setViewportView(jListQui4);

        jLabelData.setText("88-88.8888");

        jScrollPane27.setViewportView(jListTer5);

        jListTotal8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane48.setViewportView(jListTotal8);

        jScrollPane25.setViewportView(jListSex4);

        jScrollPane34.setViewportView(jListQui6);

        jScrollPane47.setViewportView(jListSex8);

        jComboBoxAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2011", "2012", "2013", "2014", "2015" }));

        jScrollPane4.setViewportView(jListSeg4);

        btnEtapaII.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/77.png"))); // NOI18N
        btnEtapaII.setText("Aceitar");
        btnEtapaII.setMaximumSize(new java.awt.Dimension(111, 41));
        btnEtapaII.setMinimumSize(new java.awt.Dimension(111, 41));
        btnEtapaII.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEtapaIIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelData, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(208, 208, 208)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel3)
                                        .addGap(133, 133, 133)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelSemana, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxAno, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxWeek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnPesquisa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel5)
                                .addGap(153, 153, 153)
                                .addComponent(jLabel6)
                                .addGap(152, 152, 152)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addGap(38, 38, 38)))
                        .addComponent(jLabel20))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel42)
                                    .addComponent(jLabel1))
                                .addGap(43, 43, 43)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel43)
                                                        .addComponent(jLabel44))
                                                    .addComponent(jLabel45, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(btnEtapaII, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel49)))
                                                .addComponent(jLabel46, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addComponent(jLabel47, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addComponent(jLabel48, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(btnCancel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane30, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane31, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane32, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane33, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane34, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane35, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane36, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane37, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane38, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane39, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane40, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane41, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane42, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane43, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane44, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane45, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane46, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane47, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane48, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane49, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane50, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane51, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane52, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane53, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane54, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(21, 21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelData)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabelSemana)
                            .addComponent(jComboBoxAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxWeek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnPesquisa)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(9, 9, 9)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel42))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane25, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane26, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane27, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane28, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane29, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane30, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane31, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane32, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane33, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane34, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane35, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane36, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jScrollPane37, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane38, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane39, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane40, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane41, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane42, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jScrollPane43, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane44, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane45, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane46, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane47, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane48, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel48))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel49)
                            .addComponent(btnEtapaII, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane54, javax.swing.GroupLayout.Alignment.CENTER, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane53, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane52, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane51, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane50, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane49, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:

        closeApplication();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void jBtnPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisaActionPerformed
        // TODO add your handling code here:
        ano = Integer.parseInt((String) jComboBoxAno.getSelectedItem());
        getWeekofYear = Integer.parseInt((String) jComboBoxWeek.getSelectedItem());
        // DoConnect();
    }//GEN-LAST:event_jBtnPesquisaActionPerformed

    private void btnEtapaIIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEtapaIIActionPerformed
       FormEtapaII forn = new FormEtapaII();
       forn.setVisible(true);
    }//GEN-LAST:event_btnEtapaIIActionPerformed

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
            java.util.logging.Logger.getLogger(FormEtapaI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormEtapaI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormEtapaI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormEtapaI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FormEtapaI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEtapaII;
    private javax.swing.JButton jBtnPesquisa;
    private javax.swing.JComboBox jComboBoxAno;
    private javax.swing.JComboBox jComboBoxWeek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelData;
    private javax.swing.JLabel jLabelSemana;
    private javax.swing.JList jListQua1;
    private javax.swing.JList jListQua2;
    private javax.swing.JList jListQua3;
    private javax.swing.JList jListQua4;
    private javax.swing.JList jListQua5;
    private javax.swing.JList jListQua6;
    private javax.swing.JList jListQua7;
    private javax.swing.JList jListQua8;
    private javax.swing.JList jListQuaTotal;
    private javax.swing.JList jListQui1;
    private javax.swing.JList jListQui2;
    private javax.swing.JList jListQui3;
    private javax.swing.JList jListQui4;
    private javax.swing.JList jListQui5;
    private javax.swing.JList jListQui6;
    private javax.swing.JList jListQui7;
    private javax.swing.JList jListQui8;
    private javax.swing.JList jListQuiTotal;
    private javax.swing.JList jListSeg1;
    private javax.swing.JList jListSeg2;
    private javax.swing.JList jListSeg3;
    private javax.swing.JList jListSeg4;
    private javax.swing.JList jListSeg5;
    private javax.swing.JList jListSeg6;
    private javax.swing.JList jListSeg7;
    private javax.swing.JList jListSeg8;
    private javax.swing.JList jListSegTotal;
    private javax.swing.JList jListSex1;
    private javax.swing.JList jListSex2;
    private javax.swing.JList jListSex3;
    private javax.swing.JList jListSex4;
    private javax.swing.JList jListSex5;
    private javax.swing.JList jListSex6;
    private javax.swing.JList jListSex7;
    private javax.swing.JList jListSex8;
    private javax.swing.JList jListSexTotal;
    private javax.swing.JList jListTer1;
    private javax.swing.JList jListTer2;
    private javax.swing.JList jListTer3;
    private javax.swing.JList jListTer4;
    private javax.swing.JList jListTer5;
    private javax.swing.JList jListTer6;
    private javax.swing.JList jListTer7;
    private javax.swing.JList jListTer8;
    private javax.swing.JList jListTerTotal;
    private javax.swing.JList jListTotal1;
    private javax.swing.JList jListTotal2;
    private javax.swing.JList jListTotal3;
    private javax.swing.JList jListTotal4;
    private javax.swing.JList jListTotal5;
    private javax.swing.JList jListTotal6;
    private javax.swing.JList jListTotal7;
    private javax.swing.JList jListTotal8;
    private javax.swing.JList jListTotal9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JScrollPane jScrollPane33;
    private javax.swing.JScrollPane jScrollPane34;
    private javax.swing.JScrollPane jScrollPane35;
    private javax.swing.JScrollPane jScrollPane36;
    private javax.swing.JScrollPane jScrollPane37;
    private javax.swing.JScrollPane jScrollPane38;
    private javax.swing.JScrollPane jScrollPane39;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane40;
    private javax.swing.JScrollPane jScrollPane41;
    private javax.swing.JScrollPane jScrollPane42;
    private javax.swing.JScrollPane jScrollPane43;
    private javax.swing.JScrollPane jScrollPane44;
    private javax.swing.JScrollPane jScrollPane45;
    private javax.swing.JScrollPane jScrollPane46;
    private javax.swing.JScrollPane jScrollPane47;
    private javax.swing.JScrollPane jScrollPane48;
    private javax.swing.JScrollPane jScrollPane49;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane50;
    private javax.swing.JScrollPane jScrollPane51;
    private javax.swing.JScrollPane jScrollPane52;
    private javax.swing.JScrollPane jScrollPane53;
    private javax.swing.JScrollPane jScrollPane54;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    // End of variables declaration//GEN-END:variables

    private void DoConnect() {
        try {
            System.out.println("IN");
            
            stmt = con.createStatement();
            
            //Totais
            String sql1 = "select * from produtos ";
            
            ResultSet rsProdutosTotais;
            
            rsProdutosTotais = stmt.executeQuery(sql1);
           
            
            rsProdutosTotais.last();
           
            
                            
            totalProdutos=rsProdutosTotais.getRow(); 
           
            totalNomesProdutosSeg = new String[rsProdutosTotais.getInt(1)];
            totalQuantidadeProdutosSeg = new Integer[rsProdutosTotais.getInt(1)];
            totalNomesProdutosTer = new String[rsProdutosTotais.getInt(1)];
            totalQuantidadeProdutosTer = new Integer[rsProdutosTotais.getInt(1)];
            totalNomesProdutosQua = new String[rsProdutosTotais.getInt(1)];
            totalQuantidadeProdutosQua = new Integer[rsProdutosTotais.getInt(1)];
            totalNomesProdutosQui = new String[rsProdutosTotais.getInt(1)];
            totalQuantidadeProdutosQui = new Integer[rsProdutosTotais.getInt(1)];
            totalNomesProdutosSex = new String[rsProdutosTotais.getInt(1)];
            totalQuantidadeProdutosSex = new Integer[rsProdutosTotais.getInt(1)];
            
            //total para cada restaurante
            totalNomesProdutosA = new String[rsProdutosTotais.getInt(1)];
            totalQuantidadeProdutosA = new Integer[rsProdutosTotais.getInt(1)];
            totalNomesProdutosB = new String[rsProdutosTotais.getInt(1)];
            totalQuantidadeProdutosB = new Integer[rsProdutosTotais.getInt(1)];
            totalNomesProdutosC = new String[rsProdutosTotais.getInt(1)];
            totalQuantidadeProdutosC = new Integer[rsProdutosTotais.getInt(1)];
            totalNomesProdutosD = new String[rsProdutosTotais.getInt(1)];
            totalQuantidadeProdutosD = new Integer[rsProdutosTotais.getInt(1)];
            totalNomesProdutosE = new String[rsProdutosTotais.getInt(1)];
            totalQuantidadeProdutosE = new Integer[rsProdutosTotais.getInt(1)];
            totalNomesProdutosF = new String[rsProdutosTotais.getInt(1)];
            totalQuantidadeProdutosF = new Integer[rsProdutosTotais.getInt(1)];
            totalNomesProdutosG = new String[rsProdutosTotais.getInt(1)];
            totalQuantidadeProdutosG = new Integer[rsProdutosTotais.getInt(1)];
            totalNomesProdutosH = new String[rsProdutosTotais.getInt(1)];
            totalQuantidadeProdutosH = new Integer[rsProdutosTotais.getInt(1)];
            
            totalNomesProdutos  = new String[rsProdutosTotais.getInt(1)];
            totalQuantidadeProdutos = new Integer[rsProdutosTotais.getInt(1)];
            
                   
            sql1 = "select * from produtos ";
                      
            rsProdutosTotais = stmt.executeQuery(sql1);
            rsProdutosTotais.beforeFirst();
           
            int j=0;
            
            while (rsProdutosTotais.next()) {
              totalNomesProdutos[j] = rsProdutosTotais.getString("nome");
                totalQuantidadeProdutos[j] = 0;
                totalNomesProdutosSeg[j] = rsProdutosTotais.getString("nome");
                totalQuantidadeProdutosSeg[j] = 0;
                totalNomesProdutosTer[j] = rsProdutosTotais.getString("nome");
                totalQuantidadeProdutosTer[j] = 0;
                totalNomesProdutosQua[j] = rsProdutosTotais.getString("nome");
                totalQuantidadeProdutosQua[j] = 0;
                totalNomesProdutosQui[j] = rsProdutosTotais.getString("nome");
                totalQuantidadeProdutosQui[j] = 0;
                totalNomesProdutosSex[j] = rsProdutosTotais.getString("nome");
                totalQuantidadeProdutosSex[j] = 0;
                //Totais para produtos
                totalNomesProdutosA[j] = rsProdutosTotais.getString("nome");
                totalQuantidadeProdutosA[j] = 0;
                totalNomesProdutosB[j] = rsProdutosTotais.getString("nome");
                totalQuantidadeProdutosB[j] = 0;
                totalNomesProdutosC[j] = rsProdutosTotais.getString("nome");
                totalQuantidadeProdutosC[j] = 0;
                totalNomesProdutosD[j] = rsProdutosTotais.getString("nome");
                totalQuantidadeProdutosD[j] = 0;
                totalNomesProdutosE[j] = rsProdutosTotais.getString("nome");
                totalQuantidadeProdutosE[j] = 0;
                totalNomesProdutosF[j] = rsProdutosTotais.getString("nome");
                totalQuantidadeProdutosF[j] = 0;
                totalNomesProdutosG[j] = rsProdutosTotais.getString("nome");
                totalQuantidadeProdutosG[j] = 0;
                totalNomesProdutosH[j] = rsProdutosTotais.getString("nome");
                totalQuantidadeProdutosH[j] = 0;  
                j++;
            }
            
            
            DefaultListModel modelRestauranteASeg = new DefaultListModel(); //create a new list model
            DefaultListModel modelRestauranteATer = new DefaultListModel();
            DefaultListModel modelRestauranteAQua = new DefaultListModel();
            DefaultListModel modelRestauranteAQui = new DefaultListModel();
            DefaultListModel modelRestauranteASex = new DefaultListModel();
            DefaultListModel modelRestauranteBSeg = new DefaultListModel(); //create a new list model
            DefaultListModel modelRestauranteBTer = new DefaultListModel();
            DefaultListModel modelRestauranteBQua = new DefaultListModel();
            DefaultListModel modelRestauranteBQui = new DefaultListModel();
            DefaultListModel modelRestauranteBSex = new DefaultListModel();
            DefaultListModel modelRestauranteCSeg = new DefaultListModel(); //create a new list model
            DefaultListModel modelRestauranteCTer = new DefaultListModel();
            DefaultListModel modelRestauranteCQua = new DefaultListModel();
            DefaultListModel modelRestauranteCQui = new DefaultListModel();
            DefaultListModel modelRestauranteCSex = new DefaultListModel();
            DefaultListModel modelRestauranteDSeg = new DefaultListModel(); //create a new list model
            DefaultListModel modelRestauranteDTer = new DefaultListModel();
            DefaultListModel modelRestauranteDQua = new DefaultListModel();
            DefaultListModel modelRestauranteDQui = new DefaultListModel();
            DefaultListModel modelRestauranteDSex = new DefaultListModel();
            DefaultListModel modelRestauranteESeg = new DefaultListModel(); //create a new list model
            DefaultListModel modelRestauranteETer = new DefaultListModel();
            DefaultListModel modelRestauranteEQua = new DefaultListModel();
            DefaultListModel modelRestauranteEQui = new DefaultListModel();
            DefaultListModel modelRestauranteESex = new DefaultListModel();
            DefaultListModel modelRestauranteFSeg = new DefaultListModel(); //create a new list model
            DefaultListModel modelRestauranteFTer = new DefaultListModel();
            DefaultListModel modelRestauranteFQua = new DefaultListModel();
            DefaultListModel modelRestauranteFQui = new DefaultListModel();
            DefaultListModel modelRestauranteFSex = new DefaultListModel();
            DefaultListModel modelRestauranteGSeg = new DefaultListModel(); //create a new list model
            DefaultListModel modelRestauranteGTer = new DefaultListModel();
            DefaultListModel modelRestauranteGQua = new DefaultListModel();
            DefaultListModel modelRestauranteGQui = new DefaultListModel();
            DefaultListModel modelRestauranteGSex = new DefaultListModel();
            DefaultListModel modelRestauranteHSeg = new DefaultListModel(); //create a new list model
            DefaultListModel modelRestauranteHTer = new DefaultListModel();
            DefaultListModel modelRestauranteHQua = new DefaultListModel();
            DefaultListModel modelRestauranteHQui = new DefaultListModel();
            DefaultListModel modelRestauranteHSex = new DefaultListModel();
                        
             int linha=0;
            
            
            
            //Restaurante 1 Segunda
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdseg, "+dbName+".produtos.idprodutos "
                    + "FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=1 AND YEAR("+dbName+".encomenda.data) ="
                    + "'" + ano +"' AND getWeekofYear="+ getWeekofYear;
                       
            ResultSet rsProdutos;
           
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
            
            RAItemListSeg= new String[rsProdutos.getRow()];
            RAItemList2Seg= new Integer[rsProdutos.getRow()];
                    
            boolean control;
            int i=0;
            rsProdutos.beforeFirst();
            while (rsProdutos.next()){ 
               control=false;
               
                totalQuantidadeProdutosA[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosA[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][0];
                totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][0];   
               for(j=0;j<RAItemListSeg.length;j++)  {
                           
                   if (rsProdutos.getString("produtos.nome").equals(RAItemListSeg[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt("produtos.idprodutos")-1][0][0]!=0) {
                            RAItemList2Seg[j] = RAItemList2Seg[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][0];
                            //totalQuantidadeProdutosA[j] = totalQuantidadeProdutosA[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][0];
                            control=true;
                            break;
                    }
               }
                if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][0]!=0) {
                    RAItemListSeg[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                    RAItemList2Seg[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt("produtos.idprodutos")-1][0][0]; //get the element in column "item_code"
                    linha++;
               }  
               
            }
           for(j=0;j<linha;j++)  
               modelRestauranteASeg.addElement(RAItemListSeg[j] + " - " + RAItemList2Seg[j].toString()); 
            
            jListSeg1.setModel(modelRestauranteASeg);
          
            rsProdutos.close();
           //Restaurante 1 Terça
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdter, " + dbName + ".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=1 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
            RAItemListTer= new String[rsProdutos.getRow()];
            RAItemList2Ter= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
               totalQuantidadeProdutosA[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosA[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][1];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][1];   
               for(j=0;j<RAItemListTer.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(RAItemListTer[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][1]!=0) {
                            RAItemList2Ter[j] = RAItemList2Ter[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][1];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][1]!=0) {
                    RAItemListTer[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                    RAItemList2Ter[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][1]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteATer.addElement(RAItemListTer[j] + " - " + RAItemList2Ter[j].toString()); 
            
            jListTer1.setModel(modelRestauranteATer);
          
            rsProdutos.close();
            //Restaurante 1 Quarta
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdqua, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=1 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
            RAItemListQua= new String[rsProdutos.getRow()];
            RAItemList2Qua= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
               totalQuantidadeProdutosA[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosA[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][2];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][2];   
               for(j=0;j<RAItemListQua.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(RAItemListQua[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][2]!=0) {
                            RAItemList2Qua[j] = RAItemList2Qua[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][2];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][2]!=0) {
                    RAItemListQua[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                    RAItemList2Qua[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][2]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteAQua.addElement(RAItemListQua[j] + " - " + RAItemList2Qua[j].toString()); 
            
            jListQua1.setModel(modelRestauranteAQua);
          
            rsProdutos.close();
            
            //Restaurante 1 Quinta
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdqui, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=1 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
            RAItemListQui= new String[rsProdutos.getRow()];
            RAItemList2Qui= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
               totalQuantidadeProdutosA[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosA[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][3];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][3];   
               for(j=0;j<RAItemListQui.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(RAItemListQui[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][3]!=0) {
                            RAItemList2Qui[j] = RAItemList2Qui[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][3];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][3]!=0) {
                    RAItemListQui[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                    RAItemList2Qui[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][3]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteAQui.addElement(RAItemListQui[j] + " - " + RAItemList2Qui[j].toString()); 
            
            jListQui1.setModel(modelRestauranteAQui);
          
            rsProdutos.close();
            
            //Restaurante 1 Sexta
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdsex, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=1 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
            RAItemListSex= new String[rsProdutos.getRow()];
            RAItemList2Sex= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
               totalQuantidadeProdutosA[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosA[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][4];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][4];   
               for(j=0;j<RAItemListSex.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(RAItemListSex[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][4]!=0) {
                            RAItemList2Sex[j] = RAItemList2Sex[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][4];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][4]!=0) {
                    RAItemListSex[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                    RAItemList2Sex[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][4]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteASex.addElement(RAItemListSex[j] + " - " + RAItemList2Sex[j].toString()); 
            
            jListSex1.setModel(modelRestauranteASex);
          
            rsProdutos.close();
            //Total Restaurante 1
            
            DefaultListModel modelRestauranteTotaisA = new DefaultListModel();
            for(j=0;j<totalProdutos;j++)  {
              if (totalQuantidadeProdutosA[j]!=0)
                 modelRestauranteTotaisA.addElement(totalNomesProdutosA[j] + " - " +  totalQuantidadeProdutosA[j].toString()); 
            }
            
           jListTotal1.setModel(modelRestauranteTotaisA); 
            //Fim Restaurante 1
            
           
            //Restaurante 2
            
             sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdseg, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=2 AND YEAR("+dbName+".encomenda.data) ="
                     + "'" + ano +"' AND getWeekofYear="+ getWeekofYear;
                       
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
            RBItemListSeg= new String[rsProdutos.getRow()];
            RBItemList2Seg= new Integer[rsProdutos.getRow()];
            linha=0;
            rsProdutos.beforeFirst();
            while (rsProdutos.next()){ 
               totalQuantidadeProdutosB[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosB[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][0];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][0];   
               control=false;
               for(j=0;j< RBItemListSeg.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals( RBItemListSeg[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][0]!=0) {
                            RBItemList2Seg[j] = RBItemList2Seg[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][0];
                             control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][0]!=0) {
                    RBItemListSeg[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                    RBItemList2Seg[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][0]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteBSeg.addElement( RBItemListSeg[j] + " - " + RBItemList2Seg[j].toString()); 
            
            jListSeg2.setModel(modelRestauranteBSeg);
          
            rsProdutos.close();
            //Restaurante 2 Terça
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdter, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=2 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
            RBItemListTer= new String[rsProdutos.getRow()];
            RBItemList2Ter= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
               totalQuantidadeProdutosB[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosB[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][1];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][1];  
               for(j=0;j< RBItemListTer.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals( RBItemListTer[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][1]!=0) {
                            RBItemList2Ter[j] = RBItemList2Ter[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][1];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][1]!=0) {
                    RBItemListTer[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                    RBItemList2Ter[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][1]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteBTer.addElement( RBItemListTer[j] + " - " + RBItemList2Ter[j].toString()); 
            
            jListTer2.setModel(modelRestauranteBTer);
          
            rsProdutos.close();
            //Restaurante 2 Quarta
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdqua, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda."
                    + "produtos_idprodutos WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=2 "
                    + "AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
            RBItemListQua= new String[rsProdutos.getRow()];
            RBItemList2Qua= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
               totalQuantidadeProdutosB[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosB[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][2];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][2];  
               for(j=0;j< RBItemListQua.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals( RBItemListQua[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][2]!=0) {
                            RBItemList2Qua[j] = RBItemList2Qua[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][2];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][2]!=0) {
                    RBItemListQua[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                    RBItemList2Qua[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][2]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteBQua.addElement( RBItemListQua[j] + " - " + RBItemList2Qua[j].toString()); 
            
            jListQua2.setModel(modelRestauranteBQua);
          
            rsProdutos.close();
            
            //Restaurante 2 Quinta
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdqui, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=2 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
            RBItemListQui= new String[rsProdutos.getRow()];
            RBItemList2Qui= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
               totalQuantidadeProdutosB[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosB[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][3];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][3];  
               for(j=0;j< RBItemListQui.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals( RBItemListQui[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][3]!=0) {
                            RBItemList2Qui[j] = RBItemList2Qui[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][3];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][3]!=0) {
                    RBItemListQui[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                    RBItemList2Qui[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][3]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteBQui.addElement( RBItemListQui[j] + " - " + RBItemList2Qui[j].toString()); 
            
            jListQui2.setModel(modelRestauranteBQui);
          
            rsProdutos.close();
            
            //Restaurante 2 Sexta
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdsex, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=2 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
            RBItemListSex= new String[rsProdutos.getRow()];
            RBItemList2Sex= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
               totalQuantidadeProdutosB[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosB[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][4];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][4];  
               for(j=0;j< RBItemListSex.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals( RBItemListSex[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][4]!=0) {
                            RBItemList2Sex[j] = RBItemList2Sex[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][4];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][4]!=0) {
                    RBItemListSex[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                    RBItemList2Sex[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][1][4]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteBSex.addElement( RBItemListSex[j] + " - " + RBItemList2Sex[j].toString()); 
            
            jListSex2.setModel(modelRestauranteBSex);
          
            rsProdutos.close();
            
          //Total Restaurante 2
            DefaultListModel modelRestauranteTotaisB = new DefaultListModel();
            for(j=0;j<totalProdutos;j++)  {
              if (totalQuantidadeProdutosB[j]!=0)
                 modelRestauranteTotaisB.addElement(totalNomesProdutosB[j] + " - " +  totalQuantidadeProdutosB[j].toString()); 
            }
            
           jListTotal2.setModel(modelRestauranteTotaisB); 
            
           //Fim Restaurante 2
        
           
            
            
            /////////////////////////////////
            //Restaurante 3 Segunda
           
           
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdseg, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="
                    + ""+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=3 "
                    + "AND YEAR("+dbName+".encomenda.data) ='" + ano +"' AND getWeekofYear="+ getWeekofYear;
                       
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             RCItemListSeg= new String[rsProdutos.getRow()];
             RCItemList2Seg= new Integer[rsProdutos.getRow()];
             linha=0;
            rsProdutos.beforeFirst();
            while (rsProdutos.next()){ 
               control=false;
               totalQuantidadeProdutosC[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosC[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][0];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][0];   
               for(j=0;j<  RCItemListSeg.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  RCItemListSeg[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][0]!=0) {
                             RCItemList2Seg[j] =  RCItemList2Seg[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][0];
                             control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][0]!=0) {
                     RCItemListSeg[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     RCItemList2Seg[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][0]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteCSeg.addElement(  RCItemListSeg[j] + " - " +  RCItemList2Seg[j].toString()); 
            
            jListSeg3.setModel(modelRestauranteCSeg);
          
            rsProdutos.close();
           //Restaurante 3 Terça
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdter, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=3 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             RCItemListTer= new String[rsProdutos.getRow()];
             RCItemList2Ter= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
               totalQuantidadeProdutosC[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosC[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][1];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][1];   
               for(j=0;j<  RCItemListTer.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  RCItemListTer[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][1]!=0) {
                             RCItemList2Ter[j] =  RCItemList2Ter[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][1];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][1]!=0) {
                     RCItemListTer[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     RCItemList2Ter[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][1]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteCTer.addElement(  RCItemListTer[j] + " - " +  RCItemList2Ter[j].toString()); 
            
            jListTer3.setModel(modelRestauranteCTer);
          
            rsProdutos.close();
           //Restaurante 3 Quarta
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdqua, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=3 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             RCItemListQua= new String[rsProdutos.getRow()];
             RCItemList2Qua= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
                totalQuantidadeProdutosC[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosC[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][2];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][2];   
               for(j=0;j<  RCItemListQua.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  RCItemListQua[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][2]!=0) {
                             RCItemList2Qua[j] =  RCItemList2Qua[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][2];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][2]!=0) {
                     RCItemListQua[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     RCItemList2Qua[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][2]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteCQua.addElement(  RCItemListQua[j] + " - " +  RCItemList2Qua[j].toString()); 
            
            jListQua3.setModel(modelRestauranteCQua);
          
            rsProdutos.close(); 
            
             //Restaurante 3 Quinta
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdqui, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=3 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             RCItemListQui= new String[rsProdutos.getRow()];
             RCItemList2Qui= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
                totalQuantidadeProdutosC[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosC[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][3];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][3];   
               for(j=0;j<  RCItemListQui.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  RCItemListQui[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][3]!=0) {
                             RCItemList2Qui[j] =  RCItemList2Qui[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][3];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][3]!=0) {
                     RCItemListQui[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     RCItemList2Qui[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][3]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteCQui.addElement(  RCItemListQui[j] + " - " +  RCItemList2Qui[j].toString()); 
            
            jListQui3.setModel(modelRestauranteCQui);
          
            rsProdutos.close();
            
            //Restaurante 3 Sexta
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdsex, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=3 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             RCItemListSex= new String[rsProdutos.getRow()];
             RCItemList2Sex= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
                totalQuantidadeProdutosC[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosC[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][4];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][4];   
               for(j=0;j<  RCItemListSex.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  RCItemListSex[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][4]!=0) {
                             RCItemList2Sex[j] =  RCItemList2Sex[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][4];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][4]!=0) {
                     RCItemListSex[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     RCItemList2Sex[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][2][4]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteCSex.addElement(  RCItemListSex[j] + " - " +  RCItemList2Sex[j].toString()); 
            
            jListSex3.setModel(modelRestauranteCSex);
          
            rsProdutos.close();
            
          //Total Restaurante 3
            DefaultListModel modelRestauranteTotaisC = new DefaultListModel();
            for(j=0;j<totalProdutos;j++)  {
              if (totalQuantidadeProdutosC[j]!=0)
                 modelRestauranteTotaisC.addElement(totalNomesProdutosC[j] + " - " +  totalQuantidadeProdutosC[j].toString()); 
            }
            
           jListTotal3.setModel(modelRestauranteTotaisC); 
            
            //Fim Restaurante 3
            
            /////////////////////////////////
            //Restaurante 4 Segunda  
           
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdseg, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=4 "
                    + "AND YEAR("+dbName+".encomenda.data) ='" + ano +"' AND getWeekofYear="+ getWeekofYear;
                       
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             RDItemListSeg= new String[rsProdutos.getRow()];
             RDItemList2Seg= new Integer[rsProdutos.getRow()];
             linha=0;
            rsProdutos.beforeFirst();
            while (rsProdutos.next()){ 
               control=false;
               totalQuantidadeProdutosD[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosD[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][0];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][0];   
               for(j=0;j<  RDItemListSeg.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  RDItemListSeg[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][0]!=0) {
                             RDItemList2Seg[j] =  RDItemList2Seg[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][0];
                             control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][0]!=0) {
                     RDItemListSeg[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     RDItemList2Seg[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][0]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteDSeg.addElement(  RDItemListSeg[j] + " - " +  RDItemList2Seg[j].toString()); 
            
            jListSeg4.setModel(modelRestauranteDSeg);
          
            rsProdutos.close();
           //Restaurante 4 Terça
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdter, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=4 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             RDItemListTer= new String[rsProdutos.getRow()];
             RDItemList2Ter= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
               totalQuantidadeProdutosD[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosD[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][1];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][1];   
               for(j=0;j<  RDItemListTer.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  RDItemListTer[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][1]!=0) {
                             RDItemList2Ter[j] =  RDItemList2Ter[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][1];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][1]!=0) {
                     RDItemListTer[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     RDItemList2Ter[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][1]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteDTer.addElement(  RDItemListTer[j] + " - " +  RDItemList2Ter[j].toString()); 
            
            jListTer4.setModel(modelRestauranteDTer);
          
            rsProdutos.close();
            //Restaurante 4 Quarta
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdqua, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=4 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             RDItemListQua= new String[rsProdutos.getRow()];
             RDItemList2Qua= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
               totalQuantidadeProdutosD[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosD[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][2];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][2];   
               for(j=0;j<  RDItemListQua.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  RDItemListQua[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][2]!=0) {
                             RDItemList2Qua[j] =  RDItemList2Qua[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][2];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][2]!=0) {
                     RDItemListQua[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     RDItemList2Qua[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][2]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteDQua.addElement(  RDItemListQua[j] + " - " +  RDItemList2Qua[j].toString()); 
            
            jListQua4.setModel(modelRestauranteDQua);
          
            rsProdutos.close();
            
            //Restaurante 4 Quinta
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdqui, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=4 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             RDItemListQui= new String[rsProdutos.getRow()];
             RDItemList2Qui= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
               totalQuantidadeProdutosD[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosD[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][3];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][3];   
               for(j=0;j<  RDItemListQui.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  RDItemListQui[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][3]!=0) {
                             RDItemList2Qui[j] =  RDItemList2Qui[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][0][3];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][3]!=0) {
                     RDItemListQui[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     RDItemList2Qui[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][3]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteDQui.addElement(  RDItemListQui[j] + " - " +  RDItemList2Qui[j].toString()); 
            
            jListQui4.setModel(modelRestauranteDQui);
          
            rsProdutos.close();
            
            //Restaurante 4 Sexta
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdsex, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=4 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             RDItemListSex= new String[rsProdutos.getRow()];
             RDItemList2Sex= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
               totalQuantidadeProdutosD[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosD[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][4];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][4];   
               for(j=0;j<  RDItemListSex.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  RDItemListSex[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][4]!=0) {
                             RDItemList2Sex[j] =  RDItemList2Sex[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][4];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][4]!=0) {
                     RDItemListSex[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     RDItemList2Sex[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][3][4]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteDSex.addElement(  RDItemListSex[j] + " - " +  RDItemList2Sex[j].toString()); 
            
            jListSex4.setModel(modelRestauranteDSex);
          
            rsProdutos.close();
            
          //Total Restaurante 4
            DefaultListModel modelRestauranteTotaisD = new DefaultListModel();
            for(j=0;j<totalProdutos;j++)  {
              if (totalQuantidadeProdutosD[j]!=0)
                 modelRestauranteTotaisD.addElement(totalNomesProdutosD[j] + " - " +  totalQuantidadeProdutosD[j].toString()); 
            }
            
           jListTotal4.setModel(modelRestauranteTotaisD); 
            
            //Fim Restaurante 4
            
            /////////////////////////////////
            //Restaurante 5 Segunda   
         
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdseg, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=5 AND"
                    + " YEAR("+dbName+".encomenda.data) ='" + ano +"' AND getWeekofYear="+ getWeekofYear;
                       
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             REItemListSeg= new String[rsProdutos.getRow()];
             REItemList2Seg= new Integer[rsProdutos.getRow()];
             linha=0;
            rsProdutos.beforeFirst();
            while (rsProdutos.next()){ 
               control=false;
               totalQuantidadeProdutosE[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosE[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][0];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][0];   
               for(j=0;j<  REItemListSeg.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  REItemListSeg[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][0]!=0) {
                             REItemList2Seg[j] =  REItemList2Seg[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][0];
                             control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][0]!=0) {
                     REItemListSeg[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     REItemList2Seg[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][0]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteESeg.addElement(  REItemListSeg[j] + " - " +  REItemList2Seg[j].toString()); 
            
            jListSeg5.setModel(modelRestauranteESeg);
          
            rsProdutos.close();
           //Restaurante 5 Terça
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdter, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=5 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             REItemListTer= new String[rsProdutos.getRow()];
             REItemList2Ter= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
                totalQuantidadeProdutosE[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosE[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][1];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][1];  
               for(j=0;j<  REItemListTer.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  REItemListTer[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][1]!=0) {
                             REItemList2Ter[j] =  REItemList2Ter[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][1];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][1]!=0) {
                     REItemListTer[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     REItemList2Ter[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][1]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteETer.addElement(  REItemListTer[j] + " - " +  REItemList2Ter[j].toString()); 
            
            jListTer5.setModel(modelRestauranteETer);
          
            rsProdutos.close();
            //Restaurante 5 Quarta
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdqua, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=5 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             REItemListQua= new String[rsProdutos.getRow()];
             REItemList2Qua= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
                totalQuantidadeProdutosE[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosE[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][2];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][2];  
               for(j=0;j<  REItemListQua.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  REItemListQua[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][2]!=0) {
                             REItemList2Qua[j] =  REItemList2Qua[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][2];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][2]!=0) {
                     REItemListQua[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     REItemList2Qua[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][2]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteEQua.addElement(  REItemListQua[j] + " - " +  REItemList2Qua[j].toString()); 
            
            jListQua5.setModel(modelRestauranteEQua);
          
            rsProdutos.close();
            
            //Restaurante 5 Quinta
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdqui, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=5 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             REItemListQui= new String[rsProdutos.getRow()];
             REItemList2Qui= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
                totalQuantidadeProdutosE[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosE[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][3];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][3];  
               for(j=0;j<  REItemListQui.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  REItemListQui[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][3]!=0) {
                             REItemList2Qui[j] =  REItemList2Qui[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][3];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][3]!=0) {
                     REItemListQui[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     REItemList2Qui[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][3]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteEQui.addElement(  REItemListQui[j] + " - " +  REItemList2Qui[j].toString()); 
            
            jListQui5.setModel(modelRestauranteEQui);
          
            rsProdutos.close();
            
            //Restaurante 5 Sexta
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdsex, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=5 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             REItemListSex= new String[rsProdutos.getRow()];
             REItemList2Sex= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
                totalQuantidadeProdutosE[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosE[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][4];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][4];  
               for(j=0;j<  REItemListSex.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  REItemListSex[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][4]!=0) {
                             REItemList2Sex[j] =  REItemList2Sex[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][4];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][4]!=0) {
                     REItemListSex[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     REItemList2Sex[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][4][4]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteESex.addElement(  REItemListSex[j] + " - " +  REItemList2Sex[j].toString()); 
            
            jListSex5.setModel(modelRestauranteESex);
          
            rsProdutos.close();
            
          //Total Restaurante 5
            DefaultListModel modelRestauranteTotaisE = new DefaultListModel();
            for(j=0;j<totalProdutos;j++)  {
              if (totalQuantidadeProdutosE[j]!=0)
                 modelRestauranteTotaisE.addElement(totalNomesProdutosE[j] + " - " +  totalQuantidadeProdutosE[j].toString()); 
            }
            
           jListTotal5.setModel(modelRestauranteTotaisE); 
            
            //Fim Restaurante 5
            
            /////////////////////////////////
            //Restaurante 6 Segunda  
            
             sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdseg, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="
                     + ""+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=6 "
                     + "AND YEAR("+dbName+".encomenda.data) ='" + ano +"' AND getWeekofYear="+ getWeekofYear;
                       
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             RFItemListSeg= new String[rsProdutos.getRow()];
             RFItemList2Seg= new Integer[rsProdutos.getRow()];
             linha=0;
            rsProdutos.beforeFirst();
            while (rsProdutos.next()){ 
               control=false;
               totalQuantidadeProdutosF[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosF[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][0];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][0];   
               
               for(j=0;j<  RFItemListSeg.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  RFItemListSeg[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][0]!=0) {
                             RFItemList2Seg[j] =  RFItemList2Seg[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][0];
                             control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][0]!=0) {
                     RFItemListSeg[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     RFItemList2Seg[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][0]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteFSeg.addElement(  RFItemListSeg[j] + " - " +  RFItemList2Seg[j].toString()); 
            
            jListSeg6.setModel(modelRestauranteFSeg);
          
            rsProdutos.close();
           //Restaurante 6 Terça
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdter, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=6 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             RFItemListTer= new String[rsProdutos.getRow()];
             RFItemList2Ter= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
               totalQuantidadeProdutosF[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosF[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][1];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][1];   
               
               for(j=0;j<  RFItemListTer.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  RFItemListTer[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][1]!=0) {
                             RFItemList2Ter[j] =  RFItemList2Ter[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][1];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][1]!=0) {
                     RFItemListTer[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     RFItemList2Ter[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][1]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteFTer.addElement(  RFItemListTer[j] + " - " +  RFItemList2Ter[j].toString()); 
            
            jListTer6.setModel(modelRestauranteFTer);
          
            rsProdutos.close();
            //Restaurante 6 Quarta
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdqua, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=6 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             RFItemListQua= new String[rsProdutos.getRow()];
             RFItemList2Qua= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
               totalQuantidadeProdutosF[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosF[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][2];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][2];   
               
               for(j=0;j<  RFItemListQua.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  RFItemListQua[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][2]!=0) {
                             RFItemList2Qua[j] =  RFItemList2Qua[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][2];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][2]!=0) {
                     RFItemListQua[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     RFItemList2Qua[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][2]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteFQua.addElement(  RFItemListQua[j] + " - " +  RFItemList2Qua[j].toString()); 
            
            jListQua6.setModel(modelRestauranteFQua);
          
            rsProdutos.close();
            
            //Restaurante 6 Quinta
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdqui, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=6 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             RFItemListQui= new String[rsProdutos.getRow()];
             RFItemList2Qui= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
               totalQuantidadeProdutosF[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosF[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][3];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][3];   
               
               for(j=0;j<  RFItemListQui.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  RFItemListQui[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][3]!=0) {
                             RFItemList2Qui[j] =  RFItemList2Qui[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][3];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][3]!=0) {
                     RFItemListQui[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     RFItemList2Qui[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][3]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteFQui.addElement(  RFItemListQui[j] + " - " +  RFItemList2Qui[j].toString()); 
            
            jListQui6.setModel(modelRestauranteFQui);
          
            rsProdutos.close();
            
            //Restaurante 6 Sexta
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdsex, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=6 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             RFItemListSex= new String[rsProdutos.getRow()];
             RFItemList2Sex= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
               totalQuantidadeProdutosF[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosF[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][4];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][4];   
               
               for(j=0;j<  RFItemListSex.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  RFItemListSex[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][4]!=0) {
                             RFItemList2Sex[j] =  RFItemList2Sex[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][4];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][4]!=0) {
                     RFItemListSex[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     RFItemList2Sex[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][5][4]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteFSex.addElement(  RFItemListSex[j] + " - " +  RFItemList2Sex[j].toString()); 
            
            jListSex6.setModel(modelRestauranteFSex);
          
            rsProdutos.close();
            
          //Total Restaurante 6
            DefaultListModel modelRestauranteTotaisF = new DefaultListModel();
            for(j=0;j<totalProdutos;j++)  {
              if (totalQuantidadeProdutosF[j]!=0)
                 modelRestauranteTotaisF.addElement(totalNomesProdutosF[j] + " - " +  totalQuantidadeProdutosF[j].toString()); 
            }
            
           jListTotal6.setModel(modelRestauranteTotaisF); 
            
            //Fim Restaurante 6
            
            /////////////////////////////////
            //Restaurante 7 Segunda
            
              sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdseg, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="
                      + ""+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=7 AND"
                      + " YEAR("+dbName+".encomenda.data) ='" + ano +"' AND getWeekofYear="+ getWeekofYear;
                       
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             RGItemListSeg= new String[rsProdutos.getRow()];
             RGItemList2Seg= new Integer[rsProdutos.getRow()];
             linha=0;
            rsProdutos.beforeFirst();
            while (rsProdutos.next()){ 
               control=false;
               totalQuantidadeProdutosG[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosG[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][0];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][0]; 
               for(j=0;j<  RGItemListSeg.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  RGItemListSeg[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][0]!=0) {
                             RGItemList2Seg[j] =  RGItemList2Seg[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][0];
                             control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][0]!=0) {
                     RGItemListSeg[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     RGItemList2Seg[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][0]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteGSeg.addElement(  RGItemListSeg[j] + " - " +  RGItemList2Seg[j].toString()); 
            
            jListSeg7.setModel(modelRestauranteGSeg);
          
            rsProdutos.close();
           //Restaurante 7 Terça
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdter, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=7 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             RGItemListTer= new String[rsProdutos.getRow()];
             RGItemList2Ter= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
                totalQuantidadeProdutosG[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosG[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][1];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][1]; 
               for(j=0;j<  RGItemListTer.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  RGItemListTer[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][1]!=0) {
                             RGItemList2Ter[j] =  RGItemList2Ter[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][1];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][1]!=0) {
                     RGItemListTer[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     RGItemList2Ter[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][1]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteGTer.addElement(  RGItemListTer[j] + " - " +  RGItemList2Ter[j].toString()); 
            
            jListTer7.setModel(modelRestauranteGTer);
          
            rsProdutos.close();
            //Restaurante 7 Quarta
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdqua, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=7 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             RGItemListQua= new String[rsProdutos.getRow()];
             RGItemList2Qua= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
                totalQuantidadeProdutosG[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosG[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][2];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][2]; 
               for(j=0;j<  RGItemListQua.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  RGItemListQua[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][2]!=0) {
                             RGItemList2Qua[j] =  RGItemList2Qua[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][2];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][2]!=0) {
                     RGItemListQua[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     RGItemList2Qua[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][2]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteGQua.addElement(  RGItemListQua[j] + " - " +  RGItemList2Qua[j].toString()); 
            
            jListQua7.setModel(modelRestauranteGQua);
          
            rsProdutos.close();
            
            //Restaurante 7 Quinta
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdqui, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=7 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             RGItemListQui= new String[rsProdutos.getRow()];
             RGItemList2Qui= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
                totalQuantidadeProdutosG[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosG[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][3];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][3]; 
               for(j=0;j<  RGItemListQui.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  RGItemListQui[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][3]!=0) {
                             RGItemList2Qui[j] =  RGItemList2Qui[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][3];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][3]!=0) {
                     RGItemListQui[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     RGItemList2Qui[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][3]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteGQui.addElement(  RGItemListQui[j] + " - " +  RGItemList2Qui[j].toString()); 
            
            jListQui7.setModel(modelRestauranteGQui);
          
            rsProdutos.close();
            
            //Restaurante 7 Sexta
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdsex, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=7 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             RGItemListSex= new String[rsProdutos.getRow()];
             RGItemList2Sex= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
                totalQuantidadeProdutosG[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosG[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][4];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][4]; 
               for(j=0;j<  RGItemListSex.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  RGItemListSex[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][4]!=0) {
                             RGItemList2Sex[j] =  RGItemList2Sex[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][4];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][4]!=0) {
                     RGItemListSex[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     RGItemList2Sex[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][6][4]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteGSex.addElement(  RGItemListSex[j] + " - " +  RGItemList2Sex[j].toString()); 
            
            jListSex7.setModel(modelRestauranteGSex);
          
            rsProdutos.close();
            
          //Total Restaurante 7
            DefaultListModel modelRestauranteTotaisG = new DefaultListModel();
            for(j=0;j<totalProdutos;j++)  {
              if (totalQuantidadeProdutosG[j]!=0)
                 modelRestauranteTotaisG.addElement(totalNomesProdutosG[j] + " - " +  totalQuantidadeProdutosG[j].toString()); 
            }
            
           jListTotal7.setModel(modelRestauranteTotaisG); 
            //Fim Restaurante 7
            
            /////////////////////////////////
            //Restaurante 8 Segunda  
            
             sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdseg, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="
                     + ""+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=8 AND"
                     + " YEAR("+dbName+".encomenda.data) ='" + ano +"' AND getWeekofYear="+ getWeekofYear;
                       
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             RHItemListSeg= new String[rsProdutos.getRow()];
             RHItemList2Seg= new Integer[rsProdutos.getRow()];
            linha=0;
            rsProdutos.beforeFirst();
            while (rsProdutos.next()){ 
               control=false;
                totalQuantidadeProdutosH[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosH[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][0];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][0]; 
               for(j=0;j<  RHItemListSeg.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  RHItemListSeg[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][0]!=0) {
                             RHItemList2Seg[j] =  RHItemList2Seg[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][0];
                             control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][0]!=0) {
                     RHItemListSeg[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     RHItemList2Seg[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][0]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteHSeg.addElement(  RHItemListSeg[j] + " - " +  RHItemList2Seg[j].toString()); 
            
            jListSeg8.setModel(modelRestauranteHSeg);
          
            rsProdutos.close();
           //Restaurante 8 Terça
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdter, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=8 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             RHItemListTer= new String[rsProdutos.getRow()];
             RHItemList2Ter= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
               totalQuantidadeProdutosH[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosH[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][1];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][1]; 
               for(j=0;j<  RHItemListTer.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  RHItemListTer[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][1]!=0) {
                             RHItemList2Ter[j] =  RHItemList2Ter[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][1];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][1]!=0) {
                     RHItemListTer[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     RHItemList2Ter[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][1]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteHTer.addElement(  RHItemListTer[j] + " - " +  RHItemList2Ter[j].toString()); 
            
            jListTer8.setModel(modelRestauranteHTer);
          
            rsProdutos.close();
            //Restaurante 8 Quarta
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdqua, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=8 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             RHItemListQua= new String[rsProdutos.getRow()];
             RHItemList2Qua= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
               totalQuantidadeProdutosH[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosH[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][2];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][2]; 
               for(j=0;j<  RHItemListQua.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  RHItemListQua[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][2]!=0) {
                             RHItemList2Qua[j] =  RHItemList2Qua[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][2];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][2]!=0) {
                     RHItemListQua[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     RHItemList2Qua[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][2]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteHQua.addElement(  RHItemListQua[j] + " - " +  RHItemList2Qua[j].toString()); 
            
            jListQua8.setModel(modelRestauranteHQua);
          
            rsProdutos.close();
            
            //Restaurante 8 Quinta
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdqui, "+dbName+".produtos.idprodutos FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=8 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             RHItemListQui= new String[rsProdutos.getRow()];
             RHItemList2Qui= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
               totalQuantidadeProdutosH[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosH[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][3];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][3]; 
               for(j=0;j<  RHItemListQui.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  RHItemListQui[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][3]!=0) {
                             RHItemList2Qui[j] =  RHItemList2Qui[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][3];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][3]!=0) {
                     RHItemListQui[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     RHItemList2Qui[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][3]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteHQui.addElement(  RHItemListQui[j] + " - " +  RHItemList2Qui[j].toString()); 
            
            jListQui8.setModel(modelRestauranteHQui);
          
            rsProdutos.close();
            
            //Restaurante 8 Sexta
            sql1 = "SELECT "+dbName+".produtos.nome, "+dbName+".encomenda.qtdsex, "+dbName+".produtos.idprodutos  FROM "+dbName+".produtos "
                    + "INNER JOIN "+dbName+".encomenda ON "+dbName+".produtos.idprodutos="+dbName+".encomenda.produtos_idprodutos "
                    + "WHERE "+dbName+".encomenda.restaurantes_idrestaurantes=8 AND YEAR("+dbName+".encomenda.data) ='"+ano+"' "
                    + "AND getWeekofYear="+ getWeekofYear;
         
            
            rsProdutos = stmt.executeQuery(sql1);
            rsProdutos.last();
           
             RHItemListSex= new String[rsProdutos.getRow()];
             RHItemList2Sex= new Integer[rsProdutos.getRow()];
                     
            rsProdutos.beforeFirst();
            linha=0;
             while (rsProdutos.next()){ 
               control=false;
               totalQuantidadeProdutosH[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutosH[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][4];
               totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1]= totalQuantidadeProdutos[rsProdutos.getInt("produtos.idprodutos")-1] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][4]; 
               for(j=0;j<  RHItemListSex.length;j++)  {
                    if (rsProdutos.getString("produtos.nome").equals(  RHItemListSex[j]) && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][4]!=0) {
                             RHItemList2Sex[j] =  RHItemList2Sex[j] + quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][4];
                            control=true;
                            break;
                    }
               }
               if (control==false && quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][4]!=0) {
                     RHItemListSex[linha] = rsProdutos.getString("produtos.nome"); //get the element in column "item_code"
                     RHItemList2Sex[linha] = quantidadeProdutoDisponibilizar[rsProdutos.getInt( "produtos.idprodutos")-1][7][4]; //get the element in column "item_code"
                    linha++;
               }              
            }
           for(j=0;j<linha;j++)  
               modelRestauranteHSex.addElement(  RHItemListSex[j] + " - " +  RHItemList2Sex[j].toString()); 
            
            jListSex8.setModel(modelRestauranteHSex);
          
            rsProdutos.close();
            
          //Total Restaurante 8
            DefaultListModel modelRestauranteTotaisH = new DefaultListModel();
            for(j=0;j<totalProdutos;j++)  {
              if (totalQuantidadeProdutosH[j]!=0)
                 modelRestauranteTotaisH.addElement(totalNomesProdutosH[j] + " - " +  totalQuantidadeProdutosH[j].toString()); 
            }
            
           jListTotal8.setModel(modelRestauranteTotaisH); 
            
            //Fim Restaurante 8
            
            /////////////////////////////////
            
            DefaultListModel modelRestauranteTotaisTotais = new DefaultListModel();
            for(j=0;j<totalProdutos;j++)  {
              if (totalQuantidadeProdutos[j]!=0)
                 modelRestauranteTotaisTotais.addElement(totalNomesProdutos[j] + " - " +  totalQuantidadeProdutos[j].toString()); 
            }
            
           jListTotal9.setModel(modelRestauranteTotaisTotais); 
            
            //TOTAIS SEGUNDA
            //A
            linha=0;
            for (i=0;i<modelRestauranteASeg.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosSeg[j].equals(RAItemListSeg[i])) {
                            totalQuantidadeProdutosSeg[j] = RAItemList2Seg[i] + totalQuantidadeProdutosSeg[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosSeg[linha] = RAItemListSeg[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosSeg[linha] = RAItemList2Seg[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
            //B
            for (i=0;i<modelRestauranteBSeg.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosSeg[j].equals(RBItemListSeg[i])) {
                            totalQuantidadeProdutosSeg[j] = RBItemList2Seg[i] + totalQuantidadeProdutosSeg[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosSeg[linha] = RBItemListSeg[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosSeg[linha] = RBItemList2Seg[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
            //C
            for (i=0;i<modelRestauranteCSeg.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosSeg[j].equals(RCItemListSeg[i])) {
                            totalQuantidadeProdutosSeg[j] = RCItemList2Seg[i] + totalQuantidadeProdutosSeg[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosSeg[linha] = RCItemListSeg[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosSeg[linha] = RCItemList2Seg[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
            //D
            for (i=0;i<modelRestauranteDSeg.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosSeg[j].equals(RDItemListSeg[i])) {
                            totalQuantidadeProdutosSeg[j] = RDItemList2Seg[i] + totalQuantidadeProdutosSeg[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosSeg[linha] = RDItemListSeg[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosSeg[linha] = RDItemList2Seg[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
            //E
            for (i=0;i<modelRestauranteESeg.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosSeg[j].equals(REItemListSeg[i])) {
                            totalQuantidadeProdutosSeg[j] = REItemList2Seg[i] + totalQuantidadeProdutosSeg[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosSeg[linha] = REItemListSeg[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosSeg[linha] = REItemList2Seg[i]; //get the element in column "item_code"
                    linha++;
               }
          }
            //F
            for (i=0;i<modelRestauranteFSeg.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosSeg[j].equals(RFItemListSeg[i])) {
                            totalQuantidadeProdutosSeg[j] = RFItemList2Seg[i] + totalQuantidadeProdutosSeg[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosSeg[linha] = RFItemListSeg[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosSeg[linha] = RFItemList2Seg[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
            //G
            for (i=0;i<modelRestauranteGSeg.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosSeg[j].equals(RGItemListSeg[i])) {
                            totalQuantidadeProdutosSeg[j] = RGItemList2Seg[i] + totalQuantidadeProdutosSeg[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosSeg[linha] = RGItemListSeg[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosSeg[linha] = RGItemList2Seg[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
            //H
            for (i=0;i<modelRestauranteHSeg.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosSeg[j].equals(RHItemListSeg[i])) {
                            totalQuantidadeProdutosSeg[j] = RHItemList2Seg[i] + totalQuantidadeProdutosSeg[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosSeg[linha] = RHItemListSeg[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosSeg[linha] = RHItemList2Seg[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
          
          
            DefaultListModel modelRestauranteTotaisSeg = new DefaultListModel();
          for(j=0;j<totalProdutos;j++)  {
              if (totalQuantidadeProdutosSeg[j]!=0)
              modelRestauranteTotaisSeg.addElement(totalNomesProdutosSeg[j] + " - " +  totalQuantidadeProdutosSeg[j].toString()); 
          }
              
               
            
           jListSegTotal.setModel(modelRestauranteTotaisSeg); 
                       
         //TOTAIS TERÇA
           
         //A
            linha=0;
            for (i=0;i<modelRestauranteATer.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosTer[j].equals(RAItemListTer[i])) {
                            totalQuantidadeProdutosTer[j] = RAItemList2Ter[i] + totalQuantidadeProdutosTer[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosTer[linha] = RAItemListTer[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosTer[linha] = RAItemList2Ter[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
           //B
            for (i=0;i<modelRestauranteBTer.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosTer[j].equals(RBItemListTer[i])) {
                            totalQuantidadeProdutosTer[j] = RBItemList2Ter[i] + totalQuantidadeProdutosTer[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosTer[linha] = RBItemListTer[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosTer[linha] = RBItemList2Ter[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
             //C
            for (i=0;i<modelRestauranteCTer.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosTer[j].equals(RCItemListTer[i])) {
                            totalQuantidadeProdutosTer[j] = RCItemList2Ter[i] + totalQuantidadeProdutosTer[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosTer[linha] = RCItemListTer[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosTer[linha] = RCItemList2Ter[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
            //D
            for (i=0;i<modelRestauranteDTer.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosTer[j].equals(RDItemListTer[i])) {
                            totalQuantidadeProdutosTer[j] = RDItemList2Ter[i] + totalQuantidadeProdutosTer[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosTer[linha] = RDItemListTer[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosTer[linha] = RDItemList2Ter[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
            //E
            for (i=0;i<modelRestauranteETer.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosTer[j].equals(REItemListTer[i])) {
                            totalQuantidadeProdutosTer[j] = REItemList2Ter[i] + totalQuantidadeProdutosTer[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosTer[linha] = REItemListTer[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosTer[linha] = REItemList2Ter[i]; //get the element in column "item_code"
                    linha++;
               }
          }
            //F
            for (i=0;i<modelRestauranteFTer.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosTer[j].equals(RFItemListTer[i])) {
                            totalQuantidadeProdutosTer[j] = RFItemList2Ter[i] + totalQuantidadeProdutosTer[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosTer[linha] = RFItemListTer[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosTer[linha] = RFItemList2Ter[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
          //G
            for (i=0;i<modelRestauranteGTer.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosTer[j].equals(RGItemListTer[i])) {
                            totalQuantidadeProdutosTer[j] = RGItemList2Ter[i] + totalQuantidadeProdutosTer[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosTer[linha] = RGItemListTer[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosTer[linha] = RGItemList2Ter[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
            //H
            for (i=0;i<modelRestauranteHTer.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosTer[j].equals(RHItemListTer[i])) {
                            totalQuantidadeProdutosTer[j] = RHItemList2Ter[i] + totalQuantidadeProdutosTer[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosTer[linha] = RHItemListTer[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosTer[linha] = RHItemList2Ter[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
          
          
            DefaultListModel modelRestauranteTotaisTer = new DefaultListModel();
         
            for(j=0;j<totalProdutos;j++)  {
              if (totalQuantidadeProdutosTer[j]!=0)
              modelRestauranteTotaisTer.addElement(totalNomesProdutosTer[j] + " - " +  totalQuantidadeProdutosTer[j].toString()); 
          }
              
               
            
           jListTerTotal.setModel(modelRestauranteTotaisTer);
            
         //TOTAIS QUARTA
           
         //A
            linha=0;
            for (i=0;i<modelRestauranteAQua.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosQua[j].equals(RAItemListQua[i])) {
                            totalQuantidadeProdutosQua[j] = RAItemList2Qua[i] + totalQuantidadeProdutosQua[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosQua[linha] = RAItemListQua[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosQua[linha] = RAItemList2Qua[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
           //B
            for (i=0;i<modelRestauranteBQua.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosQua[j].equals(RBItemListQua[i])) {
                            totalQuantidadeProdutosQua[j] = RBItemList2Qua[i] + totalQuantidadeProdutosQua[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosQua[linha] = RBItemListQua[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosQua[linha] = RBItemList2Qua[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
             //C
            for (i=0;i<modelRestauranteCQua.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosQua[j].equals(RCItemListQua[i])) {
                            totalQuantidadeProdutosQua[j] = RCItemList2Qua[i] + totalQuantidadeProdutosQua[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosQua[linha] = RCItemListQua[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosQua[linha] = RCItemList2Qua[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
            //D
            for (i=0;i<modelRestauranteDQua.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosQua[j].equals(RDItemListQua[i])) {
                            totalQuantidadeProdutosQua[j] = RDItemList2Qua[i] + totalQuantidadeProdutosQua[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosQua[linha] = RDItemListQua[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosQua[linha] = RDItemList2Qua[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
            //E
            for (i=0;i<modelRestauranteEQua.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosQua[j].equals(REItemListQua[i])) {
                            totalQuantidadeProdutosQua[j] = REItemList2Qua[i] + totalQuantidadeProdutosQua[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosQua[linha] = REItemListQua[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosQua[linha] = REItemList2Qua[i]; //get the element in column "item_code"
                    linha++;
               }
          }
            //F
            for (i=0;i<modelRestauranteFQua.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosQua[j].equals(RFItemListQua[i])) {
                            totalQuantidadeProdutosQua[j] = RFItemList2Qua[i] + totalQuantidadeProdutosQua[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosQua[linha] = RFItemListQua[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosQua[linha] = RFItemList2Qua[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
          //G
            for (i=0;i<modelRestauranteGQua.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosQua[j].equals(RGItemListQua[i])) {
                            totalQuantidadeProdutosQua[j] = RGItemList2Qua[i] + totalQuantidadeProdutosQua[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosQua[linha] = RGItemListQua[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosQua[linha] = RGItemList2Qua[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
            //H
            for (i=0;i<modelRestauranteHQua.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosQua[j].equals(RHItemListQua[i])) {
                            totalQuantidadeProdutosQua[j] = RHItemList2Qua[i] + totalQuantidadeProdutosQua[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosQua[linha] = RHItemListQua[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosQua[linha] = RHItemList2Qua[i]; //get the element in column "item_code"
                    linha++;
               }
          
          } 
          
          
            DefaultListModel modelRestauranteTotaisQua = new DefaultListModel();
          for(j=0;j<totalProdutos;j++)  {
              if (totalQuantidadeProdutosQua[j]!=0)
              modelRestauranteTotaisQua.addElement(totalNomesProdutosQua[j] + " - " +  totalQuantidadeProdutosQua[j].toString()); 
          }
              
               
            
           jListQuaTotal.setModel(modelRestauranteTotaisQua);
        
        //TOTAIS QUINTA
           
          //A
            linha=0;
            for (i=0;i<modelRestauranteAQui.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosQui[j].equals(RAItemListQui[i])) {
                            totalQuantidadeProdutosQui[j] = RAItemList2Qui[i] + totalQuantidadeProdutosQui[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosQui[linha] = RAItemListQui[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosQui[linha] = RAItemList2Qui[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
           //B
            for (i=0;i<modelRestauranteBQui.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosQui[j].equals(RBItemListQui[i])) {
                            totalQuantidadeProdutosQui[j] = RBItemList2Qui[i] + totalQuantidadeProdutosQui[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosQui[linha] = RBItemListQui[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosQui[linha] = RBItemList2Qui[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
             //C
            for (i=0;i<modelRestauranteCQui.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosQui[j].equals(RCItemListQui[i])) {
                            totalQuantidadeProdutosQui[j] = RCItemList2Qui[i] + totalQuantidadeProdutosQui[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosQui[linha] = RCItemListQui[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosQui[linha] = RCItemList2Qui[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
            //D
            for (i=0;i<modelRestauranteDQui.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosQui[j].equals(RDItemListQui[i])) {
                            totalQuantidadeProdutosQui[j] = RDItemList2Qui[i] + totalQuantidadeProdutosQui[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosQui[linha] = RDItemListQui[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosQui[linha] = RDItemList2Qui[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
            //E
            for (i=0;i<modelRestauranteEQui.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosQui[j].equals(REItemListQui[i])) {
                            totalQuantidadeProdutosQui[j] = REItemList2Qui[i] + totalQuantidadeProdutosQui[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosQui[linha] = REItemListQui[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosQui[linha] = REItemList2Qui[i]; //get the element in column "item_code"
                    linha++;
               }
          }
            //F
            for (i=0;i<modelRestauranteFQui.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosQui[j].equals(RFItemListQui[i])) {
                            totalQuantidadeProdutosQui[j] = RFItemList2Qui[i] + totalQuantidadeProdutosQui[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosQui[linha] = RFItemListQui[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosQui[linha] = RFItemList2Qui[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
          //G
            for (i=0;i<modelRestauranteGQui.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosQui[j].equals(RGItemListQui[i])) {
                            totalQuantidadeProdutosQui[j] = RGItemList2Qui[i] + totalQuantidadeProdutosQui[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosQui[linha] = RGItemListQui[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosQui[linha] = RGItemList2Qui[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
            //H
            for (i=0;i<modelRestauranteHQui.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosQui[j].equals(RHItemListQui[i])) {
                            totalQuantidadeProdutosQui[j] = RHItemList2Qui[i] + totalQuantidadeProdutosQui[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosQui[linha] = RHItemListQui[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosQui[linha] = RHItemList2Qui[i]; //get the element in column "item_code"
                    linha++;
               }
          
          } 
          
          
            DefaultListModel modelRestauranteTotaisQui = new DefaultListModel();
          for(j=0;j<totalProdutos;j++)  {
              if (totalQuantidadeProdutosQui[j]!=0)
              modelRestauranteTotaisQui.addElement(totalNomesProdutosQui[j] + " - " +  totalQuantidadeProdutosQui[j].toString()); 
          }
              
               
            
           jListQuiTotal.setModel(modelRestauranteTotaisQui);  
        //TOTAIS SEXTA
           
         //A
            linha=0;
            for (i=0;i<modelRestauranteASex.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosSex[j].equals(RAItemListSex[i])) {
                            totalQuantidadeProdutosSex[j] = RAItemList2Sex[i] + totalQuantidadeProdutosSex[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosSex[linha] = RAItemListSex[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosSex[linha] = RAItemList2Sex[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
           //B
            for (i=0;i<modelRestauranteBSex.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosSex[j].equals(RBItemListSex[i])) {
                            totalQuantidadeProdutosSex[j] = RBItemList2Sex[i] + totalQuantidadeProdutosSex[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosSex[linha] = RBItemListSex[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosSex[linha] = RBItemList2Sex[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
             //C
            for (i=0;i<modelRestauranteCSex.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosSex[j].equals(RCItemListSex[i])) {
                            totalQuantidadeProdutosSex[j] = RCItemList2Sex[i] + totalQuantidadeProdutosSex[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosSex[linha] = RCItemListSex[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosSex[linha] = RCItemList2Sex[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
            //D
            for (i=0;i<modelRestauranteDSex.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosSex[j].equals(RDItemListSex[i])) {
                            totalQuantidadeProdutosSex[j] = RDItemList2Sex[i] + totalQuantidadeProdutosSex[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosSex[linha] = RDItemListSex[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosSex[linha] = RDItemList2Sex[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
            //E
            for (i=0;i<modelRestauranteESex.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosSex[j].equals(REItemListSex[i])) {
                            totalQuantidadeProdutosSex[j] = REItemList2Sex[i] + totalQuantidadeProdutosSex[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosSex[linha] = REItemListSex[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosSex[linha] = REItemList2Sex[i]; //get the element in column "item_code"
                    linha++;
               }
          }
            //F
            for (i=0;i<modelRestauranteFSex.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosSex[j].equals(RFItemListSex[i])) {
                            totalQuantidadeProdutosSex[j] = RFItemList2Sex[i] + totalQuantidadeProdutosSex[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosSex[linha] = RFItemListSex[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosSex[linha] = RFItemList2Sex[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
          //G
            for (i=0;i<modelRestauranteGSex.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosSex[j].equals(RGItemListSex[i])) {
                            totalQuantidadeProdutosSex[j] = RGItemList2Sex[i] + totalQuantidadeProdutosSex[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosSex[linha] = RGItemListSex[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosSex[linha] = RGItemList2Sex[i]; //get the element in column "item_code"
                    linha++;
               }
          
          }
            //H
            for (i=0;i<modelRestauranteHSex.size();i++){
               control=false;
               for(j=0;j<totalProdutos;j++)  {
                    if (totalNomesProdutosSex[j].equals(RHItemListSex[i])) {
                            totalQuantidadeProdutosSex[j] = RHItemList2Sex[i] + totalQuantidadeProdutosSex[j];
                            control=true;
                            break;
                    }
               }
               if (control==false) {
                   totalNomesProdutosSex[linha] = RHItemListSex[i]; //get the element in column "item_code"
                   totalQuantidadeProdutosSex[linha] = RHItemList2Sex[i]; //get the element in column "item_code"
                    linha++;
               }
          
          } 
          
          
            DefaultListModel modelRestauranteTotaisSex = new DefaultListModel();
          for(j=0;j<totalProdutos;j++)  {
              if (totalQuantidadeProdutosSex[j]!=0)
              modelRestauranteTotaisSex.addElement(totalNomesProdutosSex[j] + " - " +  totalQuantidadeProdutosSex[j].toString()); 
          }
              
               
            
           jListSexTotal.setModel(modelRestauranteTotaisSex);     
           
            
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(FormEtapaI.this, err.getMessage());
        }
    }

    private void closeApplication() {
        dispose();
    }

    private void etapai() {
        try {    
            
            //Oferta em Armazem stock
                        
            Statement stmtProdutosTotais = con.createStatement();
            Statement stmtRestaurantesTotais = con.createStatement();
            Statement stmtQtdProdutosEmArmazem = con.createStatement();
            Statement stmtTipoProduto = con.createStatement();
            ResultSet rsProdutosTotais, rsQtdProdutosEmArmazem, rsRestaurantesTotais,
                    rsTipoProduto;
            
            String sql1 = "SELECT count(distinct idprodutos) FROM "+dbName+".produtos";
            rsProdutosTotais = stmtProdutosTotais.executeQuery(sql1);
            rsProdutosTotais.next();
            
            totalProdutos = rsProdutosTotais.getInt(1);
            //System.out.println("Total de Produtos Diferentes: "+ totalProdutos);
            
            stmtProdutosTotais.close();
            rsProdutosTotais.close();
            
            sql1 = "SELECT count(distinct idrestaurantes) FROM "+dbName+".restaurantes;";
            rsRestaurantesTotais = stmtRestaurantesTotais.executeQuery(sql1);
            rsRestaurantesTotais.next();
            
            totalRestaurantes = rsRestaurantesTotais.getInt(1);
            //System.out.println("Total de Restaurantes Diferentes: "+ totalRestaurantes);
           
            //stmtRestaurantesTotais.close();
            rsRestaurantesTotais.close();
            
             sql1 = "SELECT count(distinct idfornecedores) FROM "+dbName+".produtores;";
            rsRestaurantesTotais = stmtRestaurantesTotais.executeQuery(sql1);
            rsRestaurantesTotais.next();
            
            totalProdutores = rsRestaurantesTotais.getInt(1);
            //System.out.println("Total de Restaurantes Diferentes: "+ totalRestaurantes);
           
            stmtRestaurantesTotais.close();
            rsRestaurantesTotais.close();
            
            produtosArmazemStock = new int[totalProdutos];
           
            for (int i=1; i<=totalProdutos;i++) {
                sql1 = "SELECT sum(quantidade) FROM "+dbName+".stock "
                    + "INNER JOIN daquinta_teste.produtos ON stock.produtos_idprodutos=produtos.idprodutos"
                    + " WHERE " + dbName + ".produtos.tipo=2 AND ano="+ano+" AND produtos_idprodutos="+i;
                rsQtdProdutosEmArmazem = stmtQtdProdutosEmArmazem.executeQuery(sql1);
                rsQtdProdutosEmArmazem.next();
                produtosArmazemStock[i-1]=rsQtdProdutosEmArmazem.getInt(1);
                // stockProdutosTotal[i-1]=rsQtdProdutosEmArmazem.getInt(1);
                //System.out.println("quantidade em stock: "+ produtosArmazemStock[i-1]);
                rsQtdProdutosEmArmazem.close();
            } 
           
            stmtQtdProdutosEmArmazem.close();
            
           //fim Oferta em Armazem stock
            
            /*
             * 
             *   INICICIAÇÂO DE VARIAVEIS E LIGAÇÕES
             */
            
            Statement stmtQtdProdutosEncomendados = con.createStatement(); //Quantidade de produtos encomendados na semana
            Statement stmtProduto = con.createStatement(); //Produto
            Statement stmtQtdRestaurantesEncomendam = con.createStatement(); //Quantidade de Restaurantes que fizeram encomendas na semana
            Statement stmtRestaurante = con.createStatement(); //Restaurante
            Statement stmtDiasdeEncomenda = con.createStatement(); //Query para os dias que encomendou
            Statement stmtQuantidadesEncomendadas = con.createStatement(); //Query para as quantidade encomendadas
            Statement stmtProdutosDisponiveis = con.createStatement(); //Produtos disponiveis tanto frescos como armazenaveis
            Statement stmtQtdProdutosFrescos = con.createStatement(); //Quantidade de produtos frescos disponiveis no dia da seman
            Statement stmtQtdProdutoDiaCliente = con.createStatement(); //Quantidade de produto requerido por cada cliente no dia da semana
            
            Statement stmtQtdDeEncomendasDoProduto = con.createStatement();
            ResultSet rsQtdDeEncomendasDoProduto; 
            Statement stmtQtdEncomendadaDoProdutoNoDia = con.createStatement();
            ResultSet rsQtdEncomendadaDoProdutoNoDia;      
            Statement stmtSubConjuntoClientesEncomendas = con.createStatement();
            ResultSet rsSubConjuntoClientesEncomendas;   
            Statement stmtHistoricoEncomendas = con.createStatement();
            ResultSet rsHistoricoEncomendas;  
            Statement stmtHistoricoEncomendasEntregues = con.createStatement();
            ResultSet rsHistoricoEncomendasEntregues;
            Statement stmtSeHaProcura = con.createStatement(); 
            ResultSet rsSeHaProcura; 
            Statement stmtActualizaHistorico = con.createStatement(); 
            ResultSet rsActualizaHistorico; 
            
            ResultSet rsQtdProdutosEncomendados, rsProduto,  rsQtdRestaurantesEncomendam,  rsRestaurante, rsDiasdeEncomenda, 
                    rsQuantidadesEncomendadas, rsProdutosDisponiveis, rsQtdProdutosFrescos,
                    rsQtdProdutoDiaCliente;
            String [] diaSemana ={"qtdseg","qtdter","qtdqua","qtdqui","qtdsex"};
            
           quantidadeProdutoDisponibilizar = new int [totalProdutos][totalRestaurantes][5]; //x_ikd = quantidade de produto i a prepar no dia d para cliente k 
           ofertaProdutoDia = new int [totalProdutos][5];
           numeroDiasClienteProduto= new int[totalProdutos][totalRestaurantes];
           quantidadeClienteProduto= new int[totalProdutos][totalRestaurantes];
           ofertasDisponivelDiaSemanaFrescos= new int[totalProdutos][5];
           ofertasDisponivelDiaSemanaArmazenaveis= new int[totalProdutos][5];
           stockProdutosTotal= new int [totalProdutos][5]; 
           subConjuntoClientesEncomendas = new int  [totalProdutos][5][totalRestaurantes];
           historicoEncomendas = new int [totalProdutos][totalRestaurantes];
           historicoEncomendasEntregues = new int [totalProdutos][totalRestaurantes];        
           fraccaoEncomendas = new int [totalProdutos][totalRestaurantes];          
           int [][] vectorTemporal = new int  [totalProdutos][totalRestaurantes];  
           
           /*
             * INICIO ETAPA I
             * 
             */
             sql1 = "SELECT * FROM " + dbName + ".produtos";

                    //sql1 = "SELECT SUM("+diaSemana[dia]+") FROM " + dbName + ".producao_semanal";
                    rsTipoProduto = stmtTipoProduto.executeQuery(sql1);
             
            for(int d=0; d<5; d++) { //For each weekday (Segunda..Sexta)
                //System.out.println("Dia da Semana: "+ diaSemana[dia]);
                rsTipoProduto.beforeFirst();
              for (int i=1; i<=totalProdutos;i++) {  //For each product
                    //System.out.println("Produto: "+ rsProduto.getInt(1));
                   sql1 = "SELECT SUM("+diaSemana[d]+") FROM " + dbName + ".encomenda "
                                + "WHERE "+diaSemana[d]+">0 AND produtos_idprodutos="+i+" AND "
                                + "getWeekofYear="+ getWeekofYear+" AND YEAR(data)="+ano;
                            rsSeHaProcura = stmtSeHaProcura.executeQuery(sql1);
                            rsSeHaProcura.first();
                    if (rsSeHaProcura.getInt("SUM("+diaSemana[d]+")")>0) {
                        rsTipoProduto.next();

                        //System.out.println("Tipo Produto: "+ rsetapai7.getInt(1));

                        //If the product are fresh add to stock total
                        if (rsTipoProduto.getInt("tipo")==1) { //Fresh products
                            sql1 ="SELECT sum("+diaSemana[d]+") FROM " + dbName + ".producao_semanal "
                                    + "WHERE getWeekofYear="+ getWeekofYear+" AND YEAR(data)="+ano
                                    + " AND produtos_idprodutos="+i;
                            rsQtdEncomendadaDoProdutoNoDia = stmtQtdEncomendadaDoProdutoNoDia.executeQuery(sql1);
                            rsQtdEncomendadaDoProdutoNoDia.first();
                            stockProdutosTotal[i-1][d]=rsQtdEncomendadaDoProdutoNoDia.getInt("sum("+diaSemana[d]+")");
                        }
                        else {
                            sql1 ="SELECT sum("+diaSemana[d]+") FROM " + dbName + ".producao_semanal "
                                    + "WHERE getWeekofYear="+ getWeekofYear+" AND YEAR(data)="+ano
                                    + " AND produtos_idprodutos="+i;
                            rsQtdEncomendadaDoProdutoNoDia = stmtQtdEncomendadaDoProdutoNoDia.executeQuery(sql1);
                            rsQtdEncomendadaDoProdutoNoDia.first();                        
                            stockProdutosTotal[i-1][d]=produtosArmazemStock[i-1]+rsQtdEncomendadaDoProdutoNoDia.getInt("sum("+diaSemana[d]+")");;
                        }

                    if (stockProdutosTotal[i-1][d]>0) { //if are offer
                            sql1 = "SELECT SUM("+diaSemana[d]+") FROM " + dbName + ".encomenda "
                                + "WHERE "+diaSemana[d]+">0 AND produtos_idprodutos="+i+" AND "
                                + "getWeekofYear="+ getWeekofYear+" AND YEAR(data)="+ano;
                                rsQtdDeEncomendasDoProduto = stmtQtdDeEncomendasDoProduto.executeQuery(sql1);
                                rsQtdDeEncomendasDoProduto.first();

                            if (stockProdutosTotal[i-1][d]>=rsQtdDeEncomendasDoProduto.getInt("SUM("+diaSemana[d]+")")) {
                                for(int k=1;k<=totalRestaurantes;k++){
                                        sql1 = "SELECT sum("+diaSemana[d]+") FROM " + dbName + ".encomenda "
                                                + "WHERE getWeekofYear="+getWeekofYear+" AND YEAR(data)="+ano+" "
                                                + "AND produtos_idprodutos="+i+" AND restaurantes_idrestaurantes="+k;
                                        rsQuantidadesEncomendadas = stmtQuantidadesEncomendadas.executeQuery(sql1);
                                        rsQuantidadesEncomendadas.first();
                                        //total supply of orders
                                            quantidadeProdutoDisponibilizar[i-1][k-1][d]=rsQuantidadesEncomendadas.getInt("sum("+diaSemana[d]+")");
                                            stockProdutosTotal[i-1][d]-=quantidadeProdutoDisponibilizar[i-1][k-1][d];
                                    }

                            }
                            else { //if the offer is lowest that the order 
                                //Set of clients who ording the product i on day d 
                                    sql1 = "SELECT  DISTINCT(restaurantes_idrestaurantes), SUM("+diaSemana[d]+") FROM " + dbName + ".encomenda "
                                        + "WHERE getWeekofYear="+getWeekofYear+" AND YEAR(data)="+ano+" "
                                        + "AND produtos_idprodutos="+i+" AND "+diaSemana[d]+">0";
                                    rsSubConjuntoClientesEncomendas = stmtSubConjuntoClientesEncomendas.executeQuery(sql1);
                                    rsSubConjuntoClientesEncomendas.beforeFirst();
                                    int kk=1;
                                    while (rsSubConjuntoClientesEncomendas.next()) {
                                        subConjuntoClientesEncomendas[i-1][d][rsSubConjuntoClientesEncomendas.getInt("restaurantes_idrestaurantes") -1]=rsSubConjuntoClientesEncomendas.getInt("SUM("+diaSemana[d]+")");
                                    }  

                                for(int k=1;k<=totalRestaurantes;k++){

                                    sql1 = "SELECT SUM(qtdseg + qtdter + qtdqua + qtdqui + qtdsex) FROM " + dbName + ".encomenda "
                                            + "WHERE restaurantes_idrestaurantes="+k+" AND produtos_idprodutos="+i;
                                    rsHistoricoEncomendas = stmtHistoricoEncomendas.executeQuery(sql1);
                                    rsHistoricoEncomendas.first();
                                    historicoEncomendas[i-1][k-1]=rsHistoricoEncomendas.getInt("SUM(qtdseg + qtdter + qtdqua + qtdqui + qtdsex)");

                                    sql1 = "SELECT SUM(qtdseg + qtdter + qtdqua + qtdqui + qtdsex) FROM " + dbName + ".entrega_encomenda "
                                            + "WHERE restaurantes_idrestaurantes="+k+" AND produtos_idprodutos="+i;
                                    rsHistoricoEncomendasEntregues = stmtHistoricoEncomendasEntregues.executeQuery(sql1);
                                    rsHistoricoEncomendasEntregues.first();
                                    historicoEncomendasEntregues[i-1][k-1]=rsHistoricoEncomendasEntregues.getInt("SUM(qtdseg + qtdter + qtdqua + qtdqui + qtdsex)");

                                    if (historicoEncomendas[i-1][k-1]>0)
                                        fraccaoEncomendas[i-1][k-1]=(historicoEncomendas[i-1][k-1]-historicoEncomendasEntregues[i-1][k-1])/historicoEncomendas[i-1][k-1];                              
                                    else
                                        fraccaoEncomendas[i-1][k-1]=0;
                                        
                                }
                                bubbleSort(fraccaoEncomendas[i-1]); //ordering clients set in descending order
                                
                                boolean [] usados = new boolean [totalRestaurantes];
                                boolean usado;
                                //ording clients second fraccaoEncomendas
                                for (kk=1;kk<=fraccaoEncomendas.length;kk++) {
                                    for(int k=1;k<=totalRestaurantes;k++){
                                        if (fraccaoEncomendas[i-1][kk-1] == subConjuntoClientesEncomendas[i-1][d][k-1] && usados[k-1]==false) {
                                            vectorTemporal[i-1][kk-1]=k;
                                            usados[kk-1]=true;
                                            break;
                                        } 
                                    } 
                                }
                            int temporal; 
                            //System.out.println("Geral: "+stockProdutosTotal[i-1][d]);
                            kk=1;
                                while (stockProdutosTotal[i-1][d]>0 && kk-1<totalRestaurantes) { //do while stock on day is more that zero
                                    if (stockProdutosTotal[i-1][d] > subConjuntoClientesEncomendas[i-1][d][vectorTemporal[i-1][kk-1]]) 
                                    {
                                        quantidadeProdutoDisponibilizar[i-1][kk-1][d]=subConjuntoClientesEncomendas[i-1][d][vectorTemporal[i-1][kk-1]];

                                        //Actualizar historico de encomendas recebidas;

                                        stockProdutosTotal[i-1][d]=stockProdutosTotal[i-1][d]-subConjuntoClientesEncomendas[i-1][d][vectorTemporal[i-1][kk-1]];  
                                    }
                                    else
                                    {
                                        if (verificaEntragaTotalidade()==1) 
                                        {
                                            quantidadeProdutoDisponibilizar[i-1][kk-1][d]=0;
                                        }
                                        else
                                        {
                                            quantidadeProdutoDisponibilizar[i-1][kk-1][d]=stockProdutosTotal[i-1][d];
                                        }
                                    }

                                    kk++;
                                }
                            }
                        }
                    
                        
                    }
                   
                    
                    
                    
                    
                }
                
            }
            
             //Actualizar historico de
            for (int i=1; i<=totalProdutos;i++) {  //For each product    
                //System.out.println(x);
                for (int k=1;k<totalRestaurantes;k++)  {   
                    ResultSet rss = stmtActualizaHistorico.executeQuery("SELECT * FROM "+dbName+".entrega_encomenda") ; 

                    int x=0;
                    int y=0;
                    rss.last();
                    y=rss.getRow();
                    if (y==0){
                        x=1;
                    }else if (y != 0){
                        rss.last();
                        x=rss.getInt(1)+1;
                    }
                
                    for(int d=0; d<5; d++) { //For each weekday (Segunda..Sexta)
                    
                        if(diaSemana[d].equals("qtdseg")) 
                            stmtActualizaHistorico.executeUpdate("INSERT INTO "+dbName+".entrega_encomenda  VALUES ('"+x+"','" + i + "', '" + k + "', '" + quantidadeProdutoDisponibilizar[i-1][k-1][d] +  "', '0', "
                                    + "'0', '0', '0', '"+getWeekofYear+"', '"+dateFormat.format(date)+"', 'null')");
                        else {
                            stmtActualizaHistorico.executeUpdate("UPDATE "+dbName+".entrega_encomenda  SET "+diaSemana[d]+"='"+quantidadeProdutoDisponibilizar[i-1][k-1][d]+"' WHERE identrega_encomenda=" + x);
                        }       
                    } 
                }
            }
             stmtActualizaHistorico.close();
             //etapaII();   
                ArmazenaveisNovos(ofertasDisponivelDiaSemanaArmazenaveis);
             DoConnect();
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(FormEtapaI.this, err.getMessage());
        }
       
    }

    private void bubbleSort(int[] vector) {
        boolean houveTroca = true;
 
        while (houveTroca) {
                houveTroca = false;
                for (int i = 0; i < (vector.length)-1; i++){
                        if (vector[i] < vector[i+1]){
                                int variavelAuxiliar = vector[i+1];
                                vector[i+1] = vector[i];
                                vector[i] = variavelAuxiliar;
                                houveTroca = true;
                        }
                }
        }               
    }

    private void etapaII() {
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;

      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File ("C:\\archivo.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null)
            System.out.println(linea);
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
    }

    private void ArmazenaveisNovos(int[][] ofertasDisponivelDiaSemanaArmazenaveis1) {
        int cc_ik=0;
        quantidadeProdutoDiponibilizarDepoisT = new int[totalProdutos][totalRestaurantes];
                
       for(int i=0;i<totalProdutos;i++)
       {
           if (ofertasDisponivelDiaSemanaArmazenaveis1[4][i]>0)
           {
               for(int k=0;k<totalRestaurantes;k++)
               {
                   cc_ik=3;
                   //media de produto a disponibilizar em armazem
               }
               if (ofertasDisponivelDiaSemanaArmazenaveis1[4][i]>cc_ik)
               {
                   for(int k=0;k<totalRestaurantes;k++)
                    {
                        quantidadeProdutoDiponibilizarDepoisT[i][k]=cc_ik;
                    }
               }
               else
               {
                   for(int k=0;k<totalRestaurantes;k++)
                    {
                        quantidadeProdutoDiponibilizarDepoisT[i][k]=(cc_ik/(cc_ik)*ofertasDisponivelDiaSemanaArmazenaveis1[4][i]);
                    }
               }
               
           }
           else
           {
               for(int k=0;k<totalRestaurantes;k++)
                    {
                        quantidadeProdutoDiponibilizarDepoisT[i][k]=0;
                    }
           }
       }
    }

    private int verificaEntragaTotalidade() {
        try {
            
            String host = "jdbc:mysql://localhost:3306/" + dbName;
            String uName = "root";
            String uPass ="admin";
            con = DriverManager.getConnection(host, uName, uPass);
            
            stmt = con.createStatement();
            String sql = "SELECT * FROM restaurantes";
            ResultSet rs = stmt.executeQuery(sql);
            
            rs.next();
            
            return rs.getInt("totalidadeEncomenda");
            
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(FormEtapaI.this, err.getMessage());
        }
        return 0;
    }

    private void etapi_b() {
       
                            
      
       try {    
            
            //Oferta em Armazem stock
                        
            Statement stmtProdutosTotais = con.createStatement();
            Statement stmtRestaurantesTotais = con.createStatement();
            Statement stmtProdutoresTotais = con.createStatement();
            Statement stmtProdutos = con.createStatement();
            Statement stmtQtdProdutosEmArmazem = con.createStatement();
            Statement stmtTipoProduto = con.createStatement();
            Statement stmtSeHaProcura = con.createStatement();
            Statement stmtQtdEncomendadaDoProdutoNoDia  = con.createStatement();
            Statement stmtProducaoDiaria  = con.createStatement();
            Statement stmtQuantidadesEncomendadas = con.createStatement();
            Statement stmtHistoricoEncomendas = con.createStatement();
            Statement stmtHistoricoEncomendasEntregues = con.createStatement();
            Statement stmtQuantidadesEncomendadasL = con.createStatement();
            Statement stmtClienteQuerTudo = con.createStatement();
            Statement stmtConjuntosClientesEncomendamProduto = con.createStatement();
            
            ResultSet rsProdutosTotais, rsQtdProdutosEmArmazem, rsRestaurantesTotais,
                    rsTipoProduto, rsProdutoresTotais,rsQtdEncomendadaDoProdutoNoDia,
                    rsSeHaProcura, rsProdutos, rsProducaoDiaria, rsQuantidadesEncomendadas,
                    rsQuantidadesEncomendadasL, rsClienteQuerTudo, rsConjuntosClientesEncomendamProduto;
            
          
            
            String sql1 = "SELECT count(distinct idprodutos) FROM "+dbName+".produtos";
            rsProdutosTotais = stmtProdutosTotais.executeQuery(sql1);
            rsProdutosTotais.next();
            
            totalProdutos = rsProdutosTotais.getInt(1);
            stmtProdutosTotais.close();
            rsProdutosTotais.close();
            
            int T = getWeekofYear; // T Semana de Planeamento 
            int ms_T = getMonthogYear; // ms_T Mes planeamento
            double D = 4.36; // D numero medio de semanas por mes
            int d_0 = T-1; 
            int d_u = T;
            int [] P = new int[totalProdutos]; //conjuntoTotalProdutos 
            boolean [] Pf= new boolean[totalProdutos];//conjuntoProdutosNaoArmazenaveis;
            boolean [] Ps= new boolean[totalProdutos]; //conjuntoProdutosArmazenaveis;
            double [] B_i = new double[3]; 
            B_i[0]=5;//Batatas 5 meses 
            B_i[1]=5;//Cebolas 5 meses
            B_i[2]=1/D;//Cenouras 5 meses
            double [] oM_i = new double[3];
            oM_i[0]=2.4;//Batatas
            oM_i[1]=1.7;//Cebolas
            oM_i[2]=1.025;//Cenouras
            //conjuntoTotalRestaurantes
            int [] CLP;
            int [] CLS;
            boolean [] ClN_i= new boolean  [totalProdutos];
           
            //int [][] CL_id = new int [totalProdutos][5]; //subconjunto dos clientes CL
            
            int [] Fa = new int [totalProdutores];
            int [] F_aS;
            int [] F_aP;
            int [][] qa_id = new int[totalProdutos][5];
            int [][] of_id = new int[totalProdutos][5];
            int [][] total_c_ikd = new int [totalProdutos][5];
            int [][] Clord_id = new int [totalProdutos][5];
            
            
            sql1 = "SELECT tipo FROM "+dbName+".produtos";
            rsProdutos = stmtProdutos.executeQuery(sql1);
            rsProdutos.beforeFirst();
            
            int ii=1;
            while (rsProdutos.next() && ii<=totalProdutos)
            {
                //System.out.println("Produto " + ii);
                Ps[ii-1]=false;
                Pf[ii-1]=false;
                if(rsProdutos.getInt("tipo")==2)
                {
                    //System.out.println("Produto Armazenavel " + ii); 
                    Ps[ii-1]=true;
                }
                else{
                    //System.out.println("Produto Não Armazenavel " + ii);
                     Pf[ii-1]=true;
                }
                   
                ii++;
            }
            
            stmtProdutos.close();
            rsProdutos.close();
            
            sql1 = "SELECT count(distinct idrestaurantes) FROM "+dbName+".restaurantes;";
            rsRestaurantesTotais = stmtRestaurantesTotais.executeQuery(sql1);
            rsRestaurantesTotais.next();
            
            totalRestaurantes = rsRestaurantesTotais.getInt(1);
            //System.out.println("Total de Restaurantes Diferentes: "+ totalRestaurantes);
           
            stmtRestaurantesTotais.close();
            rsRestaurantesTotais.close();
            
            int [][][] x_ikd = new int [totalProdutos][totalRestaurantes][5];
            int [][][] x_ild = new int [totalProdutos][totalRestaurantes][5];
            int [][] y_ik = new int [totalProdutos][totalRestaurantes];
            int [][] cc_ik= new int [totalProdutos][totalRestaurantes];
            int [][] totalcc_ik= new int [totalProdutos][totalRestaurantes];
            int [][][] c_ikm = new int [totalProdutos][totalRestaurantes][12]; //estimativa da quantidade de produto
            int [][] q_ik = new int [totalProdutos][totalRestaurantes];
            int [][] qq_ik = new int [totalProdutos][totalRestaurantes];
            int [][] qq_il = new int [totalProdutos][totalRestaurantes];
            int [][] Hq_ik = new int [totalProdutos][totalRestaurantes];
            int [][][] c_ikd = new int [totalProdutos][totalRestaurantes][5];
            int [][][] c_ild = new int [totalProdutos][totalRestaurantes][5];
            int [] Cl = new int[totalRestaurantes]; 
            
            
             sql1 = "SELECT count(distinct idfornecedores) FROM "+dbName+".produtores;";
            rsProdutoresTotais = stmtProdutoresTotais.executeQuery(sql1);
            rsProdutoresTotais.next();
            
            totalProdutores = rsProdutoresTotais.getInt(1);
            //System.out.println("Total de Restaurantes Diferentes: "+ totalRestaurantes);
           
            stmtProdutoresTotais.close();
            rsProdutoresTotais.close();
            
            int [][] Fa_i = new int [totalProdutores][totalProdutos];
            int [][][] p_ijd = new int[totalProdutos][totalProdutores][5];
            int [][] soma_p_ijd = new int[totalProdutos][5];
            int [][][] qqa_ijd = new int[totalProdutos][totalProdutores][5];
            
             /*
             * 
             *   INICICIAÇÂO DE VARIAVEIS E LIGAÇÕES
             */
            
           
            String [] diaSemana ={"qtdseg","qtdter","qtdqua","qtdqui","qtdsex"};
            
           quantidadeProdutoDisponibilizar = new int [totalProdutos][totalRestaurantes][5]; //x_ikd = quantidade de produto i a prepar no dia d para cliente k 
           
//           System.out.println("Total Produtos: " + totalProdutos); 
//           System.out.println("Total Restaurantes: " + totalRestaurantes); 
//           System.out.println("Total Produtores: " + totalProdutores); 
            
            
            for (int i=1; i<=totalProdutos;i++) {  //For each product
                  
                if (Ps[i-1]==true)  of_id[i-1][0]=produtosArmazemStock(i-1);//qa_id[i-1][0]; 
                 
            }
            
//            for (int i=1; i<=totalProdutos;i++) {  //For each product
//                  if (Ps[i-1]==true) System.out.println("Oferta do dia:" + of_id[i-1][0]);
//            }
//            
//           
//            
            for(int d=0; d<5; d++) { //For each weekday (Segunda..Sexta)
                
                
              for (int i=1; i<=totalProdutos;i++) {  //For each product
                  //order
                    sql1 = "SELECT SUM("+diaSemana[d]+") FROM " + dbName + ".encomenda "
                                        + "WHERE "+diaSemana[d]+">0 AND produtos_idprodutos="+i+" AND "
                                        + "getWeekofYear="+ getWeekofYear+" AND YEAR(data)="+ano;
                    rsSeHaProcura = stmtSeHaProcura.executeQuery(sql1);
                    rsSeHaProcura.first();
                    int [][] CCL_id = new int[totalProdutos][5];  //Total da encomando do produto i no dia d
                    CCL_id[i-1][d]=rsSeHaProcura.getInt("SUM("+diaSemana[d]+")");
                    //System.out.println("Encomenda Produto: " + i +", dia "+ d + ", Qtd "+CL_id[i-1][d]);
                    rsSeHaProcura.close();
                    //offer
                  if (Ps[i-1]==true && d!=0)  of_id[i-1][d]=produtosArmazemStock(i);
                  else of_id[i-1][d]=of_id[i-1][0];
                  if (CCL_id[i-1][d]!=0) {
                      sql1 ="SELECT sum("+diaSemana[d]+") FROM " + dbName + ".producao_semanal "
                                    + "WHERE getWeekofYear="+ getWeekofYear+" AND YEAR(data)="+ano
                                    + " AND produtos_idprodutos="+i;
                      rsProducaoDiaria = stmtProducaoDiaria.executeQuery(sql1);
                      rsProducaoDiaria.first(); 
                      soma_p_ijd[i-1][d]= rsProducaoDiaria.getInt("sum("+diaSemana[d]+")");
                      //System.out.println("Oferta Diaria 1, Prod" + i +", dia "+ d + ", Qtd "+of_id[i-1][d]);
                      rsProducaoDiaria.close();
                      if (Pf[i-1]==true) //if the product is fresh
                      {
                            
                            of_id[i-1][d]=soma_p_ijd[i-1][d];
                            //System.out.println("Oferta Diaria Frescos, Prod" + i +", dia "+ d + ", Qtd "+of_id[i-1][d]);
                      }
                      else //if the product is storable
                      {  
                           of_id[i-1][d]= of_id[i-1][d]+soma_p_ijd[i-1][d];
                           //System.out.println("Oferta Diaria Armazenaveis, Prod" + i +", dia "+ d + ", Qtd "+of_id[i-1][d]);
                      }
                      if(of_id[i-1][d]>0)
                      {
                          if (of_id[i-1][d]>CCL_id[i-1][d])
                          {
                              for (int k=1;k<=totalRestaurantes;k++)
                              {
                                  sql1 = "SELECT sum("+diaSemana[d]+") FROM " + dbName + ".encomenda "
                                                + "WHERE getWeekofYear="+getWeekofYear+" AND YEAR(data)="+ano+" "
                                                + "AND produtos_idprodutos="+i+" AND restaurantes_idrestaurantes="+k;
                                  rsQuantidadesEncomendadas = stmtQuantidadesEncomendadas.executeQuery(sql1);
                                  rsQuantidadesEncomendadas.first();
                                  c_ikd[i-1][k-1][d]=rsQuantidadesEncomendadas.getInt("sum("+diaSemana[d]+")");
                                  x_ikd[i-1][k-1][d]=c_ikd[i-1][k-1][d];
                                  of_id[i-1][d]-=c_ikd[i-1][k-1][d];
                                   if (Ps[i-1]==true) ActualizarprodutosArmazemStock(i,c_ikd[i-1][k-1][d]);
                                  //System.out.println("Oferta Diaria 2, Prod" + i +", dia "+ d + ", Qtd "+of_id[i-1][d]);
                              }
                          }
                          else
                          {
                              
                              
                              /*
                               * ERRO de formulação para a classe ordenada  !!!!!
                               */
//                              //System.out.println("Lista Ordenada " + Clord_id[i-1][d]);
//                              sql1 = "SELECT produtor_idprodutor FROM " + dbName + ".encomenda "
//                                                + "WHERE getWeekofYear="+getWeekofYear+" AND YEAR(data)="+ano+" "
//                                                + "AND produtos_idprodutos="+i+" AND " + diaSemana[d] ;
//                                  rsConjuntosClientesEncomendamProduto = stmtConjuntosClientesEncomendamProduto.executeQuery(sql1);
//                                  rsConjuntosClientesEncomendamProduto.first();
//                                  boolean [][][] CL_id = new boolean [totalProdutos][5][totalRestaurantes]; //subconjunto dos clientes CL
//                                  
//                                  while (rsConjuntosClientesEncomendamProduto.next()) {
//                                    for (int k=1;k<=totalRestaurantes;k++)
//                                    {
//                                        if(rsConjuntosClientesEncomendamProduto.getInt("produtor_idprodutor")==k) CL_id[i-1][d][k-1]=true;
//                                    }
//                                    
//                                  }
                                      
//                             Clord_id[i-1][d]=OrdenarDecrescenteSegundoHqik(i, d, CL_id[i-1][d]);
                              int l=1;
                              while (of_id[i-1][d]>0 && l>totalRestaurantes) //&& Clord_id[i-1][d]!=0
                              {
                                  //int primeiroElemento = Clord_id[i-1][d];
                                  
                                  sql1 = "SELECT sum("+diaSemana[d]+") FROM " + dbName + ".encomenda "
                                                + "WHERE getWeekofYear="+getWeekofYear+" AND YEAR(data)="+ano+" "
                                                + "AND produtos_idprodutos="+i+" AND restaurantes_idrestaurantes="+l;
                                  rsQuantidadesEncomendadasL = stmtQuantidadesEncomendadasL.executeQuery(sql1);
                                  rsQuantidadesEncomendadasL.first();
                                  c_ild[i-1][l-1][d]=rsQuantidadesEncomendadasL.getInt("sum("+diaSemana[d]+")");
                                  
                                  if (of_id[i-1][d]>CCL_id[i-1][d])
                                  {
                                      
                                      x_ikd[i-1][l-1][d]=c_ild[i-1][l-1][d];
                                      of_id[i-1][d]-=x_ikd[i-1][l-1][d];
                                  }
                                  else 
                                  {
                                      sql1 = "SELECT totalidadeEncomenda FROM daquinta_teste.restaurantes WHERE idrestaurantes="+l;
                                    rsClienteQuerTudo = stmtClienteQuerTudo.executeQuery(sql1);
                                    rsClienteQuerTudo.first();
                                      if (rsClienteQuerTudo.getInt("totalidadeEncomenda")==1) // if the producer wont receive all
                                      {
                                          x_ikd[i-1][l-1][d]=0;
                                          qq_il[i-1][l]+=c_ild[i-1][l-1][d];
                                      }
                                      else
                                      {
                                          x_ikd[i-1][l-1][d]=of_id[i-1][d];
                                          qq_il[i-1][l-1]+=c_ild[i-1][l-1][d]-x_ikd[i-1][l-1][d];
                                      }
                                  }
                                  
                                  l++;
                              }
                              if(Clord_id[i-1][d]!=0)
                              {
                                  for(int k=1;k<=totalRestaurantes;k++)
                                  {
                                      x_ikd[i-1][k-1][d]=0;
                                      qq_ik[i-1][k-1]+=c_ikd[i-1][k-1][d];
                                  }
                              }
                          }
                      }
                      for(int k=1;k<=totalRestaurantes;k++)
                        {
                            q_ik[i-1][k-1]+=c_ikd[i-1][k-1][d];
                            Hq_ik[i-1][k-1]=0;//qq_ik[i-1][k-1]/q_ik[i-1][k-1];
                        }
                  }
              }
            }
                   
            //ArmazenaveisNovos2(Ps,of_id,Cl,B_i,D,y_ik,cc_ik,B_i,D,cc_ik,oM_i);
            for (int d=0;d<5;d++) 
            {
                for (int i=1; i<=totalProdutos;i++) {
                    for (int k=1; k<=totalRestaurantes;k++) {
                        quantidadeProdutoDisponibilizar[i-1][k-1][d]=x_ikd[i-1][k-1][d];
                    }
                }
            }
            DoConnect();
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(FormEtapaI.this, err.getMessage());
        }
       
    }

    private void ArmazenaveisNovos2(boolean[] Ps, int[][] of_id, int[] Cl, double[] B_i, double D, int[][] y_ik, int[][] cc_ik, double[] B_i2, double D2, int[][] cc_ik2, double[] oM_i) {
        int totalcc_ik=0;
        for (int i=1; i<=totalProdutos;i++) { 
            int aR=0;
            if(Ps[i-1]==true)
            {
                if(of_id[i-1][4]>0)
                {
                   
                    for(int k=1;k<=totalRestaurantes;k++)
                        {
                            cc_ik[i-1][k-1]=1;//(int) (((double)cc_ik2[i-1][k-1])/(B_i[i-1]*D)*oM_i[aR]);
                            totalcc_ik+= cc_ik[i-1][k-1];
                        }
                    if(of_id[i-1][4]>totalcc_ik)
                    {
                        for(int k=0;k<totalRestaurantes;k++)
                        {
                            y_ik[i-1][k-1]=cc_ik[i-1][k-1];
                        }
                    }
                    else
                    {
                        for(int k=1;k<=totalRestaurantes;k++)
                        {
                            y_ik[i-1][k-1]=cc_ik[i-1][k-1]/totalcc_ik*of_id[i-1][4];
                        }
                    }
                }
                else
                {
                    for(int k=1;k<=totalRestaurantes;k++)
                        {
                            y_ik[i-1][k-1]=0;
                        }
                }
                aR++;
            }
        }
    }

    private int produtosArmazemStock(int i) {
       // System.out.println("Metodo Armazem produto" + i);
       try{
            
            Statement stmtQtdProdutosEmArmazem = con.createStatement();
                ResultSet rsQtdProdutosEmArmazem;
                produtosArmazemStock = new int[totalProdutos];
                String sql1 = "SELECT SUM(quantidade) FROM "+dbName+".stock "
                + "INNER JOIN daquinta_teste.produtos ON stock.produtos_idprodutos=produtos.idprodutos"
                + " WHERE " + dbName + ".produtos.tipo=2 AND produtos_idprodutos="+i;
                rsQtdProdutosEmArmazem = stmtQtdProdutosEmArmazem.executeQuery(sql1);
                rsQtdProdutosEmArmazem.first();
                int qtd;
                qtd = rsQtdProdutosEmArmazem.getInt("SUM(quantidade)");
                //System.out.println("qtd: " + qtd+ " do Produto " + i);
                rsQtdProdutosEmArmazem.close();
          
            return qtd;
      
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(FormEtapaI.this, err.getMessage());
        }
       return 0;
    }

    private void ActualizarprodutosArmazemStock(int i, int par) {
         System.out.println("Metodo Armazem produto" + i);
       try{
            
            Statement stmtQtdProdutosEmArmazem = con.createStatement();
            Statement stmtQtd2 = con.createStatement();
            ResultSet rsQtdProdutosEmArmazem;
            ResultSet rss = stmtQtd2.executeQuery("SELECT * FROM "+dbName+".stock") ;
            //System.out.println("Hora e data:" + dateFormat2.format(date));
            int x=0;
            int y=0;
            rss.last();
            y=rss.getRow();
            if (y==0){
                x=1;
            }else if (y != 0){
                rss.last();
                x=rss.getInt(1)+1;
            }
            //System.out.println("Xxx:" + x);
            stmtQtdProdutosEmArmazem.executeUpdate("INSERT INTO "+dbName+".stock VALUES ('"+x+"','" + 
                i + "', '0', '" + par  + "', '" +
                ano + "', '" + getMonthogYear + "')");
            //stmtQtdProdutosEmArmazem.executeUpdate("INSERT INTO "+dbName+".stock  VALUES ('"+x+"','" + i + "', '" + 88 + "', '" + (par*(-1)) +  "', '"+ ano + "', '"+ getMonthogYear +"')");
            
      
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(FormEtapaI.this, err.getMessage());
        }
    }

    private int[][] OrdenarDecrescenteSegundoHqik(int i, int d, boolean[] par) {
        int [][] Hq_ik = new int [totalProdutos][totalRestaurantes];
        int [][] Clord_id = new int [totalProdutos][5];
        try {
            Statement stmtHistoricoEncomendas = con.createStatement();
            Statement stmtHistoricoEncomendasEntregues = con.createStatement();
            ResultSet rsHistoricoEncomendas,rsHistoricoEncomendasEntregues;
            
            
            
             for(int k=1;k<=totalRestaurantes;k++){
                    String sql1 = "SELECT SUM(qtdseg + qtdter + qtdqua + qtdqui + qtdsex) FROM " + dbName + ".encomenda "
                            + "WHERE restaurantes_idrestaurantes="+k+" AND produtos_idprodutos="+i;
                    rsHistoricoEncomendas = stmtHistoricoEncomendas.executeQuery(sql1);
                    rsHistoricoEncomendas.first();
                    historicoEncomendas[i-1][k-1]=rsHistoricoEncomendas.getInt("SUM(qtdseg + qtdter + qtdqua + qtdqui + qtdsex)");

                    sql1 = "SELECT SUM(qtdseg + qtdter + qtdqua + qtdqui + qtdsex) FROM " + dbName + ".entrega_encomenda "
                            + "WHERE restaurantes_idrestaurantes="+k+" AND produtos_idprodutos="+i;
                    rsHistoricoEncomendasEntregues = stmtHistoricoEncomendasEntregues.executeQuery(sql1);
                    rsHistoricoEncomendasEntregues.first();
                    historicoEncomendasEntregues[i-1][k-1]=rsHistoricoEncomendasEntregues.getInt("SUM(qtdseg + qtdter + qtdqua + qtdqui + qtdsex)");

                    if (historicoEncomendas[i-1][k-1]>0)
                        Hq_ik[i-1][k-1]=(historicoEncomendas[i-1][k-1]-historicoEncomendasEntregues[i-1][k-1])/historicoEncomendas[i-1][k-1];                              
                    else
                        Hq_ik[i-1][k-1]=0;
                }
                
             
                bubbleSort(Hq_ik[i-1]);
                
                //System.out.println("Lista Ordenada2 " + Clord_id[i-1][d]);
                
                return Hq_ik;
               
        } 
        catch (SQLException err) {
            JOptionPane.showMessageDialog(FormEtapaI.this, err.getMessage());
        }
        return Hq_ik;
    }
}
