package br.edu.iff.meu_dinheiro.controller.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.meu_dinheiro.entities.Categoria;
import br.edu.iff.meu_dinheiro.exception.RegraDeNegocioException;
import br.edu.iff.meu_dinheiro.repository.CategoriaRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;



@RestController
@RequestMapping("/api/v1/categoria")

public class RestApiCategoriaController {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public RestApiCategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public ResponseEntity<Categoria> createCategoria(@ModelAttribute Categoria categoria, UriComponentsBuilder uriBuilder) {
        if (categoria.getNome() == null || categoria.getNome().isEmpty() || categoria.getTipo() == null) {
            throw new RegraDeNegocioException("Nome e tipo são obrigatórios.");
        }
        Categoria savedCategoria = categoriaRepository.save(categoria);
        return ResponseEntity.created(uriBuilder.path("/api/v1/categoria/{id}").buildAndExpand(savedCategoria.getId()).toUri())
                .body(savedCategoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Long id, @ModelAttribute Categoria categoriaDetails) {
        return categoriaRepository.findById(id)
                .map(categoria -> {
                    if (categoriaDetails.getNome() != null && !categoriaDetails.getNome().isEmpty()) {
                        categoria.setNome(categoriaDetails.getNome());
                    }
                    if (categoriaDetails.getDescricao() != null) {
                        categoria.setDescricao(categoriaDetails.getDescricao());
                    }
                    if (categoriaDetails.getTipo() != null) {
                        categoria.setTipo(categoriaDetails.getTipo());
                    }
                    Categoria updatedCategoria = categoriaRepository.save(categoria);
                    return new ResponseEntity<>(updatedCategoria, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
