package br.com.banco.service;

import br.com.banco.model.PropostaEmprestimo;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ValidadorEmprestimo {
    private static final BigDecimal PERCENTUAL_MARGEM_MAXIMA = new BigDecimal("0.30");

    public boolean verificarAprovacao(PropostaEmprestimo proposta){
        if (proposta == null) return false;
        return proposta.getValorPrestacao().compareTo(calcularLimite(proposta)) <= 0;
    }
    public BigDecimal calcularLimite(PropostaEmprestimo proposta){
        return proposta.getSalarioBruto().multiply(PERCENTUAL_MARGEM_MAXIMA).setScale(2, RoundingMode.HALF_UP);
    }
}
