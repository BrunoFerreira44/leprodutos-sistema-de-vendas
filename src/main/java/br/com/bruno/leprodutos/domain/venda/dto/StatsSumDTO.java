package br.com.bruno.leprodutos.domain.venda.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StatsSumDTO(@JsonProperty("catalogo_vendas") Double somaVendasCatalogo,
                          @JsonProperty("catalogo_compras") Double somaComprasCatalogo,
                          @JsonProperty("catalogo_lucro") Double lucroCatalogo,
                          @JsonProperty("bazar_vendas") Double somaVendasBazar,
                          @JsonProperty("bazar_compras") Double somaComprasBazar,
                          @JsonProperty("bazar_lucro") Double lucroBazar) {
}
