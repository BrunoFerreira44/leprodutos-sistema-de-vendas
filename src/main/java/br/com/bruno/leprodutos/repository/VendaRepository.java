package br.com.bruno.leprodutos.repository;

import br.com.bruno.leprodutos.domain.venda.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface VendaRepository extends JpaRepository<Venda, Long> {

    List<Venda> findByDataVendaBetween(LocalDate dataInicial, LocalDate dataFinal);

    Optional<Venda> findTopByOrderByDataVendaAsc();
}
