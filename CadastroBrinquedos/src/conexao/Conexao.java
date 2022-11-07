/*
 * Essa Classe será responsavel pela conesão com o MySql
 * terá 3 metodos:
 * abertura da conexão
 * fechamaneto da conexão
 * e execução de comandos SQL
 */
package conexao;

import javax.swing.JOptionPane;
import java.sql.*; // responsavel por executar os comandos SQL no Ambinte Java

/**
 * @author Victor Roma
 */
public class Conexao {

    // Define o Driver MsSql para aos dados
    final private String driver = "com.mysql.jdbc.Driver";
    // acesso ao bd clientes no servidor - easyphp
    final private String url = "jdbc:mysql://localhost/lojabrinquedos";
    // usúari do MySql -
    final private String usuario = "root";
    // senha do MySql - easyphp
    final private String senha = "";
    // variavel que armazenará a conexão aberta
    private Connection conexao;
    // variavel para execução dos comandos SQL dentro do ambiente Java
    public Statement statemant;
    // variavel que armazenará o resultado da execução de um comando SQL
    public ResultSet resultset;

    public boolean conecta() {
        //cria variavel boolean verdadeira
        boolean result = true;
        //tenta estabelecer uma conexao com o banco de dados 
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
            JOptionPane.showMessageDialog(null, "Conexão estabelecida",
                    "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException Driver) {
            JOptionPane.showMessageDialog(null,
                    "Driver não localizado" + Driver, "Mensagem de Programa",
                    JOptionPane.INFORMATION_MESSAGE);
            result = false;
        } catch (SQLException Fonte) {
            JOptionPane.showMessageDialog(null,
                    "Fontes de dados não localizada"
                    + Fonte, "Mensagem de Programa",
                    JOptionPane.INFORMATION_MESSAGE);
            result = false;
        }
        //retorna a varivael boolean
        return result;
    }
    
    public boolean conectaRest() {
        //cria variavel boolean verdadeira
        boolean result = true;
        //tenta estabelecer uma conexao com o banco de dados 
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, usuario, senha);
            
        } catch (ClassNotFoundException Driver) {
            JOptionPane.showMessageDialog(null,
                    "Driver não localizado" + Driver, "Mensagem de Programa",
                    JOptionPane.INFORMATION_MESSAGE);
            result = false;
        } catch (SQLException Fonte) {
            JOptionPane.showMessageDialog(null,
                    "Fontes de dados não localizada"
                    + Fonte, "Mensagem de Programa",
                    JOptionPane.INFORMATION_MESSAGE);
            result = false;
        }
        //retorna a varivael boolean
        return result;
    }

    public void desconecta() {
        //metodo feito para desconectar com o banco de dados
        try {
            conexao.close();
            JOptionPane.showMessageDialog(null,
                    "Conexão com o banco fechada", "Mensagem de Programa",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException fecha) {

        }
    }

    public void executaSQL(String sql) {
        //executa o SQL e
        //permite com que os comandos sql sejam aceitos no ambiente java
        try {
            statemant = conexao.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultset = statemant.executeQuery(sql);
        } catch (SQLException excecao) {
            JOptionPane.showMessageDialog(null,
                    "Erro no comando SQL! \n Erro: "
                    + excecao, "Mensagem de Programa",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
