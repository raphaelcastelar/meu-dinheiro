package br.edu.iff.meu_dinheiro.service;

import br.edu.iff.meu_dinheiro.entities.Categoria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriaService {
    private List<Categoria> categorias = new ArrayList<>();
    private Long nextId = 1L;

    public CategoriaService() {
        categorias.add(new Categoria(1L, "Alimentação"));
        categorias.add(new Categoria(2L, "Lazer"));
        categorias.add(new Categoria(3L, "Contas Fixas"));
    }

    public List<Categoria> findAll() { return new ArrayList<>(categorias); }
    public void save(Categoria categoria) {
        if (categoria.getId() == null) {
            categoria.setId(nextId++);
            categorias.add(categoria);
        }
    }
}