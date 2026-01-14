package br.com.banco.app;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.banco.exception.NegocioException;
import br.com.banco.model.PropostaEmprestimo;
import br.com.banco.service.ValidadorEmprestimo;
import br.com.banco.util.FormatadorMoeda;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String continuar;
        List<PropostaEmprestimo> historico = new ArrayList<>();
        ValidadorEmprestimo validador = new ValidadorEmprestimo();
        System.out.println("=== SISTEMA BANCÁRIO DE EMPRÉSTIMOS ===");
        do {

                try {
                    System.out.println("\n------ Nova Simulação ------\n");
                    System.out.print("Nome do Cliente: ");
                    String nomeCliente = scan.nextLine().trim();

                    BigDecimal salarioBruto = lerBigDecimalSeguro("Insira o seu salário bruto: ");
                    BigDecimal valorPrestacao = lerBigDecimalSeguro("Insira o valor da prestação: ");

                    // Criação do Objeto (Valida no construtor)
                    PropostaEmprestimo proposta = new PropostaEmprestimo(nomeCliente, salarioBruto, valorPrestacao);

                    // Adição ao Histórico
                    historico.add(proposta);

                    // Processamento e Exibição Imediata
                    exibirAprovacao(proposta, validador);

                } catch (NegocioException e) {
                    System.out.println("ATENÇÃO: " + e.getMessage());
                }
            System.out.println("Deseja continuar? [S/N]: ");
            continuar = scan.nextLine();
        } while (continuar.equalsIgnoreCase("S"));

        exibirRelatorioFinal(historico, validador);
    }

    private static BigDecimal lerBigDecimalSeguro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                String entrada = scan.nextLine().trim().replace(",", ".");
                if (entrada.isEmpty()) throw new Exception();
                return new BigDecimal(entrada);
            } catch (Exception e) {
                System.out.println("Erro: Digite um valor numérico válido (ex: 1500,50).");
            }
        }
    }

    private static void exibirAprovacao(PropostaEmprestimo proposta, ValidadorEmprestimo validador) {
        if (validador.verificarAprovacao(proposta)) {
            System.out.println("\nSTATUS: Empréstimo Aprovado!");
        } else {
            System.out.println("\nSTATUS: Empréstimo Negado! \nValor máximo permitido: " + validador.calcularLimite(proposta));
        }

    }

    private static void exibirRelatorioFinal(List<PropostaEmprestimo> historico, ValidadorEmprestimo validador) {
        System.out.println("\n========================================================================================");
        System.out.println("      RESUMO DAS SIMULAÇÕES REALIZADAS      ");
        System.out.println("========================================================================================");

        for (PropostaEmprestimo p : historico) {
            String status = validador.verificarAprovacao(p) ? "Aprovado" : "Reprovado";
            System.out.printf("Cliente: %-15s | Salário: %-10s | Status: %s%n",
                    p.getNomeCliente(),
                    FormatadorMoeda.formatarParaReal(p.getSalarioBruto()),
                    status);
        }
        System.out.println("========================================================================================\n");
    }
}