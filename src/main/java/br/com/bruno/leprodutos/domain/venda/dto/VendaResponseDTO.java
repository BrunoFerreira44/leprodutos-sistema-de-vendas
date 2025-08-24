package br.com.bruno.leprodutos.domain.venda.dto;

import br.com.bruno.leprodutos.domain.venda.TipoDeVenda;
import br.com.bruno.leprodutos.domain.venda.Venda;

import java.math.BigDecimal;
import java.time.LocalDate;

public record VendaResponseDTO(Long id,
                               LocalDate dataVenda,
                               String produto,
                               BigDecimal precoCompra,
                               BigDecimal precoVenda,
                               TipoDeVenda tipoDeVenda) {

    public VendaResponseDTO(Venda venda) {
        this(venda.getId(), venda.getDataVenda(), venda.getProduto(), venda.getPrecoCompra(), venda.getPrecoVenda(), venda.getTipoDeVenda());
    }
}
