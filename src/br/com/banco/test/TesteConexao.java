package br.com.banco.test;

import br.com.banco.util.FabricaConexao;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {
    public static void main(String[] args) {
        System.out.println("---- INICIANDO TESTE DE CONEXÃO ----\n");

        try(Connection conexao = FabricaConexao.getConnection()) {

            if(conexao != null && !conexao.isClosed()) {
                System.out.println("✅ SUCESSO: O Java conectou ao PostgreSQL!");
                System.out.println("Conectado a: " + conexao.getMetaData().getURL());
                System.out.println("Driver: " + conexao.getMetaData().getDriverName());
            }

        } catch(SQLException e) {
            System.err.println("❌ FALHA NO SQL: Problema nos dados de acesso ou no Driver.");
            System.err.println("Mensagem: " + e.getMessage());
            e.printStackTrace();

        } catch (Exception e) {
            System.err.println("❌ ERRO DE CONFIGURAÇÃO: O arquivo .properties foi encontrado?");
            System.err.println("Mensagem: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("\n---- FIM DO TESTE ----");
    }
}
