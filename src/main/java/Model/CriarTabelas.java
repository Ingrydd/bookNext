package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelas {
    static String url = "jdbc:mysql://localhost:3306/hotel";
    static String driver = "com.mysql.cj.jdbc.Driver";
    static String user = "root";
    static String senha = "123456";
    
    public static void main(String[] args){
        Connection conn = null;
        Statement st = null;
        String sqlFuncionario = "CREATE TABLE Funcionario ("
                + "nome VARCHAR(255) NOT NULL,"
                + "numFuncionario INT AUTO_INCREMENT PRIMARY KEY NOT NULL,"
                + "telefone INT,"
                + "cpf INT NOT NULL UNIQUE)";

        String sqlHospede = "CREATE TABLE Hospede ("
                + "email VARCHAR(255),"
                + "nome VARCHAR(255) NOT NULL,"
                + "idHospede INT AUTO_INCREMENT PRIMARY KEY NOT NULL,"
                + "telefone INT,"
                + "idade INT,"
                + "cpf INT NOT NULL UNIQUE)";

        String sqlReserva = "CREATE TABLE Reserva ("
                + "statusPagamento VARCHAR(255) NOT NULL,"
                + "dataInicio DATE NOT NULL,"
                + "dataFim DATE NOT NULL,"
                + "numQuarto INT NOT NULL,"
                + "idReserva INT AUTO_INCREMENT PRIMARY KEY NOT NULL)";
        
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, senha);

            System.out.println("Criando a tabela Funcionario...");
            st = conn.createStatement();
            st.executeUpdate(sqlFuncionario);
            System.out.println("Tabela Funcionario criada com sucesso!");

            System.out.println("Criando a tabela Hospede...");
            st.executeUpdate(sqlHospede);
            System.out.println("Tabela Hospede criada com sucesso!");

            System.out.println("Criando a tabela Reserva...");
            st.executeUpdate(sqlReserva);
            System.out.println("Tabela Reserva criada com sucesso!");
            
        } catch (Exception e){
            System.out.println("Erro ao criar tabelas: " + e.getMessage());
        }
    }
}
    

