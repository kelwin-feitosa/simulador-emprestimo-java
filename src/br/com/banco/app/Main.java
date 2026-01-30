package br.com.banco.app;

import java.math.BigDecimal;
import java.util.Scanner;

import br.com.banco.exception.NegocioException;
import br.com.banco.model.PropostaEmprestimo;
import br.com.banco.service.ResultadoProcessamento;
import br.com.banco.util.FormatadorMoeda;
import br.com.banco.service.EmprestimoService;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    private static final EmprestimoService service = new EmprestimoService();

    public static void main(String[] args) {
        System.out.println("=== SISTEMA BANCÁRIO DE EMPRÉSTIMOS ===");

        String continuar;
        do {
            try {
                processarNovaSimulacao();
            } catch (NegocioException e) {
                System.out.println("ATENÇÃO: " + e.getMessage());
            }

            System.out.print("Deseja continuar? [S/N]: ");
            continuar = scan.nextLine();
        } while (continuar.equalsIgnoreCase("S"));

        exibirRelatorioFinal();
    }

    private static void processarNovaSimulacao() {
        System.out.println("\n------ Nova Simulação ------\n");
        System.out.print("Nome do Cliente: ");
        String nomeCliente = scan.nextLine().trim();

        BigDecimal salarioBruto = lerBigDecimalSeguro("Insira o seu salário bruto: ");
        BigDecimal valorPrestacao = lerBigDecimalSeguro("Insira o valor da prestação: ");

        PropostaEmprestimo proposta = new PropostaEmprestimo(nomeCliente, salarioBruto, valorPrestacao);

        // A MÁGICA: O Service resolve tudo e te entrega o "envelope" (record)
        ResultadoProcessamento resultado = service.processar(proposta);

        exibirAprovacao(resultado);
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

    private static void exibirAprovacao(ResultadoProcessamento resultado) {
        if (resultado.aprovado()) {
            System.out.println("\nSTATUS: Empréstimo Aprovado!");
        } else {
            System.out.println("\nSTATUS: Empréstimo Negado! \nValor máximo permitido: "
                    + FormatadorMoeda.formatarParaReal(resultado.limiteSugerido()));
        }
    }

    private static void exibirRelatorioFinal() {
        System.out.println("\n========================================================================================");
        System.out.println("         RESUMO DAS SIMULAÇÕES REALIZADAS (FONTE: SERVICE)         ");
        System.out.println("========================================================================================");

        service.getHistorico().forEach(
                p -> System.out.printf("Cliente: %-15s | Salário: %-10s%n",
                p.getNomeCliente(),
                FormatadorMoeda.formatarParaReal(p.getSalarioBruto()))
        );
        System.out.println("========================================================================================\n");
    }
}