package br.com.banco.service;

import java.math.BigDecimal;

public record ResultadoProcessamento(boolean aprovado, BigDecimal limiteSugerido) {}