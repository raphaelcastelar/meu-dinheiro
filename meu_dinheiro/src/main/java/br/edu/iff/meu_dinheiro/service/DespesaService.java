package br.edu.iff.meu_dinheiro.service;

import br.edu.iff.meu_dinheiro.entities.Despesa;
import org.springframework.stereotype.Service;
import br.edu.iff.meu_dinheiro.entities.Categoria;


import java.util.ArrayList;
import java.util.List;

@Service
public class DespesaService {
    private List<Despesa> Despesas = new ArrayList<>();
    private Long nextId = 1L;

    public DespesaService() {
        Categoria cat1 = new Categoria(1L, "Alimentação");
        Despesas.add(new Despesa(1L, "Almoço", 50.0, cat1, "2025-08-01"));
    }

    public List<Despesa> findAll() { return new ArrayList<>(Despesas); }
    public void save(Despesa despesa) {
        if (despesa.getId() == null) {
            despesa.setId(nextId++);
            Despesas.add(despesa);
        }
    }
    public void deleteById(Long id) {
        Despesas.removeIf(d -> d.getId().equals(id));
    }
}