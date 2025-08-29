package br.edu.iff.meu_dinheiro.service;

import br.edu.iff.meu_dinheiro.entities.categoria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {
    private List<categoria> categorias = new ArrayList<>();
    private Long nextId = 1L;

    public CategoriaService() {
        categorias.add(new categoria(1L, "Alimentação"));
        categorias.add(new categoria(2L, "Lazer"));
        categorias.add(new categoria(3L, "Contas Fixas"));
    }

    public List<categoria> findAll() { return new ArrayList<>(categorias); }
    public void save(categoria categoria) {
        if (categoria.getId() == null) {
            categoria.setId(nextId++);
            categorias.add(categoria);
        }
    }
}