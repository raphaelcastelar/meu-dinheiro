package br.edu.iff.meu_dinheiro.service;

import br.edu.iff.meu_dinheiro.entities.Receita;
import br.edu.iff.meu_dinheiro.entities.Categoria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReceitaService {
    private List<Receita> receitas = new ArrayList<>();
    private Long nextId = 1L;

    public ReceitaService() {
        // Dados mockados
        Categoria cat1 = new Categoria(1L, "Renda Principal");
        receitas.add(new Receita(1L, "Salário", 2000.0, cat1, "2025-08-01"));
    }

    public List<Receita> findAll() { return new ArrayList<>(receitas); }
    public void save(Receita receita) {
        if (receita.getId() == null) {
            receita.setId(nextId++);
            receitas.add(receita);
        }
    }
}