package br.edu.iff.meu_dinheiro.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import br.edu.iff.meu_dinheiro.service.DespesaService;
import br.edu.iff.meu_dinheiro.service.ReceitaService;

@Controller
@RequestMapping("/")
public class HomeController {
    private final DespesaService despesaService;
    private final ReceitaService receitaService;

    public HomeController(DespesaService despesaService, ReceitaService receitaService) {
        this.despesaService = despesaService;
        this.receitaService = receitaService;
    }

    @GetMapping
    public String showHome(@RequestParam(required = false) String nome, Model model) {
        // Define um nome padrão
        String defaultName = "João";
        model.addAttribute("pageTitle", "Início");
        model.addAttribute("expenses", despesaService.findAll());
        model.addAttribute("revenues", receitaService.findAll());
        model.addAttribute("userName", nome != null ? nome : defaultName);

        // Dados mockados para o usuário João
        model.addAttribute("id", 1L); // ID fictício
        model.addAttribute("saldo", 1500.50); // Saldo fictício
        model.addAttribute("gastos", 600.75); // Gastos fictícios
        model.addAttribute("metaEconomia", 1000.00); // Meta de economia fictícia

        return "index";
    }
}