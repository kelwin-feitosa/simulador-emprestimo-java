package br.com.banco.model;

import br.com.banco.exception.NegocioException;

import java.math.BigDecimal;

public class PropostaEmprestimo {
    private final String nomeCliente;
    private final BigDecimal salarioBruto;
    private final BigDecimal valorPrestacao;

    public PropostaEmprestimo(String nomeCliente, BigDecimal salarioBruto, BigDecimal valorPrestacao){
        if (nomeCliente == null || nomeCliente.isBlank()) throw new NegocioException("Insira um nome Válido!!!");
        this.nomeCliente = nomeCliente;
        if (salarioBruto == null || salarioBruto.compareTo(BigDecimal.ZERO) <= 0)
            throw new NegocioException("O salário bruto deve ser maior que zero!");
        this.salarioBruto = salarioBruto;
        if (valorPrestacao == null || valorPrestacao.compareTo(BigDecimal.ZERO) <= 0)
            throw new NegocioException("A prestação deve ser maior que zero!");
        this.valorPrestacao = valorPrestacao;
    }

    public String getNomeCliente() { return nomeCliente; }
    public BigDecimal getSalarioBruto(){ return salarioBruto; }
    public BigDecimal getValorPrestacao(){ return valorPrestacao; }

}

