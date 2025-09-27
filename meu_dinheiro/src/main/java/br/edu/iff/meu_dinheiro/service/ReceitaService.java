package br.edu.iff.meu_dinheiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.meu_dinheiro.entities.Receita;
import br.edu.iff.meu_dinheiro.repository.ReceitaRepository;

@Service
public class ReceitaService {

    private final ReceitaRepository receitasRepository;

    @Autowired
    public ReceitaService(ReceitaRepository receitasRepository) {
        this.receitasRepository = receitasRepository;
    }

    public Receita saveReceita(Receita receita) {
        // Validação básica (pode ser expandida)
        if (receita.getData() == null || !receita.getData().matches("\\d{4}-\\d{2}") || receita.getDescricao() == null) {
            throw new IllegalArgumentException("Dados inválidos para a receita.");
        }
        return receitasRepository.save(receita);
    }

    public Iterable<Receita> findAll() {
        return receitasRepository.findAll();
    }

    public Receita findById(Long id) {
        return receitasRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Receita não encontrada."));
    }

    public void deleteReceita(Long id) {
        if (receitasRepository.existsById(id)) {
            receitasRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Receita não encontrada para exclusão.");
        }
    }
}