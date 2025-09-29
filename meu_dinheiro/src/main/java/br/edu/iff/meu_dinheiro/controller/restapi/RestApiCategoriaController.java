package br.edu.iff.meu_dinheiro.controller.restapi;

import br.edu.iff.meu_dinheiro.exception.CategoriaNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.meu_dinheiro.entities.Categoria;
import br.edu.iff.meu_dinheiro.entities.TipoCategoria;
import br.edu.iff.meu_dinheiro.repository.CategoriaRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categoria")

public class RestApiCategoriaController {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public RestApiCategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
        if (categoria.getNome() == null || categoria.getNome().isEmpty() || categoria.getTipo() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Categoria savedCategoria = categoriaRepository.save(categoria);
        return new ResponseEntity<>(savedCategoria, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Categoria>> getAllCategorias() {
        return new ResponseEntity<>(categoriaRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Long id, @RequestBody Categoria categoriaDetails) {
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
        throw new CategoriaNaoEncontradaException(id);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Categoria>> getCategoriasByTipo(@PathVariable TipoCategoria tipo) {
        List<Categoria> categorias = categoriaRepository.findByTipo(tipo);
        return ResponseEntity.ok(categorias);
    }
}