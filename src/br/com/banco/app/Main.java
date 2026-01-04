package br.com.banco.app;

import java.math.BigDecimal;
import java.util.Scanner;
import br.com.banco.model.PropostaEmprestimo;
import br.com.banco.service.ValidadorEmprestimo;

public class Main {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String continuar;
        ValidadorEmprestimo validarEmprestimo = new ValidadorEmprestimo();

        do {
            System.out.println("Insira seu nome: ");
            String nomeCliente = scan.nextLine().trim();

            BigDecimal salarioBruto = lerBigDecimalSeguro("Insira o seu salário bruto: ");
            BigDecimal valorPrestacao = lerBigDecimalSeguro("Insira o valor da prestação: ");

            PropostaEmprestimo minhaProposta = new PropostaEmprestimo(nomeCliente, salarioBruto, valorPrestacao);

            if(validarEmprestimo.verificarAprovacao(minhaProposta)){
                System.out.println("O empréstimo foi Aprovado! ");
            } else {
                System.out.println("STATUS: Empréstimo Negado! Valor máximo permitido: " + validarEmprestimo.calcularLimite(minhaProposta));
            }

            System.out.println("Deseja continuar? [S/N]: ");
            continuar = scan.nextLine();
        } while (continuar.equalsIgnoreCase("S"));
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
                scan.nextLine();
            }
        } while(true);
    }
}