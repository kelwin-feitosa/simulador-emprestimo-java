package br.com.banco.service;

import br.com.banco.model.PropostaEmprestimo;

public class ValidadorEmprestimo {
    public boolean VerificarAprovacao(PropostaEmprestimo proposta){
        return proposta.getValorPrestacao() <= CalcularLimite(proposta);
    }
    public double CalcularLimite(PropostaEmprestimo proposta){
        return proposta.getSalarioBruto() * 0.3;
    }
}
