package br.com.indra.Capacitacao_RaphaelNinomiya.controller;

import br.com.indra.Capacitacao_RaphaelNinomiya.model.Category;
import br.com.indra.Capacitacao_RaphaelNinomiya.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public Category create(@RequestBody Category category){
        return categoryService.create(category);
    }

    @GetMapping
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category category){
        return categoryService.update(id, category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        categoryService.delete(id);
    }
}