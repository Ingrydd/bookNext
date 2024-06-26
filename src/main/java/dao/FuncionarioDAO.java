package dao;

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
    static String senha = "123456";

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
            String sql1 = "INSERT INTO Funcionario(nome, numFuncionario, telefone, cpf) VALUES(?, ?, ?, ?);";
            ps = conn.prepareStatement(sql1);
            ps.setString(1, funcionario.getNome());
            ps.setInt(2, funcionario.getNumFuncionario());
            ps.setInt(3, funcionario.getTelefone());
            ps.setInt(4, funcionario.getCpf());
            ps.execute();
            ps.close();
            conn.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}

