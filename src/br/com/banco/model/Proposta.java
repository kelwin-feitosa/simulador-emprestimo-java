package br.com.banco.model;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Proposta {
    private Long id;
    private String nomeCliente;
    private BigDecimal salarioBruto;
    private BigDecimal valorPrestacao;
    private String statusAprovacao;
    private LocalDateTime dataCriacao;

    public Proposta(String nomeCliente, BigDecimal salarioBruto, BigDecimal valorPrestacao, String statusAprovacao) {
        this.nomeCliente = nomeCliente;
        this.salarioBruto = salarioBruto;
        this.valorPrestacao = valorPrestacao;
        this.statusAprovacao = statusAprovacao;
    }
}
