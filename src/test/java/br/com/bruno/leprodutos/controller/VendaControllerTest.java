package br.com.bruno.leprodutos.controller;

import br.com.bruno.leprodutos.domain.venda.TipoDeVenda;
import br.com.bruno.leprodutos.domain.venda.Venda;
import br.com.bruno.leprodutos.infrastructure.exception.VendaNaoExistente;
import br.com.bruno.leprodutos.repository.VendaRepository;
import br.com.bruno.leprodutos.service.VendaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class VendaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private VendaRepository vendaRepository;


    @Test
    @DisplayName("/stats/full - Deve retornar código 200")
    void getStatsFullCenario1() throws Exception {

        vendaRepository.save(getVendaBazar3());
        vendaRepository.save(getVendaCatalogo3());

        mockMvc.perform(get("/vendas/stats/full").header("Authorization", "123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.stats").isNotEmpty());
    }

    @Test
    @DisplayName("/stats/full - Deve retornar erro VendaNaoExistente - Nenhum registro no banco de dados")
    void getStatsFullCenario2() throws Exception {

        vendaRepository.deleteAll();

        mockMvc.perform(get("/vendas/stats/full").header("Authorization", "123"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("/stats/full - Deve retornar 401 - Token incorreto")
    void getStatsFullCenario3() throws Exception {

        mockMvc.perform(get("/vendas/stats/full").header("Authorization", "12345"))
                .andExpect(status().isUnauthorized());
    }


    @Test
    @DisplayName("/stats/sum - Deve retornar código 200 e valores de 'lucro' Not Empty")
    void getStatsSumCenario1() throws Exception {

        vendaRepository.save(getVendaBazar1());
        vendaRepository.save(getVendaCatalogo1());

        mockMvc.perform(get("/vendas/stats/sum").header("Authorization", "123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.bazar_lucro").isNotEmpty())
                .andExpect(jsonPath("$.catalogo_lucro").isNotEmpty());
    }


    @Test
    @DisplayName("/stats/sum - Deve retornar código 401 - Token incorreto")
    void getStatsSumCenario2() throws Exception {

        mockMvc.perform(get("/vendas/stats/sum").header("Authorization", "12345"))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$.error").exists());
    }


    @Test
    @DisplayName("/stats/sum - Deve retornar erro VendaNaoExistente - Nenhum registro cadastrado no banco")
    void getStatsSumCenario3() throws Exception {

        vendaRepository.deleteAll();

        mockMvc.perform(get("/vendas/stats/sum").header("Authorization", "123"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").value("Não existe nenhuma venda cadastrada"));
    }



    private Venda getVendaBazar1() {
        return new Venda(
                null,
                LocalDate.now(),
                "Shampoo",
                BigDecimal.valueOf(100),
                BigDecimal.valueOf(125.99),
                TipoDeVenda.BAZAR
        );
    }

    private Venda getVendaBazar2() {
        return new Venda(
                null,
                LocalDate.now().minusDays(45),
                "Condicionador",
                BigDecimal.valueOf(49.99),
                BigDecimal.valueOf(75.49),
                TipoDeVenda.BAZAR
        );
    }

    private Venda getVendaBazar3() {
        return new Venda(
                null,
                LocalDate.now().minusDays(90),
                "Creme Rince",
                BigDecimal.valueOf(12.50),
                BigDecimal.valueOf(30),
                TipoDeVenda.BAZAR
        );
    }

    private Venda getVendaCatalogo1() {
        return new Venda(
                null,
                LocalDate.now(),
                "Pote",
                BigDecimal.valueOf(100.99),
                BigDecimal.valueOf(130),
                TipoDeVenda.CATALOGO
        );
    }

    private Venda getVendaCatalogo2() {
        return new Venda(
                null,
                LocalDate.now().minusDays(45),
                "Tupperware",
                BigDecimal.valueOf(40),
                BigDecimal.valueOf(75.49),
                TipoDeVenda.CATALOGO
        );
    }

    private Venda getVendaCatalogo3() {
        return new Venda(
                null,
                LocalDate.now().minusDays(90),
                "Panela",
                BigDecimal.valueOf(12.50),
                BigDecimal.valueOf(34.99),
                TipoDeVenda.CATALOGO
        );
    }
}