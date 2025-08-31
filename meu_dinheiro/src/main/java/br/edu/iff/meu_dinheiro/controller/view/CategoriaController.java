package br.edu.iff.meu_dinheiro.controller.view;

import br.edu.iff.meu_dinheiro.entities.Categoria;
import br.edu.iff.meu_dinheiro.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String listCategories(@RequestParam(required = false) String nome, Model model) {
        try {
            System.out.println("Carregando categorias: " + categoriaService.findAll());
            model.addAttribute("pageTitle", "Categorias");
            model.addAttribute("categorias", categoriaService.findAll() != null ? categoriaService.findAll() : java.util.Collections.emptyList());
            model.addAttribute("item", new Categoria()); // Garantir que "item" seja adicionado
            model.addAttribute("userName", nome != null ? nome : "Usuário");
            System.out.println("Modelo enviado: " + model); // Depuração
        } catch (Exception e) {
            System.out.println("Erro ao carregar categorias: " + e.getMessage());
            model.addAttribute("categorias", java.util.Collections.emptyList());
            model.addAttribute("item", new Categoria());
            model.addAttribute("userName", "Usuário");
        }
        return "categoria";
    }

    @PostMapping("/save")
    public String saveCategory(@Validated @ModelAttribute("item") Categoria categoria, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("categorias", categoriaService.findAll() != null ? categoriaService.findAll() : java.util.Collections.emptyList());
            return "categoria";
        }
        categoriaService.save(categoria);
        return "redirect:/categoria";
    }
}