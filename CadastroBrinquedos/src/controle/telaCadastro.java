/*
 * Click nbfs://nbhost/SystemFileSystem/
Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/
Templates/GUIForms/JFrame.java to edit this template
 */
package controle;

import conexao.Conexao;// Importa o packege e a classe
import javax.swing.JOptionPane;// importa o pacote do JOptionPane
import javax.swing.table.DefaultTableModel;// para reconhecimento da Jtable
import java.sql.*;// para reconhecimento dos comandos SQL

/**
 *
 * @author dti
 */
public class telaCadastro extends javax.swing.JFrame {

    Conexao con_cliente;

    public telaCadastro() {
        //instancia a classe conexao, estabelece a conexao com o banco de dados 
        //e preeche a tabela com os dados do banco de dados
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
            mostrar_Dados(); //chama o método que ira buscar o dado da tabela
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,
                    "Não foi possível posicionar no primeiro registro: " + erro,
                    "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void mostrar_Dados() {
        //metodo criado para mostrar o dados nos campos 
        try {
            txtId.setText(con_cliente.resultset.getString("id"));
            txtNome.setText(con_cliente.resultset.getString("nome"));
            txtCat.setText(con_cliente.resultset.getString("cat"));
            txtPreco.setText(con_cliente.resultset.getString("preco"));
            txtAdd.setText(con_cliente.resultset.getString("datadd"));
            txtDescr.setText(con_cliente.resultset.getString("descr"));
            txtQuant.setText(con_cliente.resultset.getString("quant"));
            
            
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não localizou dados: " + erro,
                    "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

//    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {
//        //metodo que mostra os dados de ua linha selecionada nos capos de texto
//        int linha_selecionada = tblClientes.getSelectedRow();
//        txtId.setText(tblClientes.
//                getValueAt(linha_selecionada, 0).toString());
//        txtNome.setText(tblClientes.
//                getValueAt(linha_selecionada, 1).toString());
//        txtCat.setText(tblClientes.
//                getValueAt(linha_selecionada, 2).toString());
//        txtPreco.setText(tblClientes.
//                getValueAt(linha_selecionada, 3).toString());
//
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCodigo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblNasc = new javax.swing.JLabel();
        lblFone = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtCat = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBrinquedos = new javax.swing.JTable();
        btnPrimeiroRegistro = new javax.swing.JButton();
        btnVoltarUmRegistro = new javax.swing.JButton();
        btnAvancarUmRegistro = new javax.swing.JButton();
        btnUltimoRegistro = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_pesquisa = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtQuant = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDescr = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtAdd = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblCodigo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblCodigo.setText("Id:");

        lblNome.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNome.setText("Nome:");

        lblNasc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNasc.setText("Categoria:");

        lblFone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblFone.setText("Preço:");

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        tblBrinquedos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "Categoria", "Preço", "Quantidade", "Descrição", "Data de Adição"
            }
        ));
        jScrollPane1.setViewportView(tblBrinquedos);

        btnPrimeiroRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/resultset_first.png"))); // NOI18N
        btnPrimeiroRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeiroRegistroActionPerformed(evt);
            }
        });

        btnVoltarUmRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/resultset_previous.png"))); // NOI18N
        btnVoltarUmRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarUmRegistroActionPerformed(evt);
            }
        });

        btnAvancarUmRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/resultset_next.png"))); // NOI18N
        btnAvancarUmRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvancarUmRegistroActionPerformed(evt);
            }
        });

        btnUltimoRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/resultset_last.png"))); // NOI18N
        btnUltimoRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoRegistroActionPerformed(evt);
            }
        });

        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/disk.png"))); // NOI18N
        btnCadastrar.setToolTipText("");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/add.png"))); // NOI18N
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/application_edit.png"))); // NOI18N
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/application_delete.png"))); // NOI18N
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

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

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/door_in.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Quantidade:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Descrição do produto:");

        txtDescr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescrActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Data de Adição:");

        try {
            txtAdd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtDescr)
                        .addGap(66, 66, 66))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCodigo)
                                    .addComponent(lblNome)
                                    .addComponent(lblNasc)
                                    .addComponent(lblFone)
                                    .addComponent(jLabel2))
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPreco)
                                    .addComponent(txtCat)
                                    .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                                    .addComponent(txtQuant)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnPrimeiroRegistro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnVoltarUmRegistro)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnAvancarUmRegistro)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnUltimoRegistro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnNovo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCadastrar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAlterar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnExcluir)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1))
                                    .addComponent(jScrollPane1))
                                .addGap(66, 66, 66))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigo)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txt_pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNome)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNasc)
                            .addComponent(txtCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFone)
                            .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPrimeiroRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVoltarUmRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAvancarUmRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnUltimoRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtDescr, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnUltimoRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoRegistroActionPerformed
        //botão responsavel por mostrar o ultimo registro da tabela
        try {
            con_cliente.resultset.last();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,
                    "não foi possivel posicionar no último registro" + erro);
        }
    }//GEN-LAST:event_btnUltimoRegistroActionPerformed

    private void btnAvancarUmRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancarUmRegistroActionPerformed
        //botão responsavel por mostrar o próximo registro da tabela
        try {
            int linha = con_cliente.resultset.getRow();
            int gntlinha = tblBrinquedos.getRowCount();
            if (linha == gntlinha) {
                con_cliente.resultset.last();
            } else {
                con_cliente.resultset.next();
            }
//            con_cliente.resultset.next();
            mostrar_Dados();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,
                    "não foi possivel posicionar no proximo registro" + erro);
        }
    }//GEN-LAST:event_btnAvancarUmRegistroActionPerformed

    private void btnVoltarUmRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarUmRegistroActionPerformed
        //botão responsavel por mostrar registro anterior da tabela
        try {
            int linha = con_cliente.resultset.getRow();

            if (linha == 1) {
                con_cliente.resultset.first();
            } else {
                con_cliente.resultset.previous();
            }
//            con_cliente.resultset.previous();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,
                    "não foi possivel posicionar no registro anterior" + erro);
        }
    }//GEN-LAST:event_btnVoltarUmRegistroActionPerformed

    private void btnPrimeiroRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroRegistroActionPerformed
        //botão responsavel por mostrar o primeiro registro da tabela
        try {
            con_cliente.resultset.first();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,
                    "não foi possivel acessar o primeiro registro" + erro);
        }
    }//GEN-LAST:event_btnPrimeiroRegistroActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        //botão responsavel por apagar todos os dados apresentados nos campos de
        //texto
        txtId.setText("");
        txtNome.setText("");
        txtCat.setText("");
        txtPreco.setText("");
        txtAdd.setText("");
        txtDescr.setText("");
        txtQuant.setText("");
        
        txtId.requestFocus();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        //atribui os valores apresentados nos campos de texto à variaveis
        String nome = txtNome.getText();
        String cat = txtCat.getText();
        String preco = txtPreco.getText();
        String data = txtAdd.getText();
        String descr = txtDescr.getText();
        String quant = txtQuant.getText();
        
        

        //atribui valores aos campos baseando-se nas variaveis
        try {
            String insert_sql = "insert into tblbrinquedos (nome,cat, preco, datadd, descr, quant"
                    + ") values ('" + nome + "','" + cat + "','"
                    + preco + "','" +data+
                    "','"+descr+"','"+quant+"')";
            con_cliente.statemant.executeUpdate(insert_sql);
            JOptionPane.showMessageDialog(null,
                    "Gravação realizada com sucesso!!", "Mensagem do Programa",
                    JOptionPane.INFORMATION_MESSAGE);
            con_cliente.executaSQL("select * from tblbrinquedos order by id");
            con_cliente.resultset.first();
            preencherTabela();
            posicionarRegistro();
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Erro na gravação: \n"
                    + errosql, "Mensagem do Programa",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        //atribui os valores apresentados nos campos de texto à variaveis
        String nome = txtNome.getText();
        String cat = txtCat.getText();
        String preco = txtPreco.getText();
        String descr = txtCat.getText();
        String quant = txtNome.getText();

        String sql = "";
        String msg = "";

        try {
            //se não haver um codigo ele irá criar um novo registro
            if (txtId.getText().equals("")) {
                sql = "insert into tblbrinquedos (nome,cat, preco, descr, quant)"
                        + " values ('" + nome + "','" + cat + "','"
                    + preco +"','"+descr+"','"+quant+"')";
                msg = "Gravação de um novo registro";
                //se houver um codigo ele irá alterar o registro existente
            } else {
                sql = "update tblbrinquedos set "
                        + "nome='" + nome 
                        + "',cat='" + cat 
                        + "', preco='" + preco
                        + "', descr='" + descr
                        + "', quant='" + quant
                        + "' where id = " + txtId.getText();
                msg = "Alteração de registro";
            }

            con_cliente.statemant.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, msg + "realizada com sucesso!!",
                    "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);

            con_cliente.executaSQL("select * from tblbrinquedos order by id");
            con_cliente.resultset.first();
            preencherTabela();
            posicionarRegistro();

        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "\n Erro na gravação: \n"
                    + errosql, "Mensagem do Programa",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String sql = "";
        //botão responsavel por excluir um registro
        try {
            int resposta = JOptionPane.showConfirmDialog(rootPane,
                    "Deseja excluir o registro: ", "Confirmar Excluisão",
                    JOptionPane.YES_NO_OPTION, 3);
            if (resposta == 0) {
                sql = "delete from tblbrinquedos where id = " + txtId.getText();
                int excluir = con_cliente.statemant.executeUpdate(sql);
                if (excluir == 1) {
                    JOptionPane.showMessageDialog(null,
                            "Exclusão realizada com sucesso!!",
                            "Mesagem do Programa",
                            JOptionPane.INFORMATION_MESSAGE);
                    con_cliente.executaSQL("select * from tblbrinquedos order by id");
                    con_cliente.resultset.first();
                    posicionarRegistro();
                    preencherTabela();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Operação cancelada pelo usuário!!",
                            "Mensagem do Programa",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (SQLException excecao) {
            JOptionPane.showMessageDialog(null,
                    "Erro na exclusão: " + excecao,
                    "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void txt_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_pesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_pesquisaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void txtDescrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescrActionPerformed

    private void txtAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddActionPerformed

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
            java.util.logging.Logger.getLogger(telaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaCadastro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaCadastro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnAvancarUmRegistro;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPrimeiroRegistro;
    private javax.swing.JButton btnUltimoRegistro;
    private javax.swing.JButton btnVoltarUmRegistro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblFone;
    private javax.swing.JLabel lblNasc;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTable tblBrinquedos;
    private javax.swing.JFormattedTextField txtAdd;
    private javax.swing.JTextField txtCat;
    private javax.swing.JTextField txtDescr;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQuant;
    private javax.swing.JTextField txt_pesquisa;
    // End of variables declaration//GEN-END:variables
}
