package br.com.indra.Capacitacao_RaphaelNinomiya.service;

import br.com.indra.Capacitacao_RaphaelNinomiya.enums.TransactionType;
import br.com.indra.Capacitacao_RaphaelNinomiya.model.InventoryTransaction;
import br.com.indra.Capacitacao_RaphaelNinomiya.model.Produtos;
import br.com.indra.Capacitacao_RaphaelNinomiya.repository.InventoryTransactionRepository;
import br.com.indra.Capacitacao_RaphaelNinomiya.repository.ProdutosRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class InventoryService {

    private final ProdutosRepository produtosRepository;
    private final InventoryTransactionRepository transactionRepository;

    public InventoryService(ProdutosRepository produtosRepository,
                            InventoryTransactionRepository transactionRepository) {
        this.produtosRepository = produtosRepository;
        this.transactionRepository = transactionRepository;
    }

    public Produtos addStock(Long productId, Integer quantity){

        Produtos product = produtosRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if(product.getStock() == null){
            product.setStock(0);
        }

        product.setStock(product.getStock() + quantity);

        InventoryTransaction transaction = new InventoryTransaction();
        transaction.setProduct(product);
        transaction.setQuantity(quantity);
        transaction.setType(TransactionType.ENTRY);
        transaction.setCreatedAt(LocalDateTime.now());

        transactionRepository.save(transaction);

        return produtosRepository.save(product);
    }

    public Produtos removeStock(Long productId, Integer quantity){

        Produtos product = produtosRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if(product.getStock() < quantity){
            throw new RuntimeException("Estoque insuficiente");
        }

        product.setStock(product.getStock() - quantity);

        InventoryTransaction transaction = new InventoryTransaction();
        transaction.setProduct(product);
        transaction.setQuantity(quantity);
        transaction.setType(TransactionType.EXIT);
        transaction.setCreatedAt(LocalDateTime.now());

        transactionRepository.save(transaction);

        return produtosRepository.save(product);
    }

    public Integer getStock(Long productId){

        Produtos product = produtosRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        return product.getStock();
    }

}