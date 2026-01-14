package br.com.banco.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class FormatadorMoeda {
    public static String formatarParaReal(BigDecimal dinheiro) {
        if (dinheiro == null) return "R$ 0,00";

        Locale ptBr = Locale.of("pt", "BR");
        NumberFormat formatador = NumberFormat.getCurrencyInstance(ptBr);

        return formatador.format(dinheiro);
    }
}
