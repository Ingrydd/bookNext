package Controler;

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
            String sql1 = "INSERT INTO Hospede(avaliacao, email, nome, telefone, idade, cpf) VALUES(?, ?, ?, ?, ?, ?);";
            ps = conn.prepareStatement(sql1);
            ps.setString(1, hospede.getAvaliacao());
            ps.setString(2, hospede.getEmail());
            ps.setString(3, hospede.getNome());
            ps.setInt(4, hospede.getTelefone());
            ps.setInt(5, hospede.getIdade());
            ps.setInt(6, hospede.getCpf());
            ps.execute();
            ps.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public Hospede buscarH(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Hospede hospede = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, senha);
            String sql = "SELECT * FROM Hospede WHERE idHospede = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                hospede = new Hospede();
                hospede.setIdHospede(rs.getInt("idHospede"));
                hospede.setAvaliacao(rs.getString("avaliacao"));
                hospede.setEmail(rs.getString("email"));
                hospede.setNome(rs.getString("nome"));
                hospede.setTelefone(rs.getInt("telefone"));
                hospede.setIdade(rs.getInt("idade"));
                hospede.setCpf(rs.getInt("cpf"));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return hospede;
    }
        public void atualizarH(Hospede hospede) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, senha);
            String sql = "UPDATE Hospede SET avaliacao = ?, email = ?, nome = ?, telefone = ?, idade = ?, cpf = ? WHERE idHospede = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, hospede.getAvaliacao());
            ps.setString(2, hospede.getEmail());
            ps.setString(3, hospede.getNome());
            ps.setInt(4, hospede.getTelefone());
            ps.setInt(5, hospede.getIdade());
            ps.setInt(6, hospede.getCpf());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
        
    public void deletarH(int idHospede) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, senha);
            String sql = "DELETE FROM Hospede WHERE idHospede = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idHospede);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }  
    }
}
