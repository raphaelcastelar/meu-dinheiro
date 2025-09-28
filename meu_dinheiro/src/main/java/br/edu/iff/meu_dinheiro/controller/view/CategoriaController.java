package br.edu.iff.meu_dinheiro.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.iff.meu_dinheiro.entities.Categoria;
import br.edu.iff.meu_dinheiro.repository.CategoriaRepository;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping
    public String showCategoriasPage(Model model) {
        model.addAttribute("categorias", categoriaRepository.findAll());
        model.addAttribute("newCategoria", new Categoria());
        return "categoria";
    }
}