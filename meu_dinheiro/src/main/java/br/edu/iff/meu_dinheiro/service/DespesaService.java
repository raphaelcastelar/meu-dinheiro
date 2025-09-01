package br.edu.iff.meu_dinheiro.service;

import br.edu.iff.meu_dinheiro.entities.Despesa;
import br.edu.iff.meu_dinheiro.entities.Categoria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DespesaService {
    private List<Despesa> despesas = new ArrayList<>();
    private Long nextId = 1L;

    public DespesaService() {
        Categoria cat1 = new Categoria(1L, "Alimentação");
        Categoria cat2 = new Categoria(2L, "Lazer");
        Categoria cat3 = new Categoria(3L, "Contas Fixas");
        despesas.add(new Despesa(nextId++, "Almoço", 50.0, cat1, "2025-08-01"));
        despesas.add(new Despesa(nextId++, "Cinema", 30.0, cat2, "2025-08-15"));
        despesas.add(new Despesa(nextId++, "Mercado", 120.50, cat1, "2025-08-20"));
        despesas.add(new Despesa(nextId++, "Conta de Luz", 150.0, cat3, "2025-08-25"));
    }

    public List<Despesa> findAll() { return new ArrayList<>(despesas); }

    public void save(Despesa despesa) {
        if (despesa.getId() == null) {
            despesa.setId(nextId++);
            despesas.add(despesa);
        } else {
            despesas.removeIf(d -> d.getId().equals(despesa.getId()));
            despesas.add(despesa);
        }
    }

    public void deleteById(Long id) {
        despesas.removeIf(d -> d.getId().equals(id));
    }
}