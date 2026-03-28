package br.com.indra.Capacitacao_RaphaelNinomiya.repository;

import br.com.indra.Capacitacao_RaphaelNinomiya.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    boolean existsByNameAndParent_Id(String name, Long parentId);

}