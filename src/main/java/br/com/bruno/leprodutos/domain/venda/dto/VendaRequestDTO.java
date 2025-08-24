package br.com.bruno.leprodutos.domain.venda.dto;

import br.com.bruno.leprodutos.domain.venda.TipoDeVenda;
import br.com.bruno.leprodutos.domain.venda.Venda;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record VendaRequestDTO(@NotNull(message = "A data da venda deve ser informada") LocalDate dataVenda,
                              @NotBlank(message = "O nome do produto deve ser informado") String produto,
                              @Min(0) @NotNull(message = "O preco da compra deve ser informado") BigDecimal precoCompra,
                              @Min(0) @NotNull(message = "O preco da venda deve ser informado") BigDecimal precoVenda,
                              @NotNull(message = "O tipo de venda deve ser informado") TipoDeVenda tipoDeVenda) {

    VendaRequestDTO(Venda venda) {
        this(venda.getDataVenda(), venda.getProduto(), venda.getPrecoCompra(), venda.getPrecoVenda(), venda.getTipoDeVenda());
    }
}
