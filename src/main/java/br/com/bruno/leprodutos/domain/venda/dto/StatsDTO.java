package br.com.bruno.leprodutos.domain.venda.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record StatsDTO (List<StatsEspecificoDTO> stats) {
}
