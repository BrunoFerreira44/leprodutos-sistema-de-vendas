package br.com.bruno.leprodutos.controller;

import br.com.bruno.leprodutos.domain.venda.dto.*;
import br.com.bruno.leprodutos.service.VendaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/vendas")
@RequiredArgsConstructor
@Tag(name = "Vendas", description = "Gerenciamento de vendas")
public class VendaController {

    private final VendaService service;

    @PostMapping
    @Transactional
    @Operation(summary = "Cria uma nova venda", description = "Registra uma nova venda no sistema")
    public ResponseEntity<VendaResponseDTO> postVenda(@RequestBody @Valid VendaRequestDTO req, UriComponentsBuilder uriComponentsBuilder) {
        var vendaResponseDTO = service.postVenda(req);
        var uri = uriComponentsBuilder.path("/vendas/{id}").buildAndExpand(vendaResponseDTO.id()).toUri();
        return ResponseEntity.created(uri).body(vendaResponseDTO);
    }

    @GetMapping
    public ResponseEntity getAll(@PageableDefault(sort = {"dataVenda"}, direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(service.getAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteVenda(@PathVariable Long id) {
        service.deleteVenda(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateVenda(@RequestBody @Valid VendaUpdateDTO dto) {
        return ResponseEntity.ok(service.updateVenda(dto));
    }

    @GetMapping("/stats")
    public ResponseEntity getStats(@RequestParam(name = "month", required = false) Integer mes, @RequestParam(name = "year", required = false) Integer ano) {
        return ResponseEntity.ok(service.getStats(mes, ano));
    }

    @GetMapping("/stats/full")
    public ResponseEntity<StatsDTO> getStatsFull() {
        return ResponseEntity.ok(service.getStatsFull());
    }

    @GetMapping("/stats/sum")
    public ResponseEntity<StatsSumDTO> getStatsSum() {
        return ResponseEntity.ok(service.getStatsSum());
    }
}
