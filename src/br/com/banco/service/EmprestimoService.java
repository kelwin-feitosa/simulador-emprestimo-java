package br.com.banco.service;

import br.com.banco.model.PropostaEmprestimo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmprestimoService {

    private final ValidadorEmprestimo validador = new ValidadorEmprestimo();
    private final List<PropostaEmprestimo> historico =  new ArrayList<>();

    public ResultadoProcessamento processar(PropostaEmprestimo proposta) {
        boolean aprovado = validador.verificarAprovacao(proposta);

        historico.add(proposta);

        return new ResultadoProcessamento(
                aprovado,
                aprovado ? null : validador.calcularLimite(proposta)
        );
    }

    public List<PropostaEmprestimo> getHistorico() {
        return Collections.unmodifiableList(this.historico);
    }
}