package br.com.indra.Capacitacao_RaphaelNinomiya.repository;

import br.com.indra.Capacitacao_RaphaelNinomiya.model.InventoryTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryTransactionRepository extends JpaRepository<InventoryTransaction, Long> {
}