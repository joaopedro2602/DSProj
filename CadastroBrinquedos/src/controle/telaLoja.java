/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import conexao.Conexao;// Importa o packege e a classe
import javax.swing.JOptionPane;// importa o pacote do JOptionPane
import javax.swing.table.DefaultTableModel;// para reconhecimento da Jtable
import java.sql.*;// para reconhecimento dos comandos SQL

public class telaLoja extends javax.swing.JFrame {

    Conexao con_cliente;

    public telaLoja() {
        initComponents();
        con_cliente = new Conexao();
        con_cliente.conectaRest();
        con_cliente.executaSQL("select * from tblbrinquedos order by id");
        preencherTabela();
        posicionarRegistro();
        tblBrinquedos.setAutoCreateRowSorter(true);// ativa a classificação 
        //ordenada da tabela
    }

    public void preencherTabela() {
        //declara o tamanho maximo que cada coluna irá suportar
        tblBrinquedos.getColumnModel().getColumn(0).setPreferredWidth(8);
        tblBrinquedos.getColumnModel().getColumn(1).setPreferredWidth(30);
        tblBrinquedos.getColumnModel().getColumn(2).setPreferredWidth(11);
        tblBrinquedos.getColumnModel().getColumn(3).setPreferredWidth(14);
        tblBrinquedos.getColumnModel().getColumn(4).setPreferredWidth(14);
        tblBrinquedos.getColumnModel().getColumn(5).setPreferredWidth(30);
        tblBrinquedos.getColumnModel().getColumn(6).setPreferredWidth(30);

        DefaultTableModel modelo = (DefaultTableModel) tblBrinquedos.getModel();
        modelo.setNumRows(0);

        try {
            //adiciona os dados do banco de dados em cada linha
            con_cliente.resultset.beforeFirst();
            while (con_cliente.resultset.next()) {
                modelo.addRow(new Object[]{
                    con_cliente.resultset.getString("id"),
                    con_cliente.resultset.getString("nome"),
                    con_cliente.resultset.getString("cat"),
                    con_cliente.resultset.getString("preco"),
                    con_cliente.resultset.getString("datadd"),
                    con_cliente.resultset.getString("descr"),
                    con_cliente.resultset.getString("quant"),});
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,
                    "\n Erro ao listar dados da tabela!! :\n " + erro,
                    "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void posicionarRegistro() {
        //posiciona o seletor no primeiro registro e mostra os dados
        try {
            con_cliente.resultset.first();//posicionar no 1° registro da tabela

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,
                    "Não foi possível posicionar no primeiro registro: " + erro,
                    "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_pesquisa = new javax.swing.JTextField();
        btnComprar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBrinquedos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Pesquisa por nome do Brinquedo:");

        txt_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_pesquisaActionPerformed(evt);
            }
        });
        txt_pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_pesquisaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_pesquisaKeyReleased(evt);
            }
        });

        btnComprar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnComprar.setText("Comprar");
        btnComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComprarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel2.setText("Loja de Brinquedos");

        tblBrinquedos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Categoria", "Preço", "Data de Adição", "Descrição", "Quantidade"
            }
        ));
        jScrollPane1.setViewportView(tblBrinquedos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addComponent(btnComprar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(170, 170, 170))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(554, 554, 554)
                .addComponent(btnComprar)
                .addGap(32, 32, 32))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(131, 131, 131)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(75, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pesquisaActionPerformed

    private void txt_pesquisaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesquisaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pesquisaKeyPressed

    private void txt_pesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pesquisaKeyReleased
        //campo responvael por pesquisar um registro a partir do nome
        try {
            String pesquisa = "select * from tblbrinquedos where nome like '"
                    + txt_pesquisa.getText() + "%'";
            con_cliente.executaSQL(pesquisa);

            if (con_cliente.resultset.first()) {
                preencherTabela();
            } else {
                JOptionPane.showMessageDialog(null,
                        "\n Não existe dados com este paramêtro!!",
                        "Mensagem do Programa",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null,
                    "\n Os dados digitados não foram localizados!! :\n "
                    + errosql, "Mensagem do Programa",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_txt_pesquisaKeyReleased

    private void btnComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComprarActionPerformed
        telaExibirDet mostrar_detalhes = new telaExibirDet();
        int linha_selecionada = tblBrinquedos.getSelectedRow();

        String cod;
        
        String nome;
        
        int quant;
        
        String preco;

        String descr;
        
        cod = tblBrinquedos.getValueAt(linha_selecionada, 0).toString();

        nome = tblBrinquedos.getValueAt(linha_selecionada, 1).toString();

        preco = tblBrinquedos.getValueAt(linha_selecionada, 3).toString();
        
        quant = Integer.parseInt(tblBrinquedos.getValueAt(linha_selecionada, 6).toString());

        descr = tblBrinquedos.getValueAt(linha_selecionada, 5).toString();

        mostrar_detalhes.cod = cod;
        mostrar_detalhes.lblNome.setText(nome);
        mostrar_detalhes.lblPreco.setText(preco);
        mostrar_detalhes.quant = quant;
        mostrar_detalhes.lblDet.setText(descr);

        mostrar_detalhes.setVisible(true);
        dispose();


    }//GEN-LAST:event_btnComprarActionPerformed

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
            java.util.logging.Logger.getLogger(telaLoja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaLoja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaLoja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaLoja.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaLoja().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComprar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBrinquedos;
    private javax.swing.JTextField txt_pesquisa;
    // End of variables declaration//GEN-END:variables
}
