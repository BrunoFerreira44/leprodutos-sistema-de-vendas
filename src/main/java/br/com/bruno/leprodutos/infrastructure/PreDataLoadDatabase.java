package br.com.bruno.leprodutos.infrastructure;

import br.com.bruno.leprodutos.domain.venda.TipoDeVenda;
import br.com.bruno.leprodutos.domain.venda.Venda;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
public class PreDataLoadDatabase {

    @Bean
    public Venda venda1() {
        return new Venda(null,
                LocalDate.of(2025, 8, 25),
                "Shampoo",
                BigDecimal.valueOf(100),
                BigDecimal.valueOf(125.99),
                TipoDeVenda.BAZAR);
    }

    @Bean
    public Venda venda2() {
        return new Venda(null,
                LocalDate.of(2025, 8, 26),
                "Condicionador",
                BigDecimal.valueOf(100),
                BigDecimal.valueOf(125.99),
                TipoDeVenda.BAZAR);
    }

    @Bean
    public Venda venda3() {
        return new Venda(null,
                LocalDate.of(2025, 8, 27),
                "Sabonete",
                BigDecimal.valueOf(50),
                BigDecimal.valueOf(75.00),
                TipoDeVenda.BAZAR);
    }

    @Bean
    public Venda venda4() {
        return new Venda(null,
                LocalDate.of(2025, 8, 28),
                "Creme Hidratante",
                BigDecimal.valueOf(80),
                BigDecimal.valueOf(110.50),
                TipoDeVenda.BAZAR);
    }

    @Bean
    public Venda venda5() {
        return new Venda(null,
                LocalDate.of(2025, 8, 29),
                "Perfume",
                BigDecimal.valueOf(40),
                BigDecimal.valueOf(199.99),
                TipoDeVenda.BAZAR);
    }

    @Bean
    public Venda venda6() {
        return new Venda(null,
                LocalDate.of(2025, 8, 30),
                "Desodorante",
                BigDecimal.valueOf(120),
                BigDecimal.valueOf(145.00),
                TipoDeVenda.BAZAR);
    }

    @Bean
    public Venda venda7() {
        return new Venda(null,
                LocalDate.of(2025, 9, 1),
                "Escova de Cabelo",
                BigDecimal.valueOf(60),
                BigDecimal.valueOf(89.90),
                TipoDeVenda.BAZAR);
    }

    @Bean
    public Venda venda8() {
        return new Venda(null,
                LocalDate.of(2025, 9, 2),
                "Pasta de Dente",
                BigDecimal.valueOf(200),
                BigDecimal.valueOf(299.50),
                TipoDeVenda.BAZAR);
    }

    @Bean
    public Venda venda9() {
        return new Venda(null,
                LocalDate.of(2025, 9, 3),
                "Fio Dental",
                BigDecimal.valueOf(150),
                BigDecimal.valueOf(210.00),
                TipoDeVenda.BAZAR);
    }

    @Bean
    public Venda venda10() {
        return new Venda(null,
                LocalDate.of(2024, 9, 4),
                "Lenço Umedecido",
                BigDecimal.valueOf(70),
                BigDecimal.valueOf(95.00),
                TipoDeVenda.BAZAR);
    }

    @Bean
    public Venda venda11() {
        return new Venda(null,
                LocalDate.of(2024, 9, 5),
                "Álcool Gel",
                BigDecimal.valueOf(100),
                BigDecimal.valueOf(135.00),
                TipoDeVenda.BAZAR);
    }

    @Bean
    public Venda venda12() {
        return new Venda(null,
                LocalDate.of(2024, 9, 6),
                "Protetor Solar",
                BigDecimal.valueOf(50),
                BigDecimal.valueOf(149.99),
                TipoDeVenda.BAZAR);
    }

    @Bean
    public Venda venda13() {
        return new Venda(null,
                LocalDate.of(2024, 9, 7),
                "Batom",
                BigDecimal.valueOf(90),
                BigDecimal.valueOf(130.00),
                TipoDeVenda.BAZAR);
    }

    @Bean
    public Venda venda14() {
        return new Venda(null,
                LocalDate.of(2024, 9, 8),
                "Base de Maquiagem",
                BigDecimal.valueOf(70),
                BigDecimal.valueOf(115.00),
                TipoDeVenda.BAZAR);
    }

    @Bean
    public Venda venda15() {
        return new Venda(null,
                LocalDate.of(2024, 9, 9),
                "Rímel",
                BigDecimal.valueOf(85),
                BigDecimal.valueOf(120.00),
                TipoDeVenda.BAZAR);
    }

    @Bean
    public Venda venda16() {
        return new Venda(null,
                LocalDate.of(2024, 9, 10),
                "Sombra de Olhos",
                BigDecimal.valueOf(60),
                BigDecimal.valueOf(99.90),
                TipoDeVenda.BAZAR);
    }

    @Bean
    public Venda venda17() {
        return new Venda(null,
                LocalDate.of(2024, 9, 11),
                "Pó Compacto",
                BigDecimal.valueOf(75),
                BigDecimal.valueOf(110.00),
                TipoDeVenda.BAZAR);
    }

    @Bean
    public Venda venda18() {
        return new Venda(null,
                LocalDate.of(2024, 9, 12),
                "Esmalte",
                BigDecimal.valueOf(200),
                BigDecimal.valueOf(280.00),
                TipoDeVenda.BAZAR);
    }

    @Bean
    public Venda venda19() {
        return new Venda(null,
                LocalDate.of(2024, 9, 13),
                "Removedor de Esmalte",
                BigDecimal.valueOf(120),
                BigDecimal.valueOf(160.00),
                TipoDeVenda.CATALOGO);
    }

    @Bean
    public Venda venda20() {
        return new Venda(null,
                LocalDate.of(2024, 9, 14),
                "Creme para Mãos",
                BigDecimal.valueOf(80),
                BigDecimal.valueOf(105.00),
                TipoDeVenda.CATALOGO);
    }

    @Bean
    public Venda venda21() {
        return new Venda(null,
                LocalDate.of(2024, 9, 15),
                "Creme para Pés",
                BigDecimal.valueOf(70),
                BigDecimal.valueOf(98.00),
                TipoDeVenda.CATALOGO);
    }

    @Bean
    public Venda venda22() {
        return new Venda(null,
                LocalDate.of(2024, 9, 16),
                "Óleo Corporal",
                BigDecimal.valueOf(65),
                BigDecimal.valueOf(115.00),
                TipoDeVenda.CATALOGO);
    }


}
