package br.com.bruno.leprodutos.domain.venda.dto;

import java.time.LocalDate;

public record periodosDTO(LocalDate dataInicial,
                          LocalDate dataFinal,
                          String periodo_referencia) {
}
