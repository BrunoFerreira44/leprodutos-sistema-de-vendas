package br.com.bruno.leprodutos.domain.venda;

import br.com.bruno.leprodutos.domain.venda.dto.VendaRequestDTO;
import br.com.bruno.leprodutos.domain.venda.dto.VendaUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "vendas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Venda {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataVenda;
    private String produto;
    private BigDecimal precoCompra;
    private BigDecimal precoVenda;
    private TipoDeVenda tipoDeVenda;

    public Venda(VendaRequestDTO req) {
        this.dataVenda = req.dataVenda();
        this.produto = req.produto();
        this.precoCompra = req.precoCompra();
        this.precoVenda = req.precoVenda();
        this.tipoDeVenda = req.tipoDeVenda();
    }

    public void updateVenda(VendaUpdateDTO updateDTO) {
        this.dataVenda = updateDTO.dataVenda() == null ? this.dataVenda : updateDTO.dataVenda();
        this.produto = updateDTO.produto().isBlank() ? this.produto : updateDTO.produto();
        this.precoCompra = updateDTO.precoCompra() == null ? this.precoCompra : updateDTO.precoCompra();
        this.precoVenda = updateDTO.precoVenda() == null ? this.precoVenda : updateDTO.precoVenda();
        this.tipoDeVenda = updateDTO.tipoDeVenda() == null ? this.tipoDeVenda : updateDTO.tipoDeVenda();
    }

}
