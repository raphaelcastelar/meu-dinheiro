package br.edu.iff.meu_dinheiro.controller.view;


import br.edu.iff.meu_dinheiro.entities.TipoCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iff.meu_dinheiro.service.CategoriaService;
import br.edu.iff.meu_dinheiro.entities.Receita;
import br.edu.iff.meu_dinheiro.repository.ReceitaRepository;

import java.util.stream.Collectors;


@Controller
@RequestMapping("/user/receita")
public class ReceitaController {

    private final ReceitaRepository receitaRepository;
    private final CategoriaService categoriaService;

    @Autowired
    public ReceitaController(ReceitaRepository receitasRepository, CategoriaService categoriaService) {

        this.receitaRepository = receitasRepository;
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String showReceitasPage(Model model) {
        model.addAttribute("receitas", receitaRepository.findAll());
        model.addAttribute("newReceita", new Receita());
        model.addAttribute("categorias", categoriaService.findAll().stream()
                .filter(c -> c.getTipo() == TipoCategoria.RECEITA)
                .collect(Collectors.toList()));
        return "receita";
    }

    @GetMapping(params = "data")
    public String updateMonth(@RequestParam String data, Model model) {
        Receita monthlyReceita = receitaRepository.findByDataAndDescricao(data, null); // Ajuste conforme necessário
        model.addAttribute("monthlyReceita", monthlyReceita != null ? monthlyReceita : new Receita());
        model.addAttribute("receitas", receitaRepository.findAll());
        model.addAttribute("newReceita", new Receita());
        model.addAttribute("categorias", categoriaService.findAll().stream()
                .filter(c -> c.getTipo() == TipoCategoria.RECEITA)
                .collect(Collectors.toList()));
        return "receita";
    }
}