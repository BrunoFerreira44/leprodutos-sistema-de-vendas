package br.com.bruno.leprodutos.domain.venda.dto;

import java.math.BigDecimal;

public record valoresDTO(BigDecimal totalPrecoVendasCatalogo,
                         BigDecimal totalPrecoComprasCatalogo,
                         BigDecimal lucroCatalogo,
                         BigDecimal totalPrecoVendasBazar,
                         BigDecimal totalPrecoComprasBazar,
                         BigDecimal lucroBazar) {
}
