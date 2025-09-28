package br.edu.iff.meu_dinheiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.meu_dinheiro.entities.Despesa;
import br.edu.iff.meu_dinheiro.entities.Categoria;
import br.edu.iff.meu_dinheiro.repository.DespesaRepository;

import java.util.List;

@Service
public class DespesaService {

    private final DespesaRepository despesaRepository;

    @Autowired
    public DespesaService(DespesaRepository despesaRepository) {
        this.despesaRepository = despesaRepository;
    }

    public List<Despesa> findAll() {
        return despesaRepository.findAll();
    }

    public void save(Despesa despesa) {
        if (despesa.getId() == null) {
            despesaRepository.save(despesa); // JPA gera o ID automaticamente
        } else {
            despesaRepository.save(despesa); // Atualiza existente
        }
    }

    public void deleteById(Long id) {
        despesaRepository.deleteById(id);
    }
}