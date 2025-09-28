package br.edu.iff.meu_dinheiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.meu_dinheiro.entities.Categoria;
import br.edu.iff.meu_dinheiro.repository.CategoriaRepository;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public void save(Categoria categoria) {
        if (categoria.getId() == null) {
            categoriaRepository.save(categoria); // JPA gera o ID automaticamente
        } else {
            categoriaRepository.save(categoria); // Atualiza existente
        }
    }

    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
}