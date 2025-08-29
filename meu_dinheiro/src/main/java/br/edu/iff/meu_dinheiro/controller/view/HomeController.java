package br.edu.iff.meu_dinheiro.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.edu.iff.meu_dinheiro.service.DespesaService;
import br.edu.iff.meu_dinheiro.service.ReceitaService;

@Controller
@RequestMapping("/")
public class HomeController {

    private final DespesaService DespesaService;
    private final ReceitaService ReceitaService;

    public HomeController(DespesaService despesaService, ReceitaService receitaService) {
        this.DespesaService = despesaService;
        this.ReceitaService = receitaService;
    }

    @GetMapping
    public String showHome(Model model) {
        model.addAttribute("pageTitle", "Início");
        model.addAttribute("expenses", DespesaService.findAll());
        model.addAttribute("revenues", ReceitaService.findAll());
        return "index";
    }
}