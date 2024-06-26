package dao;

import Model.Hospede;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;


public class HospedeDAO {
        static String url = "jdbc:mysql://localhost:3306/hotel";
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String user = "root";
    static String senha = "123456";

    public void inserirH(Hospede hospede){
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName(driver);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        try {
            conn = DriverManager.getConnection(url, user, senha);
            String sql1 = "INSERT INTO Hospede(avaliacao, email, nome, idHospede, telefone, idade, cpf) VALUES(?, ?, ?, ?, ?, ?, ?);";
            ps = conn.prepareStatement(sql1);
            ps.setString(1, hospede.getAvaliacao());
            ps.setString(2, hospede.getEmail());
            ps.setString(3, hospede.getNome());
            ps.setInt(4, hospede.getIdHospede());
            ps.setInt(5, hospede.getTelefone());
            ps.setInt(6, hospede.getIdade());
            ps.setInt(7, hospede.getCpf());
            ps.execute();
            ps.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
