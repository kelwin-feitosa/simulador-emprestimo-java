package br.com.banco.model;

public class PropostaEmprestimo {
    private String nomeCliente;
    private double salarioBruto;
    private double valorPrestacao;

    public PropostaEmprestimo(String nomeCliente, double salarioBruto, double valorPrestacao){
        this.nomeCliente = nomeCliente;
        this.salarioBruto = salarioBruto;
        this.valorPrestacao = valorPrestacao;
    }

    public String getNomeCliente(){
        return nomeCliente;
    }
    public double getSalarioBruto(){
        return salarioBruto;
    }
    public double getValorPrestacao(){
        return valorPrestacao;
    }

}

