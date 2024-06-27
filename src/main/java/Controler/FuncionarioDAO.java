package Controler;

import Model.Funcionario;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;


public class FuncionarioDAO {
    static String url = "jdbc:mysql://localhost:3306/hotel";
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String user = "root";
    static String senha = "suasenha";

    public void inserirF(Funcionario funcionario){
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName(driver);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        try {
            conn = DriverManager.getConnection(url, user, senha);
            String sql1 = "INSERT INTO Funcionario(nome, telefone, cpf) VALUES(?, ?, ?);";
            ps = conn.prepareStatement(sql1);
            ps.setString(1, funcionario.getNome());
            ps.setInt(2, funcionario.getTelefone());
            ps.setInt(3, funcionario.getCpf());
            ps.execute();
            ps.close();
            conn.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public Funcionario buscarF(int numFuncionario) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Funcionario funcionario = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, senha);
            String sql = "SELECT * FROM Funcionario WHERE numFuncionario = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, numFuncionario);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setNome(rs.getString("nome"));
                funcionario.setNumFuncionario(rs.getInt("numFuncionario"));
                funcionario.setTelefone(rs.getInt("telefone"));
                funcionario.setCpf(rs.getInt("cpf"));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return funcionario;
    }
        
    public void atualizarF(Funcionario funcionario) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, senha);
            String sql = "UPDATE Funcionario SET nome = ?, numFuncionario = ?, telefone = ?, cpf = ? WHERE numFuncionario = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, funcionario.getNome());
            ps.setInt(2, funcionario.getNumFuncionario());
            ps.setInt(3, funcionario.getTelefone());
            ps.setInt(4, funcionario.getCpf());
            ps.execute();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public void deletarF(int numFuncionario) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, senha);
            String sql = "DELETE FROM Funcionario WHERE numFuncionario = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, numFuncionario);
            ps.execute();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}

