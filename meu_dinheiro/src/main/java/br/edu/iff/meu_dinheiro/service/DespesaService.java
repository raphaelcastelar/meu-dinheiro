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