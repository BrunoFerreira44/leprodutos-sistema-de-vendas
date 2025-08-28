package br.com.bruno.leprodutos.service;

import br.com.bruno.leprodutos.domain.venda.TipoDeVenda;
import br.com.bruno.leprodutos.domain.venda.Venda;
import br.com.bruno.leprodutos.domain.venda.dto.*;
import br.com.bruno.leprodutos.infrastructure.VendaNaoExistente;
import br.com.bruno.leprodutos.repository.VendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VendaService {

    private final VendaRepository repository;

    public VendaResponseDTO postVenda(VendaRequestDTO req) {
        Venda venda = new Venda(req);
        repository.save(venda);
        return new VendaResponseDTO(venda);
    }

    public List<Venda> getAll() {
        return repository.findAll();
    }

    public VendaResponseDTO getById(Long id) {
        Venda venda = findVendaByIdIfExists(id);
        return new VendaResponseDTO(venda);
    }

    public void deleteVenda(Long id) {
        Venda venda = findVendaByIdIfExists(id);
        repository.delete(venda);
    }

    public VendaResponseDTO updateVenda(VendaUpdateDTO dto) {
        Venda venda = findVendaByIdIfExists(dto.id());
        venda.updateVenda(dto);
        return new VendaResponseDTO(venda);
    }


    public StatsDTO getStats(Integer reqMes, Integer reqAno) {

        periodosDTO periodos = formatPeriodos(reqMes, reqAno);
        valoresDTO valores = formatValores(periodos);

        return new StatsDTO(List.of(
                new StatsEspecificoDTO("CATALOGO", periodos.periodo_referencia(), valores.totalPrecoComprasCatalogo(), valores.totalPrecoVendasCatalogo(), valores.lucroCatalogo()),
                new StatsEspecificoDTO("BAZAR", periodos.periodo_referencia(), valores.totalPrecoComprasBazar(), valores.totalPrecoVendasBazar(), valores.lucroBazar())
        ));
    }

    public StatsDTO getStatsFull() {

        List<StatsEspecificoDTO> lista = new ArrayList<>();
        Venda vendaMaisAntiga = repository.findTopByOrderByDataVendaAsc();

        LocalDate theData = LocalDate.of(
                vendaMaisAntiga.getDataVenda().getYear(),
                vendaMaisAntiga.getDataVenda().getMonth(),
                1
        );

        while (theData.isBefore(LocalDate.now())) {

            periodosDTO periodos = formatPeriodos(theData.getMonthValue(), theData.getYear());
            valoresDTO valores = formatValores(periodos);

            lista.add(new StatsEspecificoDTO("CATALOGO", periodos.periodo_referencia(), valores.totalPrecoComprasCatalogo(), valores.totalPrecoVendasCatalogo(), valores.lucroCatalogo()));
            lista.add(new StatsEspecificoDTO("BAZAR", periodos.periodo_referencia(), valores.totalPrecoComprasBazar(), valores.totalPrecoVendasBazar(), valores.lucroBazar()));

            theData = theData.plusMonths(1).withDayOfMonth(1);
        }

        return new StatsDTO(lista);
    }

    private valoresDTO formatValores(periodosDTO periodos) {

        List<Venda> vendas = repository.findByDataVendaBetween(periodos.dataInicial(), periodos.dataFinal());

        BigDecimal totalPrecoVendasCatalogo = vendas.stream().filter(v -> v.getTipoDeVenda().equals(TipoDeVenda.CATALOGO)).map(Venda::getPrecoVenda).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal totalPrecoComprasCatalogo = vendas.stream().filter(v -> v.getTipoDeVenda().equals(TipoDeVenda.CATALOGO)).map(Venda::getPrecoCompra).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal lucroCatalogo = totalPrecoVendasCatalogo.subtract(totalPrecoComprasCatalogo);

        BigDecimal totalPrecoVendasBazar = vendas.stream().filter(v -> v.getTipoDeVenda().equals(TipoDeVenda.BAZAR)).map(Venda::getPrecoVenda).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal totalPrecoComprasBazar = vendas.stream().filter(v -> v.getTipoDeVenda().equals(TipoDeVenda.BAZAR)).map(Venda::getPrecoCompra).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal lucroBazar = totalPrecoVendasBazar.subtract(totalPrecoComprasBazar);

        return new valoresDTO(totalPrecoVendasCatalogo, totalPrecoComprasCatalogo, lucroCatalogo, totalPrecoVendasBazar, totalPrecoComprasBazar, lucroBazar);
    }

    private periodosDTO formatPeriodos(Integer reqMes, Integer reqAno) {

        LocalDate dataInicial = null;
        LocalDate dataFinal = null;
        String periodoReferencia = null;

        if (reqMes == null && reqAno == null) {
            dataInicial = LocalDate.now().withDayOfMonth(1);
            dataFinal = LocalDate.now();
            periodoReferencia = dataInicial.format(DateTimeFormatter.ofPattern("MM/yyyy"));
            return new periodosDTO(dataInicial, dataFinal, periodoReferencia);
        }

        if (reqMes == null) {
            dataInicial = LocalDate.of(reqAno, 1, 1);
            dataFinal = dataInicial.plusYears(1);
            periodoReferencia = dataInicial.format(DateTimeFormatter.ofPattern("yyyy"));
            return new periodosDTO(dataInicial, dataFinal, periodoReferencia);
        }

        if (reqAno == null) {
            dataInicial = LocalDate.of(LocalDate.now().getYear(), reqMes, 1);
            dataFinal = dataInicial.plusMonths(1);
            periodoReferencia = dataInicial.format(DateTimeFormatter.ofPattern("MM/yyyy"));
            return new periodosDTO(dataInicial, dataFinal, periodoReferencia);
        }

        dataInicial = LocalDate.of(reqAno, reqMes, 1);
        dataFinal = dataInicial.plusMonths(1);
        periodoReferencia = dataInicial.format(DateTimeFormatter.ofPattern("MM/yyyy"));
        return new periodosDTO(dataInicial, dataFinal, periodoReferencia);

    }

    private Venda findVendaByIdIfExists(Long id) {
        var venda = repository.findById(id);
        if (venda.isEmpty()) throw new VendaNaoExistente("Não existe venda com ID " + id);
        return venda.get();
    }

}
