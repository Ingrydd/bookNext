package dao;

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
}