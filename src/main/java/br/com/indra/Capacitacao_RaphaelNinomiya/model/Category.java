package br.com.indra.Capacitacao_RaphaelNinomiya.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @NotBlank
    @Column(unique = true, nullable = false)
    private String name;

    @Setter
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    public Category() {}

}