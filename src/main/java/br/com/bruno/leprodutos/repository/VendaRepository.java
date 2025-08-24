package br.com.bruno.leprodutos.repository;

import br.com.bruno.leprodutos.domain.venda.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {


//    List<Venda> findByDataVendaAfter(LocalDate inicioDoMesAtual);

    List<Venda> findByDataVendaBetween(LocalDate dataInicial, LocalDate dataFinal);
}
