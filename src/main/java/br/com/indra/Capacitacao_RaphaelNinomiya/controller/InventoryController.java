package br.com.indra.Capacitacao_RaphaelNinomiya.controller;

import br.com.indra.Capacitacao_RaphaelNinomiya.model.Produtos;
import br.com.indra.Capacitacao_RaphaelNinomiya.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @PostMapping("/{productId}/add")
    public Produtos addStock(@PathVariable Long productId, @RequestParam Integer quantity) {
        return inventoryService.addStock(productId, quantity);
    }

    @PostMapping("/{productId}/remove")
    public Produtos removeStock(@PathVariable Long productId, @RequestParam Integer quantity) {
        return inventoryService.removeStock(productId, quantity);
    }

    @GetMapping("/{productId}")
    public Integer getStock(@PathVariable Long productId) {
        return inventoryService.getStock(productId);
    }
}