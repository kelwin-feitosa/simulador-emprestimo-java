package br.com.banco.app;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.banco.exception.NegocioException;
import br.com.banco.model.PropostaEmprestimo;
import br.com.banco.service.ValidadorEmprestimo;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String continuar;
        List<PropostaEmprestimo> historico = new ArrayList<>();
        ValidadorEmprestimo validador = new ValidadorEmprestimo();

        do {
            boolean dadosValidos = false;
            while(!dadosValidos) {
                try {
                    System.out.println("Insira seu nome: ");
                    String nomeCliente = scan.nextLine().trim();
                    BigDecimal salarioBruto = lerBigDecimalSeguro("Insira o seu salário bruto: ");
                    BigDecimal valorPrestacao = lerBigDecimalSeguro("Insira o valor da prestação: ");

                    PropostaEmprestimo proposta = new PropostaEmprestimo(nomeCliente, salarioBruto, valorPrestacao);
                    dadosValidos = true;
                    historico.add(proposta);
                    exibirAprovacao(proposta, validador);

                } catch (NegocioException e) {
                    System.out.println("ATENÇÃO: " + e.getMessage());
                }
            }
            System.out.println("Deseja continuar? [S/N]: ");
            continuar = scan.nextLine();
        } while (continuar.equalsIgnoreCase("S"));
        for(PropostaEmprestimo emprestimos: historico) {
            String status = validador.verificarAprovacao(emprestimos) ? "Aprovado" : "Reprovado";
            System.out.println("Cliente: " + emprestimos.getNomeCliente() + " | Salário: " + emprestimos.getSalarioBruto() + " | Status: " + status);
        }
    }

    /*
    public static void limparBuffer() {
        if(scan.hasNextLine()){
            scan.nextLine();
        }
    }
    */

    private static BigDecimal lerBigDecimalSeguro(String mensagem){
        do {
            try {
                System.out.println(mensagem);
                String valor = scan.nextLine().trim();
                String valorCorrigido = valor.replace(".", "").replace(",",".");

                return new BigDecimal(valorCorrigido);

            } catch (NumberFormatException e) {
                System.out.println("ERRO: Digite um valor numérico válido (ex: 1500.50)!");
            }
        } while(true);
    }

    private static void exibirAprovacao(PropostaEmprestimo proposta, ValidadorEmprestimo validador) {
        if (validador.verificarAprovacao(proposta)) {
            System.out.println("O empréstimo foi Aprovado! ");
        } else {
            System.out.println("STATUS: Empréstimo Negado! \nValor máximo permitido: " + validador.calcularLimite(proposta));
        }

    }
}