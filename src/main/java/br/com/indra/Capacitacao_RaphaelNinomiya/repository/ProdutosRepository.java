package br.com.indra.Capacitacao_RaphaelNinomiya.repository;

import br.com.indra.Capacitacao_RaphaelNinomiya.model.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
}