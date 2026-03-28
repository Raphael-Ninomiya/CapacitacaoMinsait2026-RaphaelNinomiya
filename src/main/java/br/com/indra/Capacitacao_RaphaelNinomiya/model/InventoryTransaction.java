package br.com.indra.Capacitacao_RaphaelNinomiya.model;

import br.com.indra.Capacitacao_RaphaelNinomiya.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Produtos product;

    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private LocalDateTime createdAt;

}