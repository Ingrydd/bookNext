package Controler;

import Model.Reserva;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;


public class ReservaDAO {
    static String url = "jdbc:mysql://localhost:3306/hotel";
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String user = "root";
    static String senha = "123456";

    public void inserirR(Reserva reserva){
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName(driver);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        try {
            conn = DriverManager.getConnection(url, user, senha);
            String sql1 = "INSERT INTO Reserva(statusPagamento, dataInicio, dataFim, numQuarto, idReserva) VALUES(?, ?, ?, ?, ?);";
            ps = conn.prepareStatement(sql1);
            ps.setString(1, reserva.getStatusPagamento());
            ps.setInt(2, reserva.getDataInicio());
            ps.setInt(3, reserva.getDataFim());
            ps.setInt(4, reserva.getNumQuarto());
            ps.setInt(5, reserva.getIdReserva());
            ps.execute();
            ps.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public Reserva buscarR(int idReserva) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Reserva reserva = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, senha);
            String sql = "SELECT * FROM Reserva WHERE idReserva = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idReserva);
            rs = ps.executeQuery();

            if (rs.next()) {
                reserva = new Reserva();
                reserva.setStatusPagamento(rs.getString("statusPagamento"));
                reserva.setDataInicio(rs.getInt("dataInicio"));
                reserva.setDataFim(rs.getInt("dataFim"));
                reserva.setNumQuarto(rs.getInt("numQuarto"));
                reserva.setIdReserva(rs.getInt("idReserva"));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }    
        return reserva;
    }
    
    public void atualizar(Reserva reserva) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, senha);
            String sql = "UPDATE Reserva SET statusPagamento = ?, dataInicio = ?, dataFim = ?, numQuarto = ?, idReserva = ? WHERE idReserva = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, reserva.getStatusPagamento());
            ps.setInt(2, reserva.getDataInicio());
            ps.setInt(3, reserva.getDataFim());
            ps.setInt(4, reserva.getNumQuarto());
            ps.setInt(5, reserva.getIdReserva());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public void deletar(int idReserva) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, senha);
            String sql = "DELETE FROM Reserva WHERE idReserva = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idReserva);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }    
    }

    
}