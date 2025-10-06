package br.edu.iff.meu_dinheiro.controller.view;


import br.edu.iff.meu_dinheiro.entities.TipoCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iff.meu_dinheiro.service.DespesaService;
import br.edu.iff.meu_dinheiro.entities.Despesa;
import br.edu.iff.meu_dinheiro.repository.DespesaRepository;
import br.edu.iff.meu_dinheiro.service.CategoriaService;

import java.util.stream.Collectors;

@Controller
@RequestMapping("/user/despesa")
public class DespesaController {

    private final DespesaService despesaService;
    private final CategoriaService categoriaService;
    private final DespesaRepository despesaRepository;

    @Autowired
    public DespesaController(DespesaService despesaService, CategoriaService categoriaService, DespesaRepository despesaRepository) {
        this.despesaService = despesaService;
        this.categoriaService = categoriaService;
        this.despesaRepository = despesaRepository;
    }

    @GetMapping
    public String showDespesasPage(Model model) {
        model.addAttribute("despesas", despesaService.findAll());
        model.addAttribute("newDespesa", new Despesa());
        model.addAttribute("categorias", categoriaService.findAll().stream()
                .filter(c -> c.getTipo() == TipoCategoria.DESPESA)
                .collect(Collectors.toList()));
        return "despesa";
    }

    @GetMapping(params = "data")
    public String updateMonth(@RequestParam String data, Model model) {
        Despesa monthlyDespesa = despesaRepository.findByDataAndDescricao(data, null);
        model.addAttribute("monthlyDespesa", monthlyDespesa != null ? monthlyDespesa : new Despesa());
        model.addAttribute("despesas", despesaService.findAll());
        model.addAttribute("newDespesa", new Despesa());
        model.addAttribute("categorias", categoriaService.findAll().stream()
                .filter(c -> c.getTipo() == TipoCategoria.DESPESA)
                .collect(Collectors.toList()));
        return "despesa";
    }
}