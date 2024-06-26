package com.mycompany.conexaosql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMySQL {
    public static String driverJDBC = "com.mysql.cj.jdbc.Driver";
    public static void main (String[] args) {
        try{
            System.out.println("Carregando o driver...");
            Class.forName(driverJDBC);
            System.out.println("Driver carregado com sucesso");
        }catch(Exception e){
            System.out.println("Falha no carregamento");
        }
    }
        
    public static java.sql.Connection getConexaoMySQL() {
        Connection connection = null; //atributo do tipo Connection
        return connection;
    }       
}
