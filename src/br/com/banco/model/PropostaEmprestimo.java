package br.com.banco.model;

import br.com.banco.exception.NegocioException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PropostaEmprestimo {
    private Long id; // Gerado pelo Banco
    private final String nomeCliente;
    private final BigDecimal salarioBruto;
    private final BigDecimal valorPrestacao;
    private boolean aprovada; // Novo campo para o status
    private LocalDateTime dataCriacao;

    public PropostaEmprestimo(String nomeCliente, BigDecimal salarioBruto, BigDecimal valorPrestacao) {
        validarCampos(nomeCliente, salarioBruto, valorPrestacao);
        this.nomeCliente = nomeCliente;
        this.salarioBruto = salarioBruto;
        this.valorPrestacao = valorPrestacao;
        this.dataCriacao = LocalDateTime.now();
    }

    private void validarCampos(String nome, BigDecimal salario, BigDecimal prestacao) {
        if (nome == null || nome.isBlank()) throw new NegocioException("Nome inválido!");
        if (salario == null || salario.compareTo(BigDecimal.ZERO) <= 0) throw new NegocioException("Salário inválido!");
        if (prestacao == null || prestacao.compareTo(BigDecimal.ZERO) <= 0) throw new NegocioException("Prestação inválida!");
    }

    // Getters e Setters para o que o Banco vai preencher (id, aprovada)
    public void setId(Long id) { this.id = id; }
    public void setAprovada(boolean aprovada) { this.aprovada = aprovada; }
    public String getNomeCliente() { return nomeCliente; }
    public BigDecimal getSalarioBruto() { return salarioBruto; }
    public BigDecimal getValorPrestacao() { return valorPrestacao; }
    public boolean isAprovada() { return aprovada; }
}