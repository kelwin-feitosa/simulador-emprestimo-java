package br.com.banco.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FabricaConexao {
    private static final Properties prop = new Properties();

    static {
        try (FileInputStream file = new FileInputStream("database.properties")) {
            prop.load(file);
        }catch(IOException e) {
            throw new RuntimeException("Erro ao carregar o arquivo de configuração: " + e.getMessage());
        }
    }

    public static Connection getConnection() {
        try{
            return DriverManager.getConnection(
                prop.getProperty("db.url"),
                prop.getProperty("db.user"),
                prop.getProperty("db.password")
            );
        }catch(SQLException e) {
            throw new RuntimeException("Erro de conexão: " + e.getMessage());
        }
    }
}
