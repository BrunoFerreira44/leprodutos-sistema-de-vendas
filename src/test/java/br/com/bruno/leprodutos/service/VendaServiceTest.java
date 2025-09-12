package br.com.bruno.leprodutos.service;

import br.com.bruno.leprodutos.domain.venda.TipoDeVenda;
import br.com.bruno.leprodutos.domain.venda.Venda;
import br.com.bruno.leprodutos.domain.venda.dto.StatsDTO;
import br.com.bruno.leprodutos.domain.venda.dto.StatsSumDTO;
import br.com.bruno.leprodutos.infrastructure.exception.VendaNaoExistente;
import br.com.bruno.leprodutos.repository.VendaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class VendaServiceTest {

    @InjectMocks
    private VendaService vendaService;

    @Mock
    private VendaRepository vendaRepository;

    @Test
    @DisplayName("ainda nao sei")
    void getStatsFullCenario1() {

        Optional<Venda> vendaMaisAntiga = Optional.of(getVendaBazar3());
        List<Venda> vendas = List.of(
                getVendaBazar1(),
                getVendaBazar2(),
                getVendaBazar3(),
                getVendaCatalogo1(),
                getVendaCatalogo2(),
                getVendaCatalogo3()
        );

        Mockito.when(vendaRepository.findTopByOrderByDataVendaAsc()).thenReturn(vendaMaisAntiga);
        Mockito.when(vendaRepository.findByDataVendaBetween(Mockito.any(), Mockito.any())).thenReturn(vendas);

        StatsDTO result = vendaService.getStatsFull();

        System.out.println(result);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/yyyy");
        String dataRef = vendaMaisAntiga.get().getDataVenda().format(dtf);
        System.out.println(dataRef);

        Assertions.assertThat(result.stats()).isNotEmpty();
        Assertions.assertThat(result.stats().getFirst().periodoReferencia()).isEqualTo(dataRef);

    }

    @Test
    @DisplayName("Deve calcular corretamente o lucro do Bazar e do Catalogo")
    void getStatsSumCenario1() {

        List<Venda> mock = List.of(
                getVendaBazar1(),
                getVendaCatalogo1()
        );

        Mockito.when(vendaRepository.findAll()).thenReturn(mock);

        StatsSumDTO dto = vendaService.getStatsSum();
        BigDecimal mockLucroBazar = getVendaBazar1().getPrecoVenda().subtract(getVendaBazar1().getPrecoCompra());
        BigDecimal mockLucroCatalogo = getVendaCatalogo1().getPrecoVenda().subtract(getVendaCatalogo1().getPrecoCompra());

        assertEquals(mockLucroBazar.doubleValue(), dto.lucroBazar(), 0.01);
        assertEquals(mockLucroCatalogo.doubleValue(), dto.lucroCatalogo(), 0.01);
    }

    @Test
    @DisplayName("Deve lançar a exceção 'VendaNaoExistente' quando não houver registros no banco")
    void getStatsSumCenario2() {

        List<Venda> mock = List.of();

        Mockito.when(vendaRepository.findAll()).thenReturn(mock);

        assertThrows(VendaNaoExistente.class, () -> vendaService.getStatsSum());
    }


    private Venda getVendaBazar1() {
        return new Venda(
                1L,
                LocalDate.now(),
                "Shampoo",
                BigDecimal.valueOf(100),
                BigDecimal.valueOf(125.99),
                TipoDeVenda.BAZAR
        );
    }

    private Venda getVendaBazar2() {
        return new Venda(
                2L,
                LocalDate.now().minusDays(45),
                "Condicionador",
                BigDecimal.valueOf(49.99),
                BigDecimal.valueOf(75.49),
                TipoDeVenda.BAZAR
        );
    }

    private Venda getVendaBazar3() {
        return new Venda(
                3L,
                LocalDate.now().minusDays(90),
                "Creme Rince",
                BigDecimal.valueOf(12.50),
                BigDecimal.valueOf(30),
                TipoDeVenda.BAZAR
        );
    }

    private Venda getVendaCatalogo1() {
        return new Venda(
                1L,
                LocalDate.now(),
                "Pote",
                BigDecimal.valueOf(100.99),
                BigDecimal.valueOf(130),
                TipoDeVenda.CATALOGO
        );
    }

    private Venda getVendaCatalogo2() {
        return new Venda(
                2L,
                LocalDate.now().minusDays(45),
                "Tupperware",
                BigDecimal.valueOf(40),
                BigDecimal.valueOf(75.49),
                TipoDeVenda.CATALOGO
        );
    }

    private Venda getVendaCatalogo3() {
        return new Venda(
                3L,
                LocalDate.now().minusDays(90),
                "Panela",
                BigDecimal.valueOf(12.50),
                BigDecimal.valueOf(34.99),
                TipoDeVenda.CATALOGO
        );
    }
}