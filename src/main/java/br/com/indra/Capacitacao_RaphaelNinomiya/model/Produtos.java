package br.com.indra.Capacitacao_RaphaelNinomiya.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "produtos")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String descricao;

    @Column(nullable = false)
    private BigDecimal preco;

    @Column(name="codigo_barras")
    private String codigoBarras;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Entity
    public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;

        private Integer stock;

        private Integer minimumStock;

    }

    @Column(nullable = false)
    private Integer stock = 0;
}
