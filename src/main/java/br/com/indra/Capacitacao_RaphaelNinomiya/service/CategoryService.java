package br.com.indra.Capacitacao_RaphaelNinomiya.service;

import br.com.indra.Capacitacao_RaphaelNinomiya.model.Category;
import br.com.indra.Capacitacao_RaphaelNinomiya.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category create(Category category){

        Long parentId = null;

        if(category.getParent() != null){
            parentId = category.getParent().getId();
        }

        if(categoryRepository.existsByNameAndParent_Id(
                category.getName(),
                category.getParent() != null ? category.getParent().getId() : null
        )){
            throw new RuntimeException("Categoria já existe nesse nível");
        }

        return categoryRepository.save(category);
    }

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public Category update(Long id, Category category){

        Category existing = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        existing.setName(category.getName());
        existing.setParent(category.getParent());

        return categoryRepository.save(existing);
    }

    public void delete(Long id){

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        categoryRepository.delete(category);
    }

}