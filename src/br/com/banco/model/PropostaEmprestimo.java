package br.com.banco.model;

import java.math.BigDecimal;

public class PropostaEmprestimo {
    private final String nomeCliente;
    private final BigDecimal salarioBruto;
    private final BigDecimal valorPrestacao;

    public PropostaEmprestimo(String nomeCliente, BigDecimal salarioBruto, BigDecimal valorPrestacao){
        this.nomeCliente = nomeCliente;
        this.salarioBruto = salarioBruto;
        this.valorPrestacao = valorPrestacao;
    }

    public String getNomeCliente(){
        return nomeCliente;
    }
    public BigDecimal getSalarioBruto(){
        return salarioBruto;
    }
    public BigDecimal getValorPrestacao(){
        return valorPrestacao;
    }

}

