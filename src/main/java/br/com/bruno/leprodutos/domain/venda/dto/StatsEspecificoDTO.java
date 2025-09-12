package br.com.bruno.leprodutos.domain.venda.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public record StatsEspecificoDTO(
        @JsonProperty("tipo")
        String tipo,

        @JsonProperty("periodo_referencia")
        String periodoReferencia,

        @JsonProperty("total_compras")
        BigDecimal totalPrecoCompras,

        @JsonProperty("total_vendas")
        BigDecimal totalPrecoVendas,

        BigDecimal lucro) {
}
