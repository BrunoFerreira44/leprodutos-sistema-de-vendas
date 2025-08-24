package br.com.bruno.leprodutos.domain.venda.dto;

import br.com.bruno.leprodutos.domain.venda.TipoDeVenda;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record VendaUpdateDTO(@NotNull Long id,
                             LocalDate dataVenda,
                             String produto,
                             BigDecimal precoCompra,
                             BigDecimal precoVenda,
                             TipoDeVenda tipoDeVenda) {
}
