package br.com.banco.app;

import java.util.Scanner;
import br.com.banco.model.PropostaEmprestimo;
import br.com.banco.service.ValidadorEmprestimo;

public class Main {
    private static final Scanner leitor = new Scanner(System.in);

    public static void main(String[] args) {
        String continuar;
        do {
            System.out.println("Digite o seu nome: ");
            String nomeCliente = leitor.nextLine();
            double salarioBruto = LerDoubleSeguro("Digite o seu salário bruto: ");
            double valorPrestacao = LerDoubleSeguro("Insira o valor da prestação: ");

            PropostaEmprestimo minhaProposta = new PropostaEmprestimo(nomeCliente, salarioBruto, valorPrestacao);
            ValidadorEmprestimo validador = new ValidadorEmprestimo();

            if (validador.VerificarAprovacao(minhaProposta)) {
                System.out.println("O empréstimo foi Aprovado!!");
            } else {
                System.out.println("Empréstimo negado!");
                System.out.println("Valor máximo permitido é de: " + validador.CalcularLimite(minhaProposta));
            }

            System.out.println("Deseja continuar? [S/N]: ");
            continuar = leitor.nextLine();
        } while (continuar.equalsIgnoreCase("S"));


    }

    public static void limparBuffer(){
        if (leitor.hasNextLine()) {
            leitor.nextLine();
        }
    }

    private static double LerDoubleSeguro(String mensagem){
        while(true){
            try{
                System.out.println(mensagem);
                double valor = leitor.nextDouble();
                limparBuffer();
                return valor;

            }catch(java.util.InputMismatchException e){
                System.out.println("ERRO: Digite apenas números!!!");
                limparBuffer();
            }
        }
    }

}