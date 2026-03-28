package br.com.indra.Capacitacao_RaphaelNinomiya.service;

import br.com.indra.Capacitacao_RaphaelNinomiya.repository.HistoricoPrecoRepository;
import br.com.indra.Capacitacao_RaphaelNinomiya.service.dto.HistoricoProdutoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistoricoService {

    private final HistoricoPrecoRepository historicoPrecoRepository;

    public List<HistoricoProdutoDTO> getHistoricoByProdutoId(Long produtoId) {

        return historicoPrecoRepository.findByProdutosId(produtoId)
                .stream()
                .map(h -> new HistoricoProdutoDTO(
                        h.getId(),
                        h.getProdutos().getNome(),
                        h.getPrecoAntigo(),
                        h.getPrecoNovo(),
                        h.getDataAlteracao()
                ))
                .toList();
    }
}
